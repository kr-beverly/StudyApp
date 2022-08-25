package com.example.myapplication_study;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class UserInfo extends AppCompatActivity {

    private Button btn_update;
    private EditText et_id, et_pass, et_name, et_birth, et_phonenum, et_mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        et_id = findViewById(R.id.et_id);
        et_pass = findViewById(R.id.et_pass);
        et_name = findViewById(R.id.et_name);
        et_birth = findViewById(R.id.et_birth);
        et_phonenum = findViewById(R.id.et_phonenum);
        et_mail = findViewById(R.id.et_mail);

        btn_update = (findViewById(R.id.btn_update));

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_id = et_id.getText().toString();
                String user_pass = et_pass.getText().toString();
                String user_name = et_name.getText().toString();
                int birth = Integer.parseInt(et_birth.getText().toString());
                int phonenum = Integer.parseInt(et_phonenum.getText().toString());
                String mail = et_mail.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success) {
                                Toast.makeText(getApplicationContext(),"정보 수정에 성공하였습니다.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(UserInfo.this, Signup_home.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(getApplicationContext(),"정보 수정에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                UpdateRequest updaterequest = new UpdateRequest(user_id, user_pass, user_name, birth, phonenum, mail, responseListener);
                RequestQueue queue = Volley.newRequestQueue(UserInfo.this);
                queue.add(updaterequest);

            }
        });
    }
}