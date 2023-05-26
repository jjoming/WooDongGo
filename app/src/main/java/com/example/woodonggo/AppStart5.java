package com.example.woodonggo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AppStart5 extends AppCompatActivity {
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appstart5);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // todo : 자동로그인시 메인액티비티로 넘어가기
                Intent intent = new Intent(AppStart5.this, Login_MainActivity.class);
                startActivity(intent);
                overridePendingTransition(0,0);
                finish();
            }
        }, 2000);
    }
}
