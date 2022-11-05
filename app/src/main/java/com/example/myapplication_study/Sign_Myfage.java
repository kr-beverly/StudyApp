package com.example.myapplication_study;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Sign_Myfage extends Fragment {
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_signmyfage, container, false);

        CheckBox ch_box = view.findViewById(R.id.ch_box);
        TextView ch_text_box = view.findViewById(R.id.ch_text_box);

        //탈퇴 사유
        RadioGroup gr_quit = (RadioGroup) view.findViewById(R.id.gr_quit);
        int quirGroupID = gr_quit.getCheckedRadioButtonId();
        RadioButton quit_1 = view.findViewById(R.id.quit_1);
        RadioButton quit_2 = view.findViewById(R.id.quit_2);
        RadioButton quit_3 = view.findViewById(R.id.quit_3);
        RadioButton quit_4 = view.findViewById(R.id.quit_4);
        EditText etc_quit = view.findViewById(R.id.etc_quit);

        //탈퇴 버튼
        Button quit_btn = view.findViewById(R.id.quit_btn);

        ch_box.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(ch_box.isChecked()) {
                    ch_text_box.setVisibility(View.VISIBLE);
                    gr_quit.setVisibility(View.VISIBLE);
                    quit_1.setVisibility(View.VISIBLE);
                    quit_2.setVisibility(View.VISIBLE);
                    quit_3.setVisibility(View.VISIBLE);
                    quit_4.setVisibility(View.VISIBLE);
                    quit_btn.setVisibility(View.VISIBLE);
                }else {
                    ch_text_box.setVisibility(View.VISIBLE);
                    gr_quit.setVisibility(View.VISIBLE);
                    quit_1.setVisibility(View.VISIBLE);
                    quit_2.setVisibility(View.VISIBLE);
                    quit_3.setVisibility(View.VISIBLE);
                    quit_4.setVisibility(View.VISIBLE);
                    quit_btn.setVisibility(View.VISIBLE);
                }
            }
        });

        quit_4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (quit_4.isChecked()) {
                    etc_quit.setVisibility(View.VISIBLE);
                } else {
                    etc_quit.setVisibility(View.VISIBLE);
                }
            }
        });

        //내 이용권 보기
        Button show_myVoucher = view.findViewById(R.id.show_myVoucher);
        show_myVoucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), My_Voucher.class);
                startActivity(intent);
            }
        });

        //회원정보 수정
        Button ch_myinfo = view.findViewById(R.id.ch_myinfo);
        ch_myinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UserInfo.class);
                startActivity(intent);
            }
        });

        return view;
    }
}