package com.example.latabledesgourmands.demarrageapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.latabledesgourmands.R;

public class AcceuilApplication extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil_application);
    }

    public void onClickConnexionInscriptionButton(View view){
        startChoixCuisinierInviteActivity();
    }

    private void startChoixCuisinierInviteActivity(){
        Intent intent = new Intent(this, ChoixCuisinierInvite.class);
        startActivity(intent);
    }
}
