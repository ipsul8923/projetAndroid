package com.example.latabledesgourmands.cuisinier.creerMaTable;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.latabledesgourmands.R;
import com.example.latabledesgourmands.utilitaire.Models.Menu;
import com.example.latabledesgourmands.utilitaire.Models.Table;

public class creerMaTableStep2bis extends AppCompatActivity {
    Table maTable;
    ImageButton firstStep;
    ImageButton secondStep;
    ImageButton thridStep;
    ImageButton fourthStep;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creer_ma_table_step2bis);
        Intent intent = getIntent();
        if(intent != null){
            if(intent.hasExtra("maTable")){
                maTable=intent.getParcelableExtra("maTable");
            }
        }
        setUpBottomFragment();
        setUpMenuFragment(maTable.getMonMenu());
    }
    private void setUpBottomFragment()
    {
        firstStep = findViewById(R.id.firstStepImage);
        secondStep = findViewById(R.id.secondStepImage);
        thridStep = findViewById(R.id.thirdStepImage);
        fourthStep = findViewById(R.id.fourthStepImage);


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

    private void startCreerMaTableStep3Activity(){
        Intent intent = new Intent(this, creerMaTableStep3.class);
        intent.putExtra("maTable",maTable);
        startActivity(intent);
    }

    public void onClickNextStepButton(View view) {
        startCreerMaTableStep3Activity();
    }

}