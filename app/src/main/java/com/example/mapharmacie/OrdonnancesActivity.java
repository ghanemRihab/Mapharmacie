package com.example.mapharmacie;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class OrdonnancesActivity extends AppCompatActivity {
    Button btn1 , btn2 ;
    ImageView tv2 ;


    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordonnances);
        btn1=findViewById(R.id.button1);
        btn2=findViewById(R.id.button2);
        tv2=findViewById(R.id.text_back);



        btn1.setOnClickListener(v -> startActivity(new Intent(OrdonnancesActivity.this,ajoutord.class)));
        btn2.setOnClickListener(v -> startActivity(new Intent(OrdonnancesActivity.this,List_ordActivity.class)));
        tv2.setOnClickListener(v -> startActivity(new Intent(OrdonnancesActivity.this, acceuil.class)));

    }
}