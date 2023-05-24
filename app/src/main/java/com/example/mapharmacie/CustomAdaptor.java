package com.example.mapharmacie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public abstract class CustomAdaptor extends RecyclerView.Adapter<CustomAdaptor.MyViewHolder> {
    private Context context;

    private ArrayList ord_id,date,nom_mede,specialite_mede,adress_mede,telephone_mede,mail_mede,nom_medi,dosage_medi,frequence_medi,nombre_boite_medi,moment_prise_medi,image_ord;

    CustomAdaptor(Context context, ArrayList ord_id, ArrayList date, ArrayList nom_mede, ArrayList specialite_mede, ArrayList adress_mede, ArrayList telephone_mede, ArrayList mail_mede, ArrayList nom_medi, ArrayList dosage_medi, ArrayList frequence_medi, ArrayList nombre_boite_medi,
                  ArrayList moment_prise_medi)
    {
        this.context = context;
        this.ord_id= ord_id;
        this.date=date;
        this.nom_mede=nom_mede;
        this.specialite_mede=specialite_mede;
        this.adress_mede=adress_mede;
        this.telephone_mede=telephone_mede;
        this.mail_mede=mail_mede;
        this.nom_medi=nom_medi;
        this.dosage_medi=dosage_medi;
        this.frequence_medi=frequence_medi;
        this.nombre_boite_medi=nombre_boite_medi;
        this.moment_prise_medi=moment_prise_medi;
        this.image_ord=image_ord=image_ord;

    }

}

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(context)  ;
        View view = inflater.inflate(R.layout.my_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.ord_id_txt.setText(String.valueOf(ord_id.get(position)));
        holder.date_txt.setText(String.valueOf(date.get(position)));
        holder.nom_mede_txt.setText(String.valueOf(nom_mede.get(position)));
        holder.specialite_mede_txt.setText(String.valueOf(specialite_mede.get(position)));
        holder.telephone_mede_txt.setText(String.valueOf(telephone_mede.get(position)));
        holder.adress_mede_txt.setText(String.valueOf(adress_mede.get(position)));
        holder.mail_mede_txt.setText(String.valueOf(mail_mede.get(position)));
        holder.nom_medi_txt.setText(String.valueOf(nom_medi.get(position)));
        holder.dosage_medi_txt.setText(String.valueOf(dosage_medi.get(position)));
        holder.frequence_medi_txt.setText(String.valueOf(frequence_medi.get(position)));
        holder.nombre_boite_medi_txt.setText(String.valueOf(nombre_boite_medi.get(position)));
        holder.moment_prise_medi_txt.setText(String.valueOf(moment_prise_medi.get(position)));
        holder.image_ord_txt.setText(String.valueOf(image_ord.get(position)));

    }

    @Override
    public int getItemCount() {
        return ord_id.size();
    }}

public class MyViewHolder extends RecyclerView.Adapter<CustomAdaptor.MyViewHolder> {
    TextView ord_id_txt,date_txt,nom_mede_txt,specialite_mede_txt,adress_mede_txt,telephone_mede_txt,mail_mede_txt,nom_medi_txt,dosage_medi_txt,frequence_medi_txt,nombre_boite_medi_txt,moment_prise_medi_txt,image_ord_txt;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        ord_id_txt=itemView.findViewById(R.id.ord_id_txt);
        date_txt=itemView.findViewById(R.id.date_txt);
        nom_mede_txt=itemView.findViewById(R.id.nom_mede_txt);
        specialite_mede_txt=itemView.findViewById(R.id.specialite_mede_txt);
        adress_mede_txt=itemView.findViewById(R.id.adress_mede_txt);
        telephone_mede_txt=itemView.findViewById(R.id.telephone_mede_txt);
        mail_mede_txt=itemView.findViewById(R.id.mail_mede_txt);
        nom_medi_txt=itemView.findViewById(R.id.nom_medi_txt);
        dosage_medi_txt=itemView.findViewById(R.id.dosage_medi_txt);
        frequence_medi_txt=itemView.findViewById(R.id.frequence_medi_txt);
        nombre_boite_medi_txt=itemView.findViewById(R.id.nombre_boite_medi_txt);
        moment_prise_medi_txt=itemView.findViewById(R.id.moment_prise_medi_txt);
        image_ord_txt=itemView.findViewById(R.id.image_ord_txt);
    }


    @NonNull
    @Override
    public CustomAdaptor.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdaptor.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

