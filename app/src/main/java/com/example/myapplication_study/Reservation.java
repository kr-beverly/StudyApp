package com.example.myapplication_study;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import java.util.Calendar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;


public class Reservation extends Fragment {
    private View view;

    Button button[] = new Button[40];
    int btnID[] = {R.id.seat_01, R.id.seat_02, R.id.seat_03, R.id.seat_04, R.id.seat_05, R.id.seat_06, R.id.seat_07, R.id.seat_08, R.id.seat_09, R.id.seat_10,
            R.id.seat_11, R.id.seat_12, R.id.seat_13, R.id.seat_14, R.id.seat_15, R.id.seat_16, R.id.seat_17, R.id.seat_18, R.id.seat_19, R.id.seat_20,
            R.id.seat_21, R.id.seat_22, R.id.seat_23, R.id.seat_24, R.id.seat_25, R.id.seat_26, R.id.seat_27, R.id.seat_28, R.id.seat_29, R.id.seat_30,
            R.id.seat_31, R.id.seat_32, R.id.seat_33, R.id.seat_34, R.id.seat_35, R.id.seat_36, R.id.seat_37, R.id.seat_38, R.id.seat_39, R.id.seat_40};
    Button check_seat_time;
    String url = "http://capstudyapp.dothome.co.kr/SeatCheck.php";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_reservation, container, false);

        check_seat_time = view.findViewById(R.id.check_seat_time);

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

        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            JSONArray jsonArray = jsonObject.getJSONArray("data");

                            if (success.equals("1")) {
                                for(int i=0;i<jsonArray.length();i++) {
                                    JSONObject object = jsonArray.getJSONObject(i);

                                    String seat_able = object.getString("seat_able");
                                    String seat_code = object.getString("seat_code");

                                    Log.d("seat_code",seat_code);
                                    Log.d("seat_able",seat_able);

                                    if(seat_able.equals("X")) {
                                        button[i].setBackgroundColor(getContext().getResources().getColor(R.color.gray));
                                    }
                                }

                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(request);

        for (int i = 0; i < 40; i++) {
            int finalI = i;
            button[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Button newButton = (Button) view;
                    for (Button tempButton : button) {
                        if (tempButton == newButton) {
                            Intent intent = new Intent(getActivity(), loginfrom.class);
                            startActivity(intent);
                        }
                    }
                }
            });
        }
        return view;
    }
}

