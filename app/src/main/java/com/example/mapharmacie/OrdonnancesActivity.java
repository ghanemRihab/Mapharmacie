package com.example.mapharmacie;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class OrdonnancesActivity extends AppCompatActivity {
    Button add, consult;
    ImageView tv2;


    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordonnances);
        add = findViewById(R.id.addOrdonnance);
        consult = findViewById(R.id.consultOrdonnance);
        tv2 = findViewById(R.id.text_back);

        add.setOnClickListener(v -> startActivity(new Intent(OrdonnancesActivity.this, ajoutord.class)));
        consult.setOnClickListener(v -> startActivity(new Intent(OrdonnancesActivity.this, List_ordActivity.class)));
        tv2.setOnClickListener(v -> startActivity(new Intent(OrdonnancesActivity.this, acceuil.class)));
    }
}