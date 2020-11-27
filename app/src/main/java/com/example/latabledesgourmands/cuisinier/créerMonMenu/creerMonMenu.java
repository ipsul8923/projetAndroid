package com.example.latabledesgourmands.cuisinier.créerMonMenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.latabledesgourmands.R;
import com.example.latabledesgourmands.utilitaire.Models.Table;

public class creerMonMenu extends AppCompatActivity {
    Table maTable;
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
    }
}