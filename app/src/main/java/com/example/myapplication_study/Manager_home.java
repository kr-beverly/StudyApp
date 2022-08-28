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
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class Manager_home extends AppCompatActivity {
    private Button manager_btn_logout;

    private BottomNavigationView manager_bottomNavigationView;
    private FragmentManager sign_fm;
    private FragmentTransaction sign_ft;

    private Manager_Seat manager_seat;
    private Manager_Notice manager_notice;
    private ManagerUserman manager_userman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_managerhome);

        manager_btn_logout=findViewById(R.id.manager_btn_logout);
        manager_btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_home = new Intent(Manager_home.this, MainActivity.class);
                startActivity(intent_home);
            }
        });

        manager_bottomNavigationView = findViewById(R.id.manager_bottomNavi);
        manager_bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuitem) {
                switch (menuitem.getItemId()) {
                    case R.id.manager_seat:
                        setFrag(0);
                        break;
                    case R.id.manager_notice:
                        setFrag(1);
                        break;
                    case R.id.manager_userman:
                        setFrag(2);
                        break;
                }
                return true;
            }
        });
        manager_seat = new Manager_Seat();
        manager_notice = new Manager_Notice();
        manager_userman = new Manager_Userman();
        setFrag(0);
    }

    private void setFrag (int n) {
        sign_fm = getSupportFragmentManager();
        sign_ft = sign_fm.beginTransaction();

        switch (n) {
            case 0:
                sign_ft.replace(R.id.manager_main_frame, manager_seat);
                sign_ft.commit();
                break;
            case 1:
                sign_ft.replace(R.id.manager_main_frame, manager_notice);
                sign_ft.commit();
                break;
            case 2:
                sign_ft.replace(R.id.manager_main_frame, manager_userman);
                sign_ft.commit();
        }
    }
}