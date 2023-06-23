package com.example.woodonggo;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabLayout;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "SOL_LOG"; //ㅎㅐ시키

    public FrameLayout frameLayout;

    Home_Fragment_Main home_fragment_main;
    Ranking_Fragment_Main ranking_fragment_main;
    Local_Fragment_Main local_fragment_main;
    Chat_Fragment_Main  chat_fragment_main;
    MyPage_Fragment_Main myPage_fragment_main;

    @RequiresApi(api = Build.VERSION_CODES.P) //해시키
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout = findViewById(R.id.frameLayout);

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



            try {
                PackageManager packageManager = getPackageManager();
                String packageName = getPackageName();
                PackageInfo information = packageManager.getPackageInfo(packageName, PackageManager.GET_SIGNING_CERTIFICATES);
                android.content.pm.Signature[] signatures = information.signingInfo.getApkContentsSigners();
                for (android.content.pm.Signature signature : signatures) {
                    MessageDigest md = MessageDigest.getInstance("SHA");
                    md.update(signature.toByteArray());
                    byte[] digest = md.digest();
                    String HASH_CODE = Base64.encodeToString(digest, Base64.DEFAULT);

                    Log.d(TAG, "HASH_CODE -> " + HASH_CODE);
                }
            } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException e) {
                Log.d(TAG, "Exception -> " + e);

        }
    }
}