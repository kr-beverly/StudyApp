package com.example.myapplication_study;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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

public class Myfage extends Fragment {
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_myfage, container, false);

        CheckBox ch_login= view.findViewById(R.id.ch_login);
        Button myfage_loginbtn = view.findViewById(R.id.myfage_loginbtn);
        myfage_loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), loginfrom.class);
                startActivity(intent);
            }
        });

        ch_login.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(ch_login.isChecked()) {
                    myfage_loginbtn.setVisibility(View.VISIBLE);
                } else {
                    myfage_loginbtn.setVisibility(View.VISIBLE);
                }
            }
        });

        return view;
    }
}