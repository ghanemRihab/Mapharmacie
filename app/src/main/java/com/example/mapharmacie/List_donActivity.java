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

public class List_donActivity extends AppCompatActivity {
     ListView ls;
     String nom,quantite,dateex;
     HashMap<String,String> map;

     params p =new params();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_don);
        ls = findViewById(R.id.lst);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            nom = extras.getString("nom");
            quantite = extras.getString("quantité");
            dateex = extras.getString("date");
            map = new HashMap<String, String>();
            map.put("nom", nom);
            map.put("quantité", quantite);
            map.put("date", dateex);
            p.values.add(map);


        }
        SimpleAdapter adapter = new SimpleAdapter(List_donActivity.this, p.values, R.layout.item,
                new String[]{"nom", "quantité", "dateex"},
                new int[]{R.id.nom, R.id.quantite, R.id.dateex}
        );
        ls.setAdapter(adapter);
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                      @Override
                                      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                          Toast.makeText(getApplicationContext(),"Cliquez ici pour modifier!", Toast.LENGTH_LONG).show();
                                      }
                                  });
                ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent i =new Intent(getApplicationContext(),DetailActivity.class);
                        i.putExtra("postion",position);
                        startActivity(i);

                    }
                });
    }
}