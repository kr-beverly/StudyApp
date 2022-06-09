package com.example.myapplication_study;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;


import androidx.fragment.app.Fragment;


public class Voucher_fragment extends Fragment {
    RadioGroup gr_voucher, gr_voucher_day, gr_voucher_time, gr_voucher_group4, gr_voucher_group6;
    RadioButton voucher_day, voucher_time, voucher_group4, voucher_group6;
    RadioButton voucher_day_2, voucher_day_4, voucher_day_6, voucher_day_8, voucher_day_12;
    RadioButton voucher_time_30, voucher_time_50, voucher_time_100, voucher_time_200;
    RadioButton voucher_group4_2, voucher_group4_4, voucher_group4_6;
    RadioButton voucher_group6_2, voucher_group6_4, voucher_group6_6;

    public Voucher_fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_voucher, container, false);

        gr_voucher = v.findViewById(R.id.gr_voucher);
        gr_voucher_day = v.findViewById(R.id.gr_voucher_day);
        gr_voucher_time = v.findViewById(R.id.gr_voucher_time);
        gr_voucher_group4 = v.findViewById(R.id.gr_voucher_group4);
        gr_voucher_group6 = v.findViewById(R.id.gr_voucher_group6);

        voucher_day = v.findViewById(R.id.voucher_day);
        voucher_time = v.findViewById(R.id.voucher_time);
        voucher_group4 = v.findViewById(R.id.voucher_group4);
        voucher_group6 = v.findViewById(R.id.voucher_group6);

        voucher_day_2 = v.findViewById(R.id.voucher_day_2);
        voucher_day_4 = v.findViewById(R.id.voucher_day_4);
        voucher_day_6 = v.findViewById(R.id.voucher_day_6);
        voucher_day_8 = v.findViewById(R.id.voucher_day_8);
        voucher_day_12 = v.findViewById(R.id.voucher_day_12);

        voucher_time_30 = v.findViewById(R.id.voucher_time_30);
        voucher_time_50 = v.findViewById(R.id.voucher_time_50);
        voucher_time_100 = v.findViewById(R.id.voucher_time_100);
        voucher_time_200 = v.findViewById(R.id.voucher_time_200);

        voucher_group4_2 = v.findViewById(R.id.voucher_group4_2);
        voucher_group4_4 = v.findViewById(R.id.voucher_group4_4);
        voucher_group4_6 = v.findViewById(R.id.voucher_group4_6);

        voucher_group6_2 = v.findViewById(R.id.voucher_group6_2);
        voucher_group6_4 = v.findViewById(R.id.voucher_group6_4);
        voucher_group6_6 = v.findViewById(R.id.voucher_group6_6);

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

    return v;
    }

}

