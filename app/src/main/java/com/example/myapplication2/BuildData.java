package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class BuildData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_data);


        //    add data animals

        HashMap<String , Object> map = new HashMap<>();
        map.put("Q", "How many compartments does a cow’s stomach have?");
        map.put("XA" , "Four*");
        map.put("XB" , "Three");
        map.put("XC" , "Two");
        map.put("XD" , "One");

        FirebaseDatabase.getInstance().getReference().child("Questions").child("animals").child("1").updateChildren(map);

        map.clear();

        map.put("Q", "What type of animal is a Flemish giant?");
        map.put("XA" , "rabbit*");
        map.put("XB" , "dog");
        map.put("XC" , "cat");
        map.put("XD" , "cow");

        FirebaseDatabase.getInstance().getReference().child("Questions").child("animals").child("2").updateChildren(map);

        map.clear();

        map.put("Q", "What is the farm animal that becomes the best friend of Shrek?");
        map.put("XA" , "Donkey*");
        map.put("XB" , "Dog");
        map.put("XC" , "Cat");
        map.put("XD" , "Rabbit");

        FirebaseDatabase.getInstance().getReference().child("Questions").child("animals").child("3").updateChildren(map);

        map.clear();

        map.put("Q", "What kind of animal is the main character in the book titled Babe by Dick King-Smith?");
        map.put("XA" , "pig*");
        map.put("XB" , "dog");
        map.put("XC" , "rabbit");
        map.put("XD" , "cow");

        FirebaseDatabase.getInstance().getReference().child("Questions").child("animals").child("4").updateChildren(map);

        map.clear();

        map.put("Q", "What farm animal shares its name with a country that is often said to border both Europe and Asia?");
        map.put("XA" , "turkey*");
        map.put("XB" , "dog");
        map.put("XC" , "cat");
        map.put("XD" , "cow");

        FirebaseDatabase.getInstance().getReference().child("Questions").child("animals").child("5").updateChildren(map);


        //----------------------------------------------------------------------

        //    add data Geography

        map.clear();
        map.put("Q", " What is Earth's largest continent?");
        map.put("XA" , "Asia*");
        map.put("XB" , "Africa");
        map.put("XC" , "Europe");
        map.put("XD" , "Antarctica");

        FirebaseDatabase.getInstance().getReference().child("Questions").child("geography").child("1").updateChildren(map);

        map.clear();

        map.put("Q", "What river runs through Baghdad?");
        map.put("XA" , "Tigris river*");
        map.put("XB" , "Karun");
        map.put("XC" , "Jordan");
        map.put("XD" , "Euphrates");

        FirebaseDatabase.getInstance().getReference().child("Questions").child("geography").child("2").updateChildren(map);

        map.clear();

        map.put("Q", "What country has the most natural lakes?");
        map.put("XA" , "Canada*");
        map.put("XB" , "India");
        map.put("XC" , "United States");
        map.put("XD" , "Australia");

        FirebaseDatabase.getInstance().getReference().child("Questions").child("geography").child("3").updateChildren(map);

        map.clear();

        map.put("Q", "What percentage of the River Nile is located in Egypt?");
        map.put("XA" , "22%*");
        map.put("XB" , "83%");
        map.put("XC" , "100%");
        map.put("XD" , "9%");

        FirebaseDatabase.getInstance().getReference().child("Questions").child("geography").child("4").updateChildren(map);

        map.clear();

        map.put("Q", "In what country can you visit Machu Picchu?");
        map.put("XA" , "Peru*");
        map.put("XB" , "Chile");
        map.put("XC" , "Bolivia");
        map.put("XD" , "Columbia");

        FirebaseDatabase.getInstance().getReference().child("Questions").child("geography").child("5").updateChildren(map);


        //----------------------------------------------------------------------

        //    add data Music

        map.clear();
        map.put("Q", " What was Smokey Robinsons most famous band called?");
        map.put("XA" , "The Miracles*");
        map.put("XB" , "Iron maiden");
        map.put("XC" , "Metallica");
        map.put("XD" , "Megadeth");

        FirebaseDatabase.getInstance().getReference().child("Questions").child("Music").child("1").updateChildren(map);

        map.clear();

        map.put("Q", "What was Elvis Presleys middle name?");
        map.put("XA" , "Aaron*");
        map.put("XB" , "Stave");
        map.put("XC" , "Dave");
        map.put("XD" , "BOB");

        FirebaseDatabase.getInstance().getReference().child("Questions").child("Music").child("2").updateChildren(map);

        map.clear();

        map.put("Q", "Entertainment icon Elvis Presley passed away in which year?");
        map.put("XA" , "1977*");
        map.put("XB" , "1970");
        map.put("XC" , "1969");
        map.put("XD" , "1978");

        FirebaseDatabase.getInstance().getReference().child("Questions").child("Music").child("3").updateChildren(map);

        map.clear();

        map.put("Q", "The Beatles released their first UK single Love Me Do in what year?");
        map.put("XA" , "1962*");
        map.put("XB" , "1963");
        map.put("XC" , "2000");
        map.put("XD" , "1999");

        FirebaseDatabase.getInstance().getReference().child("Questions").child("Music").child("4").updateChildren(map);

        map.clear();

        map.put("Q", "How many valves does a trumpet have?");
        map.put("XA" , "Three*");
        map.put("XB" , "Four");
        map.put("XC" , "Two");
        map.put("XD" , "One");

        FirebaseDatabase.getInstance().getReference().child("Questions").child("Music").child("5").updateChildren(map);


        //----------------------------------------------------------------------

        //    add data History

        map.clear();
        map.put("Q", " Which Century did the French Revolution take place?");
        map.put("XA" , "Eighteenth Century*");
        map.put("XB" , "Sixteenth Century");
        map.put("XC" , "Seventeenth Century");
        map.put("XD" , "Nineteenth Century");

        FirebaseDatabase.getInstance().getReference().child("Questions").child("History").child("1").updateChildren(map);

        map.clear();

        map.put("Q", "On what year did the Ford Model T enter production?");
        map.put("XA" , "1908*");
        map.put("XB" , "1907");
        map.put("XC" , "1909");
        map.put("XD" , "1910");

        FirebaseDatabase.getInstance().getReference().child("Questions").child("History").child("2").updateChildren(map);

        map.clear();

        map.put("Q", "The devastating Great fire of London happened on which year?");
        map.put("XA" , "1666*");
        map.put("XB" , "2000");
        map.put("XC" , "1987");
        map.put("XD" , "500");

        FirebaseDatabase.getInstance().getReference().child("Questions").child("History").child("3").updateChildren(map);

        map.clear();

        map.put("Q", "In what year was Mahatma Ghandi killed?");
        map.put("XA" , "1948*");
        map.put("XB" , "1949");
        map.put("XC" , "1950");
        map.put("XD" , "1947");

        FirebaseDatabase.getInstance().getReference().child("Questions").child("History").child("4").updateChildren(map);

        map.clear();

        map.put("Q", "Who is the Greek God of the Underworld?");
        map.put("XA" , "Hades*");
        map.put("XB" , "Zeus");
        map.put("XC" , "Ares");
        map.put("XD" , "Apollo");

        FirebaseDatabase.getInstance().getReference().child("Questions").child("History").child("5").updateChildren(map);



        //----------------------------------------------------------------------

        //    add data Celebrity

        map.clear();
        map.put("Q", " WWhat year did Jerry Springer turn 50 years old?");
        map.put("XA" , "1993*");
        map.put("XB" , "1994");
        map.put("XC" , "1990");
        map.put("XD" , "2000");

        FirebaseDatabase.getInstance().getReference().child("Questions").child("Celebrity").child("1").updateChildren(map);

        map.clear();

        map.put("Q", "What year was Leonardo DiCaprio born?");
        map.put("XA" , "1973*");
        map.put("XB" , "1977");
        map.put("XC" , "1999");
        map.put("XD" , "1980");

        FirebaseDatabase.getInstance().getReference().child("Questions").child("Celebrity").child("2").updateChildren(map);

        map.clear();

        map.put("Q", "What is the name of Angelina Jolies eldest son?");
        map.put("XA" , "Maddox*");
        map.put("XB" , "Aaron");
        map.put("XC" , "Dave");
        map.put("XD" , "BOB");

        FirebaseDatabase.getInstance().getReference().child("Questions").child("Celebrity").child("3").updateChildren(map);

        map.clear();

        map.put("Q", "What is the name of Jim Carreys first daughter?");
        map.put("XA" , "Jane*");
        map.put("XB" , "Aaron");
        map.put("XC" , "Maddox");
        map.put("XD" , "BOB");


        FirebaseDatabase.getInstance().getReference().child("Questions").child("Celebrity").child("4").updateChildren(map);

        map.clear();

        map.put("Q", "In what year was Tom Hanks born?");
        map.put("XA" , "1956*");
        map.put("XB" , "1977");
        map.put("XC" , "1970");
        map.put("XD" , "1980");

        FirebaseDatabase.getInstance().getReference().child("Questions").child("Celebrity").child("5").updateChildren(map);



        //==================================================================================================
        startActivity(new Intent(BuildData.this , MainActivity.class));
        finish();


    }
}