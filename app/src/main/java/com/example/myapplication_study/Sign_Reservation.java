package com.example.myapplication_study;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class Sign_Reservation extends Fragment {
    private View view;

    Button button[] = new Button[40];
    int btnID[] = {R.id.sign_seat_01, R.id.sign_seat_02, R.id.sign_seat_03, R.id.sign_seat_04, R.id.sign_seat_05, R.id.sign_seat_06, R.id.sign_seat_07, R.id.sign_seat_08, R.id.sign_seat_09, R.id.sign_seat_10,
            R.id.sign_seat_11, R.id.sign_seat_12, R.id.sign_seat_13, R.id.sign_seat_14, R.id.sign_seat_15, R.id.sign_seat_16, R.id.sign_seat_17, R.id.sign_seat_18, R.id.sign_seat_19, R.id.sign_seat_20,
            R.id.sign_seat_21, R.id.sign_seat_22, R.id.sign_seat_23, R.id.sign_seat_24, R.id.sign_seat_25, R.id.sign_seat_26, R.id.sign_seat_27, R.id.sign_seat_28, R.id.sign_seat_29, R.id.sign_seat_30,
            R.id.sign_seat_31, R.id.sign_seat_32, R.id.sign_seat_33, R.id.sign_seat_34, R.id.sign_seat_35, R.id.sign_seat_36, R.id.sign_seat_37, R.id.sign_seat_38, R.id.sign_seat_39, R.id.sign_seat_40};
    TextView textView;
    Button check_seat_time;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_signreservation, container, false);

        check_seat_time = view.findViewById(R.id.check_seat_time);
        textView = view.findViewById(R.id.textView);

        check_seat_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("???????????????");
                builder.setMessage(" ");
                builder.setPositiveButton("??????", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        for (int i = 0; i < 40; i++) {
            button[i] = view.findViewById(btnID[i]);
        }

        for (int i = 0; i < 40; i++) {
            int finalI = i;
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

                            textView = new TextView(getActivity());
                            //timePicker ???????????????
                            timePicker = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                                @Override
                                public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                                    String state = "??????";
                                    if (selectedHour > 12) {
                                        selectedHour -= 12;
                                        state = "??????";
                                    }

                                    textView.setText(state + " " + selectedHour + "???" + selectedMinute + "???");



                                    //?????? ??????
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle(button[finalI].getText().toString() + "??? ??????");
                                    builder.setMessage(textView.getText().toString() + " ?????? ?????????????????????????");
                                    builder.setPositiveButton("?????? ??????", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Toast.makeText(getContext(), button[finalI].getText().toString() + "??? ?????? " + textView.getText().toString() + " ?????? ?????? ???????????????.", Toast.LENGTH_SHORT).show();
                                            dialog.dismiss();
                                        }
                                    });
                                    builder.setNegativeButton("??????", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            Toast.makeText(getContext(),"?????????????????????.", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();
                                }
                                }, hour, minute, false); // true??? ?????? 24?????? ????????? TimePicker ??????
                            timePicker.setTitle("30??? ????????? ?????? ???????????????.");
                            timePicker.show();
                        }
                    }
                }
            });
        }
        return view;
    }
}

