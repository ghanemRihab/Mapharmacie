package com.example.mapharmacie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NoteActivity extends AppCompatActivity {

    EditText description, conseil, effet, remarque;

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        description = findViewById(R.id.description);
        conseil = findViewById(R.id.conseil);
        effet = findViewById(R.id.effets);
        remarque = findViewById(R.id.remarques);
        btn = findViewById(R.id.ajoutnote);

        btn.setOnClickListener(v -> {
            String desc = description.getText().toString();
            String advice = conseil.getText().toString();
            String effect = effet.getText().toString();
            String rmq = remarque.getText().toString();

            Database db = new Database(getApplicationContext());
            if ((desc.length() == 0 || desc.length() == 0) || (advice.length() == 0 || advice.length() == 0) || (effect.length() == 0 || effect.length() == 0) || (rmq.length() == 0 || rmq.length() == 0)) {
                Toast.makeText(getApplicationContext(), "Remplir tous les champs svp", Toast.LENGTH_LONG).show();
            } else {
                //db.addNote(desc, advice, effect,  rmq, );

            }
        });
    }
}