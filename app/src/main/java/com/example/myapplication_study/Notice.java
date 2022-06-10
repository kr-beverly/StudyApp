package com.example.myapplication_study;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Notice extends Fragment implements View.OnCreateContextMenuListener{
<<<<<<< HEAD
=======

>>>>>>> d2da87ed0e188cfdb49edae166fd3b83eb5f42dd
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_notice, container, false);
<<<<<<< HEAD

        return view;

=======
        return view;
>>>>>>> d2da87ed0e188cfdb49edae166fd3b83eb5f42dd
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}