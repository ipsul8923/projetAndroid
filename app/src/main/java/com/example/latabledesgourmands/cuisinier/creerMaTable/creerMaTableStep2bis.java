package com.example.latabledesgourmands.cuisinier.creerMaTable;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
    nomEntree=findViewById(R.id.nomEntree);
    nomPlat=findViewById(R.id.nomPlat);
    nomDessert=findViewById(R.id.nomDessert);
    nomEntree.setText(menu.getMonEntree().getNom());
    nomPlat.setText(menu.getMonPlat().getNom());
    nomDessert.setText(menu.getMonDessert().getNom());
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