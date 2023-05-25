package com.example.mapharmacie;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class List_ordActivity extends AppCompatActivity {
    RecyclerView r ;
    Database database ;
    ArrayList<String> ord_id,date,nom_mede,specialite_mede,adress_mede,telephone_mede,mail_mede,nom_medi,dosage_medi,frequence_medi,nombre_boite_medi,moment_prise_medi,image_ord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_ord);
        r =findViewById(R.id.recycle_view);
        database = new Database(List_ordActivity.this);
        ord_id = new ArrayList<>();
        date = new ArrayList<>();
        nom_mede =new ArrayList<>();
        specialite_mede=new ArrayList<>();
        adress_mede=new ArrayList<>();
        telephone_mede=new ArrayList<>();
        mail_mede=new ArrayList<>();
        nom_medi=new ArrayList<>();
        mail_mede=new ArrayList<>();
        dosage_medi=new ArrayList<>();
        frequence_medi=new ArrayList<>();
        nombre_boite_medi=new ArrayList<>();
        moment_prise_medi=new ArrayList<>();
        image_ord=new ArrayList<>();

        r.setLayoutManager(new LinearLayoutManager(List_ordActivity.this));
    }
  /* void StoreDataInArrays(){
        Cursor cursor = database.readAllData();
        if(cursor.getCount()==0){
            Toast.makeText(this, "Pas de base de données", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                ord_id.add(cursor.getString(0));
                date.add(cursor.getString(1));
                nom_mede.add(cursor.getString( 2));
                specialite_mede.add(cursor.getString(3));
                adress_mede.add(cursor.getString(4));
                telephone_mede.add(cursor.getString(5));
                mail_mede.add(cursor.getString(6));
                dosage_medi.add(cursor.getString(7));
                frequence_medi.add(cursor.getString(8));
                nombre_boite_medi.add(cursor.getString(9));
                moment_prise_medi.add(cursor.getString(10));
                image_ord.add(cursor.getString(11));


            }
        }

    }*/
}