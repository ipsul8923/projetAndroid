package com.example.latabledesgourmands.cuisinier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.latabledesgourmands.R;
import com.example.latabledesgourmands.cuisinier.creerMaTable.creerMaTable;
import com.example.latabledesgourmands.cuisinier.créerMonMenu.creerMonMenu;
import com.example.latabledesgourmands.cuisinier.gererMesMenus.gererMesMenus;
import com.example.latabledesgourmands.cuisinier.gérerMesTables.gererMesTables;
import com.example.latabledesgourmands.demarrageapplication.ChoixCuisinierInvite;

public class acceuilCuisinier extends AppCompatActivity {
    Button acceuilButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil_cuisinier);
        acceuilButton = findViewById(R.id.logo);
        acceuilButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startChoixCuisinierInviteActivity();
            }
        });
    }
    private void startChoixCuisinierInviteActivity(){
        Intent intent = new Intent(this, ChoixCuisinierInvite.class);
        startActivity(intent);
    }


    private void startCreerMaTableActivity(){
        Intent intent = new Intent(this, creerMaTable.class);
        startActivity(intent);
    }


    private void startGererMesTablesActivity(){
        Intent intent = new Intent(this, gererMesTables.class);
        startActivity(intent);
    }

    public void startCreerMonMenuActivity(){
        Intent intent = new Intent(this, creerMonMenu.class);
        startActivity(intent);
    }private void startGererMesMenusActivity(){
        Intent intent = new Intent(this, gererMesMenus.class);
        startActivity(intent);
    }
    public void onClickCreerMaTableButton(View view) {
        startCreerMaTableActivity();
    }

    public void onClickGererMesTablesButton(View view) {
        startGererMesTablesActivity();
    }

    public void onClickCreerMonMenuButton(View view) {
        startCreerMonMenuActivity();
    }

    public void onClickGererMesMenusButton(View view) {
        startGererMesMenusActivity();
    }
}