package com.example.latabledesgourmands.cuisinier.creerMaTable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.latabledesgourmands.R;
import com.example.latabledesgourmands.cuisinier.acceuilCuisinier;
import com.example.latabledesgourmands.utilitaire.Models.Menu;
import com.example.latabledesgourmands.utilitaire.Models.Table;

public class creerMaTableStep4 extends AppCompatActivity {
    Table maTable;

    TextView date;
    TextView heure;
    TextView adresse;
    TextView nombreCuisinier;
    TextView nombreConvives;
    TextView nomTheme;
    Button fumeur;
    Button alcool;
    Button animaux;
    boolean isFumeur;
    boolean isAlcool;
    boolean isAnimaux;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creer_ma_table_step4);
        Intent intent = getIntent();
        if(intent != null){
            if(intent.hasExtra("maTable")){
                maTable=intent.getParcelableExtra("maTable");
            }
        }
        linkActivityToLayout();
        printDataFromTable(maTable);
    }


    private void linkActivityToLayout(){
        date=findViewById(R.id.datePrint);
        heure=findViewById(R.id.hourPrint);
        adresse=findViewById(R.id.adressePrint);
        nombreCuisinier=findViewById(R.id.cookNumerPrint);
        nombreConvives=findViewById(R.id.nombreConvivePrint);
        nomTheme=findViewById(R.id.nomThemePrint);
        fumeur=findViewById(R.id.fumeurPrint);
        animaux=findViewById(R.id.animauxPrint);
        alcool=findViewById(R.id.alcoolPrint);
    }

    private void printDataFromTable(Table table){
        nombreCuisinier.setText(Integer.toString(table.getMonEvenement().getNombreCuisinier()));
        setUpMenuFragment(table.getMonMenu());
        date.setText(table.getMonEvenement().getDate());
        heure.setText(table.getMonEvenement().getHeure());
        adresse.setText(table.getMonEvenement().getAdresse());
        nombreConvives.setText(Integer.toString(table.getMonEvenement().getNombreConvive()) + " convives");

        String themeName = table.getMonEvenement().getTheme().getNom().equals("thème") ?
                "pas de thème" : table.getMonEvenement().getTheme().getNom();
        nomTheme.setText(themeName);
        isAnimaux = table.getMonEvenement().getAnimalOk();
        isFumeur = table.getMonEvenement().getFumeurOk();
        isAlcool = table.getMonEvenement().getAlcoolOk();
        animaux.setSelected(isAnimaux);
        fumeur.setSelected(isFumeur);
        alcool.setSelected(isAlcool);


    }


    private void setUpMenuFragment(Menu menu){
        TextView nomEntree;
        TextView nomPlat;
        TextView nomDessert;
        nomEntree=findViewById(R.id.nomEntree);
        nomPlat=findViewById(R.id.nomPlat);
        nomDessert=findViewById(R.id.nomDessert);
        nomEntree.setText(menu.getMonEntree().getNom());
        nomPlat.setText(menu.getMonPlat().getNom());
        nomDessert.setText(menu.getMonDessert().getNom());
    }


    private void startAcceuilCuisinierActivity(){
        Intent intent = new Intent(this, acceuilCuisinier.class);
        startActivity(intent);
    }

    public void onClickCreateATable(View view) {
        Toast.makeText(getApplicationContext(), "la table est créée", Toast.LENGTH_LONG).show();
        startAcceuilCuisinierActivity();
    }
}