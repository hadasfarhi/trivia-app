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

public class CelebrityQ extends AppCompatActivity {

    private Button stop;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private ListView listView;
    private TextView timerView;
    private int point=0;
    private ArrayList<String> slist = new ArrayList<>();
    private ArrayList<String> qlist = new ArrayList<>();
    private ArrayList<String> templist = new ArrayList<>();
    private ArrayList<String> alist = new ArrayList<>();
    private String gooda;
    private int numQ =0;
    private int tempQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        getSupportActionBar().setTitle("Celebrity");

        stop = findViewById(R.id.stop);
        listView = findViewById(R.id.listView);
        timerView = findViewById(R.id.timerView);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

        long duration = TimeUnit.SECONDS.toMillis(10);

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPoint(point);
                numQ=-1;
                startActivity(new Intent(CelebrityQ.this, EndSession.class));
            }
        });


        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.show,qlist);
        listView.setAdapter(adapter);


        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Questions").child("Celebrity");
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                alist.clear();
                qlist.clear();
                slist.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    alist.add(snapshot.getValue().toString());
                    Collections.sort(alist);
                }

                Collections.shuffle(alist);

                setAsArrayString(alist);
                qlist.add(slist.get(0));
                slist.remove(0);
                gooda = slist.get(0);
                Collections.shuffle(slist);

                adapter.notifyDataSetChanged();
                button1.setText(slist.get(0));
                button2.setText(slist.get(1));
                button3.setText(slist.get(2));
                button4.setText(slist.get(3));

                numQ=alist.size();
                tempQ=numQ;

                button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (slist.get(0) == gooda)
                        {
                            point++;
                            Toast.makeText(CelebrityQ.this , "point " + point, Toast.LENGTH_SHORT).show();
                        }

                        alist.remove(0);
                        numQ--;

                        if (alist.isEmpty())
                        {
                            getPoint(point);
                            numQ--;
                            startActivity(new Intent(CelebrityQ.this, EndSession.class));
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
                            point++;
                            Toast.makeText(CelebrityQ.this , "point " + point, Toast.LENGTH_SHORT).show();
                        }

                        alist.remove(0);
                        numQ--;
                        if (alist.isEmpty())
                        {
                            getPoint(point);
                            numQ--;
                            startActivity(new Intent(CelebrityQ.this, EndSession.class));
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
                            point++;
                            Toast.makeText(CelebrityQ.this , "point " + point, Toast.LENGTH_SHORT).show();
                        }

                        alist.remove(0);
                        numQ--;
                        if (alist.isEmpty())
                        {
                            getPoint(point);
                            numQ--;
                            startActivity(new Intent(CelebrityQ.this, EndSession.class));
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
                            point++;
                            Toast.makeText(CelebrityQ.this , "point " + point, Toast.LENGTH_SHORT).show();
                        }

                        alist.remove(0);
                        numQ--;
                        if (alist.isEmpty())
                        {
                            getPoint(point);
                            numQ--;
                            startActivity(new Intent(CelebrityQ.this, EndSession.class));
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



        new CountDownTimer(duration, 1000) {

            @Override
            public void onTick(long l) {

                String sduration = String.format(Locale.ENGLISH,"%02d : %02d"
                        , TimeUnit.MILLISECONDS.toMinutes(l)
                        , TimeUnit.MILLISECONDS.toSeconds(l) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(l)));
                timerView.setText(sduration);

                if (tempQ>numQ)
                {
                    tempQ=numQ;
                    this.start();
                }

                if (numQ<0)
                {
                    this.cancel();
                }
            }

            @Override
            public void onFinish() {

                alist.remove(0);
                numQ--;
                if (alist.isEmpty())
                {
                    getPoint(point);
                    this.cancel();
                    startActivity(new Intent(CelebrityQ.this, EndSession.class));
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

    private void setAsArrayString(ArrayList<String> list)
    {

        String temp;
        String temp2 = list.get(0);
        int a = 0;
        int b = 0;

        for (int i = 1; i < temp2.length() - 1; i++) {
            if (temp2.charAt(i) == 'Q' || temp2.charAt(i) == 'X')
            {
                a = i ;
            }

            if (temp2.charAt(i) == 44) {
                b = i;
            }

            if (a != 0 && b != 0) {
                templist.add(temp2.substring(a, b));
                a = 0;
                b = 0;
            }

        }

        templist.add(temp2.substring(a, temp2.length()-1));

        Collections.sort(templist);

        //-----------------to cut
        slist.clear();
        qlist.clear();

        temp =String.valueOf(templist);

        int x = 0;
        int y = 0;
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) == 61) {
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

    private void getPoint (int newpoint)
    {

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("UserData");
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                FirebaseAuth auth = FirebaseAuth.getInstance();
                String id = auth.getUid();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                    if (snapshot.getRef().getKey().equals(auth.getUid()))
                    {


                        int pointi = Integer.parseInt(snapshot.getValue().toString());
                        pointi=pointi+newpoint;
                        HashMap<String , Object> map = new HashMap<>();
                        map.put( auth.getUid(), pointi);
                        FirebaseDatabase.getInstance().getReference().child("UserData").updateChildren(map);
                        break;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}