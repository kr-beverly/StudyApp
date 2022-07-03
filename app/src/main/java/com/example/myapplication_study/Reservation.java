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
    private Object Reservation;
    Button seat_01, seat_02, seat_03, seat_04, seat_05, seat_06, seat_07, seat_08, seat_09, seat_10,
            seat_11, seat_12, seat_13, seat_14, seat_15, seat_16, seat_17, seat_18,
            seat_19, seat_20, seat_21, seat_22, seat_23, seat_24, seat_25, seat_26,
            seat_27, seat_28, seat_29, seat_30, seat_31, seat_32, seat_33, seat_34,
            seat_35, seat_36, seat_37, seat_38, seat_39, seat_40;

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_reservation, container, false);

        seat_01 = view.findViewById(R.id.seat_01);
        seat_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), loginfrom.class);
                startActivity(intent);
            }
        });
        seat_02 = view.findViewById(R.id.seat_02);
        seat_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), loginfrom.class);
                startActivity(intent);
            }
        });
        seat_03 = view.findViewById(R.id.seat_03);
        seat_03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), loginfrom.class);
                startActivity(intent);
            }
        });
        seat_04 = view.findViewById(R.id.seat_04);
        seat_04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), loginfrom.class);
                startActivity(intent);
            }
        });
        seat_05 = view.findViewById(R.id.seat_05);
        seat_05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), loginfrom.class);
                startActivity(intent);
            }
        });
        seat_06 = view.findViewById(R.id.seat_06);
        seat_06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), loginfrom.class);
                startActivity(intent);
            }
        });
        seat_07 = view.findViewById(R.id.seat_07);
        seat_07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), loginfrom.class);
                startActivity(intent);
            }
        });
        seat_08 = view.findViewById(R.id.seat_08);
        seat_08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), loginfrom.class);
                startActivity(intent);
            }
        });
        seat_09 = view.findViewById(R.id.seat_09);
        seat_09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), loginfrom.class);
                startActivity(intent);
            }
        });

        seat_10 = view.findViewById(R.id.seat_10);
        seat_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), loginfrom.class);
                startActivity(intent);
            }
        });
        seat_11 = view.findViewById(R.id.seat_11);
        seat_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), loginfrom.class);
                startActivity(intent);
            }
        });
        seat_12 = view.findViewById(R.id.seat_12);
        seat_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), loginfrom.class);
                startActivity(intent);
            }
        });
        seat_13 = view.findViewById(R.id.seat_13);
        seat_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), loginfrom.class);
                startActivity(intent);
            }
        });
        seat_14 = view.findViewById(R.id.seat_14);
        seat_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), loginfrom.class);
                startActivity(intent);
            }
        });
        seat_15 = view.findViewById(R.id.seat_15);
        seat_15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), loginfrom.class);
                startActivity(intent);
            }
        });
        seat_16 = view.findViewById(R.id.seat_16);
        seat_16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), loginfrom.class);
                startActivity(intent);
            }
        });
        seat_17 = view.findViewById(R.id.seat_17);
        seat_17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), loginfrom.class);
                startActivity(intent);
            }
        });
        seat_18 = view.findViewById(R.id.seat_18);
        seat_18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), loginfrom.class);
                startActivity(intent);
            }
        });
        seat_19 = view.findViewById(R.id.seat_19);
        seat_19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), loginfrom.class);
                startActivity(intent);
            }
        });

        seat_20 = view.findViewById(R.id.seat_20);
        seat_20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), loginfrom.class);
                startActivity(intent);
            }
        });
        seat_21 = view.findViewById(R.id.seat_21);
        seat_21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), loginfrom.class);
                startActivity(intent);
            }
        });
        seat_22 = view.findViewById(R.id.seat_22);
        seat_22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), loginfrom.class);
                startActivity(intent);
            }
        });
        seat_23 = view.findViewById(R.id.seat_23);
        seat_23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), loginfrom.class);
                startActivity(intent);
            }
        });
        seat_24 = view.findViewById(R.id.seat_24);
        seat_24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), loginfrom.class);
                startActivity(intent);
            }
        });
        seat_25 = view.findViewById(R.id.seat_25);
        seat_25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), loginfrom.class);
                startActivity(intent);
            }
        });
        seat_26 = view.findViewById(R.id.seat_26);
        seat_26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), loginfrom.class);
                startActivity(intent);
            }
        });
        seat_27 = view.findViewById(R.id.seat_27);
        seat_27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), loginfrom.class);
                startActivity(intent);
            }
        });
        seat_28 = view.findViewById(R.id.seat_28);
        seat_28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), loginfrom.class);
                startActivity(intent);
            }
        });
        seat_29 = view.findViewById(R.id.seat_29);
        seat_29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), loginfrom.class);
                startActivity(intent);
            }
        });

        seat_30 = view.findViewById(R.id.seat_30);
        seat_30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), loginfrom.class);
                startActivity(intent);
            }
        });
        seat_31 = view.findViewById(R.id.seat_31);
        seat_31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), loginfrom.class);
                startActivity(intent);
            }
        });
        seat_32 = view.findViewById(R.id.seat_32);
        seat_32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), loginfrom.class);
                startActivity(intent);
            }
        });
        seat_33 = view.findViewById(R.id.seat_33);
        seat_33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), loginfrom.class);
                startActivity(intent);
            }
        });
        seat_34 = view.findViewById(R.id.seat_34);
        seat_34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), loginfrom.class);
                startActivity(intent);
            }
        });
        seat_35 = view.findViewById(R.id.seat_35);
        seat_35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), loginfrom.class);
                startActivity(intent);
            }
        });
        seat_36 = view.findViewById(R.id.seat_36);
        seat_36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), loginfrom.class);
                startActivity(intent);
            }
        });
        seat_37 = view.findViewById(R.id.seat_37);
        seat_37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), loginfrom.class);
                startActivity(intent);
            }
        });
        seat_38 = view.findViewById(R.id.seat_38);
        seat_38.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), loginfrom.class);
                startActivity(intent);
            }
        });
        seat_39 = view.findViewById(R.id.seat_39);
        seat_39.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), loginfrom.class);
                startActivity(intent);
            }
        });
        seat_40 = view.findViewById(R.id.seat_40);
        seat_40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), loginfrom.class);
                startActivity(intent);
            }
        });

        return view;
    }

}

