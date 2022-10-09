package com.example.myapplication_study;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Manager_home extends AppCompatActivity {
    private Button manager_btn_logout;

    private BottomNavigationView manager_bottomNavigationView;
    private FragmentManager sign_fm;
    private FragmentTransaction sign_ft;

    private Manager_Seat manager_seat;
    private ManagerNotice manager_notice;
    private ManagerUserman manager_userman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_managerhome);

        new BackgroundTask().execute();

        manager_btn_logout = findViewById(R.id.manager_btn_logout);
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
        manager_notice = new ManagerNotice();
        manager_userman = new ManagerUserman();
        setFrag(0);
    }

    private void setFrag(int n) {
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

    //매니저버튼
    class BackgroundTask extends AsyncTask<Void, Void, String>
    {
        String target;

        @Override
        //초기화
        protected void onPreExecute() {
            target = "http://capstudyapp.dothome.co.kr/managerBoardList.php";
        }

        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url  = new URL(target);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String temp;
                StringBuilder stringBuilder = new StringBuilder();
                while((temp = bufferedReader.readLine()) != null)
                {
                    stringBuilder.append(temp +"\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();

            } catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        public void onPostExecute(String result){
            //액티비티 전환
            Intent intent = new Intent(Manager_home.this, ManagerNotice.class);
            intent.putExtra("managerBoardList", result);
            //Manager_home.this.startActivity(intent);
        }
    }
}