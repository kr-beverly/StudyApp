package com.example.myapplication_study;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class ManagerRequest extends StringRequest {
    //서버 url 설정(php파일 연동)
    final static  private String URL="http://capstudyapp.dothome.co.kr/userList.php";
    private Map<String, String> map;

    public ManagerRequest(String name, String user_id, String user_pass, Response.Listener<String> listener){
        super(Method.POST, URL, listener,null);

        map = new HashMap<>();
        map.put("name", name);
        map.put("user_id", user_id);
        map.put("user_pass", user_pass);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}