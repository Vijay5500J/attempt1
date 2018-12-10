package com.example.attempt1;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Details2Activity extends AppCompatActivity {
    Button btn,move1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details2);
        btn=(Button)findViewById(R.id.btncontect2);
        move1=(Button)findViewById(R.id.move1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),connectactivity.class);
                startActivity(intent);
            }
        });
        move1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Details2Activity.this,Details3Activity.class);
                startActivity(i);
            }
        });
    }
}
