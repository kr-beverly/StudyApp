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

public class ManagerNotice extends Fragment {
    Button manager_notice_delete, manager_notice_write_btn;

    private ListView managerListView;
    private ManagerNoticeAdapter noticeAdapter;
    private ArrayList<ManagerNoticeDataList> managerNoticeDataList = new ArrayList<>();

    String url = "http://capstudyapp.dothome.co.kr/managerBoardList.php";
    ManagerNoticeDataList managerNoticeList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_managernotice, container, false);

        managerListView = view.findViewById(R.id.managerNoticeListView);
        noticeAdapter = new ManagerNoticeAdapter(getContext(), managerNoticeDataList, getActivity());
        managerListView.setAdapter(noticeAdapter);

        retrieveData();

        //공지글 쓰기
        manager_notice_write_btn = view.findViewById(R.id.manager_notice_write_btn);
        manager_notice_write_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                        managerNoticeDataList.clear();
                        try{

                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            JSONArray jsonArray = jsonObject.getJSONArray("data");

                            if(success.equals("1")){
                                for(int i=0;i<jsonArray.length();i++) {

                                    JSONObject object = jsonArray.getJSONObject(i);

                                    String writ_num = object.getString("writ_num");
                                    String writ_title = object.getString("writ_title");

                                    managerNoticeList = new ManagerNoticeDataList(writ_num, writ_title);
                                    managerNoticeDataList.add(managerNoticeList);
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
