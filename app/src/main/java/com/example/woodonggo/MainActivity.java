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
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, home_fragment_main);
        NavigationBarView navigationBarView = findViewById(R.id.navigationView);
        navigationBarView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    //TODO: 선택한 아이템의 아이디에 따라서 다른 프레그먼트 보여주기
                }
                return false;
            }
        });
    }
}