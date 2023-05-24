package com.example.mapharmacie;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;
// inscription
public class creationActivity extends AppCompatActivity {
    EditText edNom,edEmail,edPassword,edConfirm;
    Button btn ;
    TextView tv ;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation);

        edNom = findViewById(R.id.editTextPersonNameEng);
        edPassword = findViewById(R.id.editTextPasswordEng);
        edConfirm = findViewById(R.id.editTextConfirm);
        edEmail = findViewById(R.id.editTextEmail);
        btn = findViewById(R.id.buttonEng);
        tv = findViewById(R.id.textView4);



        tv.setOnClickListener(view -> startActivity(new Intent(creationActivity.this, login.class)));

        btn.setOnClickListener(view -> {
            String nomEng = edNom.getText().toString();
            String email = edEmail.getText().toString();
            String passwordEng = edPassword.getText().toString();
            String confirm = edConfirm.getText().toString();
            Database db = new Database(getApplicationContext());
            if (nomEng.isEmpty() || email.isEmpty() || passwordEng.isEmpty() || confirm.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Remplir tous les champs svp", Toast.LENGTH_LONG).show();

            }

            // Vérification de la validité de l'e-mail
            if (!isValidEmail(email)) {
                Toast.makeText(getApplicationContext(), "Votre email est invalide", Toast.LENGTH_LONG).show();

            }

            // Vérification de la validité du mot de passe
            if (!isValid(passwordEng)) {
                Toast.makeText(getApplicationContext(), "Votre mot de passe doit contenir au minimum 8 caractères, dont une lettre minuscule, une lettre majuscule, un chiffre et un caractère spécial", Toast.LENGTH_LONG).show();

            }

            if (!passwordEng.equals(confirm)) {
                Toast.makeText(getApplicationContext(), "Les mots de passe ne correspondent pas", Toast.LENGTH_LONG).show();

            }

            // Insertion de l'utilisateur dans la base de données
            if (passwordEng.compareTo(confirm)==0) {
                db.register(nomEng, email, passwordEng);
                Toast.makeText(getApplicationContext(), "vous etes inscrit !", Toast.LENGTH_LONG).show();
                startActivity(new Intent(creationActivity.this, login.class));
            }
            else{
                Toast.makeText(getApplicationContext(), "Echec dans l'enregistrement de données", Toast.LENGTH_LONG).show();
            }

        });
    }
    public boolean isValid(String passwordhere){
        int f1=0,f2=0,f3=0;
        if (passwordhere.length() < 8) {
            return false;
        }else {
            for (int p = 0; p < passwordhere.length();p++){
                if (Character.isDigit(passwordhere.charAt(p))){
                    f1=1 ;
                }
            }
            for (int r = 0;r < passwordhere.length();r++){
                if(Character.isDigit(passwordhere.charAt(r))){
                    f2=1;
                }
            }
            for (int s = 0;s < passwordhere.length();s++){
                char c = passwordhere.charAt(s);
                if (c >= 33 && c <= 46 || c == 64){
                    f3=1;
                }
            }
            return f1 == 1 && f2 == 1 && f3 == 1;
        }

    }

    public boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();



    }}

