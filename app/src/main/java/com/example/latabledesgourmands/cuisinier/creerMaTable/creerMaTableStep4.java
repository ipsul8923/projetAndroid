package com.example.latabledesgourmands.cuisinier.creerMaTable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.latabledesgourmands.R;
import com.example.latabledesgourmands.cuisinier.acceuilCuisinier;
import com.example.latabledesgourmands.utilitaire.Models.Menu;

public class creerMaTableStep4 extends AppCompatActivity {
    Menu selectedMenu;
    Fragment menuFragment;
    FragmentManager Fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creer_ma_table_step4);
        Intent intent = getIntent();
        if(intent != null){
            if(intent.hasExtra("selectedMenu")){
                selectedMenu=intent.getParcelableExtra("selectedMenu");
            }
        }
        setUpMenuFragment(selectedMenu);
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