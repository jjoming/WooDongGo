package com.example.woodonggo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

public class MyPage_Fragment_Main extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.mypage_fragment_main, container, false);
        Toolbar toolbar = view.findViewById(R.id.toolbar);

        return view;
    }
}