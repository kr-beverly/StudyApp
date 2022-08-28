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

public class MainActivity extends AppCompatActivity {
    private Button btn_login;
    private Button btn_manager_login;

    private BottomNavigationView bottomNavigationView;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private Reservation reservation;
    private Voucher voucher;
    private Notice notice;
    private Myfage myfage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //버튼 연결
        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, loginfrom.class);
                startActivity(intent);
            }
        });

        bottomNavigationView =findViewById(R.id.bottomNavi);
        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.reservation:
                       setFrag(0);
                      break;
                    case R.id.voucher:
                        setFrag(1);
                        break;
                    case R.id.notice:
                        setFrag(2);
                        break;
                    case R.id.myfage:
                        setFrag(3);
                        break;
                }
                return true;
            }
        });
        reservation = new Reservation();
        voucher = new  Voucher();
        notice = new Notice();
        myfage = new Myfage();
        setFrag(0); //첫 프래그먼트 화면 지정
    }

    //프레그먼트 교체
    private void setFrag (int n) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

        switch (n) {
            case 0:
                ft.replace(R.id.main_frame, reservation);
                ft.commit();
                break;
            case 1:
                ft.replace(R.id.main_frame, voucher);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.main_frame, notice);
                ft.commit();
                break;
            case 3:
                ft.replace(R.id.main_frame, myfage);
                ft.commit();
                break;
        }
    }
}