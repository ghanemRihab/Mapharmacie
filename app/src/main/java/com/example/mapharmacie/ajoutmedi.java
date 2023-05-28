package com.example.mapharmacie;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class ajoutmedi extends AppCompatActivity {
    Spinner Sp;
    EditText nom_medicament, dosage, nbr_prise, traitement, quantite;
    Button btn, btn1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajoutmedi);

        nom_medicament = findViewById(R.id.nom_medicament);
        dosage = findViewById(R.id.dosage);
        nbr_prise = findViewById(R.id.nbr_prise);
        traitement = findViewById(R.id.traitement);
        quantite = findViewById(R.id.quantite);
        Sp = findViewById(R.id.spinner_moment_prise2);
        btn = findViewById(R.id.ajoutMed);
        btn1 = findViewById(R.id.consultMed);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.moments_prise, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Application de l'adaptateur au Spinner
        Sp.setAdapter(adapter);

        // Définition d'une action à effectuer lorsqu'un élément est sélectionné dans le Spinner
        Sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedMoment = (String) parent.getItemAtPosition(position);
                //Toast.makeText(getApplicationContext(), " Vous avez sélectionné : " + selectedMoment, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(ajoutmedi.this, "Aucun élément sélectionné", Toast.LENGTH_SHORT).show();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = nom_medicament.getText().toString();
                String dose = dosage.getText().toString();
                int prise = Integer.parseInt(nbr_prise.getText().toString());
                String trait = traitement.getText().toString();
                int box_numbers = Integer.parseInt(quantite.getText().toString());
                String take_moment = Sp.getSelectedItem().toString();

                Database db = new Database(ajoutmedi.this);

                if ((name.isEmpty() && name.length() == 0) || (dose.isEmpty() && dose.length() == 0) || (prise == 0) || (trait.isEmpty() && trait.length() == 0) || (box_numbers == 0) || (take_moment.isEmpty() && take_moment.length() == 0)) {
                    Toast.makeText(getApplicationContext(), "Veuillez remplir les champs", Toast.LENGTH_LONG).show();
                } else {
                    db.addMedicament(name, dose, prise, trait, box_numbers, take_moment);
                    Toast.makeText(getApplicationContext(), "Medicament ajouté avec succès", Toast.LENGTH_LONG).show();
                }
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ajoutmedi.this, ListMedicamentActivity.class));
            }
        });
    }
}