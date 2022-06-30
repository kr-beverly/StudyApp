package com.example.myapplication_study;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

public class Reservation extends Fragment {
    View view;
    Button seat[] = new Button[38];
    Integer[] Rid_seat = {R.id.seat_01,R.id.seat_02,R.id.seat_03,R.id.seat_04,R.id.seat_05,
                        R.id.seat_06,R.id.seat_07,R.id.seat_08,R.id.seat_09,R.id.seat_10,
                        R.id.seat_11,R.id.seat_12,R.id.seat_13,R.id.seat_14,R.id.seat_15,
                        R.id.seat_16,R.id.seat_17,R.id.seat_18,R.id.seat_19,R.id.seat_20,
                        R.id.seat_21,R.id.seat_22,R.id.seat_23,R.id.seat_24,R.id.seat_25,
                        R.id.seat_26,R.id.seat_27,R.id.seat_28,R.id.seat_29,R.id.seat_30,
                        R.id.seat_31,R.id.seat_32,R.id.seat_33,R.id.seat_34,R.id.seat_35,
                        R.id.seat_36,R.id.seat_37,R.id.seat_38};
    ArrayList<String> mDataList;

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_reservation, container, false);



        for (int i = 0; i < 38; i++) {
            seat[i] = (Button) view.findViewById(Rid_seat[i]);
        }

        for(int i=0; i<seat.length; i++){
            final int INDEX;
            INDEX = i;
            seat[INDEX].setOnClickListener(v -> {
                class MyListener implements View.OnClickListener {
                    @Override
                    public void onClick(View view) {
                        androidx.appcompat.app.AlertDialog.Builder alert = new androidx.appcompat.app.AlertDialog.Builder(getActivity());
                        alert.setTitle("예약 확정");

                        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
                        String date = format.format(Calendar.getInstance().getTime());
                        alert.setMessage(date);
                        alert.setMessage(date + "\n" + "예약을 확정하시겠습니까?");

                        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int ok) {
                                Toast.makeText(getContext().getApplicationContext(), "예약 확정되었습니다.", Toast.LENGTH_SHORT).show();
                            }
                        });

                        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int cancel) {
                                Toast.makeText(getContext().getApplicationContext(), "Cancel", Toast.LENGTH_SHORT).show();
                            }
                        });

                        alert.show();
                    }
                }
            });
        }

        return view;
    }

}

