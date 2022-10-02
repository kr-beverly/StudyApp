package com.example.myapplication_study;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class Notice extends Fragment{
    private View view;

    ListView notice_listView;
    NoticeAdapter noticeAdapter;
    public static ArrayList<NoticeList> noticeListArrayList = new ArrayList<>();

    String url = "http://capstudyapp.dothome.co.kr/BoardList.php";
    NoticeList noticeList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.activity_notice, container, false);

        notice_listView = view.findViewById(R.id.notice_listView);
        noticeAdapter = new NoticeAdapter(getContext(), noticeListArrayList);
        notice_listView.setAdapter(noticeAdapter);

        retrieveData();

        return view;
    }

    public void retrieveData(){
        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        noticeListArrayList.clear();
                        try{

                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            JSONArray jsonArray = jsonObject.getJSONArray("data");

                            if(success.equals("1")){
                                for(int i=0;i<jsonArray.length();i++) {

                                    JSONObject object = jsonArray.getJSONObject(i);

                                    String writ_num = object.getString("writ_num");
                                    String writ_title = object.getString("writ_title");

                                    noticeList = new NoticeList(writ_num, writ_title);
                                    noticeListArrayList.add(noticeList);
                                    noticeAdapter.notifyDataSetChanged();
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