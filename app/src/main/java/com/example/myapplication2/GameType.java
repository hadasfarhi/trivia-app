package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameType extends AppCompatActivity {

    private Button singleb;
    private Button vsb;
    private Button personalq;
    private Button topply;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_type);

        singleb = findViewById(R.id.Single);
        vsb = findViewById(R.id.vs);
        personalq = findViewById(R.id.Personal);
        topply = findViewById(R.id.Topplayers);

        singleb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GameType.this , Questionsmenu.class));
            }
        });

        topply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GameType.this , showplayersdata.class));
            }
        });

    }
}