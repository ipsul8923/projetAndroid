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
import com.example.latabledesgourmands.utilitaire.API.menuHelper;
import com.example.latabledesgourmands.utilitaire.Models.Menu;
import com.example.latabledesgourmands.utilitaire.Models.Table;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

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
            monMenu = intent.hasExtra("monMenu") ? intent.getParcelableExtra("monMenu") : null;
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
        Button wineIndicator;
        if(menu!=null) {
            nomEntree = findViewById(R.id.nomEntreeFragment);
            diffEntree = findViewById(R.id.difficulteEntreeFragment);
            nomDessert = findViewById(R.id.nomDessertFragment);
            diffDessert = findViewById(R.id.difficulteDessertFragment);
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
            nomPlat = findViewById(R.id.nomPlatFragment);
            priceMenu = findViewById(R.id.prixMenuFragment);
            diffPlat = findViewById(R.id.difficultePlatFragment);
            veggieIndicator = findViewById(R.id.VegetarienMenuIndicatorFragment);
            veganIndicator = findViewById(R.id.VeganMenuIndicatorFragment);
            glutenIndicator = findViewById(R.id.GlutenMenuIndicatorFragment);
            wineIndicator = findViewById(R.id.wineIndicatorFragment);
            nomPlat.setText(menu.getMonPlat().getNom());
            priceMenu.setText(String.valueOf(menu.getPrixDuMenuParPersonne()) + " $");
            diffPlat.setRating(menu.getMonPlat().getDifficulte());
            veggieIndicator.setSelected(menu.getVegetarien());
            veganIndicator.setSelected(menu.getVegan());
            glutenIndicator.setSelected(menu.getSansGluten());
            wineIndicator.setSelected(menu.getMonPlat().getWineWanted());
        }
        else{
            Toast.makeText(getApplicationContext(), "Pas de menu à afficher, une erreur a du se glisser", Toast.LENGTH_LONG).show();
        }
    }
    protected FirebaseUser getCurrentUser(){ return FirebaseAuth.getInstance().getCurrentUser(); }
    protected Boolean isCurrentUserLogged(){ return (this.getCurrentUser() != null); }
    private void sendDatabyIntent(Intent intent){
        if(maTable!=null){ //On a besoin d'envoyer la table avec le bon menu
            maTable.setMonMenu(monMenu);
            intent.putExtra("maTable",maTable);
        }
        else{
            if(monMenu.getMonEntree()!=null){
                if(monMenu.getMonDessert()!=null){
                    menuHelper.createMenu(monMenu.getMonEntree(), monMenu.getMonPlat(), monMenu.getMonDessert(), getCurrentUser().getUid());
                }
                menuHelper.createMenuEntreePlat(monMenu.getMonEntree(), monMenu.getMonPlat(), getCurrentUser().getUid());
            }
            else {


                if (monMenu.getMonDessert() != null) {
                    menuHelper.createMenuPlatDessert(monMenu.getMonPlat(), monMenu.getMonDessert(), getCurrentUser().getUid());
                }
                else{
                    menuHelper.createMenuPlat(monMenu.getMonPlat(), getCurrentUser().getUid());
                }
            }
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
                Toast.makeText(getApplicationContext(), "Menu créé et importé dans votre table", Toast.LENGTH_LONG).show();
                startCreerMaTableStep2bisActivity();
            } else {
                Toast.makeText(getApplicationContext(), "Menu créé et importé dans votre base de donnée", Toast.LENGTH_LONG).show();
                startAcceuilCuisinierActivity();
            }
    }
}