package com.example.woodonggo;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Home_Tab_Team extends Fragment {

    private RecyclerView recyclerView_team;
    private Home_ViewPager_Adapter adapter;
    private ArrayList<Home_Tab_Data> arrayList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_tab_team, container, false);

        recyclerView_team = view.findViewById(R.id.recyclerView_team);

        // 데이터 리스트 초기화
        arrayList = new ArrayList<>();

        // 어댑터 생성 및 설정
        adapter = new Home_ViewPager_Adapter(getActivity(), R.layout.home_tab_data, arrayList);
        recyclerView_team.setAdapter(adapter);

        return view;
    }
}