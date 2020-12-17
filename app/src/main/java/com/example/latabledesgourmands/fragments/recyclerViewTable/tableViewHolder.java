package com.example.latabledesgourmands.fragments.recyclerViewTable;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.latabledesgourmands.R;
import com.example.latabledesgourmands.utilitaire.Models.Menu;
import com.example.latabledesgourmands.utilitaire.Models.Table;

import org.w3c.dom.Text;

public class tableViewHolder extends RecyclerView.ViewHolder {

    //TextView prixTable;
    TextView dateTable;
    TextView heureTable;
    TextView adresseTable;
    TextView nomTheme;
    Button fumeurTable;
    Button animauxTable;
    Button alcoolTable;

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
    public tableViewHolder(View itemView) {
        super(itemView);
        //prixTable = itemView.findViewById(R.id.prixTable);
        dateTable = itemView.findViewById(R.id.dateTable);
        heureTable = itemView.findViewById(R.id.heureTable);
        adresseTable = itemView.findViewById(R.id.adresseTable);
        nomTheme = itemView.findViewById(R.id.nomTheme);
        fumeurTable = itemView.findViewById(R.id.tableFumeur);
        animauxTable = itemView.findViewById(R.id.tableAnimaux);
        alcoolTable = itemView.findViewById(R.id.tableAlcool);

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



    public void updateWithTableList(Table table){
        nomEntree.setText(table.getMonMenu().getMonEntree().getNom());
        nomPlat.setText(table.getMonMenu().getMonPlat().getNom());
        nomDessert.setText(table.getMonMenu().getMonDessert().getNom());
        //prixTable.setText(String.valueOf(table.getMonMenu().getPrixDuMenuParPersonne()) + " $");
        dateTable.setText(table.getMonEvenement().getDate());
        heureTable.setText(table.getMonEvenement().getHeure());
        adresseTable.setText(table.getMonEvenement().getAdresse());
        nomTheme.setText(table.getMonEvenement().getTheme());
        fumeurTable.setSelected(table.getMonEvenement().getFumeurOk());
        animauxTable.setSelected(table.getMonEvenement().getAnimalOk());
        alcoolTable.setSelected(table.getMonEvenement().getAlcoolOk());
        Menu menu = table.getMonMenu();
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

