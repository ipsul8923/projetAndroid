package com.example.latabledesgourmands.cuisinier.creerMaTable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.latabledesgourmands.R;
import com.example.latabledesgourmands.cuisinier.acceuilCuisinier;

public class creerMaTableStep4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creer_ma_table_step4);
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