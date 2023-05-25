package com.example.mapharmacie;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {
    EditText name , password ;
    Button btn ;
    TextView tv ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        name = findViewById(R.id.name);
        password = findViewById(R.id.password);
        btn = findViewById(R.id.button);
        tv = findViewById(R.id.textView3);

        btn.setOnClickListener(v -> {
            String nom = name.getText().toString();
            String mdp = password.getText().toString();

            Database db = new Database(getApplicationContext());
            if (nom.length() == 0 || mdp.length() == 0) {
                Toast.makeText(getApplicationContext(), "Remplir tous les champs svp", Toast.LENGTH_LONG).show();
            } else {
                if (db.checkUser(nom,mdp)) {
                    Toast.makeText(getApplicationContext(), "se connecter avec succé", Toast.LENGTH_LONG).show();
                    SharedPreferences sharedpreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString("nom", nom);
                    //enregistrer notre données avec "key and value".
                    editor.apply();
                    startActivity(new Intent(login.this, acceuil.class));
                } else {
                    Toast.makeText(getApplicationContext(), "Nom et mot de passe ne sont pas validés", Toast.LENGTH_LONG).show();
                }
            }
        });
        tv.setOnClickListener(view -> startActivity(new Intent(login.this, creationActivity.class)));

    }  }
