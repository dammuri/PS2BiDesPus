package com.example.ps2bidespus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton loginbtn =findViewById(R.id.floatbtn);
        final EditText username = findViewById(R.id.username);
        final EditText password = findViewById(R.id.password);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String usr = username.getText().toString();
                final String pwd = password.getText().toString();
                final Intent goHome = new Intent(LoginActivity.this, Home.class);

                DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
                mDatabase.child("login").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        //Get admin
                        String adminUsr = snapshot.child("admin").child("username").getValue().toString();
                        String adminPass = snapshot.child("admin").child("password").getValue().toString();
                        if(usr.equals(adminUsr) && pwd.equals(adminPass)){
                            Toast.makeText(LoginActivity.this, "Selamat Datang", Toast.LENGTH_SHORT).show();
                            startActivity(goHome);
                            finish();
                        }
                        else{
                            Toast.makeText(LoginActivity.this, "Username Atau Password Salah", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });
    }
}