package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class adminlogin extends AppCompatActivity {

    private Button addq;
    private Button seeq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);

        addq = findViewById(R.id.addq);
        seeq = findViewById(R.id.seeq);


        addq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(adminlogin.this, addQuestion.class));
            }
        });

        seeq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(adminlogin.this, seeQuestion.class));
            }
        });

    }
}