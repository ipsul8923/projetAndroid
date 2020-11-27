package com.example.latabledesgourmands.fragments.recyclerViewTable;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.latabledesgourmands.R;
import com.example.latabledesgourmands.utilitaire.Models.Table;

public class tableViewHolder extends RecyclerView.ViewHolder {
    TextView nomEntree;
    TextView nomPlat;
    TextView nomDessert;
    //TextView valeurPrix;
    TextView donneesInformations;
    //TextView nomTheme;


    public tableViewHolder(View itemView) {
        super(itemView);
        nomEntree = itemView.findViewById(R.id.nomEntreeTable);
        nomPlat = itemView.findViewById(R.id.nomPlatTable);
        nomDessert = itemView.findViewById(R.id.nomDessertTable);
        //valeurPrix = itemView.findViewById(R.id.valeurPrix);
        donneesInformations = itemView.findViewById(R.id.donneesInformations);
        //nomTheme = itemView.findViewById(R.id.nomTheme);
    }

    public void updateWithTableList(Table table){
        nomEntree.setText(table.getMonMenu().getMonEntree().getNom());
        nomPlat.setText(table.getMonMenu().getMonPlat().getNom());
        nomDessert.setText(table.getMonMenu().getMonDessert().getNom());
        //valeurPrix.setText(Float.toString(table.getMonMenu().getPrixDuMenuParPersonne().getValeur()) + "€");
        donneesInformations.setText(table.getMonEvenement().getDate());
        //nomTheme.setText(table.getMonEvenement().getTheme().getNom());
    }
}
