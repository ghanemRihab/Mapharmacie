package com.example.mapharmacie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;

public class DetailActivity extends AppCompatActivity {
    EditText nom,quantite,dateex;
    Button mod;
    int position;
params p=new params();
HashMap<String,String>m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        nom=findViewById(R.id.nom);
        quantite =findViewById(R.id.quantite);
        dateex=findViewById(R.id.dateex);
        mod=findViewById(R.id.modification);

        Bundle extras=getIntent().getExtras();
        if(extras!=null)
        {
            position=extras.getInt("position");

        }
        m =p.values.get(position);
        nom.setText(m.get("nom"));
        quantite.setText(m.get("quantite"));
        dateex.setText(m.get("dateex"));
        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m.put("nom",nom.getText().toString());
                m.put("quantite",quantite.getText().toString());
                m.put("dateex",dateex.getText().toString());
                Intent i=new Intent(getApplicationContext(),List_donActivity.class);
                startActivity(i);
                finish();

            }
        });


    }
}