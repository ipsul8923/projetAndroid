package com.example.latabledesgourmands.invite.rechercherUneTable;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.latabledesgourmands.R;
import com.example.latabledesgourmands.utilitaire.Models.Entree;
import com.example.latabledesgourmands.utilitaire.Models.Table;

public class RechercherTableStep3 extends AppCompatActivity {
    Table tableSelected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche_table_step3);

        Intent intent = getIntent();
        if(intent != null){
            if(intent.hasExtra("tableSelected")){
                tableSelected = intent.getParcelableExtra("tableSelected");
            }
        }

        setUpTableFragment(tableSelected);
    }

    private void setUpTableFragment(Table tableSelected) {
        TextView nomEntree;
        TextView nomPlat;
        TextView nomDessert;
        TextView valeurPrix;
        TextView donneesInformations;
        TextView nomTheme;

        nomEntree=findViewById(R.id.nomEntree);
        nomPlat=findViewById(R.id.nomPlat);
        nomDessert=findViewById(R.id.nomDessert);
        valeurPrix=findViewById(R.id.valeurPrix);
        donneesInformations=findViewById(R.id.donneesInformations);
        nomTheme=findViewById(R.id.nomTheme);

        nomEntree.setText(tableSelected.getMonEntree().getNom());
        nomPlat.setText(tableSelected.getMonPlat().getNom());
        nomDessert.setText(tableSelected.getMonDessert().getNom());
        valeurPrix.setText(Float.toString(tableSelected.getMonPrix().getValeur()));
        donneesInformations.setText(tableSelected.getMesInformations().getDonnees());
        nomTheme.setText(tableSelected.getMonTheme().getNom());
    }


}
