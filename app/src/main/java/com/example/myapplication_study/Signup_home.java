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

    private BottomNavigationView signbottomNavigationView;
    private FragmentManager signfm;
    private FragmentTransaction signft;
    private Reservation signreservation;
    private Voucher signvoucher;
    private Notice signnotice;
    private Myfage signmyfage;

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

        signbottomNavigationView = findViewById(R.id.sign_bottomNavi);
        signbottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
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
        signreservation = new Reservation();
        signvoucher = new Voucher();
        signnotice = new Notice();
        signmyfage = new Myfage();
        setFrag(1);
    }

    private void setFrag (int n) {
        signfm = getSupportFragmentManager();
        signft = signfm.beginTransaction();

        switch (n) {
            case 0:
                signft.replace(R.id.sign_main_frame, signreservation);
                signft.commit();
                break;
            case 1:
                signft.replace(R.id.sign_main_frame, signvoucher);
                signft.commit();
                break;
            case 2:
                signft.replace(R.id.sign_main_frame, signnotice);
                signft.commit();
                break;
            case 3:
                signft.replace(R.id.sign_main_frame, signmyfage);
                signft.commit();
        }
    }
}