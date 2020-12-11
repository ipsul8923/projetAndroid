package com.example.latabledesgourmands.cuisinier.créerMonMenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.latabledesgourmands.R;
import com.example.latabledesgourmands.cuisinier.acceuilCuisinier;
import com.example.latabledesgourmands.cuisinier.creerMaTable.creerMaTableStep2bis;
import com.example.latabledesgourmands.utilitaire.Models.Dessert;
import com.example.latabledesgourmands.utilitaire.Models.Entree;
import com.example.latabledesgourmands.utilitaire.Models.Menu;
import com.example.latabledesgourmands.utilitaire.Models.Plat;
import com.example.latabledesgourmands.utilitaire.Models.Prix;
import com.example.latabledesgourmands.utilitaire.Models.Table;

public class creerMonMenuStep3 extends AppCompatActivity {
    Table maTable;
    Menu monMenu;
    Entree monEntree;
    Plat monPlat;
    Dessert monDessert;

    TextView nom;
    TextView ingrédients;
    TextView recette;
    TextView prix;
    RatingBar difficulte;
    CheckBox vegetarien;
    CheckBox vegan;
    CheckBox sansGluten;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creer_mon_menu_step3);
        Intent intent = getIntent();
        if (intent != null) {
            maTable = intent.hasExtra("maTable") ? intent.getParcelableExtra("maTable"): null;
            monEntree = intent.hasExtra("monEntree")? intent.getParcelableExtra("monEntree") : null;
            monPlat = intent.hasExtra("monPlat") ? intent.getParcelableExtra("monPlat") : null;

        }
        linkActivityToLayout();
    }


    private void linkActivityToLayout(){
        nom=findViewById(R.id.dessertNameInput);
        ingrédients=findViewById(R.id.ingredientDessertInput);
        recette =findViewById(R.id.recetteDessertInput);
        prix = findViewById(R.id.prixDessertInput);
        difficulte = findViewById(R.id.difficulteDessertInput);
        vegetarien = findViewById(R.id.vegetarienDessertInput);
        vegan = findViewById(R.id.veganDessertInput);
        sansGluten = findViewById(R.id.sansGlutenDessertInput);
    }
    private void getDataFromInput(){
        if((nom.getText().toString().equals(" ")) || (ingrédients.getText().toString().equals(" ")) ||
                (recette.getText().toString().equals(" ")) || (prix.getText().toString().equals(" "))) {
            monDessert=null;
        }
        else{
            monDessert = new Dessert(nom.getText().toString(), ingrédients.getText().toString(),
                    recette.getText().toString(), Float.parseFloat(prix.getText().toString()),
                    difficulte.getRating(), vegetarien.isChecked(), vegan.isChecked(), sansGluten.isChecked());

            //On recupère le dessert, et ensuite on créer le menu
            if (monEntree != null) {
                monMenu = new Menu(monEntree, monPlat, monDessert);
            } else {
                monMenu = new Menu(monPlat, monDessert);
            }
        }
    }

    private void sendDatabyIntent(Intent intent){
        if(maTable!=null){ //On a besoin d'envoyer la table avec le bon menu
            maTable.setMonMenu(monMenu);
            intent.putExtra("maTable",maTable);
        }
        intent.putExtra("monMenu", monMenu);
    }
    private void startCreerMonMenuFinalStepActivity(){
        Intent intent = new Intent(this, creerMonMenuFinalStep.class);
        sendDatabyIntent(intent);
        startActivity(intent);
    }
    public void onClickCreateThirdStep(View view){
        getDataFromInput();
        // à terme seulement dans on créer une table, autrement on enregistre le menu dans le cloud à ce moment là
        if(monDessert!=null) {
            startCreerMonMenuFinalStepActivity();
        }
        else{
            Toast.makeText(getApplicationContext(), "Veuillez remplir tous les champs pour créer votre Dessert", Toast.LENGTH_LONG).show();
        }
    }
}