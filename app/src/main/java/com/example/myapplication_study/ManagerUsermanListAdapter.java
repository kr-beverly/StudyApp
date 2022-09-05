package com.example.myapplication_study;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.List;

public class ManagerUsermanListAdapter extends BaseAdapter {
    private Context context;
    private List<ManagerUsermanList> usermanList;
    private Activity parentActivity;


    public ManagerUsermanListAdapter(Context context, List<ManagerUsermanList> usermanList, Activity parentActivity) {
        this.context = context;
        this.usermanList = usermanList;
        this.parentActivity = parentActivity;
    }

    @Override
    public int getCount() {
        return usermanList.size();
    }

    @Override
    public Object getItem(int i) {
        return usermanList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View convertView, ViewGroup parent) {
       View v = View.inflate(context, R.layout.activity_manageruserman_list, null);

       TextView userName = (TextView) v.findViewById(R.id.userName);
       final TextView userID = (TextView) v.findViewById(R.id.userID);
       TextView userPassword = (TextView) v.findViewById(R.id.userPassword);

       userName.setText(usermanList.get(i).getName());
       userID.setText(usermanList.get(i).getUser_id());
       userPassword.setText(usermanList.get(i).getUser_pass());

       v.setTag(usermanList.get(i).getUser_id());

        Button manager_user_delete_btn = (Button) v.findViewById(R.id.manager_user_delete_btn);
        manager_user_delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success) {
                                usermanList.remove(i);
                                notifyDataSetChanged();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };

                DeleteRequest deleteRequest = new DeleteRequest(userID.getText().toString(), responseListener);
                RequestQueue queue = Volley.newRequestQueue(parentActivity);
                queue.add(deleteRequest);
            }
        });

        return v;
    }
}
