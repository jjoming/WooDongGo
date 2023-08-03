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

public class Home_Tab_Team extends AppCompatActivity {

    private RecyclerView recyclerView_team;
    private Home_ViewPager_Adapter adapter;
    private ArrayList<Home_Tab_Data> arrayList;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_tab_team);

        recyclerView_team = findViewById(R.id.recyclerView_team);

    }

    private void init() {
        recyclerView_team = findViewById(R.id.recyclerView_team);
        arrayList = new ArrayList<Home_Tab_Data>();
        adapter = new Home_ViewPager_Adapter(getApplicationContext(), R.layout.home_tab_data, arrayList);
        recyclerView_team.setAdapter(adapter);
    }

    private void addItem() {

    }

    private void setRecyclerView() {

    }
}