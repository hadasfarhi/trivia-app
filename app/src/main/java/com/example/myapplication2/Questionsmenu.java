package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Questionsmenu extends AppCompatActivity {

    private Button bAnimals;
    private Button bGeography;
    private Button bMusic;
    private Button bhistory;
    private Button bCelebrity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionsmenu);

        getSupportActionBar().setTitle("Choose your category");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bAnimals = findViewById(R.id.Animals);
        bGeography = findViewById(R.id.Geography);
        bMusic = findViewById(R.id.Music);
        bhistory = findViewById(R.id.history);
        bCelebrity = findViewById(R.id.Celebrity);


        bAnimals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Questionsmenu.this, AnimalsQ.class));
            }
        });

        bGeography.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Questionsmenu.this, GeographyQ.class));
            }
        });

        bMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Questionsmenu.this, MusicQ.class));
            }
        });

        bhistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Questionsmenu.this, HistoryQ.class));
            }
        });

        bCelebrity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Questionsmenu.this, CelebrityQ.class));
            }
        });

    }
}