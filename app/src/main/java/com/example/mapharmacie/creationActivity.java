package com.example.mapharmacie;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

// inscription
public class creationActivity extends AppCompatActivity {
    EditText name, email, password, confirmPassword;
    Button registerBtn;
    TextView loginBtN;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.passwordConfirm);
        registerBtn = findViewById(R.id.register);
        loginBtN = findViewById(R.id.login);

        loginBtN.setOnClickListener(view -> startActivity(new Intent(creationActivity.this, login.class)));
        registerBtn.setOnClickListener(view -> {
            String nom = name.getText().toString();
            String mail = email.getText().toString();
            String mdp = password.getText().toString();
            String mdpConfirm = confirmPassword.getText().toString();
            Database db = new Database(creationActivity.this);

            if ((nom.isEmpty() && nom.length() == 0) || (mail.isEmpty() && mail.length() == 0) || (mdp.isEmpty() && mdp.length() == 0) || (mdpConfirm.isEmpty() && mdpConfirm.length() == 0)) {
                Toast.makeText(getApplicationContext(), "Veuillez remplir les champs", Toast.LENGTH_LONG).show();
            }else if (!isValidEmail(mail)) {
                Toast.makeText(getApplicationContext(), "Votre email est invalide", Toast.LENGTH_LONG).show();
            }else if (!isValid(mdp)) {
                Toast.makeText(getApplicationContext(), "Votre mot de passe doit contenir au minimum 8 caractères", Toast.LENGTH_LONG).show();
            } else if (!mdp.equals(mdpConfirm)) {
                Toast.makeText(getApplicationContext(), "Les mots de passe ne correspondent pas", Toast.LENGTH_LONG).show();
            }else if (mdp.compareTo(mdpConfirm) == 0) {
                db.register(nom, mail, mdp, mdpConfirm);
                startActivity(new Intent(creationActivity.this, login.class));
                Toast.makeText(getApplicationContext(), "vous êtes inscrit !", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "Echec dans l'enregistrement de données", Toast.LENGTH_LONG).show();
            }
        });
    }

    public boolean isValid(String passwordhere) {
        return passwordhere.length() >= 8;
    }

    public boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }
}