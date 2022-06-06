package com.example.myapplication_study;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class loginfrom extends AppCompatActivity {
    private Button btn_loginform;
    private Button btn_loginform_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginform);

        btn_loginform=findViewById(R.id.btn_loginform);
        btn_loginform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(loginfrom.this, Signup_home.class);
                startActivity(intent);
            }
        });

        btn_loginform_signup=findViewById(R.id.btn_loginform_signup);
        btn_loginform_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(loginfrom.this, Signup.class);
                startActivity(intent);
            }
        });
    }

}
