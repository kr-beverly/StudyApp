package com.example.myapplication_study;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Buy_Voucher extends AppCompatActivity {

    private String acess_code;
    Button voucher_purchase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_voucher);

        voucher_purchase = findViewById(R.id.vocher_purchase);
        voucher_purchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioGroup gr_voucher = (RadioGroup) findViewById(R.id.gr_voucher);
                int gr_voucherID = gr_voucher.getCheckedRadioButtonId();
                acess_code = ((RadioButton) findViewById(gr_voucherID)).getText().toString();

                gr_voucher.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        RadioButton voucherButton = (RadioButton) findViewById(checkedId);
                        acess_code = voucherButton.getText().toString();
                    }
                });

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success) {
                                Toast.makeText(getApplicationContext(), "이용권 구매에 성공하였습니다!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Buy_Voucher.this, Sign_Voucher.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(getApplicationContext(),"이용권 구매에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                BuyRequest buyRequest = new BuyRequest(acess_code, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Buy_Voucher.this);
                queue.add(buyRequest);
            }
        });
    }
}