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

public class NoticeAdapter extends ArrayAdapter<NoticeList> {

    Context context;
    List<NoticeList> arraynoticeList;

    public NoticeAdapter(@NonNull Context context, List<NoticeList> arraynoticeList) {
        super(context, R.layout.activity_notice_list, arraynoticeList);

        this.context = context;
        this.arraynoticeList = arraynoticeList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_notice_list, null, true);

        TextView tvnum = view.findViewById(R.id.notice_num);
        TextView tvtitle = view.findViewById(R.id.notice_title);

        tvnum.setText(arraynoticeList.get(position).getWrit_num());
        tvtitle.setText(arraynoticeList.get(position).getWrit_title());

        return view;
    }
}
