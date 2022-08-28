package com.example.myapplication_study;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

class Manager_Userman_Data{
    String user_id;
    String user_pass;
    String name;


    public String getUserID() {
        return user_id;
    }

    public void setUserID(String user_id) {
        this.user_id = user_id;
    }

    public String getUserPassword() {
        return user_pass;
    }

    public void setUserPassword(String user_pass) {
        this.user_pass = user_pass;
    }

    public String getUserName() {
        return name;
    }

    public void setUserName(String name) {
        this.name = name;
    }

    public Manager_Userman_Data(String user_id, String user_pass, String name) {
        this.user_id = user_id;
        this.user_pass = user_pass;
        this.name = name;
    }

}

class ManagerAdapter extends BaseAdapter{
    private Context context;
    private List<Manager_Userman_Data> userList;

    public ManagerAdapter(Context context, List<Manager_Userman_Data> userList){
        this.context = context;
        this.userList = userList;
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int position) {
        return userList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(context, R.layout.activity_manageruserman_list, null);
        TextView userID = (TextView) v.findViewById(R.id.userID);
        TextView userPassword = (TextView) v.findViewById(R.id.userPassword);
        TextView userName = (TextView) v.findViewById(R.id.userName);


        userID.setText(userList.get(position).getUserID());
        userPassword.setText(userList.get(position).getUserPassword());
        userName.setText(userList.get(position).getUserName());

        v.setTag(userList.get(position).getUserID());
        return v;
    }
}

