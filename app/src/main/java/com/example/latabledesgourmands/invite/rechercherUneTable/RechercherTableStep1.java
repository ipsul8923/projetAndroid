package com.example.latabledesgourmands.invite.rechercherUneTable;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.latabledesgourmands.R;

public class RechercherTableStep1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche_table_step1);
    }

    public void onClickRechercherTableButton(View view){
        startRechercherTableStep2Activity();
    }

    private void startRechercherTableStep2Activity(){
        Intent intent = new Intent(this, RechercherTableStep2.class);
        startActivity(intent);
    }

}
