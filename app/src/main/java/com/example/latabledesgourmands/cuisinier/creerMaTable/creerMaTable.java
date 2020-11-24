package com.example.latabledesgourmands.cuisinier.creerMaTable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.latabledesgourmands.R;

public class creerMaTable extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creer_ma_table);
    }
    private void startCreerMaTableStep2Activity(){
        Intent intent = new Intent(this, creerMaTableStep2.class);
        startActivity(intent);
    }
    public void onClickNextStepButton(View view) {
        startCreerMaTableStep2Activity();
    }
}