package com.example.latabledesgourmands.fragments.recyclerViewMenu;


import android.app.Application;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

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
    Button wineIndicator;

    Context context;

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
    wineIndicator = itemView.findViewById(R.id.wineIndicatorFragment);
    context=itemView.getContext();
    }




    public void updateWithMenuList(Menu menu){
        //date.setText('date : ' + schedule.getDate());
        if(menu!=null) {
            if(menu.getMonEntree()!=null){
                nomEntree.setText(menu.getMonEntree().getNom());
                diffEntree.setRating(menu.getMonEntree().getDifficulte());
            }
            else{
                nomEntree.setVisibility(View.GONE);
                diffEntree.setVisibility(View.GONE);
            }
            if(menu.getMonDessert()!=null){

                nomDessert.setText(menu.getMonDessert().getNom());
                diffDessert.setRating(menu.getMonDessert().getDifficulte());
            }
            else{
                nomDessert.setVisibility(View.GONE);
                diffDessert.setVisibility(View.GONE);
            }

            nomPlat.setText(menu.getMonPlat().getNom());
            priceMenu.setText(String.valueOf(menu.getPrixDuMenuParPersonne()) + " $");
            diffPlat.setRating(menu.getMonPlat().getDifficulte());
            veggieIndicator.setSelected(menu.getVegetarien());
            veganIndicator.setSelected(menu.getVegan());
            glutenIndicator.setSelected(menu.getSansGluten());
            wineIndicator.setSelected(menu.getMonPlat().getWineWanted());
        }
        else{
            Toast.makeText(context, "Pas de menu à afficher, une erreur a du se glisser", Toast.LENGTH_LONG).show();
        }
    }
}
