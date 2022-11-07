package com.example.myapplication_study;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class Manager_Seat extends Fragment {
    private View view;

    Button button[] = new Button[40];
    int btnID[] = {R.id.manager_seat_01, R.id.manager_seat_02, R.id.manager_seat_03, R.id.manager_seat_04, R.id.manager_seat_05, R.id.manager_seat_06, R.id.manager_seat_07, R.id.manager_seat_08, R.id.manager_seat_09, R.id.manager_seat_10,
            R.id.manager_seat_11, R.id.manager_seat_12, R.id.manager_seat_13, R.id.manager_seat_14, R.id.manager_seat_15, R.id.manager_seat_16, R.id.manager_seat_17, R.id.manager_seat_18, R.id.manager_seat_19, R.id.manager_seat_20,
            R.id.manager_seat_21, R.id.manager_seat_22, R.id.manager_seat_23, R.id.manager_seat_24, R.id.manager_seat_25, R.id.manager_seat_26, R.id.manager_seat_27, R.id.manager_seat_28, R.id.manager_seat_29, R.id.manager_seat_30,
            R.id.manager_seat_31, R.id.manager_seat_32, R.id.manager_seat_33, R.id.manager_seat_34, R.id.manager_seat_35, R.id.manager_seat_36, R.id.manager_seat_37, R.id.manager_seat_38, R.id.manager_seat_39, R.id.manager_seat_40};
    Button check_seat_time;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_managerseat, container, false);

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

        for (int i = 0; i < 40; i++) {
            int finalI = i;
            button[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Button newButton = (Button) view;
                    for (Button tempButton : button) {
                        if (tempButton == newButton) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                            builder.setTitle(button[finalI].getText().toString() + "번 좌석");
                            builder.setMessage("이용불가 좌석으로 지정 하시겠습니까?");
                            builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int id) {
                                    Toast.makeText(getContext(), button[finalI].getText().toString() + "번 좌석 " + "이용불가 처리되었습니다.", Toast.LENGTH_SHORT).show();
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
                        }
                    }
                }
            });
        }
        return view;
    }
}

