package com.example.myapplication_study;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class Reservation extends Fragment implements View.OnClickListener {

    Button seat_1, seat_2, seat_3, seat_4, seat_5, seat_6, seat_7, seat_8, seat_9, seat_10;
    Button seat_11, seat_12, seat_13, seat_14;
    Button seat_15, seat_16, seat_17, seat_18;
    Button seat_19, seat_20, seat_21, seat_22;
    Button seat_23, seat_24, seat_25, seat_26;
    Button seat_27, seat_28, seat_29, seat_30, seat_31, seat_32;
    Button seat_33, seat_34, seat_35, seat_36, seat_37, seat_38;
    Button[] numButtons = new Button[40];
    Integer[] numBtnIDs = {R.id.seat_1,R.id.seat_2,R.id.seat_3,R.id.seat_4,R.id.seat_5,R.id.seat_6,R.id.seat_7,R.id.seat_8,R.id.seat_9,R.id.seat_10,
            R.id.seat_11,R.id.seat_12,R.id.seat_13,R.id.seat_14,
            R.id.seat_15,R.id.seat_16,R.id.seat_17,R.id.seat_18,
            R.id.seat_19,R.id.seat_20,R.id.seat_21,R.id.seat_22,
            R.id.seat_23,R.id.seat_24,R.id.seat_25,R.id.seat_26,
            R.id.seat_27,R.id.seat_28,R.id.seat_29,R.id.seat_30,R.id.seat_31,R.id.seat_32,
            R.id.seat_33,R.id.seat_34,R.id.seat_35,R.id.seat_36,R.id.seat_37,R.id.seat_38};
    int i;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_reservation, container, false);
        return v;
    }
    @Override
    public void onClick(View view) {
        for(i=0;i<numButtons.length;i++){
            final int index;
            index = i;
            numButtons[index].setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (index < 39) {
                        AlertDialog.Builder dlg = new AlertDialog.Builder(getActivity());
                        dlg.setTitle("예약 확정");
                        dlg.setMessage("정말 예약을 확정하시겠습니까?");
                        dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getActivity(), "예약 확정 되었습니다.\n 완료 버튼을 누르세요",
                                        Toast.LENGTH_SHORT).show();

                            }

                        });
                    }
                }
            });
        }
    }
}