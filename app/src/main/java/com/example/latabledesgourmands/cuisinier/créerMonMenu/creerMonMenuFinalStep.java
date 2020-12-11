package com.example.latabledesgourmands.cuisinier.créerMonMenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.latabledesgourmands.R;
import com.example.latabledesgourmands.cuisinier.acceuilCuisinier;
import com.example.latabledesgourmands.cuisinier.creerMaTable.creerMaTableStep2bis;
import com.example.latabledesgourmands.utilitaire.Models.Menu;
import com.example.latabledesgourmands.utilitaire.Models.Table;

public class creerMonMenuFinalStep extends AppCompatActivity {
    Table maTable;
    Menu monMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creer_mon_menu_final_step);
        Intent intent = getIntent();
        if (intent != null) {
            maTable = intent.hasExtra("maTable") ? intent.getParcelableExtra("maTable"): null;
            monMenu = intent.hasExtra("monMenu")? intent.getParcelableExtra("monMenu") : null;
        }
        setUpMenuFragment(monMenu);
    }
    private void setUpMenuFragment(Menu menu){
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
        nomEntree.setText(menu.getMonEntree().getNom());
        nomPlat.setText(menu.getMonPlat().getNom());
        nomDessert.setText(menu.getMonDessert().getNom());
        priceMenu.setText((int) menu.getPrixDuMenuParPersonne().getValeur());
        diffEntree.setRating(menu.getMonEntree().getDifficulte());
        diffPlat.setRating(menu.getMonPlat().getDifficulte());
        diffDessert.setRating(menu.getMonDessert().getDifficulte());
        veggieIndicator.setSelected(menu.isVegetarien());
        veganIndicator.setSelected(menu.isVegan());
        glutenIndicator.setSelected(menu.isSansGluten());
    }

    private void sendDatabyIntent(Intent intent){
        if(maTable!=null){ //On a besoin d'envoyer la table avec le bon menu
            maTable.setMonMenu(monMenu);
            intent.putExtra("maTable",maTable);
        }
        else{
            //on créer le menu dans le cloud
        }
    }
    private void startCreerMaTableStep2bisActivity(){
        Intent intent = new Intent(this, creerMaTableStep2bis.class);
        sendDatabyIntent(intent);
        startActivity(intent);
    }
    private void startAcceuilCuisinierActivity(){
        Intent intent = new Intent(this, acceuilCuisinier.class);
        sendDatabyIntent(intent);
        startActivity(intent);
    }
    public void onClickCreateMenuButton(View view){
            if (maTable != null) {
                Toast.makeText(getApplicationContext(), "Menu créer et importer dans votre table", Toast.LENGTH_LONG).show();
                startCreerMaTableStep2bisActivity();
            } else {
                Toast.makeText(getApplicationContext(), "Menu créer et importer dans votre base de donnée", Toast.LENGTH_LONG).show();
                startAcceuilCuisinierActivity();
            }
    }
}