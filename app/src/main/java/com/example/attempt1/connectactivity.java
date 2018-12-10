package com.example.attempt1;



import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class connectactivity extends AppCompatActivity {
    TextView tvtitle,tvaddress,tvaddress1,tvcontect,tvcontectno,tvcontect1,tvcontectmo;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);
        tvtitle=(TextView)findViewById(R.id.tvtitle);
        tvaddress=(TextView)findViewById(R.id.tvaddress);
        tvaddress1=(TextView)findViewById(R.id.tvaddress1);
        tvcontect=(TextView)findViewById(R.id.tvcontect);
        tvcontectno=(TextView)findViewById(R.id.tvcontectno);
        tvcontect1=(TextView)findViewById(R.id.tvcontect2);
        tvcontectmo=(TextView)findViewById(R.id.tvcontectno2);
        imageView=(ImageView)findViewById(R.id.imageView);

    }
}

