package com.example.latabledesgourmands.cuisinier.créerMonMenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.latabledesgourmands.R;
import com.example.latabledesgourmands.cuisinier.acceuilCuisinier;
import com.example.latabledesgourmands.cuisinier.creerMaTable.creerMaTableStep2bis;
import com.example.latabledesgourmands.utilitaire.API.platHelper;
import com.example.latabledesgourmands.utilitaire.Models.Entree;
import com.example.latabledesgourmands.utilitaire.Models.Menu;
import com.example.latabledesgourmands.utilitaire.Models.Plat;

import com.example.latabledesgourmands.utilitaire.Models.Table;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class creerMonMenuStep2 extends AppCompatActivity {
    Table maTable;
    Menu monMenu;
    Entree monEntree;
    Plat monPlat;
    boolean isDessert;

    TextView nom;
    TextView ingrédients;
    TextView recette;
    TextView prix;
    RatingBar difficulte;
    CheckBox vegetarien;
    CheckBox vegan;
    CheckBox sansGluten;
    CheckBox isWine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creer_mon_menu_step2);
        Intent intent = getIntent();
        if (intent != null) {
            maTable = intent.hasExtra("maTable") ? intent.getParcelableExtra("maTable"): null;
            isDessert = intent.getBooleanExtra("isDessert", false);
            monEntree = intent.hasExtra("monEntree")? intent.getParcelableExtra("monEntree") : null;
        }
        Log.i("nico", "onCreate: " + maTable);
        Log.i("nico", "onCreate Dessert: " + isDessert);
        linkActivityToLayout();
    }




    private void startCreerMonMenuFinalStepActivity(){
        Intent intent = new Intent(this, creerMonMenuFinalStep.class);
        sendDatabyIntent(intent);
        startActivity(intent);
    }
    private void startCreerMonMenuStep3Activity(){
        Intent intent = new Intent(this, creerMonMenuStep3.class);
        sendDatabyIntent(intent);
        startActivity(intent);
    }

    protected FirebaseUser getCurrentUser(){ return FirebaseAuth.getInstance().getCurrentUser(); }


    private void getDataFromInput() {
        if((nom.getText().toString().equals(" ")) || (ingrédients.getText().toString().equals(" ")) ||
                (recette.getText().toString().equals(" ")) || (prix.getText().toString().equals(" "))) {
            monPlat=null;
        }
        else{
            monPlat = new Plat(nom.getText().toString(), ingrédients.getText().toString(),
                    recette.getText().toString(), Float.parseFloat(prix.getText().toString()),
                    difficulte.getRating(), vegetarien.isChecked(), vegan.isChecked(), sansGluten.isChecked(), isWine.isChecked());

            platHelper.createPlat(nom.getText().toString(), ingrédients.getText().toString(),
                    recette.getText().toString(), Float.parseFloat(prix.getText().toString()),
                    difficulte.getRating(), vegetarien.isChecked(), vegan.isChecked(), sansGluten.isChecked(), isWine.isChecked(), getCurrentUser().getUid() );
        }
    }

    private void linkActivityToLayout(){
        nom=findViewById(R.id.platNameInput);
        ingrédients=findViewById(R.id.ingredientPlatInput);
        recette =findViewById(R.id.recettePlatInput);
        prix = findViewById(R.id.prixPlatInput);
        difficulte = findViewById(R.id.difficultePlatInput);
        vegetarien = findViewById(R.id.vegetarienPlatInput);
        vegan = findViewById(R.id.veganPlatInput);
        sansGluten = findViewById(R.id.sansGlutenPlatInput);
        isWine = findViewById(R.id.wineInput);
    }


    private void sendDatabyIntent(Intent intent){
        if(isDessert){ //On a choisi avec Dessert
            if(monEntree!= null){ //on a choisi avec Entree
                intent.putExtra(("monEntree"), monEntree);
            }
            intent.putExtra(("monPlat"), monPlat); //On a le plat quoi qu'il arrive
        }
        else{ //On n'a pas choisi de dessert, donc on créer le menu
            if(monEntree !=null){ //Menu avec entrée
                monMenu = new Menu(monEntree, monPlat);
            }
            else { //Menu sans entrée
                monMenu=new Menu(monPlat);
            }
            intent.putExtra("monMenu", monMenu);
        }
        if(maTable!=null){ //Si jamais on est dans le processus de création d'une table, on envoi la table
            if(monMenu!=null){ //Si jamais on a fini le créer le menu, on ajoute le menu à la table, sinon on envoi que la table sans menu
                maTable.setMonMenu(monMenu);
            }
            intent.putExtra("maTable",maTable);
        }
    }
    public void onClickCreateSecondStep(View view) {
        getDataFromInput();
        if(monPlat!=null) {
            if (!isDessert) {
                startCreerMonMenuFinalStepActivity();
            }
            if (isDessert) {
                startCreerMonMenuStep3Activity();
            }
        }
        else{
            Toast.makeText(getApplicationContext(), "Veuillez remplir tous les champs pour créer votre plat", Toast.LENGTH_LONG).show();
        }

    }
}