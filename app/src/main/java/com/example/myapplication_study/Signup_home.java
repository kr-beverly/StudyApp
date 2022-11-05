package com.example.myapplication_study;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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


public class Signup_home extends AppCompatActivity {
    private Button sign_btn_logout;

    private BottomNavigationView sign_bottomNavigationView;
    private FragmentManager sign_fm;
    private FragmentTransaction sign_ft;

    private Sign_Reservation sign_reservation;
    private Sign_Voucher sign_voucher;
    private SignNotice sign_notice;
    private Sign_Myfage sign_myfage;

    private SharedPreferences preferences;
    private TextView tv_usernum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signuphome);

        preferences = getSharedPreferences("user_tbl", MODE_PRIVATE);
        tv_usernum = findViewById(R.id.tv_usernum);

        //매니저 버튼
        Intent intent = getIntent();
        String user_id = intent.getStringExtra("user_id");
        String user_pass = intent.getStringExtra("user_pass");

        Button ManagementButton = (Button) findViewById(R.id.btn_manager_login);

        if(!user_id.equals("admin"))
        {
            ManagementButton.setVisibility(View.GONE);
        }

        ManagementButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                new BackgroundTask().execute();
            }
        });


//        btn_manager_login = findViewById(R.id.btn_manager_login);
//        btn_manager_login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Signup_home.this, Manager_home.class);
//                startActivity(intent);
//            }
//        });

        sign_btn_logout=findViewById(R.id.sign_btn_logout);
        sign_btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Signup_home.this, "로그아웃 되었습니다!", Toast.LENGTH_LONG).show();
                Intent intent_home = new Intent(Signup_home.this, MainActivity.class);
                intent_home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
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
        sign_notice = new SignNotice();
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

    //매니저버튼
    class BackgroundTask extends AsyncTask<Void, Void, String>
    {
        String target;

        @Override
        //초기화
        protected void onPreExecute() {
            target = "http://capstudyapp.dothome.co.kr/userList.php";
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
            Intent intent = new Intent(Signup_home.this, Manager_home.class);
            intent.putExtra("userList", result);
            Signup_home.this.startActivity(intent);
        }
    }

    private void getPreferences(){
        //getString(KEY,KEY값이 없을때 대체)
        tv_usernum.setText("user_num = " + preferences.getString("user_num",""));
    }
}