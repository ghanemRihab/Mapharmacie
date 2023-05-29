package com.example.mapharmacie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.HashMap;

public class ListMedicamentActivity extends AppCompatActivity {
    ListView liste_medi;
    String name,quantite;
    HashMap<String,String> map;

    params p =new params();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_don);
        liste_medi = findViewById(R.id.lst);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            name = extras.getString("nom");
            quantite = extras.getString("quantité");

            map = new HashMap<String, String>();
            map.put("nom", name);
            map.put("quantite", quantite);
            p.values.add(map);

        }
        SimpleAdapter adapter = new SimpleAdapter(ListMedicamentActivity.this, p.values, R.layout.item,
                new String[]{"nom", "quantité", "dateex"},
                new int[]{R.id.nom, R.id.quantite, R.id.dateex}
        );
        liste_medi.setAdapter(adapter);
        liste_medi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Cliquez ici pour modifier!", Toast.LENGTH_LONG).show();
            }
        });
        liste_medi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i =new Intent(getApplicationContext(),ItemActivity.class);
                i.putExtra("postion",position);
                startActivity(i);

            }
        });
    }
}