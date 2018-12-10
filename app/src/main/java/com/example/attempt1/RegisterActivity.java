package com.example.attempt1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RegisterActivity extends AppCompatActivity {
    DatabaseReference ref;
    FirebaseDatabase database;
    Bean bean;
    EditText pass;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }


    public void registerData(View v) {
        final EditText et_name = (EditText) findViewById(R.id.et_name);
        final EditText et_mob = (EditText) findViewById(R.id.et_mobile);
        final  EditText et_email=(EditText)findViewById(R.id.et_email);
        final EditText et_pass=(EditText)findViewById(R.id.et_pass);


        final String name = et_name.getText().toString();
        final String mobile = et_mob.getText().toString();
        final String pass=et_pass.getText().toString();
        String email=et_email.getText().toString();

        bean = new Bean();
        bean.setName(name);
        bean.setMobile(mobile);
        bean.setEmail(email);
        bean.setPassword(pass);


        database = FirebaseDatabase.getInstance();
        ref = database.getReference(mobile);

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    Toast.makeText(RegisterActivity.this, "Mobile is already exist", Toast.LENGTH_SHORT).show();
                    et_mob.setText("");
                    et_name.setText("");
                } else {

                    ref.setValue(bean);
                    Toast.makeText(RegisterActivity.this, "Successfully registered", Toast.LENGTH_SHORT).show();

                    SharedPreferences sp = getSharedPreferences("APP_DATA", MODE_PRIVATE);
                    sp.edit().putString("NAME", name).putString("PASS", pass).putString("MOB", mobile).commit();

                    Intent i = new Intent(RegisterActivity.this,HomeActivity.class);
                    startActivity(i);

                }
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public void LoginData(View view) {
        Intent i=new Intent(RegisterActivity.this,HomeActivity.class);
        startActivity(i);

    }
}









