package com.example.myapplication_study;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;


public class Sign_Voucher extends Fragment {
    private View view;
    private Button sign_buy_vocherbtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_signvoucher, container, false);

        sign_buy_vocherbtn = view.findViewById(R.id.sign_buy_vocherbtn);
        sign_buy_vocherbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Buy_Voucher.class);
                startActivity(intent);
            }
        });

        ImageView qrcode;
        qrcode = (ImageView)view.findViewById(R.id.qrcode) ;

        // TODO : QR코드를 읽었을떄, 문자열값
        String value = "https://www.naver.com";
        // ex : 01063313034
        // ex : 300,000,000
        createQRcode(qrcode, value);

        return view;
    }

    //QR 코드 생성 코드
    public void createQRcode(ImageView img, String text) {

        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(text, BarcodeFormat.QR_CODE, 200, 200);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            img.setImageBitmap(bitmap);
        } catch (Exception e) {
        }
    }
}