package com.example.myapplication2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class showplayersdata extends AppCompatActivity {

    private ListView listView;
    private HashMap<Integer, String> map = new HashMap<>();
    private ArrayList<String> plist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showplayersdata);

        getSupportActionBar().setTitle("Top Players");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.listView);
        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.show, plist);
        listView.setAdapter(adapter);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("UserData");       // Connects to the database - in the userData
        reference.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                int x=0;
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {                  //get the data

                    for (int i=0; i<snapshot.getValue().toString().length()-1 ; i++)
                    {
                        if(snapshot.getValue().toString().charAt(i)==':')                 //because in the DataBase the data  Stored as follows username : point
                        {
                            x=i;                                                             // find the : so we can separate username from the points
                        }
                    }

                    String pont = snapshot.getValue().toString().substring(x+1);            //get the points
                    int pointi = Integer.parseInt(pont);                                     //the data in the database is a string , set it to int
                    String theusername= snapshot.getValue().toString().substring(0,x);        //Temporarily store the username
                    map.put(pointi,theusername);                                            //add it to a HashMap - point then username - more efficient to sort by key

                }

                TreeMap<Integer, String> sorted = new TreeMap<>();                     //because the DataBase the data  Stored as HashMap - and it less efficient to sort HashMap- copy the data to treemap
                sorted.putAll(map);
                int num=sorted.size();                                              //number the player plase
                for (Map.Entry<Integer, String> entry : sorted.entrySet())
                {
                    plist.add(num + " " + entry.getValue()+" : " +entry.getKey() );                 //add the data to a ArrayList so it can be displayed in a listView
                    num--;
                }
                Collections.reverse(plist);                                             // in sort the low is firt so reverse it
                adapter.notifyDataSetChanged();
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}