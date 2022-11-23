package com.skytale;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.skytale.myadapter.ViewPagerCryptographyAdapter;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabSkyMain;
    private ViewPager viewPagerSkyMain;

    private ViewPagerCryptographyAdapter myFragmentAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        tabSkyMain = findViewById(R.id.tabSkyMain);
        viewPagerSkyMain = findViewById(R.id.viewPagerSkyMain);
        myFragmentAdapter = new ViewPagerCryptographyAdapter(getSupportFragmentManager());
        viewPagerSkyMain.setAdapter(myFragmentAdapter);
//        tabSkyMain.setupWithViewPager(viewPagerSkyMain);

        tabSkyMain.setupWithViewPager(viewPagerSkyMain);
    }
}