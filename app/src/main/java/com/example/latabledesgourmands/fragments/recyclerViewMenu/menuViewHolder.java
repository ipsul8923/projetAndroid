package com.example.latabledesgourmands.fragments.recyclerViewMenu;


import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.latabledesgourmands.utilitaire.Models.Menu;

public class menuViewHolder extends RecyclerView.ViewHolder {
    //Ajouter tous les éléments d'interface d'un menu


    public menuViewHolder(@NonNull View itemView) {
        super(itemView);
        //Lancer tous les findById des éléments défini précédemment sur le itemiew
    }


    public void updateWithMenuList(Menu menu){
        //date.setText('date : ' + schedule.getDate());
    }
}
