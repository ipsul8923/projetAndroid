package com.example.latabledesgourmands.cuisinier.creerMaTable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.latabledesgourmands.R;

public class creerMaTableStep3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creer_ma_table_step3);
    }

    private void startcreerMaTablestep4Activity(){
        Intent intent = new Intent(this, creerMaTableStep4.class);
        startActivity(intent);
    }


    public void onClickNextStepButton(View view) {
        startcreerMaTablestep4Activity();
    }
}