package com.example.ps2bidespus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;

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
                String usr = username.getText().toString();
                String pwd = password.getText().toString();
                Intent goHome = new Intent(LoginActivity.this, Home.class);
                if(usr.equals("")){
                    Toast.makeText(LoginActivity.this, "Silahkan is username", Toast.LENGTH_SHORT).show();
                }else if(pwd.equals("")){
                    Toast.makeText(LoginActivity.this, "silahkan isi password", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(LoginActivity.this, "Hallo Bujank", Toast.LENGTH_SHORT).show();
                    startActivity(goHome);
                    finish();
                }
            }
        });
    }
}