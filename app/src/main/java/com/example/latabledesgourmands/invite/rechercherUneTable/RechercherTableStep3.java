package com.example.latabledesgourmands.invite.rechercherUneTable;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.latabledesgourmands.R;
import com.example.latabledesgourmands.invite.AccueilInvite;
import com.example.latabledesgourmands.utilitaire.Models.Menu;
import com.example.latabledesgourmands.utilitaire.Models.Table;

public class RechercherTableStep3 extends AppCompatActivity {
    Table tableSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche_table_step3);

        Intent intent = getIntent();
        if(intent != null){
            if(intent.hasExtra("tableSelected")){
                tableSelected = intent.getParcelableExtra("tableSelected");
            }
        }

        setUpTableFragment(tableSelected);
    }

    private void setUpTableFragment(Table tableSelected) {
                TextView prixTable;
        TextView dateTable;
        TextView heureTable;
        TextView adresseTable;
        TextView nomTheme;
        Button fumeurTable;
        Button animauxTable;
        Button alcoolTable;

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

        //Lancer tous les findById des éléments défini précédemment sur le itemiew
        nomEntree=findViewById(R.id.nomEntreeFragment);
        nomPlat=findViewById(R.id.nomPlatFragment);
        nomDessert=findViewById(R.id.nomDessertFragment);
        priceMenu=findViewById(R.id.prixMenuFragment);
        diffEntree=findViewById(R.id.difficulteEntreeFragment);
        diffPlat=findViewById(R.id.difficultePlatFragment);
        diffDessert=findViewById(R.id.difficulteDessertFragment);
        veggieIndicator=findViewById(R.id.VegetarienMenuIndicatorFragment);
        veganIndicator=findViewById(R.id.VeganMenuIndicatorFragment);
        glutenIndicator=findViewById(R.id.GlutenMenuIndicatorFragment);
        wineIndicator = findViewById(R.id.wineIndicatorFragment);

        dateTable = findViewById(R.id.dateTableBis);
        heureTable = findViewById(R.id.heureTableBis);
        adresseTable = findViewById(R.id.adresseTableBis);
        nomTheme = findViewById(R.id.nomThemeBis);
        fumeurTable = findViewById(R.id.tableFumeurBis);
        animauxTable = findViewById(R.id.tableAnimauxBis);
        alcoolTable = findViewById(R.id.tableAlcoolBis);


        nomEntree.setText(tableSelected.getMonMenu().getMonEntree().getNom());
        nomPlat.setText(tableSelected.getMonMenu().getMonPlat().getNom());
        nomDessert.setText(tableSelected.getMonMenu().getMonDessert().getNom());
        dateTable.setText(tableSelected.getMonEvenement().getDate());
        heureTable.setText(tableSelected.getMonEvenement().getHeure());
        adresseTable.setText(tableSelected.getMonEvenement().getAdresse());
        nomTheme.setText(tableSelected.getMonEvenement().getTheme());
        fumeurTable.setSelected(tableSelected.getMonEvenement().getFumeurOk());
        animauxTable.setSelected(tableSelected.getMonEvenement().getAnimalOk());
        alcoolTable.setSelected(tableSelected.getMonEvenement().getAlcoolOk());
        Menu menu = tableSelected.getMonMenu();
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
            Toast.makeText(this, "Pas de menu à afficher, une erreur a du se glisser", Toast.LENGTH_LONG).show();
        }
    }

    private void startAcceuilInviteActivity(){
        Intent intent = new Intent(this, AccueilInvite.class);
        startActivity(intent);
    }

    public void onClickValiderBoutton(View view) {
        Toast.makeText(getApplicationContext(), "La table a été choisie", Toast.LENGTH_LONG).show();
        startAcceuilInviteActivity();
    }

}
