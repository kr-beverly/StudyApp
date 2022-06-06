package com.example.myapplication_study;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication_study.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private Button btn_login;

    Button reservation, voucher, notice, myfage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //버튼 연결
        btn_login=findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, loginfrom.class);
                startActivity(intent);
            }
        });

        reservation = (Button) findViewById(R.id.resvation);
        voucher = (Button) findViewById(R.id.voucher);
        notice = (Button) findViewById(R.id.notice);
        myfage = (Button) findViewById(R.id.myfage);

        reservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Reservation reservation = new Reservation();
                transaction.replace(R.id.main_frame, reservation);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        voucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Voucher voucher = new Voucher();
                transaction.replace(R.id.main_frame, voucher);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Notice notice = new Notice();
                transaction.replace(R.id.main_frame, notice);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        myfage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Myfage myfage = new Myfage();
                transaction.replace(R.id.main_frame, myfage);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }
}