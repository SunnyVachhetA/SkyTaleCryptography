package com.skytale.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.skytale.MainActivity;
import com.skytale.R;

public class SkyTaleSplashActivity extends AppCompatActivity {

    private final static int SPLASH_SCREEN = 2500;

    ImageView imageView;
    TextView textView1, textView2;
    Animation top, bottom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sky_tale_splash);

        if(getSupportActionBar() != null)
            getSupportActionBar().hide();

        imageView = findViewById(R.id.imageView);
        textView1 = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);


        top = AnimationUtils.loadAnimation(this, R.anim.top);
        bottom = AnimationUtils.loadAnimation(this, R.anim.bottom);
        imageView.setAnimation(top);
        textView1.setAnimation(bottom);
        textView2.setAnimation(bottom);

        Intent intent = new Intent(SkyTaleSplashActivity.this, MainActivity.class);
        new Handler(Looper.getMainLooper()).postDelayed
                (
                    () -> {
                        startActivity(intent);
                        finish();
                    },
                    SPLASH_SCREEN
                );
    }
}