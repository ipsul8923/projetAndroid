package com.example.latabledesgourmands.fragments.recyclerViewTable;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.latabledesgourmands.R;
import com.example.latabledesgourmands.utilitaire.Models.Table;

import org.w3c.dom.Text;

public class tableViewHolder extends RecyclerView.ViewHolder {
    TextView nomEntree;
    TextView nomPlat;
    TextView nomDessert;
    TextView prixTable;
    TextView dateTable;
    TextView heureTable;
    TextView adresseTable;
    TextView nomTheme;
    Button fumeurTable;
    Button animauxTable;
    Button alcoolTable;

    public tableViewHolder(View itemView) {
        super(itemView);
        nomEntree = itemView.findViewById(R.id.nomEntreeTable);
        nomPlat = itemView.findViewById(R.id.nomPlatTable);
        nomDessert = itemView.findViewById(R.id.nomDessertTable);
        prixTable = itemView.findViewById(R.id.prixTable);
        dateTable = itemView.findViewById(R.id.dateTable);
        heureTable = itemView.findViewById(R.id.heureTable);
        adresseTable = itemView.findViewById(R.id.adresseTable);
        nomTheme = itemView.findViewById(R.id.nomTheme);
        fumeurTable = itemView.findViewById(R.id.tableFumeur);
        animauxTable = itemView.findViewById(R.id.tableAnimaux);
        alcoolTable = itemView.findViewById(R.id.tableAlcool);
    }

    public void updateWithTableList(Table table){
        nomEntree.setText(table.getMonMenu().getMonEntree().getNom());
        nomPlat.setText(table.getMonMenu().getMonPlat().getNom());
        nomDessert.setText(table.getMonMenu().getMonDessert().getNom());
        prixTable.setText(String.valueOf(table.getMonMenu().getPrixDuMenuParPersonne()));
        dateTable.setText(table.getMonEvenement().getDate());
        heureTable.setText(table.getMonEvenement().getHeure());
        adresseTable.setText(table.getMonEvenement().getAdresse());
        //nomTheme.setText(table.getMonEvenement().getTheme().getNom());
        fumeurTable.setSelected(table.getMonEvenement().getFumeurOk());
        animauxTable.setSelected(table.getMonEvenement().getAnimalOk());
        alcoolTable.setSelected(table.getMonEvenement().getAlcoolOk());
    }
}
