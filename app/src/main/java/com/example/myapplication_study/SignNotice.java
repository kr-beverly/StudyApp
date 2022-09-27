package com.example.myapplication_study;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SignNotice extends Fragment {
    private Button sign_notice_write_btn;
    private View view;

    ListView listView;
    SignNoticeAdapter signNoticeAdapter;
    public static ArrayList<SignNoticeList> signNoticeListArrayList = new ArrayList<>();
    String url = "http://capstudyapp.dothome.co.kr/BoardList.php";
    SignNoticeList signNoticeList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_signnotice, container, false);

        listView = view.findViewById(R.id.sign_listView);
        signNoticeAdapter = new SignNoticeAdapter(getContext(), signNoticeListArrayList);
        listView.setAdapter(signNoticeAdapter);
        retrieveData();

        //글쓰기 창으로 넘어감
        sign_notice_write_btn = view.findViewById(R.id.sign_notice_write_btn);
        sign_notice_write_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Register.class);
                startActivity(intent);
            }
        });

        return view;
    }

    public void retrieveData(){
        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        signNoticeListArrayList.clear();
                        try{

                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            JSONArray jsonArray = jsonObject.getJSONArray("data");

                            if(success.equals("1")){
                                for(int i=0;i<jsonArray.length();i++) {

                                    JSONObject object = jsonArray.getJSONObject(i);

                                    String writ_num = object.getString("writ_num");
                                    String writ_title = object.getString("writ_title");

                                    signNoticeList = new SignNoticeList(writ_num, writ_title);
                                    signNoticeListArrayList.add(signNoticeList);
                                    signNoticeAdapter.notifyDataSetChanged();
                                }
                            }
                        }
                        catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(request);
    }
}