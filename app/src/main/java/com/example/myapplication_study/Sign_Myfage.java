package com.example.myapplication_study;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
<<<<<<< HEAD
import android.widget.EditText;
import android.widget.Toast;
=======
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
>>>>>>> 399935cf1fc08a3d6e5f0a665ac5e521947d88f3

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

<<<<<<< HEAD
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Sign_Myfage extends Fragment {
    private View view;
    private Button btn_update;
    private EditText et_id, et_pass, et_name, et_birth, et_phonenum, et_mail;
=======
public class Sign_Myfage extends Fragment {
    private View view;
>>>>>>> 399935cf1fc08a3d6e5f0a665ac5e521947d88f3

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_signmyfage, container, false);

<<<<<<< HEAD
        et_id = (EditText) view.findViewById(R.id.et_id);
        et_pass = (EditText) view.findViewById(R.id.et_pass);
        et_name = (EditText) view.findViewById(R.id.et_name);
        et_birth = (EditText) view.findViewById(R.id.et_birth);
        et_phonenum = (EditText) view.findViewById(R.id.et_phonenum);
        et_mail = (EditText) view.findViewById(R.id.et_mail);

        Intent intent = getActivity().getIntent();
        String user_id = intent.getStringExtra("user_id");
        String user_pass = intent.getStringExtra("user_pass");
        String name = intent.getStringExtra("name");
        String birth = intent.getStringExtra("birth");


        et_id.setText(user_id);
        et_pass.setText(user_pass);
        et_name.setText(name);
        et_birth.setText(birth);
//        et_phonenum.setText(et_phonenum);
//        et_mail.setText(et_mail);

        et_id = view.findViewById(R.id.et_id);
        et_pass = view.findViewById(R.id.et_pass);
        et_name = view.findViewById(R.id.et_name);
        et_birth = view.findViewById(R.id.et_birth);
        et_phonenum = view.findViewById(R.id.et_phonenum);
        et_mail = view.findViewById(R.id.et_mail);

        btn_update = (view.findViewById(R.id.btn_update));
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
                                Toast.makeText(getActivity(), "정보 수정에 성공하였습니다!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getActivity(), Signup_home.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(getActivity(), "정보 수정에 실패하였습니다.", Toast.LENGTH_SHORT).show();

                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                UpdateRequest updaterequest = new UpdateRequest(user_id, user_pass, user_name, birth, phonenum, mail, responseListener);
                RequestQueue queue = Volley.newRequestQueue(getContext());
                queue.add(updaterequest);

            }
        });
=======
        CheckBox ch_box = view.findViewById(R.id.ch_box);
        TextView ch_text_box = view.findViewById(R.id.ch_text_box);

        //탈퇴 사유
        RadioGroup gr_quit = (RadioGroup) view.findViewById(R.id.gr_quit);
        int quirGroupID = gr_quit.getCheckedRadioButtonId();
        RadioButton quit_1 = view.findViewById(R.id.quit_1);
        RadioButton quit_2 = view.findViewById(R.id.quit_2);
        RadioButton quit_3 = view.findViewById(R.id.quit_3);
        RadioButton quit_4 = view.findViewById(R.id.quit_4);
        EditText etc_quit = view.findViewById(R.id.etc_quit);

        //탈퇴 버튼
        Button quit_btn = view.findViewById(R.id.quit_btn);

        ch_box.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(ch_box.isChecked()) {
                    ch_text_box.setVisibility(View.VISIBLE);
                    gr_quit.setVisibility(View.VISIBLE);
                    quit_1.setVisibility(View.VISIBLE);
                    quit_2.setVisibility(View.VISIBLE);
                    quit_3.setVisibility(View.VISIBLE);
                    quit_4.setVisibility(View.VISIBLE);
                    quit_btn.setVisibility(View.VISIBLE);
                }else {
                    ch_text_box.setVisibility(View.VISIBLE);
                    gr_quit.setVisibility(View.VISIBLE);
                    quit_1.setVisibility(View.VISIBLE);
                    quit_2.setVisibility(View.VISIBLE);
                    quit_3.setVisibility(View.VISIBLE);
                    quit_4.setVisibility(View.VISIBLE);
                    quit_btn.setVisibility(View.VISIBLE);
                }
            }
        });

        quit_4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (quit_4.isChecked()) {
                    etc_quit.setVisibility(View.VISIBLE);
                } else {
                    etc_quit.setVisibility(View.VISIBLE);
                }
            }
        });

        //내 이용권 보기
        Button show_myVoucher = view.findViewById(R.id.show_myVoucher);
        show_myVoucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), My_Voucher.class);
                startActivity(intent);
            }
        });

        //회원정보 수정
        Button ch_myinfo = view.findViewById(R.id.ch_myinfo);
        ch_myinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UserInfo.class);
                startActivity(intent);
            }
        });

>>>>>>> 399935cf1fc08a3d6e5f0a665ac5e521947d88f3
        return view;
    }
}