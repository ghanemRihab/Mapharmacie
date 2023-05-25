package com.example.mapharmacie;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class PlanActivity extends AppCompatActivity {
    TextView t1,t2,t3,t4,t5;
    EditText edt1;
    ImageView img;
    Button mod, aj ,sup;
    RadioButton r1,r2,r3,r4,r5,r6,r7,r8;
    DatePicker dt1;
    RadioGroup ra1,ra2,ra3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
        t1=findViewById(R.id.textView);
        t2=findViewById(R.id.text_date);
        t3=findViewById(R.id.text_nbre_fois);
        t4=findViewById(R.id.temps);
        t5=findViewById(R.id.repas);
        img=findViewById(R.id.image);
        mod=findViewById(R.id.modify);
        aj=findViewById(R.id.add);
        sup=findViewById(R.id.delet);
        edt1=findViewById(R.id.dose);
        r1=findViewById(R.id.rd1);
        r2=findViewById(R.id.rd2);
        r3=findViewById(R.id.rd3);
        r4=findViewById(R.id.rd4);
        r5=findViewById(R.id.rd5);
        r6=findViewById(R.id.rd6);
        r7=findViewById(R.id.rd7);
        r8=findViewById(R.id.rd8);
        dt1=findViewById(R.id.date_picker);
        ra1=(RadioGroup) findViewById(R.id.radio_button) ;
        ra2=(RadioGroup) findViewById(R.id.radio_button_temps) ;
        ra3=(RadioGroup) findViewById(R.id.radio_button_repas) ;
        aj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(PlanActivity.this,ListplanActivity.class);
                i.putExtra("t1",t1.getText().toString());
                i.putExtra("t2",t2.getText().toString());
                i.putExtra("t3",t3.getText().toString());
                i.putExtra("t4",t4.getText().toString());
                i.putExtra("t5",t5.getText().toString());
                i.putExtra("t5",t5.getText().toString());
                i.putExtra("img",img.getImageAlpha());
                i.putExtra("edt1",edt1.getText().toString());
                Intent intent = getIntent();
                DatePicker selectedDate = (DatePicker) intent.getSerializableExtra("dt1");
                i.putExtra("ra1",ra1.getCheckedRadioButtonId());
                i.putExtra("ra2",ra2.getCheckedRadioButtonId());
                i.putExtra("ra3",ra3.getCheckedRadioButtonId());
                startActivity(i, intent.getExtras());


            }
        });
        sup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });




    }
}