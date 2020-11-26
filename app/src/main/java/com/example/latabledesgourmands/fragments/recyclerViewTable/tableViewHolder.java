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
    TextView valeurPrix;
    TextView donneesInformations;
    TextView nomTheme;


    public tableViewHolder(View itemView) {
        super(itemView);
        nomEntree = itemView.findViewById(R.id.nomEntree);
        nomPlat = itemView.findViewById(R.id.nomPlat);
        nomDessert = itemView.findViewById(R.id.nomDessert);
        valeurPrix = itemView.findViewById(R.id.valeurPrix);
        donneesInformations = itemView.findViewById(R.id.donneesInformations);
        nomTheme = itemView.findViewById(R.id.nomTheme);
    }

    public void updateWithTableList(Table table){
        nomEntree.setText(table.getMonEntree().getNom());
        nomPlat.setText(table.getMonPlat().getNom());
        nomDessert.setText(table.getMonDessert().getNom());
        valeurPrix.setText(Float.toString(table.getMonPrix().getValeur()) + "€");
        donneesInformations.setText(table.getMesInformations().getDonnees());
        nomTheme.setText(table.getMonTheme().getNom());
    }
}
