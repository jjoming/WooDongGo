package com.example.woodonggo;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class Home_Fragment_Main extends Fragment {
    TabLayout tabLayout;
    ViewPager2 viewPager;
    FloatingActionButton floatingBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment_main, container, false);
        tabLayout = view.findViewById(R.id.tabLayout);
        viewPager = view.findViewById(R.id.viewPager);
        Home_ViewPager_Adapter home_viewPager_adapter = new Home_ViewPager_Adapter(requireActivity());
        viewPager.setAdapter(home_viewPager_adapter);

        // TabLayout과 ViewPager 연동
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    switch (position) {
                        case 0:
                            tab.setText("팀");
                            break;
                        case 1:
                            tab.setText("개인");
                            break;
                    }
                }).attach();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        floatingBtn = view.findViewById(R.id.floatingBtn);
        floatingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO:게시글 작성 화면으로 이동
            }
        });
        super.onViewCreated(view, savedInstanceState);
    }
}