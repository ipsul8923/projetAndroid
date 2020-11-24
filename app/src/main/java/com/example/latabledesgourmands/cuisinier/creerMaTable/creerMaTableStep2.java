package com.example.latabledesgourmands.cuisinier.creerMaTable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.latabledesgourmands.R;
import com.example.latabledesgourmands.cuisinier.acceuilCuisinier;
import com.example.latabledesgourmands.cuisinier.créerMonMenu.creerMonMenu;

public class creerMaTableStep2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creer_ma_table_step2);

    }





    private void startCreerMonMenuActivity(){
        Intent intent = new Intent(this, creerMonMenu.class);
        startActivity(intent);
    }
    private void startImportMonMenuActivity(){
        Intent intent = new Intent(this, importMenu.class);
        startActivity(intent);
    }



    public void onClickImportMenuButton(View view) {
        startImportMonMenuActivity();
    }

    public void onClickCreateMenuButton(View view) {
        startCreerMonMenuActivity();
    }
}