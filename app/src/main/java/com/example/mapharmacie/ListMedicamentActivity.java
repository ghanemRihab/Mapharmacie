package com.example.mapharmacie;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;

public class ListMedicamentActivity extends AppCompatActivity {

    private ArrayList<MedicamentModal> medicaments;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_medicament);
        medicaments = new ArrayList<>();
        Database db = new Database(ListMedicamentActivity.this);
        medicaments = db.getMedicamentData();
        ListView name = findViewById(R.id.liste_medi);
        // Creating a ListView adapter
        ArrayAdapter mAdapter = new ArrayAdapter<>(this, R.layout.items, R.id.name, medicaments);

        // Setting the ListView adapter with the one created above
        name.setAdapter(mAdapter);
    }

}
