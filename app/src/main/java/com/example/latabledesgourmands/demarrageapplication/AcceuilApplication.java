package com.example.latabledesgourmands.demarrageapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.latabledesgourmands.R;
import com.example.latabledesgourmands.utilitaire.API.userHelper;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ErrorCodes;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;

public class AcceuilApplication extends AppCompatActivity {
    private static final int RC_SIGN_IN = 123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil_application);
            startChoixCuisinierInviteActivity();
    }

    public void onClickInscriptionButton(View view){
            this.startSignInActivity();

    }

    public void onClickConnexionButton(View view){
            this.startSignInActivity();
    }

    private void startChoixCuisinierInviteActivity(){
        if(this.isCurrentUserLogged()) {
            Intent intent = new Intent(this, ChoixCuisinierInvite.class);
            startActivity(intent);
        }
    }

    protected FirebaseUser getCurrentUser(){ return FirebaseAuth.getInstance().getCurrentUser(); }
    protected Boolean isCurrentUserLogged(){ return (this.getCurrentUser() != null); }

    private void createUserInfFirestore(){
        if(this.getCurrentUser()!=null){
            String urlPicture = (this.getCurrentUser().getPhotoUrl()!=null) ? this.getCurrentUser().getPhotoUrl().toString():null;
            String username = this.getCurrentUser().getDisplayName();
            String uid = this.getCurrentUser().getUid();
            userHelper.createUser(uid,username,urlPicture);
        }
    }




    private void handleResponseAfterSignIn(int requestCode, int resultCode, Intent data){

        IdpResponse response = IdpResponse.fromResultIntent(data);

        if (requestCode == RC_SIGN_IN) {
            if (resultCode == RESULT_OK) { // SUCCESS
                this.createUserInfFirestore();
                Toast.makeText(getApplicationContext(), "connexion réussie", Toast.LENGTH_LONG).show();
                startChoixCuisinierInviteActivity();
            } else { // ERRORS
                if (response == null) {
                    Toast.makeText(getApplicationContext(), "Authentification annulée", Toast.LENGTH_LONG).show();
                } else if (response.getError().getErrorCode() == ErrorCodes.NO_NETWORK) {
                    Toast.makeText(getApplicationContext(), "erreur : pas de connexion internet", Toast.LENGTH_LONG).show();
                } else if (response.getError().getErrorCode() == ErrorCodes.UNKNOWN_ERROR) {
                    Toast.makeText(getApplicationContext(), "erreur inconnue", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 4 - Handle SignIn Activity response on activity result
        this.handleResponseAfterSignIn(requestCode, resultCode, data);
    }

    public void startSignInActivity() {
        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(
                                Arrays.asList(
                                        new AuthUI.IdpConfig.GoogleBuilder().build(),
                                        new AuthUI.IdpConfig.EmailBuilder().build()))
                        .setIsSmartLockEnabled(false, true)
                        .build(),
                RC_SIGN_IN);
    }


}
