package com.example.latabledesgourmands.cuisinier.créerMonMenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.latabledesgourmands.R;
import com.example.latabledesgourmands.cuisinier.creerMaTable.creerMaTableStep2bis;
import com.example.latabledesgourmands.utilitaire.Models.Menu;
import com.example.latabledesgourmands.utilitaire.Models.Table;

public class creerMonMenu extends AppCompatActivity {
    Table maTable;

    CheckBox entree;
    CheckBox plat;
    CheckBox dessert;
    boolean isEntree;
    boolean isPlat;
    boolean isDessert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creer_mon_menu);
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("maTable")) {
                maTable = intent.getParcelableExtra("maTable");
            }
        }
        linkActivityToLayout();
    }


    private void linkActivityToLayout(){
       entree=findViewById(R.id.isEntreeChecked);
       plat=findViewById(R.id.isPlatChecked);
       dessert=findViewById(R.id.isDessertChecked);
    }
    private void getBoolFromCheckbox(){
        isEntree=entree.isChecked();
        isPlat=plat.isChecked();
        isDessert=dessert.isChecked();
        Log.i("nico", "onCreate Dessert: " + isDessert);

    }
    private void startCreerMonMenuStep1(){
        Intent intent = new Intent(this, creerMonMenuStep1.class);
        sendDatabyIntent(intent);
        startActivity(intent);
    }
    private void startCreerMonMenuStep2(){
        Intent intent = new Intent(this, creerMonMenuStep2.class);
        sendDatabyIntent(intent);
        startActivity(intent);
    }

    private void sendDatabyIntent(Intent intent){
        if(maTable!=null){
            intent.putExtra("maTable",maTable);}
        intent.putExtra("isDessert", isDessert);

    }

    public void onClickBeginCreationMenu(View view) {
        getBoolFromCheckbox();
        if(isEntree && isPlat){
            startCreerMonMenuStep1();
        }
        if(!isEntree && isPlat){
            startCreerMonMenuStep2();
        }
        if(!isPlat){
            Toast.makeText(getApplicationContext(), "Vous ne pouvez pas créer un menu sans plat", Toast.LENGTH_LONG).show();
        }

    }
}