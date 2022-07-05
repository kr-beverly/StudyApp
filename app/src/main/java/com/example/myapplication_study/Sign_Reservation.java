package com.example.myapplication_study;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;

import java.util.Objects;

public class Sign_Reservation extends Fragment {
    private View view;
    Button sign_seat_1, sign_seat_2, sign_seat_3, sign_seat_4, sign_seat_5, sign_seat_6, sign_seat_7, sign_seat_8, sign_seat_9, sign_seat_10,
            sign_seat_11, sign_seat_12, sign_seat_13, sign_seat_14, sign_seat_15, sign_seat_16, sign_seat_17, sign_seat_18, sign_seat_19, sign_seat_20,
            sign_seat_21, sign_seat_22, sign_seat_23, sign_seat_24, sign_seat_25, sign_seat_26, sign_seat_27, sign_seat_28, sign_seat_29, sign_seat_30,
            sign_seat_31, sign_seat_32, sign_seat_33, sign_seat_34, sign_seat_35, sign_seat_36, sign_seat_37, sign_seat_38, sign_seat_39,  sign_seat_40;

    TextView textView2;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_signreservation, container, false);

        sign_seat_1 = view.findViewById(R.id.sign_seat_1);
        textView2 = view.findViewById(R.id.textView2);


        sign_seat_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog timePicker;
                textView2 = new TextView(getActivity());
                //timePicker 다이어로그
                timePicker = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        String state = "AM";
                        if (selectedHour > 12) {
                            selectedHour -= 12;
                            state = "PM";
                        }
                        textView2.setText(state+" "+selectedHour+"시"+selectedMinute+"분");

                        //확정 팝업
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                        builder.setMessage(textView2.getText().toString()+" 예약 확정하시겠습니까?");
                        builder.setPositiveButton("예약 확정", new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                Toast.makeText(getContext(), textView2.getText().toString()+" 예약 확정 되었습니다.", Toast.LENGTH_SHORT).show();
                            }
                        });
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                    }
                }, hour, minute, false); // true의 경우 24시간 형식의 TimePicker 출현
                timePicker.setTitle("30분 전부터 예약 가능합니다.");
                timePicker.show();
            }
        });

        sign_seat_2 = view.findViewById(R.id.sign_seat_2);
        sign_seat_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog timePicker;
                textView2 = new TextView(getActivity());
                //timePicker 다이어로그
                timePicker = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        String state = "AM";
                        if (selectedHour > 12) {
                            selectedHour -= 12;
                            state = "PM";
                        }
                        textView2.setText(state+" "+selectedHour+"시"+selectedMinute+"분");

                        //확정 팝업
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                        builder.setMessage(textView2.getText().toString()+" 예약 확정하시겠습니까?");
                        builder.setPositiveButton("예약 확정", new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                Toast.makeText(getContext(), textView2.getText().toString()+" 예약 확정 되었습니다.", Toast.LENGTH_SHORT).show();
                            }
                        });
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                    }
                }, hour, minute, false); // true의 경우 24시간 형식의 TimePicker 출현
                timePicker.setTitle("30분 전부터 예약 가능합니다.");
                timePicker.show();
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