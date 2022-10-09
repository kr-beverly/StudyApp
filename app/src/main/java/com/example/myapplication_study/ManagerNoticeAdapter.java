package com.example.myapplication_study;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.List;

public class ManagerNoticeAdapter extends ArrayAdapter<ManagerNoticeDataList> {
    private Context context;
    private List<ManagerNoticeDataList> managerNoticeDataList;
    private Activity noticeparentActivity;

    public ManagerNoticeAdapter(Context context, List<ManagerNoticeDataList> managerNoticeDataList, Activity noticeparentActivity) {
        super(context, R.layout.activity_managernotice_list, managerNoticeDataList);

        this.context = context;
        this.managerNoticeDataList = managerNoticeDataList;
        this.noticeparentActivity = noticeparentActivity;
    }

    @Override
    public int getCount() {
        return managerNoticeDataList.size();
    }

    @Override
    public ManagerNoticeDataList getItem(int position) {
        return managerNoticeDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_managernotice_list, null, true);

        TextView manager_notice_num = (TextView) view.findViewById(R.id.manager_notice_num);
        final TextView manager_notice_title = (TextView) view.findViewById(R.id.manager_notice_title);

        manager_notice_num.setText(managerNoticeDataList.get(position).getWrit_num());
        manager_notice_title.setText(managerNoticeDataList.get(position).getWrit_title());
        view.setTag(managerNoticeDataList.get(position).getWrit_num());

        Button manager_notice_delete = (Button) view.findViewById(R.id.manager_notice_delete);
        manager_notice_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success) {
                                managerNoticeDataList.remove(position);
                                notifyDataSetChanged();
                                Toast.makeText(getContext(), "게시글이 삭제되었습니다!", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getContext(), "게시글 삭제에 실패하였습니다!", Toast.LENGTH_SHORT).show();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };

                NoticeDeleteRequest noticeDeleteRequest = new NoticeDeleteRequest(manager_notice_title.getText().toString(), responseListener);
                RequestQueue queue = Volley.newRequestQueue(noticeparentActivity);
                queue.add(noticeDeleteRequest);
            }
        });

        return view;
    }
}