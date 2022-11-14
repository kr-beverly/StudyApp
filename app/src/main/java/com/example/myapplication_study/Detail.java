package com.example.myapplication_study;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Detail extends AppCompatActivity {

    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView title_tv = (TextView) findViewById(R.id.title_tv);
        TextView date_tv = (TextView) findViewById(R.id.date_tv);
        TextView content_tv = (TextView) findViewById(R.id.content_tv);

        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");

        title_tv.setText(SignNotice.signNoticeListArrayList.get(position).getWrit_title());
        date_tv.setText(SignNotice.signNoticeListArrayList.get(position).getWrit_date());
        content_tv.setText(SignNotice.signNoticeListArrayList.get(position).getWrit_content());
    }
}