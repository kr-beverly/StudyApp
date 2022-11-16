package com.example.myapplication_study;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class AvailableRequest extends StringRequest {
    final static private String URL = "http://capstudyapp.dothome.co.kr/Available_seat.php";
    private Map<String, String> map;

    public AvailableRequest(String seat_code, Response.Listener<String> listener){
        super(Request.Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("seat_code",seat_code);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }

}
