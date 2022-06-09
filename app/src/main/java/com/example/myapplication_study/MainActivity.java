package com.example.myapplication_study;

<<<<<<< HEAD
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
=======
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
>>>>>>> 11b480b41a237084994d360ec930a258be9fa969

public class MainActivity extends AppCompatActivity {
    private Button btn_login;

<<<<<<< HEAD
    Button reservation, voucher, notice, myfage;
=======
    private BottomNavigationView bottomNavigationView;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private Reservation reservation;
    private Voucher voucher;
    private Notice notice;
    private Myfage myfage;

>>>>>>> 11b480b41a237084994d360ec930a258be9fa969

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //버튼 연결
<<<<<<< HEAD
        btn_login=findViewById(R.id.btn_login);
=======
        btn_login = findViewById(R.id.btn_login);
>>>>>>> 11b480b41a237084994d360ec930a258be9fa969
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, loginfrom.class);
                startActivity(intent);
            }
        });

<<<<<<< HEAD
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
                Voucher_fragment voucher = new Voucher_fragment();
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
=======
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
>>>>>>> 11b480b41a237084994d360ec930a258be9fa969
