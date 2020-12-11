package com.example.latabledesgourmands.cuisinier.creerMaTable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.latabledesgourmands.R;
import com.example.latabledesgourmands.utilitaire.Models.Dessert;
import com.example.latabledesgourmands.utilitaire.Models.Entree;
import com.example.latabledesgourmands.utilitaire.Models.Evenement;
import com.example.latabledesgourmands.utilitaire.Models.Menu;
import com.example.latabledesgourmands.utilitaire.Models.Plat;
import com.example.latabledesgourmands.utilitaire.Models.Prix;
import com.example.latabledesgourmands.utilitaire.Models.Table;
import com.example.latabledesgourmands.utilitaire.Models.Theme;

public class creerMaTable extends AppCompatActivity {
    Table maTable;
    Button oneCooker;
    Button twoCooker;
    Button threeCooker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creer_ma_table);
        linkActivityToLayout();
        initCreationTableProcess();
    }


    private void linkActivityToLayout(){
        oneCooker = findViewById(R.id.buttonOneCookerTable);
        twoCooker = findViewById(R.id.buttonTwoCookerTable);
        threeCooker = findViewById(R.id.buttonThreeCookerTable);
    }

    private void initCreationTableProcess(){
        maTable = new Table(
                new Menu(
                        new Entree("placeHolder","placeHolder","placeHolder",
                                0f, 0f, false, false,false ),
                        new Plat("placeHolder","placeHolder","placeHolder",
                                0f, 0f, false, false,false,false ),
                        new Dessert("placeHolder","placeHolder","placeHolder",
                                0f, 0f, false, false,false )
                ),
                new Evenement("date", "adresse", "heure", 6, 1, new Theme("theme"),false, false, false)
        );
    }
    private void startCreerMaTableStep2Activity(){
        Intent intent = new Intent(this, creerMaTableStep2.class);
        intent.putExtra("maTable",maTable);
        startActivity(intent);
    }


    public void onClickNextStepButton(View view) {
        if(oneCooker.isSelected() || twoCooker.isSelected() || threeCooker.isSelected()){
            startCreerMaTableStep2Activity();
        }
        else{
            Toast.makeText(getApplicationContext(), "Veuillez choisir un nombre de cuisinier", Toast.LENGTH_LONG).show();
        }
    }

    public void onClickButtonOneCooker(View view) {
        maTable.getMonEvenement().setNombreCuisinier(1);
        view.setSelected(!view.isSelected());
        twoCooker.setSelected(false);
        threeCooker.setSelected(false);
    }

    public void onClickButtonTwoCooker(View view) {
        maTable.getMonEvenement().setNombreCuisinier(2);
        view.setSelected(!view.isSelected());
        oneCooker.setSelected(false);
        threeCooker.setSelected(false);
    }

    public void onClickButtonThreeCooker(View view) {
        maTable.getMonEvenement().setNombreCuisinier(3);
        view.setSelected(!view.isSelected());
        twoCooker.setSelected(false);
        oneCooker.setSelected(false);

    }
}