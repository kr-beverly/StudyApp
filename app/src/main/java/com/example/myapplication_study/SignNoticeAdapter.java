package com.example.myapplication_study;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class SignNoticeAdapter extends ArrayAdapter<SignNoticeList> {

    Context context;
    List<SignNoticeList> arraysignNoticeList;

    public SignNoticeAdapter(@NonNull Context context, List<SignNoticeList> arraysignNoticeList) {
        super(context, R.layout.activity_signnotice_list, arraysignNoticeList);

        this.context = context;
        this.arraysignNoticeList = arraysignNoticeList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_signnotice_list, null, true);

        TextView signtvnum = view.findViewById(R.id.sign_notice_num);
        TextView signtvtitle = view.findViewById(R.id.sign_notice_title);

        signtvnum.setText(arraysignNoticeList.get(position).getWrit_num());
        signtvtitle.setText(arraysignNoticeList.get(position).getWrit_title());

        return view;
    }
}
