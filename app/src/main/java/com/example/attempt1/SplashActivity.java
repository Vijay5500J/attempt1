package com.example.attempt1;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class SplashActivity extends AppCompatActivity {
    ProgressBar pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    pb=(ProgressBar)findViewById(R.id.pb);
    pb.setVisibility(View.VISIBLE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                pb.setVisibility(View.GONE);
                Intent i=new Intent(SplashActivity.this,LoginActivity.class);
                startActivity(i);
            }
        },4000);

    }
}
