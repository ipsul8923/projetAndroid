package com.example.latabledesgourmands.invite.rechercherUneTable;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.latabledesgourmands.R;
import com.example.latabledesgourmands.utilitaire.Models.Dessert;
import com.example.latabledesgourmands.utilitaire.Models.Entree;
import com.example.latabledesgourmands.utilitaire.Models.Evenement;
import com.example.latabledesgourmands.utilitaire.Models.Menu;
import com.example.latabledesgourmands.utilitaire.Models.Plat;
import com.example.latabledesgourmands.utilitaire.Models.Table;
import com.example.latabledesgourmands.utilitaire.Models.Theme;

public class RechercherTableStep1 extends AppCompatActivity {
    Table monFiltre;
    TextView dateInput;
    Boolean isDateInputVisible = false;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche_table_step1);
        initFiltreTableProcess();
        dateInput = findViewById(R.id.editTextDate);
    }

    private void initFiltreTableProcess(){
        monFiltre = new Table(
                new Menu(
                        new Entree(null, null, null, 0f, 0f, null, null, null),
                        new Plat(null, null, null, null, 0f, null, null, null, null),
                        new Dessert(null, null, null, null, 0f, null, null, null)
                ),
                new Evenement(null, null, null, 0, 0, null, null, null, null)
        );
    }




    public void onClickRechercherTableButton(View view){
        printDataFromUser();
        startRechercherTableStep2Activity();
    }

    public void printDataFromUser(){
        if(isDateInputVisible){
            monFiltre.getMonEvenement().setDate(dateInput.getText().toString());
        }
    }

    private void startRechercherTableStep2Activity(){
        Intent intent = new Intent(this, RechercherTableStep2.class);
        intent.putExtra("monFiltre", monFiltre);
        startActivity(intent);
    }



    private void upddateVisibility(){
        if(isDateInputVisible){
            dateInput.setVisibility(View.VISIBLE);
        }
        else{
            dateInput.setVisibility(View.INVISIBLE);
        }
    }

    public void onClickDataFilter(View view) {
        isDateInputVisible = !isDateInputVisible;
        view.setSelected(!view.isSelected());
        upddateVisibility();
    }
}
