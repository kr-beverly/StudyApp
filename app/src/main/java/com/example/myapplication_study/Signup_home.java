package com.example.myapplication_study;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Signup_home extends AppCompatActivity {
    private Button sign_btn_logout;

    private BottomNavigationView sign_bottomNavigationView;
    private FragmentManager sign_fm;
    private FragmentTransaction sign_ft;

    private Sign_Reservation sign_reservation;
    private Sign_Voucher sign_voucher;
    private Sign_Notice sign_notice;
    private Sign_Myfage sign_myfage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signuphome);

        sign_btn_logout=findViewById(R.id.sign_btn_logout);
        sign_btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_home = new Intent(Signup_home.this, MainActivity.class);
                startActivity(intent_home);
            }
        });

        sign_bottomNavigationView = findViewById(R.id.sign_bottomNavi);
        sign_bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuitem) {
                switch (menuitem.getItemId()) {
                    case R.id.sign_resvation:
                        setFrag(0);
                        break;
                    case R.id.sign_voucher:
                        setFrag(1);
                        break;
                    case R.id.sign_notice:
                        setFrag(2);
                        break;
                    case R.id.sign_myfage:
                        setFrag(3);
                        break;
                }
                return true;
            }
        });
        sign_reservation = new Sign_Reservation();
        sign_voucher = new Sign_Voucher();
        sign_notice = new Sign_Notice();
        sign_myfage = new Sign_Myfage();
        setFrag(0);
    }

    private void setFrag (int n) {
        sign_fm = getSupportFragmentManager();
        sign_ft = sign_fm.beginTransaction();

        switch (n) {
            case 0:
                sign_ft.replace(R.id.sign_main_frame, sign_reservation);
                sign_ft.commit();
                break;
            case 1:
                sign_ft.replace(R.id.sign_main_frame, sign_voucher);
                sign_ft.commit();
                break;
            case 2:
                sign_ft.replace(R.id.sign_main_frame, sign_notice);
                sign_ft.commit();
                break;
            case 3:
                sign_ft.replace(R.id.sign_main_frame, sign_myfage);
                sign_ft.commit();
        }
    }
}