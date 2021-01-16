package com.example.myapplication2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class AnimalsQ extends AppCompatActivity {

    private Button stop;              //Statement for user interfaces
    private Button button1;           //Statement for user interfaces
    private Button button2;           //Statement for user interfaces
    private Button button3;            //Statement for user interfaces
    private Button button4;           //Statement for user interfaces
    private ListView listView;       //Statement for user interfaces
    private TextView timerView;     //Statement for user interfaces
    private int point=0;           //For the point that the player will be earned during the round
    private ArrayList<String> slist = new ArrayList<>();        // hold the answers to the question which appears
    private ArrayList<String> qlist = new ArrayList<>();        //hold the question the appears
    private ArrayList<String> templist = new ArrayList<>();     //For proper information from the database - Will be expanded later
    private ArrayList<String> alist = new ArrayList<>();        //Receives the entire set of questions and answers from the server
    private String gooda;           // Holds the correct answer to the question which appears
    private int numQ =0;        // for the Timer
    private int tempQ;          // for the Timer
    private int extraPoint=0;   //point per timer

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        getSupportActionBar().setTitle("Animals");

        stop = findViewById(R.id.stop);             //Link user interface to XML
        listView = findViewById(R.id.listView);       //Link user interface to XML
        timerView = findViewById(R.id.timerView);         //Link user interface to XML
        button1 = findViewById(R.id.button1);             //Link user interface to XML
        button2 = findViewById(R.id.button2);             //Link user interface to XML
        button3 = findViewById(R.id.button3);                 //Link user interface to XML
        button4 = findViewById(R.id.button4);                 //Link user interface to XML

        long duration = TimeUnit.SECONDS.toMillis(10);      // the set the TIMER by seconds

        stop.setOnClickListener(new View.OnClickListener() {            //to stop the round
            @Override
            public void onClick(View v) {
                getPoint(point);                                // update the point that are earned in the round
                numQ=-1;
                startActivity(new Intent(AnimalsQ.this, EndSession.class));     // go to EndSession
            }
        });


        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.show,qlist);          //what array list will show in  the  listView
        listView.setAdapter(adapter);                                                                //show the questions in the listView


        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Questions").child("animals");    //From which category to bring the questions
        reference.addListenerForSingleValueEvent(new ValueEventListener() {                                             // "Listener" that communicate with database
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {                     //When data is received from the database
                alist.clear();
                qlist.clear();
                slist.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {                  //get the data
                    alist.add(snapshot.getValue().toString());
                    Collections.sort(alist);                                               //Make sure the data theat received will be correct
                }

                Collections.shuffle(alist);                                               //to mix the arrangement of questions

                setAsArrayString(alist);
                qlist.add(slist.get(0));    //The question is first on the list , so set the question in the qlist
                slist.remove(0);
                gooda = slist.get(0);       //Stores the correct answer - the correct one is the first on the list
                Collections.shuffle(slist);      //to mix the arrangement of answers

                adapter.notifyDataSetChanged();     //Refreshes the view of the question
                button1.setText(slist.get(0));      //Each button gets an answer
                button2.setText(slist.get(1));
                button3.setText(slist.get(2));
                button4.setText(slist.get(3));

                numQ=alist.size();          // Gets the number of questions in the round
                tempQ=numQ;                 //To update the timer if we passed a question

                button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (slist.get(0) == gooda)      //Check if the answer is correct
                        {
                            point=extraPoint+point;                    //get points
                            Toast.makeText(AnimalsQ.this , "point " + extraPoint, Toast.LENGTH_SHORT).show();    //show it on the bottom of the screen
                        }

                        alist.remove(0);        //Remove the question
                        numQ--;                         // To update the timer that a question pass
                        if (alist.isEmpty())        //Checks if the questions are over in the round
                        {
                            getPoint(point);              // update the point that are earned in the round
                            numQ--;                       // To update the timer that a question pass - Prevents the timer from continuing to run after the end of the round
                            startActivity(new Intent(AnimalsQ.this, EndSession.class));  //go to the EndSession
                        }
                        else {
                            setAsArrayString(alist);
                            qlist.add(slist.get(0));
                            slist.remove(0);
                            gooda = slist.get(0);
                            Collections.shuffle(slist);

                            button1.setText(slist.get(0));
                            button2.setText(slist.get(1));
                            button3.setText(slist.get(2));
                            button4.setText(slist.get(3));

                            adapter.notifyDataSetChanged();
                        }
                    }
                });


                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (slist.get(1) == gooda) {
                            point=extraPoint+point;
                            Toast.makeText(AnimalsQ.this , "point " + extraPoint, Toast.LENGTH_SHORT).show();
                        }

                        alist.remove(0);
                        numQ--;
                        if (alist.isEmpty())
                        {
                            getPoint(point);
                            numQ--;
                            startActivity(new Intent(AnimalsQ.this, EndSession.class));
                        }
                        else {
                            setAsArrayString(alist);
                            qlist.add(slist.get(0));
                            slist.remove(0);
                            gooda = slist.get(0);
                            Collections.shuffle(slist);

                            button1.setText(slist.get(0));
                            button2.setText(slist.get(1));
                            button3.setText(slist.get(2));
                            button4.setText(slist.get(3));

                            adapter.notifyDataSetChanged();
                        }
                    }
                });

                button3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (slist.get(2) == gooda) {
                            point=extraPoint+point;
                            Toast.makeText(AnimalsQ.this , "point " + extraPoint, Toast.LENGTH_SHORT).show();
                        }

                        alist.remove(0);
                        numQ--;
                        if (alist.isEmpty())
                        {
                            getPoint(point);
                            numQ--;
                            startActivity(new Intent(AnimalsQ.this, EndSession.class));
                        }
                        else {
                            setAsArrayString(alist);
                            qlist.add(slist.get(0));
                            slist.remove(0);
                            gooda = slist.get(0);
                            Collections.shuffle(slist);

                            button1.setText(slist.get(0));
                            button2.setText(slist.get(1));
                            button3.setText(slist.get(2));
                            button4.setText(slist.get(3));

                            adapter.notifyDataSetChanged();
                        }
                    }
                });

                button4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (slist.get(3) == gooda) {
                            point=extraPoint+point;
                            Toast.makeText(AnimalsQ.this , "Point " + extraPoint, Toast.LENGTH_SHORT).show();
                        }

                        alist.remove(0);
                        numQ--;
                        if (alist.isEmpty())
                        {
                            getPoint(point);
                            numQ--;
                            startActivity(new Intent(AnimalsQ.this, EndSession.class));
                        }
                        else {
                            setAsArrayString(alist);
                            qlist.add(slist.get(0));
                            slist.remove(0);
                            gooda = slist.get(0);
                            Collections.shuffle(slist);

                            button1.setText(slist.get(0));
                            button2.setText(slist.get(1));
                            button3.setText(slist.get(2));
                            button4.setText(slist.get(3));

                            adapter.notifyDataSetChanged();
                        }
                    }
                });
            }
            @Override
            public void onCancelled (@NonNull DatabaseError error){

            }
        });



        new CountDownTimer(duration, 1000) {   //the timer

            @Override
            public void onTick(long l) {

                String sduration = String.format(Locale.ENGLISH,"%02d : %02d"               //set the view of the timer
                        , TimeUnit.MILLISECONDS.toMinutes(l)
                        , TimeUnit.MILLISECONDS.toSeconds(l) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(l)));
                extraPoint = (int) (TimeUnit.MILLISECONDS.toSeconds(l) -TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(l)));
                timerView.setText(sduration);                                                       //show it on the screen

                if (tempQ>numQ)                 // If a question has passed, without the timer update the amount of questions
                {
                    tempQ=numQ;
                    this.start();
                }

                if (numQ<0)
                {
                    this.cancel();      //Prevents the timer from continuing to run after the end of the round
                }
            }

            @Override
            public void onFinish() {            //If time is run out - go to the next question

                alist.remove(0);
                numQ--;
                if (alist.isEmpty())
                {
                    getPoint(point);
                    this.cancel();
                    startActivity(new Intent(AnimalsQ.this, EndSession.class));
                }
                else {
                    setAsArrayString(alist);
                    qlist.add(slist.get(0));
                    slist.remove(0);
                    gooda = slist.get(0);
                    Collections.shuffle(slist);

                    button1.setText(slist.get(0));
                    button2.setText(slist.get(1));
                    button3.setText(slist.get(2));
                    button4.setText(slist.get(3));

                    adapter.notifyDataSetChanged();
                    this.start();
                }

            }
        }.start();


    }

    /*
        Because different devices receive the question and answer from the Database In a different order ,this function is intended to:
        Cut the String that received from the server, arrange it in the correct order
        Question as a head, The correct answer follows and then three incorrect answers
        Then add it to the arraylist the show
     */
    private void setAsArrayString(ArrayList<String> list)
    {

        String temp;
        String temp2 = list.get(0);         //get The question and the answers
        int a = 0;
        int b = 0;

        for (int i = 1; i < temp2.length() - 1; i++) {
            if (temp2.charAt(i) == 'Q' || temp2.charAt(i) == 'X') //A question in the  Database begins with the letter Q - and answer begins with and X with a follow letter A,B,C,D
            {
                a = i ;
            }

            if (temp2.charAt(i) == 44) {        // all and with a ',' 44 is the ascii of ','
                b = i;
            }

            if (a != 0 && b != 0) {
                templist.add(temp2.substring(a, b));        // add it to tke list
                a = 0;
                b = 0;
            }

        }

        templist.add(temp2.substring(a, temp2.length()-1)); //add the last one , dont end with a ','

        Collections.sort(templist);                 // sort the array

        //-----------------to cut
        slist.clear();
        qlist.clear();

        temp =String.valueOf(templist);

        int x = 0;
        int y = 0;
        for (int i = 0; i < temp.length(); i++) {       //cut the The initial character ,They all start with '='
            if (temp.charAt(i) == 61) {                 //61 is the ascii of '='
                x = i + 1;
            }

            if (temp.charAt(i) == 44) {
                y = i;
            }

            if (x != 0 && y != 0) {
                slist.add(temp.substring(x, y));
                x = 0;
                y = 0;
            }

        }
        slist.add(temp.substring(x, temp.length()-1));
        templist.clear();
        //----------------end cut
    }

    private void getPoint (int newpoint)        // add the point to the user database
    {

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("UserData");      // Connects to the database - in the userData
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                FirebaseAuth auth = FirebaseAuth.getInstance();                      // Connects to the database
                String id = auth.getUid();                                      // get the user id from the database
                String allstring="";
                int x=0;
                String pont="";
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                    if (snapshot.getRef().getKey().equals(auth.getUid()))           //find the user in the database
                    {

                        if (snapshot.getRef().getKey().equals(auth.getUid()))       // when the user is fond get the data is ponts
                        {
                            for (int i=0; i<snapshot.getValue().toString().length()-1 ; i++)
                            {
                                if(snapshot.getValue().toString().charAt(i)==':')                  //because in the DataBase the data  Stored as follows username : point
                                {
                                    x=i;                                                            // find the " : " so we can get the point
                                }
                            }

                            pont = snapshot.getValue().toString().substring(x+1);               // get only the poiny
                            int pointi = Integer.parseInt(pont);      //the data in the database is a string , set it to int
                            pointi=pointi+newpoint;                                               // update the point that are earned in the round
                            String theusername= snapshot.getValue().toString().substring(0,x+1);    //Temporarily store the username
                            allstring=theusername+pointi;                                              // sote the username and the update points
                            HashMap<String , Object> map = new HashMap<>();                         //the database work with HashMap
                            map.put( auth.getUid(), allstring);
                            FirebaseDatabase.getInstance().getReference().child("UserData").updateChildren(map);    // update the database
                            break;
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}