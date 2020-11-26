package com.example.latabledesgourmands.invite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.latabledesgourmands.R;
import com.example.latabledesgourmands.invite.gererMesTables.GererMesTablesInvite;
import com.example.latabledesgourmands.invite.rechercherUneTable.RechercherTableStep1;

public class AccueilInvite extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil_invite);
    }

    public void onClickRechercherTableButton(View view){
        startRechercherTableActivity();
    }

    public void onClickGererMesTablesButton(View view){
        startGererMesTablesActivity();
    }

    private void startRechercherTableActivity(){
        Intent intent = new Intent(this, RechercherTableStep1.class);
        startActivity(intent);
    }

    private void startGererMesTablesActivity(){
        Intent intent = new Intent(this, GererMesTablesInvite.class);
        startActivity(intent);
    }


}
