package com.example.woodonggo;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    Home_Fragment_Main home_fragment_main;
    Ranking_Fragment_Main ranking_fragment_main;
    Local_Fragment_Main local_fragment_main;
    Chat_Fragment_Main  chat_fragment_main;
    MyPage_Fragment_Main myPage_fragment_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        home_fragment_main = new Home_Fragment_Main();
        ranking_fragment_main = new Ranking_Fragment_Main();
        local_fragment_main = new Local_Fragment_Main();
        chat_fragment_main = new Chat_Fragment_Main();
        myPage_fragment_main = new MyPage_Fragment_Main();

        //기본화면 지정
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, home_fragment_main).commit();

        NavigationBarView navigationBarView = findViewById(R.id.navigationView);
        navigationBarView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.home_item){
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, home_fragment_main).commit();
                    return true;
                }
                else if (item.getItemId() == R.id.ranking_item) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, ranking_fragment_main).commit();
                    return true;
                }
                else if (item.getItemId() == R.id.local_item) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, local_fragment_main).commit();
                    return true;
                }
                else if (item.getItemId() == R.id.chat_item) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, chat_fragment_main).commit();
                    return true;
                }
                else {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, myPage_fragment_main).commit();
                    return true;
                }
            }
        });
    }
}