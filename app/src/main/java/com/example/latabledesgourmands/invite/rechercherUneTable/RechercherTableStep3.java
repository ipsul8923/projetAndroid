package com.example.latabledesgourmands.invite.rechercherUneTable;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
        TextView prixTable;
        TextView dateTable;
        TextView heureTable;
        TextView adresseTable;
        TextView nomTheme;
        Button fumeurTable;
        Button animauxTable;
        Button alcoolTable;

        nomEntree = findViewById(R.id.nomEntreeTableBis);
        nomPlat = findViewById(R.id.nomPlatTableBis);
        nomDessert = findViewById(R.id.nomDessertTableBis);
        prixTable = findViewById(R.id.prixTableBis);
        dateTable = findViewById(R.id.dateTableBis);
        heureTable = findViewById(R.id.heureTableBis);
        adresseTable = findViewById(R.id.adresseTableBis);
        nomTheme = findViewById(R.id.nomThemeBis);
        fumeurTable = findViewById(R.id.tableFumeurBis);
        animauxTable = findViewById(R.id.tableAnimauxBis);
        alcoolTable = findViewById(R.id.tableAlcoolBis);


        nomEntree.setText(tableSelected.getMonMenu().getMonEntree().getNom());
        nomPlat.setText(tableSelected.getMonMenu().getMonPlat().getNom());
        nomDessert.setText(tableSelected.getMonMenu().getMonDessert().getNom());
        prixTable.setText(String.valueOf(tableSelected.getMonMenu().getPrixDuMenuParPersonne()));
        dateTable.setText(tableSelected.getMonEvenement().getDate());
        heureTable.setText(tableSelected.getMonEvenement().getHeure());
        adresseTable.setText(tableSelected.getMonEvenement().getAdresse());
        nomTheme.setText(tableSelected.getMonEvenement().getTheme().getNom());
        fumeurTable.setSelected(tableSelected.getMonEvenement().getFumeurOk());
        animauxTable.setSelected(tableSelected.getMonEvenement().getAnimalOk());
        alcoolTable.setSelected(tableSelected.getMonEvenement().getAlcoolOk());
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
