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
import com.example.latabledesgourmands.utilitaire.Models.Entree;
import com.example.latabledesgourmands.utilitaire.Models.Menu;
import com.example.latabledesgourmands.utilitaire.Models.Plat;
import com.example.latabledesgourmands.utilitaire.Models.Prix;
import com.example.latabledesgourmands.utilitaire.Models.Table;

public class creerMonMenuStep1 extends AppCompatActivity {
    Table maTable;
    Entree monEntree;
    boolean isDessert;

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
        setContentView(R.layout.activity_creer_mon_menu_step1);
        Intent intent = getIntent();
        if (intent != null) {
            maTable = intent.hasExtra("maTable") ? intent.getParcelableExtra("maTable"): null;
            isDessert = intent.getBooleanExtra("isDessert", false);
        }
        Log.i("nico", "onCreate: " + maTable);
        Log.i("nico", "onCreate Dessert: " + isDessert);

        linkActivityToLayout();
    }
    private void linkActivityToLayout(){
        nom=findViewById(R.id.entreeNameInput);
        ingrédients=findViewById(R.id.ingredientEntreeInput);
        recette =findViewById(R.id.recetteEntreeInput);
        prix = findViewById(R.id.prixEntreeInput);
        difficulte = findViewById(R.id.difficulteEntreeInput);
        vegetarien = findViewById(R.id.vegetarienEntreeInput);
        vegan = findViewById(R.id.veganEntreeInput);
        sansGluten = findViewById(R.id.sansGlutenEntreeInput);
    }
    private void getDataFromInput(){
        if((nom.getText().toString().equals(" ")) || (ingrédients.getText().toString().equals(" ")) ||
                (recette.getText().toString().equals(" ")) || (prix.getText().toString().equals(" "))){
            monEntree=null;

        }
        else{
            monEntree = new Entree(nom.getText().toString(), ingrédients.getText().toString(),
                    recette.getText().toString(), new Prix(Float.parseFloat(prix.getText().toString())),
                    difficulte.getRating(), vegetarien.isChecked(), vegan.isChecked(), sansGluten.isChecked());
            }
        }
    private void startCreerMonMenuStep2(){
        Intent intent = new Intent(this, creerMonMenuStep2.class);
        sendDatabyIntent(intent);
        startActivity(intent);
    }

    private void sendDatabyIntent(Intent intent){
        intent.putExtra(("monEntree"), monEntree);
        if(maTable!=null){
            intent.putExtra("maTable",maTable);}
        intent.putExtra("isDessert", isDessert);
    }

    public void onClickCreateFirstStep(View view) {
        getDataFromInput();
        if(monEntree!= null) {
                startCreerMonMenuStep2();
        }
        else {
            Toast.makeText(getApplicationContext(), "Veuillez remplir tous les champs pour créer votre entrée", Toast.LENGTH_LONG).show();
        }
    }

}