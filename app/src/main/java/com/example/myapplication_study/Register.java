package com.example.myapplication_study;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class Register extends AppCompatActivity {
    private Button rewrite_button;
    private EditText title_et, content_et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        title_et=findViewById(R.id.title_et);
        content_et=findViewById(R.id.content_et);

        rewrite_button = findViewById(R.id.rewrite_button);
        rewrite_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String writ_title = title_et.getText().toString();
                String writ_content = content_et.getText().toString();

                if (TextUtils.isEmpty(writ_title)) {
                    title_et.setError("Please enter Title");
                } else if (TextUtils.isEmpty(writ_content)) {
                    content_et.setError("Please enter Title");
                } else {
                    // calling method to add data to Firebase Firestore.
                    addDataToDatabase(writ_title, writ_content);
                }

                Intent intent = new Intent(Register.this, Signup_home.class);
                startActivity(intent);
            }
        });
    }

    private void addDataToDatabase(String writ_title, String writ_content) {

        // url to post our data
        String url = "http://capstudyapp.dothome.co.kr/Board.php";

        // creating a new variable for our request queue
        RequestQueue queue = Volley.newRequestQueue(Register.this);

        // on below line we are calling a string
        // request method to post the data to our API
        // in this we are calling a post method.
        StringRequest request = new StringRequest(Request.Method.POST, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("TAG", "RESPONSE IS " + response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    // on below line we are displaying a success toast message.
                    Toast.makeText(Register.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                // and setting data to edit text as empty
                title_et.setText("");
                content_et.setText("");
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // method to handle errors.
                Toast.makeText(Register.this, "Fail to get response = " + error, Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            public String getBodyContentType() {
                // as we are passing data in the form of url encoded
                // so we are passing the content type below
                return "application/x-www-form-urlencoded; charset=UTF-8";
            }

            @Override
            protected Map<String, String> getParams() {

                // below line we are creating a map for storing
                // our values in key and value pair.
                Map<String, String> params = new HashMap<String, String>();

                // on below line we are passing our
                // key and value pair to our parameters.
                params.put("writ_title", writ_title);
                params.put("writ_content", writ_content);

                // at last we are returning our params.
                return params;
            }
        };
        // below line is to make
        // a json object request.
        queue.add(request);
    }
}