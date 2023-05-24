package com.example.mapharmacie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class acceuil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);
        SharedPreferences sharedpreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String nom = sharedpreferences.getString("nom","").toString();
        Toast.makeText(getApplicationContext(), "Bienvenue"+nom, Toast.LENGTH_SHORT).show();

        CardView ord = findViewById(R.id.card_ord);
        ord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(acceuil.this,OrdonnancesActivity.class));
            }
        });
        CardView med = findViewById(R.id.card_medi);
        ord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(acceuil.this,MedicamentActivity.class));
            }
        });
        CardView note = findViewById(R.id.card_notes);
        ord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(acceuil.this,NoteActivity.class));
            }
        });
        CardView pharma = findViewById(R.id.card_plan);
        ord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(acceuil.this,PlanActivity.class));
            }
        });
        CardView plan = findViewById(R.id.card_don);
        ord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(acceuil.this,DonActivity.class));
            }
        });
        CardView don = findViewById(R.id.card_deconnexion);
        ord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(acceuil.this,DonActivity.class));
            }
        });
        TextView tv1 = findViewById(R.id.textV1);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(acceuil.this, login.class));
            }
        });


    }
}