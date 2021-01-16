package com.example.myapplication2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EndSession extends AppCompatActivity {

    private TextView viewPoint;
    private Button logout;
    private Button newgame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_end_session);
        viewPoint  = findViewById(R.id.showpint);
        logout = findViewById(R.id.logoutend);
        newgame = findViewById(R.id.newgame);

        getSupportActionBar().setTitle("Round summary");

        new Handler().postDelayed(new Runnable() {          //Adds 2 seconds of delay, so the information that updated just now will show Correct
            @Override
            public void run() {

                DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("UserData");       // Connects to the database - in the userData

                reference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        FirebaseAuth auth = FirebaseAuth.getInstance();               // Connects to the database
                        String id = auth.getUid();                                        // get the user id from the database

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                            if (snapshot.getRef().getKey().equals(auth.getUid()))       // when the user is fond show is ponts
                            {
                                String temp="";
                                int x=0;

                                for (int i=0; i<snapshot.getValue().toString().length()-1 ; i++)
                                {
                                    if(snapshot.getValue().toString().charAt(i)==':')                  //to - Check if the email has at least one character before the @
                                    {
                                        x=i;
                                    }

                                }

                                String pont = snapshot.getValue().toString().substring(x+1,snapshot.getValue().toString().length());
                                viewPoint.setText(pont);
                                break;
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        },2000);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EndSession.this , "logout successfull" , Toast.LENGTH_SHORT).show();
                startActivity(new Intent(EndSession.this, MainActivity.class));
                FirebaseAuth.getInstance().signOut();
            }
        });



        newgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EndSession.this, Questionsmenu.class));
            }
        });


    }
}