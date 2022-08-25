package com.example.myapplication_study;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

class My_Voucher_Data{
    private String lastTime;
    private String voucherName;

    public My_Voucher_Data(String lastTime, String voucherName){
        this.lastTime = lastTime;
        this.voucherName = voucherName;
    }

    public String getLastTime(){
        return this.lastTime;
    }

    public String getVoucherName(){
        return this.voucherName;
    }
}

class MyAdapter extends BaseAdapter{
    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    ArrayList<My_Voucher_Data> My_Voucher_Data;

    public MyAdapter(Context context, ArrayList<My_Voucher_Data> data){
        mContext = context;
        My_Voucher_Data = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return My_Voucher_Data.size();
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
        View view = mLayoutInflater.inflate(R.layout.activity_my_voucher_list, null);

        TextView lastTime = (TextView)view.findViewById(R.id.lastTime);
        TextView voucherName = (TextView)view.findViewById(R.id.voucherName);

        lastTime.setText(My_Voucher_Data.get(position).getLastTime());
        voucherName.setText(My_Voucher_Data.get(position).getVoucherName());

        return view;
    }
}

public class My_Voucher extends AppCompatActivity {

    ArrayList<My_Voucher_Data> myVoucherList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_voucher);

        this.InitializeMyVoucher();

        ListView listView = (ListView)findViewById(R.id.MyVoucherlistView);
        final MyAdapter myAdapter = new MyAdapter(this,myVoucherList);

        listView.setAdapter(myAdapter);

    }

    //임시 값
    private void InitializeMyVoucher() {
        myVoucherList = new ArrayList<My_Voucher_Data>();

        myVoucherList.add(new My_Voucher_Data("3시간","일일이용권"));
        myVoucherList.add(new My_Voucher_Data("1시간","일일이용권"));
    }
}