package com.skytale;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.skytale.myadapter.ViewPagerCryptographyAdapter;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabSkyMain;
    private ViewPager2 viewPagerSkyMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabSkyMain = findViewById(R.id.tabSkyMain);
        viewPagerSkyMain = findViewById(R.id.viewPagerSkyMain);

        ViewPagerCryptographyAdapter myAdapter = new ViewPagerCryptographyAdapter(this);
        myAdapter.addFragmentInList("Encrypter");
        myAdapter.addFragmentInList("Decrypter");
        viewPagerSkyMain.setAdapter(myAdapter);

        new TabLayoutMediator(
                tabSkyMain, viewPagerSkyMain,
                (tabSkyMain, position) -> tabSkyMain.setText
                        (
                            myAdapter.getFragmentTitle(position)
                        )
        ).attach();
    }
}