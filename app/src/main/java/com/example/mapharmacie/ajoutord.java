package com.example.mapharmacie;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
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

    DatePicker edDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajoutord);
        edDate=findViewById(R.id.date_picker);
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
        //btn_ajout_medi=findViewById(R.id.button_ajouter_medicament);
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
                //Toast.makeText(getApplicationContext(), " Vous avez sélectionné : " + selectedMoment, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(ajoutord.this, "Aucun élément sélectionné", Toast.LENGTH_SHORT).show();
            }
        });


        btn_ajout_ord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String date = String.valueOf(edDate.getDayOfMonth()+edDate.getMonth()+edDate.getYear());
                String doctor =  edMedecin.getText().toString();
                String specialite = edSpecialite.getText().toString();
                String address =   edAdress.getText().toString();
                String phone = edTelephone.getText().toString();
                String email =edMail.getText().toString();
                String medecin = edmedicament.getText().toString();
                String dose =  edDosage.getText().toString();
                String frequence =  edFrequence.getText().toString();
                int box_numbers = Integer.parseInt(edNb_boite.getText().toString());
                String take_moment = Sp.getSelectedItem().toString();
                String image = tvimg.getText().toString();
                Database db = new Database(ajoutord.this);

                if (
                    (date.isEmpty() && date.length() == 0) ||
                    (doctor.isEmpty() && doctor.length()== 0) ||
                    (specialite.isEmpty() && specialite.length() == 0) ||
                    (address.isEmpty() && address.length() == 0) ||
                    (phone.isEmpty() && phone.length() == 0) ||
                    (email.isEmpty() && email.length() == 0) ||
                    (medecin.isEmpty() && medecin.length() == 0) ||
                    (dose.isEmpty() && dose.length() == 0) ||
                    (frequence.isEmpty() && frequence.length() == 0) ||
                    (take_moment.isEmpty() && take_moment.length() == 0))
                {
                    Toast.makeText(getApplicationContext(), "Veuillez remplir les champs", Toast.LENGTH_LONG).show();
                }else{
                    db.addOrdonnace(date, doctor, specialite, address, phone, email, medecin, dose,frequence, String.valueOf(box_numbers),take_moment, image);
                    startActivity(new Intent(ajoutord.this, Medicament.class));
                }
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
