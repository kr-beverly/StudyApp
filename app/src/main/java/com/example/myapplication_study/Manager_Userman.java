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
<<<<<<< HEAD
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
=======

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
>>>>>>> 6c5cdb53b91cc6ab251bac3ad6da0d67a1b0be19

}

class ManagerAdapter extends BaseAdapter{
<<<<<<< HEAD
    private Context context;
    private List<Manager_Userman_Data> userList;

    public ManagerAdapter(Context context, List<Manager_Userman_Data> userList){
        this.context = context;
        this.userList = userList;
=======
    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    ArrayList<Manager_Userman_Data> Manager_Userman_Data;

    public ManagerAdapter(Context context, ArrayList<Manager_Userman_Data> data){
        mContext = context;
        Manager_Userman_Data = data;
        mLayoutInflater = LayoutInflater.from(mContext);
>>>>>>> 6c5cdb53b91cc6ab251bac3ad6da0d67a1b0be19
    }

    @Override
    public int getCount() {
<<<<<<< HEAD
        return userList.size();
=======
        return Manager_Userman_Data.size();
>>>>>>> 6c5cdb53b91cc6ab251bac3ad6da0d67a1b0be19
    }

    @Override
    public Object getItem(int position) {
<<<<<<< HEAD
        return userList.get(position);
=======
        return position;
>>>>>>> 6c5cdb53b91cc6ab251bac3ad6da0d67a1b0be19
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
<<<<<<< HEAD
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
=======
    public View getView(int position, View converView, ViewGroup parant) {
        View view = mLayoutInflater.inflate(R.layout.activity_manageruserman_list, null);

        TextView id = (TextView)view.findViewById(R.id.userID);
        TextView password = (TextView)view.findViewById(R.id.userPassword);
        TextView name = (TextView)view.findViewById(R.id.userName);
        TextView lastTime = (TextView)view.findViewById(R.id.userLasttime);
        Button manager_user_edit_btn = (Button)view.findViewById(R.id.manager_user_edit_btn);
        Button manager_user_delete_btn = (Button)view.findViewById(R.id.manager_user_delete_btn);

        id.setText(Manager_Userman_Data.get(position).getId());
        password.setText(Manager_Userman_Data.get(position).getPassword());
        name.setText(Manager_Userman_Data.get(position).getName());
        lastTime.setText(Manager_Userman_Data.get(position).getLastTime());

        manager_user_edit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setTitle("회원 정보 수정");
                builder.setMessage("수정하시겠습니까?");
                builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                        //확인 클릭 후 회원 정보 수정 이벤트 추가 해야함
                    }
                });
                builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        Toast.makeText(builder.getContext(),"취소되었습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        manager_user_delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setTitle("회원 정보 삭제");
                builder.setMessage("삭제하시겠습니까?");
                builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                        Toast.makeText(builder.getContext(),"삭제되었습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        Toast.makeText(builder.getContext(),"취소되었습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });


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

>>>>>>> 6c5cdb53b91cc6ab251bac3ad6da0d67a1b0be19
}

