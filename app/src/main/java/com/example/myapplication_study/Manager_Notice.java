package com.example.myapplication_study;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

class Manager_Notice_Data {
    private String noticetitle;

    public Manager_Notice_Data(String noticetitle){
        this.noticetitle = noticetitle;
    }


    public String getNoticetitle() {return this.noticetitle;}

}

class ManagerNoticeAdapter extends BaseAdapter{
    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    ArrayList<Manager_Notice_Data> Manager_Notice_Data;

    public ManagerNoticeAdapter(Context context, ArrayList<Manager_Notice_Data> data){
        mContext = context;
        Manager_Notice_Data = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return Manager_Notice_Data.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View converview, ViewGroup parant) {
        View view = mLayoutInflater.inflate(R.layout.activity_managernotice_list, null);

        TextView noticetitle = (TextView)view.findViewById(R.id.noticeTitle);
        Button noticedelete = (Button)view.findViewById(R.id.noticeDelete);

        noticetitle.setText(Manager_Notice_Data.get(position).getNoticetitle());
        noticedelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setTitle("공지글 삭제");
                builder.setMessage("삭제하시겠습니까?");
                builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                        Toast.makeText(builder.getContext(),"삭제되었습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        Toast.makeText(builder.getContext(),"취소되었습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
        return view;
    }
}

public class Manager_Notice extends Fragment {

    ArrayList<Manager_Notice_Data> Manager_Notice_list;
    Button manager_notice_write_btn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_managernotice, container, false);


        this.Manager_Notice();

        ListView listView = view.findViewById(R.id.Managernotice_listView);
        final ManagerNoticeAdapter myAdapter = new ManagerNoticeAdapter(getContext(), Manager_Notice_list);

        listView.setAdapter(myAdapter);

        manager_notice_write_btn = view.findViewById(R.id.manager_notice_write_btn);
        manager_notice_write_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Register.class);
                startActivity(intent);
            }
        });


        return view;
    }

    private void Manager_Notice() {
        Manager_Notice_list = new ArrayList<Manager_Notice_Data>();

        Manager_Notice_list.add(new Manager_Notice_Data("로그인 관련 공지"));
        Manager_Notice_list.add(new Manager_Notice_Data("회원가입 관련 공지"));
    }

}
