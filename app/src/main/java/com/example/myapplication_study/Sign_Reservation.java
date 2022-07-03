package com.example.myapplication_study;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Objects;

public class Sign_Reservation extends Fragment {
    private View view;
    Button sign_seat_1, sign_seat_2, sign_seat_3, sign_seat_4, sign_seat_5, sign_seat_6, sign_seat_7, sign_seat_8, sign_seat_9, sign_seat_10,
            sign_seat_11, sign_seat_12, sign_seat_13, sign_seat_14, sign_seat_15, sign_seat_16, sign_seat_17, sign_seat_18, sign_seat_19, sign_seat_20,
            sign_seat_21, sign_seat_22, sign_seat_23, sign_seat_24, sign_seat_25, sign_seat_26, sign_seat_27, sign_seat_28, sign_seat_29, sign_seat_30,
            sign_seat_31, sign_seat_32, sign_seat_33, sign_seat_34, sign_seat_35, sign_seat_36, sign_seat_37, sign_seat_38, sign_seat_39,  sign_seat_40;
    TimePickerDialog timePickerDialog;
    TextView textView;
    TextClock textClock;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_signreservation, container, false);

        sign_seat_1 = view.findViewById(R.id.sign_seat_1);
        sign_seat_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context mContext = requireActivity().getApplicationContext();
                LayoutInflater inflater1 = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                View layout = inflater1.inflate(R.layout.activity_reservation_page, (ViewGroup) view.findViewById(R.id.reservation_popup));
                AlertDialog.Builder aDialog = new AlertDialog.Builder(getActivity());

                aDialog.setView(layout);

                AlertDialog ad = aDialog.create();
                ad.show();
            }
        });

        sign_seat_2 = view.findViewById(R.id.sign_seat_2);
        sign_seat_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Reservation_page.class);
                startActivity(intent);
            }
        });
        sign_seat_3 = view.findViewById(R.id.sign_seat_3);
        sign_seat_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Reservation_page.class);
                startActivity(intent);
            }
        });
        sign_seat_4 = view.findViewById(R.id.sign_seat_4);
        sign_seat_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Reservation_page.class);
                startActivity(intent);
            }
        });
        sign_seat_5 = view.findViewById(R.id.sign_seat_5);
        sign_seat_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Reservation_page.class);
                startActivity(intent);
            }
        });
        sign_seat_6 = view.findViewById(R.id.sign_seat_6);
        sign_seat_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Reservation_page.class);
                startActivity(intent);
            }
        });
        sign_seat_7 = view.findViewById(R.id.sign_seat_7);
        sign_seat_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Reservation_page.class);
                startActivity(intent);
            }
        });
        sign_seat_8 = view.findViewById(R.id.sign_seat_8);
        sign_seat_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Reservation_page.class);
                startActivity(intent);
            }
        });
        sign_seat_9 = view.findViewById(R.id.sign_seat_9);
        sign_seat_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Reservation_page.class);
                startActivity(intent);
            }
        });

        sign_seat_10 = view.findViewById(R.id.sign_seat_10);
        sign_seat_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Reservation_page.class);
                startActivity(intent);
            }
        });
        sign_seat_11 = view.findViewById(R.id.sign_seat_11);
        sign_seat_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Reservation_page.class);
                startActivity(intent);
            }
        });
        sign_seat_12 = view.findViewById(R.id.sign_seat_12);
        sign_seat_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Reservation_page.class);
                startActivity(intent);
            }
        });
        sign_seat_13 = view.findViewById(R.id.sign_seat_13);
        sign_seat_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Reservation_page.class);
                startActivity(intent);
            }
        });
        sign_seat_14 = view.findViewById(R.id.sign_seat_14);
        sign_seat_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Reservation_page.class);
                startActivity(intent);
            }
        });
        sign_seat_15 = view.findViewById(R.id.sign_seat_15);
        sign_seat_15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Reservation_page.class);
                startActivity(intent);
            }
        });
        sign_seat_16 = view.findViewById(R.id.sign_seat_16);
        sign_seat_16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Reservation_page.class);
                startActivity(intent);
            }
        });
        sign_seat_17 = view.findViewById(R.id.sign_seat_17);
        sign_seat_17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Reservation_page.class);
                startActivity(intent);
            }
        });
        sign_seat_18 = view.findViewById(R.id.sign_seat_18);
        sign_seat_18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Reservation_page.class);
                startActivity(intent);
            }
        });
        sign_seat_19 = view.findViewById(R.id.sign_seat_19);
        sign_seat_19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Reservation_page.class);
                startActivity(intent);
            }
        });

        sign_seat_20 = view.findViewById(R.id.sign_seat_20);
        sign_seat_20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Reservation_page.class);
                startActivity(intent);
            }
        });
        sign_seat_21 = view.findViewById(R.id.sign_seat_21);
        sign_seat_21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Reservation_page.class);
                startActivity(intent);
            }
        });
        sign_seat_22 = view.findViewById(R.id.sign_seat_22);
        sign_seat_22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Reservation_page.class);
                startActivity(intent);
            }
        });
        sign_seat_23 = view.findViewById(R.id.sign_seat_23);
        sign_seat_23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Reservation_page.class);
                startActivity(intent);
            }
        });
        sign_seat_24 = view.findViewById(R.id.sign_seat_24);
        sign_seat_24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Reservation_page.class);
                startActivity(intent);
            }
        });
        sign_seat_25 = view.findViewById(R.id.sign_seat_25);
        sign_seat_25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Reservation_page.class);
                startActivity(intent);
            }
        });
        sign_seat_26 = view.findViewById(R.id.sign_seat_26);
        sign_seat_26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Reservation_page.class);
                startActivity(intent);
            }
        });
        sign_seat_27 = view.findViewById(R.id.sign_seat_27);
        sign_seat_27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Reservation_page.class);
                startActivity(intent);
            }
        });
        sign_seat_28 = view.findViewById(R.id.sign_seat_28);
        sign_seat_28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Reservation_page.class);
                startActivity(intent);
            }
        });
        sign_seat_29 = view.findViewById(R.id.sign_seat_29);
        sign_seat_29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Reservation_page.class);
                startActivity(intent);
            }
        });

        sign_seat_30 = view.findViewById(R.id.sign_seat_30);
        sign_seat_30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Reservation_page.class);
                startActivity(intent);
            }
        });
        sign_seat_31 = view.findViewById(R.id.sign_seat_31);
        sign_seat_31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Reservation_page.class);
                startActivity(intent);
            }
        });
        sign_seat_32 = view.findViewById(R.id.sign_seat_32);
        sign_seat_32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Reservation_page.class);
                startActivity(intent);
            }
        });
        sign_seat_33 = view.findViewById(R.id.sign_seat_33);
        sign_seat_33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Reservation_page.class);
                startActivity(intent);
            }
        });
        sign_seat_34 = view.findViewById(R.id.sign_seat_34);
        sign_seat_34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Reservation_page.class);
                startActivity(intent);
            }
        });
        sign_seat_35 = view.findViewById(R.id.sign_seat_35);
        sign_seat_35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Reservation_page.class);
                startActivity(intent);
            }
        });
        sign_seat_36 = view.findViewById(R.id.sign_seat_36);
        sign_seat_36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Reservation_page.class);
                startActivity(intent);
            }
        });
        sign_seat_37 = view.findViewById(R.id.sign_seat_37);
        sign_seat_37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Reservation_page.class);
                startActivity(intent);
            }
        });
        sign_seat_38 = view.findViewById(R.id.sign_seat_38);
        sign_seat_38.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Reservation_page.class);
                startActivity(intent);
            }
        });
        sign_seat_39 = view.findViewById(R.id.sign_seat_39);
        sign_seat_39.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Reservation_page.class);
                startActivity(intent);
            }
        });
        sign_seat_40 = view.findViewById(R.id.sign_seat_40);
        sign_seat_40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Reservation_page.class);
                startActivity(intent);
            }
        });

        return view;
    }

}