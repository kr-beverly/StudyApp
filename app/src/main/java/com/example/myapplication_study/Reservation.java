package com.example.myapplication_study;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class Reservation extends Fragment {
    View view;
    private Object Reservation;

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_reservation, container, false);

        Button[] seat = new Button[40];
        ArrayList<String> mDataList;
        mDataList = new ArrayList<>();

        for (int i = 0; i < 40; i++) {
            final int index;
            index = i;
            seat[i] = view.findViewById(R.id.seat_01+i);
            seat[0].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), loginfrom.class);
                    startActivity(intent);
                }
            });
        }


        return view;
    }
}

