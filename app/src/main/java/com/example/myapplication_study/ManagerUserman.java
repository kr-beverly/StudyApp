package com.example.myapplication_study;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;




public class ManagerUserman extends Fragment {
    private View view;

    private ListView listView;
    private ManagerUsermanListAdapter adapter;
    private List<ManagerUsermanList> usermanList;
    Activity context = getActivity();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_manageruserman, container, false);
        Intent intent = getActivity().getIntent();

        listView = view.findViewById(R.id.listView);
        usermanList = new ArrayList<ManagerUsermanList>();

        adapter = new ManagerUsermanListAdapter(getActivity().getApplicationContext(), usermanList, getActivity());
        listView.setAdapter(adapter);

        try {
            JSONObject jsonObject = new JSONObject(intent.getStringExtra("userList"));
            JSONArray jsonArray = jsonObject.getJSONArray("response");

            int count = 0;
            String name, user_id, user_pass;

            while (count < jsonArray.length()) {
                JSONObject object = jsonArray.getJSONObject(count);
                name = object.getString("name");
                user_id = object.getString("user_id");
                user_pass = object.getString("user_pass");
                ManagerUsermanList managerUsermanList = new ManagerUsermanList(name, user_id, user_pass);
                if(!user_id.equals("admin"))
                    usermanList.add(managerUsermanList);
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }
}