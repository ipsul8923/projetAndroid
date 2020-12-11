package com.example.latabledesgourmands.cuisinier.creerMaTable;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.latabledesgourmands.R;
import com.example.latabledesgourmands.utilitaire.Models.Menu;
import com.example.latabledesgourmands.utilitaire.Models.Table;

public class creerMaTableStep2bis extends AppCompatActivity {
    Table maTable;
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

        setUpMenuFragment(maTable.getMonMenu());
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

    private void startCreerMaTableStep3Activity(){
        Intent intent = new Intent(this, creerMaTableStep3.class);
        intent.putExtra("maTable",maTable);
        startActivity(intent);
    }

    public void onClickNextStepButton(View view) {
        startCreerMaTableStep3Activity();
    }

}