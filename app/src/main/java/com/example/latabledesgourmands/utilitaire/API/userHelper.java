package com.example.latabledesgourmands.utilitaire.API;

import com.example.latabledesgourmands.utilitaire.Models.User;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class userHelper {
    private static final String COLLECTION_NAME = "users";

    // --- COLLECTION REFERENCE ---
    protected FirebaseUser getCurrentUser(){ return FirebaseAuth.getInstance().getCurrentUser(); }
    public static CollectionReference getUsersCollection(){
        return FirebaseFirestore.getInstance().collection(COLLECTION_NAME);
    }

    // --- CREATE ---

    public static Task<Void> createUser(String uid, String username, String urlPicture) {
        User userToCreate = new User(uid, username, urlPicture);
        return userHelper.getUsersCollection()
                .document(uid)
                .set(userToCreate);
    }

    // --- GET ---

    public static Task<DocumentSnapshot> getUser(String uid){
        return userHelper.getUsersCollection().document(uid).get();
    }

    // --- UPDATE ---

    public static Task<Void> updateUsername(String username, String uid) {
        return userHelper.getUsersCollection().document(uid).update("username", username);
    }

    // --- DELETE ---

    public static Task<Void> deleteUser(String uid) {
        return userHelper.getUsersCollection().document(uid).delete();
    }
}
