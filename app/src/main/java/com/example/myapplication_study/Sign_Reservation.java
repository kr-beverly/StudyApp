package com.example.myapplication_study;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import java.util.Calendar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Objects;

public class Sign_Reservation extends Fragment {
    private View view;

    Button button[] = new Button[40];
    int btnID[] = {R.id.sign_seat_01, R.id.sign_seat_02, R.id.sign_seat_03, R.id.sign_seat_04, R.id.sign_seat_05, R.id.sign_seat_06, R.id.sign_seat_07, R.id.sign_seat_08, R.id.sign_seat_09, R.id.sign_seat_10,
            R.id.sign_seat_11, R.id.sign_seat_12, R.id.sign_seat_13, R.id.sign_seat_14, R.id.sign_seat_15, R.id.sign_seat_16, R.id.sign_seat_17, R.id.sign_seat_18, R.id.sign_seat_19, R.id.sign_seat_20,
            R.id.sign_seat_21, R.id.sign_seat_22, R.id.sign_seat_23, R.id.sign_seat_24, R.id.sign_seat_25, R.id.sign_seat_26, R.id.sign_seat_27, R.id.sign_seat_28, R.id.sign_seat_29, R.id.sign_seat_30,
            R.id.sign_seat_31, R.id.sign_seat_32, R.id.sign_seat_33, R.id.sign_seat_34, R.id.sign_seat_35, R.id.sign_seat_36, R.id.sign_seat_37, R.id.sign_seat_38, R.id.sign_seat_39, R.id.sign_seat_40};
    TextView textView2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_signreservation, container, false);

        textView2 = view.findViewById(R.id.textView2);

        for (int i = 0; i < 40; i++) {
            button[i] = view.findViewById(btnID[i]);
        }

        for (int i = 0; i < 40; i++)
        button[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Button newButton = (Button) view;
                    for (Button tempButton : button){
                        if(tempButton == newButton){
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
                                    textView2.setText(state + " " + selectedHour + "시" + selectedMinute + "분");
                                    //확정 팝업
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setMessage(textView2.getText().toString() + " 예약 확정하시겠습니까?");
                                    builder.setPositiveButton("예약 확정", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Toast.makeText(getContext(), textView2.getText().toString() + " 예약 확정 되었습니다.", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();
                                }
                            }, hour, minute, false); // true의 경우 24시간 형식의 TimePicker 출현
                            timePicker.setTitle("30분 전부터 예약 가능합니다.");
                            timePicker.show();
                        }
                    }
                }
            });

        return view;

    }
}

