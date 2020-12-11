package com.example.latabledesgourmands.fragments.recyclerViewMenu;


import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
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
    TextView priceMenu;
    RatingBar diffEntree;
    RatingBar diffPlat;
    RatingBar diffDessert;
    Button veggieIndicator;
    Button veganIndicator;
    Button glutenIndicator;

    public menuViewHolder(@NonNull View itemView) {
        super(itemView);
        //Lancer tous les findById des éléments défini précédemment sur le itemiew
    nomEntree=itemView.findViewById(R.id.nomEntreeFragment);
    nomPlat=itemView.findViewById(R.id.nomPlatFragment);
    nomDessert=itemView.findViewById(R.id.nomDessertFragment);
    priceMenu=itemView.findViewById(R.id.prixMenuFragment);
    diffEntree=itemView.findViewById(R.id.difficulteEntreeFragment);
    diffPlat=itemView.findViewById(R.id.difficultePlatFragment);
    diffDessert=itemView.findViewById(R.id.difficulteDessertFragment);
    veggieIndicator=itemView.findViewById(R.id.VegetarienMenuIndicatorFragment);
    veganIndicator=itemView.findViewById(R.id.VeganMenuIndicatorFragment);
    glutenIndicator=itemView.findViewById(R.id.GlutenMenuIndicatorFragment);

    }


    public void updateWithMenuList(Menu menu){
        //date.setText('date : ' + schedule.getDate());
        nomEntree.setText(menu.getMonEntree().getNom());
        nomPlat.setText(menu.getMonPlat().getNom());
        nomDessert.setText(menu.getMonDessert().getNom());
        priceMenu.setText(String.valueOf(menu.getPrixDuMenuParPersonne().getValeur()));
        diffEntree.setRating(menu.getMonEntree().getDifficulte());
        diffPlat.setRating(menu.getMonPlat().getDifficulte());
        diffDessert.setRating(menu.getMonDessert().getDifficulte());
        veggieIndicator.setSelected(menu.isVegetarien());
        veganIndicator.setSelected(menu.isVegan());
        glutenIndicator.setSelected(menu.isSansGluten());
    }
}
