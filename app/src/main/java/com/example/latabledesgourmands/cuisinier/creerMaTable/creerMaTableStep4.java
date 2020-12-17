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
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.latabledesgourmands.R;
import com.example.latabledesgourmands.cuisinier.acceuilCuisinier;
import com.example.latabledesgourmands.utilitaire.API.tableHelper;
import com.example.latabledesgourmands.utilitaire.API.userHelper;
import com.example.latabledesgourmands.utilitaire.Models.Menu;
import com.example.latabledesgourmands.utilitaire.Models.Table;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

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
    protected FirebaseUser getCurrentUser(){ return FirebaseAuth.getInstance().getCurrentUser(); }
    protected Boolean isCurrentUserLogged(){ return (this.getCurrentUser() != null); }
    private void printDataFromTable(Table table){
        nombreCuisinier.setText(Integer.toString(table.getMonEvenement().getNombreCuisinier()));
        setUpMenuFragment(table.getMonMenu());
        date.setText(table.getMonEvenement().getDate());
        heure.setText(table.getMonEvenement().getHeure());
        adresse.setText(table.getMonEvenement().getAdresse());
        nombreConvives.setText(Integer.toString(table.getMonEvenement().getNombreConvive()) + " convives");

        String themeName = table.getMonEvenement().getTheme().equals("thème") ?
                "pas de thème" : table.getMonEvenement().getTheme();
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


    private void startAcceuilCuisinierActivity(){
        Intent intent = new Intent(this, acceuilCuisinier.class);
        startActivity(intent);
    }

    public void onClickCreateATable(View view) {
            Toast.makeText(getApplicationContext(), "la table est créée", Toast.LENGTH_LONG).show();
            tableHelper.createTable(maTable.getMonEvenement(), maTable.getMonMenu(), getCurrentUser().getUid());
        startAcceuilCuisinierActivity();
    }
}