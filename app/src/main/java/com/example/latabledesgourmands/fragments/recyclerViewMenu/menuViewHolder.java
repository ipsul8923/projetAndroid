package com.example.latabledesgourmands.fragments.recyclerViewMenu;


import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.latabledesgourmands.R;
import com.example.latabledesgourmands.utilitaire.Models.Menu;

public class menuViewHolder extends RecyclerView.ViewHolder {
    //Ajouter tous les éléments d'interface d'un menu
    TextView nomEntree;
    TextView nomPlat;
    TextView nomDessert;

    public menuViewHolder(@NonNull View itemView) {
        super(itemView);
        //Lancer tous les findById des éléments défini précédemment sur le itemiew
    nomEntree=itemView.findViewById(R.id.nomEntree);
    nomPlat=itemView.findViewById(R.id.nomPlat);
    nomDessert=itemView.findViewById(R.id.nomDessert);

    }


    public void updateWithMenuList(Menu menu){
        //date.setText('date : ' + schedule.getDate());
        nomEntree.setText(menu.getMonEntree().getNom());
        nomPlat.setText(menu.getMonPlat().getNom());
        nomDessert.setText(menu.getMonDessert().getNom());
    }
}
