package com.example.attempt1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {
    EditText et_pass;
    FirebaseDatabase database;
    DatabaseReference ref;
    Button btn;

    private EditText et_mobile;
    String mob,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn=(Button)findViewById(R.id.login);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginData(view);
            }
        });


    }

    public void loginData(View v) {

        et_mobile = (EditText) findViewById(R.id.et_mobile);
        et_pass = (EditText) findViewById(R.id.et_pass);
        Log.d("vijay",et_pass.getText().toString());
        mob = et_mobile.getText().toString();
        pass = et_pass.getText().toString();


        database = FirebaseDatabase.getInstance();
        ref=database.getReference();
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (!dataSnapshot.exists()) {
                    Toast.makeText(LoginActivity.this, "Invalid mobile number", Toast.LENGTH_SHORT).show();
                    et_mobile.setText("");
                }
                else {
                    for (DataSnapshot childrens:dataSnapshot.getChildren()){
                        if (childrens.getKey().equals("password")){
                            if (childrens.getValue().toString().equals(pass)){
                                Toast.makeText(LoginActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(LoginActivity.this, "invalid password", Toast.LENGTH_SHORT).show();
                                et_pass.setText("");
                                ref = database.getReference(mob);

                            }
                            if(et_mobile.equals("8208426609") && et_pass.equals("5500")){
                                Toast.makeText(LoginActivity.this, "You are admin", Toast.LENGTH_SHORT).show();

                                Intent i=new Intent(LoginActivity.this,Admin.class);
                                startActivity(i);
                            }

                        }

                    }



                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError)
            {

                Log.e("oncancelerror",databaseError.getDetails());
            }
        });


    }

    public void registerData(View v) {
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));


    }
}
