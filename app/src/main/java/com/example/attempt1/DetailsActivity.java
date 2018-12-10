package com.example.attempt1;



import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DetailsActivity extends AppCompatActivity {
    Button btn,move;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        btn=(Button)findViewById(R.id.btncontect);
        move=(Button)findViewById(R.id.move);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),connectactivity.class);
                startActivity(intent);

                move.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent1=new Intent(DetailsActivity.this,Details2Activity.class);
                        startActivity(intent1);
                    }
                });
            }
        });
    }
}

