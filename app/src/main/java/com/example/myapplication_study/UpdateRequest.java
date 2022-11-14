package com.example.myapplication_study;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class UpdateRequest extends StringRequest {

    final static private String URL = "http://capstudyapp.dothome.co.kr/update.php";
    private Map<String, String> map;

    public UpdateRequest(String user_id, String user_pass, String name, int birth, int phonenum, String mail, Response.Listener<String> listener){
        super(Request.Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("user_id",user_id);
        map.put("user_pass",user_pass);
        map.put("name",name);
        map.put("birth",birth + "");
        map.put("phonenum",phonenum + "");
        map.put("mail",mail);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
