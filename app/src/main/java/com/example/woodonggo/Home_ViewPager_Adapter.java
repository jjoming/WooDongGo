package com.example.woodonggo;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class Home_ViewPager_Adapter extends FragmentStateAdapter {

    public Home_ViewPager_Adapter(@NonNull FragmentActivity fragmentActivity, int home_tab_data, ArrayList<String> arrayList) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return new Home_Tab_Team();
            case 1: return new Home_Tab_personal();
            default: return new Home_Tab_Team();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
