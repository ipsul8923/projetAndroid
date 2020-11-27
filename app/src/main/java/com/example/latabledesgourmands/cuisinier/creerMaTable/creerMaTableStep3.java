package com.example.latabledesgourmands.cuisinier.creerMaTable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.latabledesgourmands.R;
import com.example.latabledesgourmands.utilitaire.Models.Menu;
import com.example.latabledesgourmands.utilitaire.Models.Table;

public class creerMaTableStep3 extends AppCompatActivity {
    Table maTable;

    TextView date;
    TextView heure;
    TextView adresse;
    TextView nombreConvives;
    TextView nomTheme;
    CheckBox fumeur;
    CheckBox alcool;
    CheckBox animaux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creer_ma_table_step3);
        linkActivityToLayout();
        Intent intent = getIntent();
        if(intent != null){
            if(intent.hasExtra("maTable")){
                maTable=intent.getParcelableExtra("maTable");
            }
        }
    }

    private void linkActivityToLayout(){
        date=findViewById(R.id.editTextDate);
        heure=findViewById(R.id.editTextTime);
        adresse=findViewById(R.id.editTextTextPostalAddress);
        nombreConvives=findViewById(R.id.editTextNumber);
        nomTheme=findViewById(R.id.editThemeText);
        fumeur=findViewById(R.id.checkBox);
        animaux=findViewById(R.id.checkBox2);
        alcool=findViewById(R.id.checkBox3);




    }

    public void getDataFromUserInput() {
        maTable.getMonEvenement().setDate((String) date.getText().toString());
        maTable.getMonEvenement().setHeure(heure.getText().toString());
        maTable.getMonEvenement().setAdresse(adresse.getText().toString());
        maTable.getMonEvenement().setNombreConvive(Integer.valueOf(nombreConvives.getInputType()));
        maTable.getMonEvenement().getTheme().setNom(nomTheme.getText().toString());
        maTable.getMonEvenement().setAlcoolOk(alcool.isChecked());
        maTable.getMonEvenement().setFumeurOk(fumeur.isChecked());
        maTable.getMonEvenement().setAnimalOk(animaux.isChecked());
    }


    private void startcreerMaTablestep4Activity(){
        Intent intent = new Intent(this, creerMaTableStep4.class);
        intent.putExtra("maTable",maTable);
        startActivity(intent);
    }


    public void onClickNextStepButton(View view) {
        getDataFromUserInput();
        startcreerMaTablestep4Activity();
    }


}