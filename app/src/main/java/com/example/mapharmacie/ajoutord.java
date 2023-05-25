package com.example.mapharmacie;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class ajoutord extends AppCompatActivity {
    EditText edMedecin , edSpecialite , edAdress , edTelephone , edMail, edmedicament, edDosage,edFrequence ,edNb_boite ;
    TextView tvdate,tvmedi ,tvimg ;
    Button  btn_ajout_medi,btn_ajout_img, btn_ajout_ord,btn_supp_ord;
    Spinner Sp ;
    LinearLayout itemListLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajoutord);
        edMedecin=findViewById(R.id.edit_nom_medecin);
        edSpecialite=findViewById(R.id.edit_specialite);
        edAdress=findViewById(R.id.edit_adresse);
        edTelephone=findViewById(R.id.edit_telephone);
        edMail=findViewById(R.id.edit_mail);
        edmedicament=findViewById(R.id.nom_medi);
        edDosage=findViewById(R.id.edittext_dosage_medicament);
        edFrequence=findViewById(R.id.edittext_fréquence_medicament);
        edNb_boite=findViewById(R.id.edittext_nombres_boites);
        tvdate=findViewById(R.id.text_date);
        tvmedi=findViewById(R.id.text_medicament);
        tvimg=findViewById(R.id.text_image);
        btn_ajout_medi=findViewById(R.id.button_ajouter_medicament);
        btn_ajout_img=findViewById(R.id.button_ajouter_image);
        btn_ajout_ord=findViewById(R.id.button_ajouter_ordonnance);
        btn_supp_ord=findViewById(R.id.button_supprimer_ordonnances);
        Sp=findViewById(R.id.spinner_moment_prise);
        itemListLayout = findViewById(R.id.medicamentLayout);

        // Définition des options du Spinner en utilisant les ressources XML
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.moments_prise, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Application de l'adaptateur au Spinner
        Sp.setAdapter(adapter);

        // Définition d'une action à effectuer lorsqu'un élément est sélectionné dans le Spinner
        Sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedMoment = (String) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), " Vous avez sélectionné : " + selectedMoment, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(ajoutord.this, "Aucun élément sélectionné", Toast.LENGTH_SHORT).show();
            }
        });


        btn_ajout_ord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date = tvdate.getText().toString();
                String nom_Medecin =  tvmedi.getText().toString();
                String specialite = edSpecialite.getText().toString();
                String adress =   edAdress.getText().toString();
                String telephone = edTelephone.getText().toString();
                String email =edMail.getText().toString();
                String nom_Medicament = edmedicament.getText().toString();
                String dosage_Medicament =  edDosage.getText().toString();
                String fréquence_Medicament =  edFrequence.getText().toString();
                int nombres_Boites = Integer.parseInt(edNb_boite.getText().toString());
                String moment_Prise = Sp.getSelectedItem().toString();
                String image = tvimg.getText().toString();
                Database database = new Database(ajoutord.this);
              //  database.ajouterOrdonnance(tvdate.getText().toString().trim(),tvmedi.getText().toString().trim(),edSpecialite.getText().toString().trim(),edAdress.getText().toString().trim(),edTelephone.getText().toString().trim(),edMail.getText().toString().trim(),edmedicament.getText().toString().trim(),edDosage.getText().toString().trim(),edFrequence.getText().toString().trim(),Integer.parseInt(edNb_boite.getText().toString().trim()), Sp.getSelectedItem().toString().trim(), tvimg.getText().toString().trim());
            }

        });

    }

    @SuppressLint("SetTextI18n")
    private void ajouterMedicament() {
        View medicamentView = getLayoutInflater().inflate(R.layout.activity_medicament2, null, false);
        EditText nomItem = medicamentView.findViewById(R.id.nom_medicament);
        EditText quantiteItem = medicamentView.findViewById(R.id.quantite_medicament);

        // Ajoutez d'autres champs pour tous attribut du médicament
        TextView titre = new TextView(this);
        titre.setText("Médicament " + (itemListLayout.getChildCount() + 1));
        itemListLayout.addView(titre);
        itemListLayout.addView(medicamentView);
    }
}
