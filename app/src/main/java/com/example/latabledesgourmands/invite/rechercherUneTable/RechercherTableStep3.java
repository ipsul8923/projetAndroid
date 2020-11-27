package com.example.latabledesgourmands.invite.rechercherUneTable;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.latabledesgourmands.R;
import com.example.latabledesgourmands.invite.AccueilInvite;
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
        //TextView valeurPrix;
        TextView donneesInformations;
        //TextView nomTheme;

        nomEntree = findViewById(R.id.nomEntreeTable);
        nomPlat = findViewById(R.id.nomPlatTable);
        nomDessert = findViewById(R.id.nomDessertTable);
        //valeurPrix = findViewById(R.id.valeurPrix);
        donneesInformations = findViewById(R.id.donneesInformations);
        // nomTheme = findViewById(R.id.nomTheme);


        nomEntree.setText(tableSelected.getMonMenu().getMonEntree().getNom());
        nomPlat.setText(tableSelected.getMonMenu().getMonPlat().getNom());
        nomDessert.setText(tableSelected.getMonMenu().getMonDessert().getNom());
        //valeurPrix.setText(Float.toString(tableSelected.getMonPrix().getValeur()));
        donneesInformations.setText(tableSelected.getMonEvenement().getDate());
        //nomTheme.setText(tableSelected.getMonTheme().getNom());
    }

    private void startAcceuilInviteActivity(){
        Intent intent = new Intent(this, AccueilInvite.class);
        startActivity(intent);
    }

    public void onClickValiderBoutton(View view) {
        Toast.makeText(getApplicationContext(), "La table a été choisie", Toast.LENGTH_LONG).show();
        startAcceuilInviteActivity();
    }

}
