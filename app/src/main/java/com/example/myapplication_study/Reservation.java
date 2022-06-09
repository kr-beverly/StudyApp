package com.example.myapplication_study;

import android.os.Bundle;
<<<<<<< HEAD
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.myapplication_study.databinding.ActivityReservationBinding;

public class Reservation extends Fragment {
    public Reservation() {
        // Required empty public constructor
    }
=======
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

public class Reservation extends Fragment {
    private View view;
>>>>>>> 11b480b41a237084994d360ec930a258be9fa969

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
<<<<<<< HEAD
        return inflater.inflate(R.layout.activity_reservation, container, false);
=======
        view = inflater.inflate(R.layout.activity_reservation, container, false);
        return view;
>>>>>>> 11b480b41a237084994d360ec930a258be9fa969
    }
}