package com.example.mapharmacie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DonActivity extends AppCompatActivity {
    TextView tv1;
    ImageView im1;
    EditText edt1;
    EditText edt2;
    EditText edt3;
    Button btn1;
    Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_don);
        tv1=findViewById(R.id.textView_don);
        im1=findViewById(R.id.imageViewdon);
        edt1=findViewById(R.id.nomdon);
        edt2=findViewById(R.id.qantdon);
        edt3=findViewById(R.id.datedon);
        btn1=findViewById(R.id.ajoutdon);
        btn2=findViewById(R.id.modifdon);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DonActivity.this, "dons est ajouté", Toast.LENGTH_SHORT).show();

            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(DonActivity.this,List_donActivity.class);
                i.putExtra("nom",edt1.getText().toString());
                i.putExtra("quantité",edt2.getText().toString());
                i.putExtra("date",edt3.getText().toString());
                startActivity(i);


            }
        });
        btn2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent it = new Intent(getApplicationContext(),List_donActivity.class);
                startActivity(it);
            }
        });


    }
}