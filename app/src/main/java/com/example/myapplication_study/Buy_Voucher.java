package com.example.myapplication_study;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Buy_Voucher extends AppCompatActivity {

    RadioGroup gr_voucher, gr_voucher_day, gr_voucher_time, gr_voucher_group4, gr_voucher_group6;
    RadioButton voucher_day, voucher_time, voucher_group4, voucher_group6;
    RadioButton voucher_day_2, voucher_day_4, voucher_day_6, voucher_day_8, voucher_day_12;
    RadioButton voucher_time_30, voucher_time_50, voucher_time_100, voucher_time_200;
    RadioButton voucher_group4_2, voucher_group4_4, voucher_group4_6;
    RadioButton voucher_group6_2, voucher_group6_4, voucher_group6_6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_voucher);

        gr_voucher = findViewById(R.id.gr_voucher);
        gr_voucher_day = findViewById(R.id.gr_voucher_day);
        gr_voucher_time = findViewById(R.id.gr_voucher_time);
        gr_voucher_group4 = findViewById(R.id.gr_voucher_group4);
        gr_voucher_group6 = findViewById(R.id.gr_voucher_group6);

        voucher_day = findViewById(R.id.voucher_day);
        voucher_time = findViewById(R.id.voucher_time);
        voucher_group4 = findViewById(R.id.voucher_group4);
        voucher_group6 = findViewById(R.id.voucher_group6);

        voucher_day_2 = findViewById(R.id.voucher_day_2);
        voucher_day_4 = findViewById(R.id.voucher_day_4);
        voucher_day_6 = findViewById(R.id.voucher_day_6);
        voucher_day_8 = findViewById(R.id.voucher_day_8);
        voucher_day_12 = findViewById(R.id.voucher_day_12);

        voucher_time_30 = findViewById(R.id.voucher_time_30);
        voucher_time_50 = findViewById(R.id.voucher_time_50);
        voucher_time_100 = findViewById(R.id.voucher_time_100);
        voucher_time_200 = findViewById(R.id.voucher_time_200);

        voucher_group4_2 = findViewById(R.id.voucher_group4_2);
        voucher_group4_4 = findViewById(R.id.voucher_group4_4);
        voucher_group4_6 = findViewById(R.id.voucher_group4_6);

        voucher_group6_2 = findViewById(R.id.voucher_group6_2);
        voucher_group6_4 = findViewById(R.id.voucher_group6_4);
        voucher_group6_6 = findViewById(R.id.voucher_group6_6);

        gr_voucher.setOnCheckedChangeListener((group, checkedId) -> {
            if(voucher_day.isChecked()){
                gr_voucher_day.setVisibility(View.VISIBLE);
                gr_voucher_time.setVisibility(View.INVISIBLE);
                gr_voucher_group4.setVisibility(View.INVISIBLE);
                gr_voucher_group6.setVisibility(View.INVISIBLE);
            }if(voucher_time.isChecked()){
                gr_voucher_day.setVisibility(View.INVISIBLE);
                gr_voucher_time.setVisibility(View.VISIBLE);
                gr_voucher_group4.setVisibility(View.INVISIBLE);
                gr_voucher_group6.setVisibility(View.INVISIBLE);
            }if(voucher_group4.isChecked()){
                gr_voucher_day.setVisibility(View.INVISIBLE);
                gr_voucher_time.setVisibility(View.INVISIBLE);
                gr_voucher_group4.setVisibility(View.VISIBLE);
                gr_voucher_group6.setVisibility(View.INVISIBLE);
            }if(voucher_group6.isChecked()){
                gr_voucher_day.setVisibility(View.INVISIBLE);
                gr_voucher_time.setVisibility(View.INVISIBLE);
                gr_voucher_group4.setVisibility(View.INVISIBLE);
                gr_voucher_group6.setVisibility(View.VISIBLE);
            }
        });

    }
}