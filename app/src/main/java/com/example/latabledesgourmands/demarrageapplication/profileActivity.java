package com.example.latabledesgourmands.demarrageapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.latabledesgourmands.R;
import com.example.latabledesgourmands.cuisinier.acceuilCuisinier;
import com.example.latabledesgourmands.utilitaire.API.userHelper;
import com.example.latabledesgourmands.utilitaire.Models.User;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;


public class profileActivity extends AppCompatActivity {
        //FOR DESIGN
        Button updateBtn;
        Button SignOutBtn;
        Button deleteBtn;
        ImageView imageViewProfile;
        TextInputEditText textInputEditTextUsername;
        TextView textViewEmail;
        private static final int SIGN_OUT_TASK=10;
        private static final int DELETE_USER_TASK=20;
        private static final int UPDATE_USERNAME = 30;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_profile);
            updateBtn= findViewById(R.id.profile_activity_button_update);
            SignOutBtn=findViewById(R.id.profile_activity_button_sign_out);
            deleteBtn= findViewById(R.id.profile_activity_button_delete);
            imageViewProfile= findViewById(R.id.profile_activity_imageview_profile) ;
            textInputEditTextUsername = findViewById(R.id.profile_activity_edit_text_username);
            textViewEmail=findViewById(R.id.profile_activity_text_view_email);
            this.updateUIWhenCreating();
        }

        // --------------------
        // ACTIONS
        // --------------------
        public void onClickUpdateButton(View v) {
            this.updateUsernameInFirebase();
        }

        public void onClickSignOutButton(View v) {
            this.signOutUserFromFirebase();
        }

        public void onClickDeleteButton(View v) {
            new AlertDialog.Builder(this, R.style.AlertDialogCustom)
                    .setMessage("êtes vous sur de supprimer votre compte")
                    .setPositiveButton("OUI", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            deleteUserFromFirebase();
                        }
                    })
                    .setNegativeButton("NON",null)
                    .show();
        }

        private void signOutUserFromFirebase(){
            AuthUI.getInstance()
                    .signOut(this)
                    .addOnSuccessListener(this, this.updateUIAfterRESTRequestsCompleted(SIGN_OUT_TASK));
            startAcceuilApplicationActivity();
        }

        protected FirebaseUser getCurrentUser(){ return FirebaseAuth.getInstance().getCurrentUser(); }
        protected Boolean isCurrentUserLogged(){ return (this.getCurrentUser() != null); }

        private void deleteUserFromFirebase(){
            if(this.getCurrentUser() !=null){
                userHelper.deleteUser(this.getCurrentUser().getUid());
                AuthUI.getInstance()
                        .delete(this)
                        .addOnSuccessListener(this, this.updateUIAfterRESTRequestsCompleted(DELETE_USER_TASK));

            }
        }

        private void updateUsernameInFirebase(){
            String username = this.textInputEditTextUsername.getText().toString();
            if(this.getCurrentUser()!=null){
                if(!username.isEmpty() && !username.equals("aucun nom d'utilisateur trouvé")){
                    userHelper.updateUsername(
                            username,
                            this.getCurrentUser().getUid())
                            .addOnSuccessListener(this.updateUIAfterRESTRequestsCompleted(UPDATE_USERNAME));
                }
            }
        }


        private OnSuccessListener<? super Void> updateUIAfterRESTRequestsCompleted (final int origin) {
            return new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    switch (origin) {
                        case SIGN_OUT_TASK:
                            finish();
                            break;
                        case DELETE_USER_TASK:
                            finish();
                            break;
                        case UPDATE_USERNAME :
                            break;
                        default:
                            break;
                    }

                }
            };

        }


        private void updateUIWhenCreating(){
            if (this.getCurrentUser() != null){
                //Get picture URL from Firebase
                if (this.getCurrentUser().getPhotoUrl() != null) {
                    Glide.with(this)
                            .load(this.getCurrentUser().getPhotoUrl())
                            .apply(RequestOptions.circleCropTransform())
                            .into(imageViewProfile);
                }
                //Get email & username from Firebase
                String email = TextUtils.isEmpty(this.getCurrentUser().getEmail()) ? "aucun email trouvé" : this.getCurrentUser().getEmail();
                this.textViewEmail.setText(email);

                userHelper.getUser(this.getCurrentUser().getUid()).addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        User currenUser= documentSnapshot.toObject(User.class);
                        String username = TextUtils.isEmpty(currenUser.getUsername()) ? "aucun nom d'utilisateur trouvé":currenUser.getUsername();
                        textInputEditTextUsername.setText(username);
                    }
                });
            }
        }

    protected void startAcceuilApplicationActivity(){
        Intent intent = new Intent(this, AcceuilApplication.class);
        startActivity(intent);
    }

    }