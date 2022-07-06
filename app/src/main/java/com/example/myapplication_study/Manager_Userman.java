package com.example.myapplication_study;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

class Manager_Userman_Data{
    private String id;
    private String password;
    private String name;
    private String lastTime;

    public Manager_Userman_Data(String id, String password, String name, String lastTime){
        this.id = id;
        this.password = password;
        this.name = name;
        this.lastTime = lastTime;
    }

    public String getId() {return this.id;}
    public String getPassword() {return this.password;}
    public String getName() {return this.name;}
    public String getLastTime() {return this.lastTime;}

}

class ManagerAdapter extends BaseAdapter{
    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    ArrayList<Manager_Userman_Data> Manager_Userman_Data;

    public ManagerAdapter(Context context, ArrayList<Manager_Userman_Data> data){
        mContext = context;
        Manager_Userman_Data = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return Manager_Userman_Data.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View converView, ViewGroup parant) {
        View view = mLayoutInflater.inflate(R.layout.activity_manageruserman_list, null);

        TextView id = (TextView)view.findViewById(R.id.userID);
        TextView password = (TextView)view.findViewById(R.id.userPassword);
        TextView name = (TextView)view.findViewById(R.id.userName);
        TextView lastTime = (TextView)view.findViewById(R.id.userLasttime);

        id.setText(Manager_Userman_Data.get(position).getId());
        password.setText(Manager_Userman_Data.get(position).getPassword());
        name.setText(Manager_Userman_Data.get(position).getName());
        lastTime.setText(Manager_Userman_Data.get(position).getLastTime());


        return view;
    }
}

public class Manager_Userman extends Fragment {

    ArrayList<Manager_Userman_Data> Manager_Userman_list;

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_manageruserman, container, false);

        this.ManagerUserman();

        ListView listView = view.findViewById(R.id.Userman_listView);
        final ManagerAdapter myAdapter = new ManagerAdapter(getContext(), Manager_Userman_list);

        listView.setAdapter(myAdapter);

        return view;
    }

    //임시 값
    private void ManagerUserman() {
        Manager_Userman_list = new ArrayList<Manager_Userman_Data>();

        Manager_Userman_list.add(new Manager_Userman_Data("abc123", "qwer1234", "이름", "3시간"));
        Manager_Userman_list.add(new Manager_Userman_Data("abc123", "qwer1234", "이름2", "7시간"));
    }

}

