package com.example.myapplication_study;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class Sign_Voucher extends Fragment {
    private View view;
    private Button sign_buy_vocherbtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_signvoucher, container, false);

        sign_buy_vocherbtn = view.findViewById(R.id.sign_buy_vocherbtn);
        sign_buy_vocherbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Buy_Voucher.class);
                startActivity(intent);
            }
        });

        return view;
    }

}