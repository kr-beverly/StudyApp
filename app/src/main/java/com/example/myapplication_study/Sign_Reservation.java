package com.example.myapplication_study;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
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

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Sign_Reservation extends Fragment {
    private View view;
    private Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    Button button[] = new Button[40];
    int btnID[] = {R.id.sign_seat_01, R.id.sign_seat_02, R.id.sign_seat_03, R.id.sign_seat_04, R.id.sign_seat_05, R.id.sign_seat_06, R.id.sign_seat_07, R.id.sign_seat_08, R.id.sign_seat_09, R.id.sign_seat_10,
            R.id.sign_seat_11, R.id.sign_seat_12, R.id.sign_seat_13, R.id.sign_seat_14, R.id.sign_seat_15, R.id.sign_seat_16, R.id.sign_seat_17, R.id.sign_seat_18, R.id.sign_seat_19, R.id.sign_seat_20,
            R.id.sign_seat_21, R.id.sign_seat_22, R.id.sign_seat_23, R.id.sign_seat_24, R.id.sign_seat_25, R.id.sign_seat_26, R.id.sign_seat_27, R.id.sign_seat_28, R.id.sign_seat_29, R.id.sign_seat_30,
            R.id.sign_seat_31, R.id.sign_seat_32, R.id.sign_seat_33, R.id.sign_seat_34, R.id.sign_seat_35, R.id.sign_seat_36, R.id.sign_seat_37, R.id.sign_seat_38, R.id.sign_seat_39, R.id.sign_seat_40};
    TextView textView;
    Button check_seat_time;
    String seat_code;

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
                builder.setTitle("퇴실예정석");
                builder.setMessage(" ");
                builder.setPositiveButton("닫기", new DialogInterface.OnClickListener() {
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
                @SuppressLint("ResourceType")
                @Override
                public void onClick(View view) {
                    Button newButton = (Button) view;

                    for (Button tempButton : button){
                        if(tempButton == newButton){

                            int seatID = btnID[finalI];
                            seat_code = view.findViewById(seatID).getContext().toString();

                            final Calendar mcurrentTime = Calendar.getInstance();
                            int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                            int minute = mcurrentTime.get(Calendar.MINUTE);
                            TimePickerDialog timePicker;

                            textView = new TextView(getActivity());
                            //timePicker 다이어로그
                            timePicker = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                                @Override
                                public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                                    String state = "오전";
                                    if (selectedHour > 12) {
                                        selectedHour -= 12;
                                        state = "오후";
                                    }

                                    textView.setText(state + " " + selectedHour + "시" + selectedMinute + "분");

                                    Response.Listener<String> responseListener = new Response.Listener<String>() {
                                        @Override
                                        public void onResponse(String response) {
                                            try{
                                                JSONObject jsonObject = new JSONObject(response);
                                                boolean success = jsonObject.getBoolean("success");
                                                if(success){
                                                    //확정 팝업
                                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                                    builder.setTitle(button[finalI].getText().toString() + "번 좌석");
                                                    builder.setMessage(textView.getText().toString() + " 예약 확정하시겠습니까?");
                                                    builder.setPositiveButton("예약 확정", new DialogInterface.OnClickListener() {
                                                        @Override
                                                        public void onClick(DialogInterface dialog, int i) {
                                                            Toast.makeText(getContext(), button[finalI].getText().toString() + "번 좌석 " + textView.getText().toString() + " 예약 확정 되었습니다.", Toast.LENGTH_SHORT).show();
                                                            dialog.dismiss();
                                                        }
                                                    });
                                                    builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                                                        @Override
                                                        public void onClick(DialogInterface dialogInterface, int i) {
                                                            Toast.makeText(getContext(),"취소되었습니다.", Toast.LENGTH_SHORT).show();
                                                        }
                                                    });
                                                    AlertDialog alertDialog = builder.create();
                                                    alertDialog.show();
                                                    //Toast.makeText(getContext(), button[finalI].getText().toString() + "번 좌석 " + textView.getText().toString() + " 예약 확정 되었습니다.", Toast.LENGTH_SHORT).show();
                                                    //Intent intent = new Intent(getActivity().getApplicationContext(), Signup_home.class);
                                                    //startActivity(intent);
                                                } else {
                                                    Toast.makeText(getActivity().getApplicationContext(),"이용권 구매에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                                                    return;
                                                }

                                            } catch (JSONException e){
                                                e.printStackTrace();
                                            }
                                        }
                                    };

                                    ReservationRequest reservationRequest = new ReservationRequest(seat_code, responseListener);
                                    RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
                                    queue.add(reservationRequest);

                                }
                            }, hour, minute, false); // true의 경우 24시간 형식의 TimePicker 출현
                            timePicker.setTitle("30분 전부터 예약 가능합니다.");
                            timePicker.show();

                        }
                    }
                }
            });
        }
        return view;
    }
}
