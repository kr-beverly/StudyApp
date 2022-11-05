package com.example.myapplication_study;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class loginfrom extends AppCompatActivity {
    private Button btn_loginform;
    private Button btn_loginform_signup;
    private EditText et_id, et_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginform);

        et_id = findViewById(R.id.et_id);
        et_pass = findViewById(R.id.et_pass);
        btn_loginform = findViewById(R.id.btn_loginform);

        btn_loginform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user_id = et_id.getText().toString();
                String user_pass = et_pass.getText().toString();
                String user_num = null;

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success) {
                                String user_id = jsonObject.getString("user_id");
                                String user_pass = jsonObject.getString("user_pass");
                                String user_num = jsonObject.getString("user_num");

                                Toast.makeText(getApplicationContext(),"로그인에 성공하였습니다.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(loginfrom.this, Signup_home.class);
                                intent.putExtra("user_id",user_id);
                                intent.putExtra("user_pass",user_pass);
                                intent.putExtra("user_num", user_num);
                                startActivity(intent);

//                                Intent intent_usernum = new Intent(loginfrom.this, Register.class);
//                                intent_usernum.putExtra("user_num", user_num);
//                                startActivity(intent_usernum);
                            } else {
                                Toast.makeText(getApplicationContext(),"로그인에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                LoginRequest loginRequest = new LoginRequest(user_id, user_pass, responseListener);
                RequestQueue queue = Volley.newRequestQueue(loginfrom.this);
                queue.add(loginRequest);

            }
        });

        btn_loginform_signup = findViewById(R.id.btn_loginform_signup);
        btn_loginform_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(loginfrom.this, Signup.class);
                startActivity(intent);
            }
        });
    }
}
