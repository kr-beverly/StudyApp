package com.example.myapplication_study;

import androidx.appcompat.app.AlertDialog;
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

public class Signup extends AppCompatActivity {
    Button complete_save_user_sign;
    private EditText et_id, et_pass, et_name, et_birth, et_phonenum, et_mail;
    private Button check_button;
    private AlertDialog dialog;
    private boolean validate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        et_id = findViewById(R.id.et_id);
        et_pass = findViewById(R.id.et_pass);
        et_name = findViewById(R.id.et_name);
        et_birth = findViewById(R.id.et_birth);
        et_phonenum = findViewById(R.id.et_phonenum);
        et_mail = findViewById(R.id.et_mail);

        //아이디 중복 체크
        check_button = findViewById(R.id.check_button);
        check_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String user_id = et_id.getText().toString();

                if (validate) {
                    return; //검증 완료
                }

                if (user_id.equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Signup.this);
                    dialog = builder.setMessage("아이디를 입력하세요.").setPositiveButton("확인", null).create();
                    dialog.show();
                    return;
                }

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {

                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if (success) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(Signup.this);
                                dialog = builder.setMessage("사용할 수 있는 아이디입니다.").setPositiveButton("확인", null).create();
                                dialog.show();
                                et_id.setEnabled(false); //아이디값 고정
                                validate = true; //검증 완료
//                                check_button.setBackgroundColor(getResources().getColor(R.color.colorGray));
                            }
                            else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(Signup.this);
                                dialog = builder.setMessage("이미 존재하는 아이디입니다.").setNegativeButton("확인", null).create();
                                dialog.show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
<<<<<<< HEAD
=======

>>>>>>> 6c5cdb53b91cc6ab251bac3ad6da0d67a1b0be19
                ValidateRequest validateRequest = new ValidateRequest(user_id, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Signup.this);
                queue.add(validateRequest);
            }
        });


        complete_save_user_sign = findViewById(R.id.complete_save_user_sign);
        complete_save_user_sign.setOnClickListener(new View.OnClickListener() {
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
                                Toast.makeText(getApplicationContext(),"회원 등록에 성공하였습니다.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Signup.this, MainActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(getApplicationContext(),"회원 등록에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                RegisterRequest registerRequest = new RegisterRequest(user_id, user_pass, user_name, birth, phonenum, mail, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Signup.this);
                queue.add(registerRequest);

            }
        });
    }
}