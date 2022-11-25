package com.skytale.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;
import com.skytale.MainActivity;
import com.skytale.R;

public class SkyTaleSplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sky_tale_splash);

        Intent intent = new Intent(SkyTaleSplashActivity.this, MainActivity.class);
        new Handler(Looper.getMainLooper()).postDelayed
                (
                    () -> {
                        startActivity(intent);
                        finish();
                    },
                    1000
                );
    }
}