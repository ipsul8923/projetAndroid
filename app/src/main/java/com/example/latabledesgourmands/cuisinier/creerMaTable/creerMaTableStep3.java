package com.example.latabledesgourmands.cuisinier.creerMaTable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.latabledesgourmands.R;
import com.example.latabledesgourmands.utilitaire.Models.Menu;

public class creerMaTableStep3 extends AppCompatActivity {
    Menu selectedMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creer_ma_table_step3);
        Intent intent = getIntent();
        if(intent != null){
            if(intent.hasExtra("selectedMenu")){
                selectedMenu=intent.getParcelableExtra("selectedMenu");
            }
        }
    }

    private void startcreerMaTablestep4Activity(){
        Intent intent = new Intent(this, creerMaTableStep4.class);
        intent.putExtra("selectedMenu",selectedMenu);
        startActivity(intent);
    }


    public void onClickNextStepButton(View view) {
        startcreerMaTablestep4Activity();
    }
}