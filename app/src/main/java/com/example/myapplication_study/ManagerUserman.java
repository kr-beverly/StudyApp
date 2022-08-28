package com.example.myapplication_study;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class ManagerUserman extends Fragment {
    ArrayList<Manager_Userman_Data> userList;
    ManagerAdapter managerAdapter;

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_manageruserman, container, false);


        return view;
    }

    //임시 값
    private void ManagerUserman() {
        userList = new ArrayList<Manager_Userman_Data>();
        userList.add(new Manager_Userman_Data("userID", "qwer1234", "이름"));
    }

}
