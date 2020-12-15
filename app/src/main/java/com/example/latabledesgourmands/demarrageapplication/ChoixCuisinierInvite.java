package com.example.latabledesgourmands.demarrageapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.latabledesgourmands.R;
import com.example.latabledesgourmands.cuisinier.acceuilCuisinier;
import com.example.latabledesgourmands.invite.AccueilInvite;

public class ChoixCuisinierInvite extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_cuisinier_invite);
    }

    public void onClickCuisinierButton(View view){
        startModeCuisinierActivity();
    }

    public void onClickinviteButton(View view){
        startModeInviteActivity();
    }

    public void onClickProfilButton(View view) {
        startProfilActivity();
    }

    protected void startModeCuisinierActivity(){
        Intent intent = new Intent(this, acceuilCuisinier.class);
        startActivity(intent);
    }
    protected void startProfilActivity(){
        Intent intent = new Intent(this, profileActivity.class);
        startActivity(intent);
    }
    protected void startModeInviteActivity(){
        Intent intent = new Intent(this, AccueilInvite.class);
        startActivity(intent);
    }

}
