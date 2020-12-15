package com.example.latabledesgourmands.utilitaire.API;

import com.example.latabledesgourmands.utilitaire.Models.Entree;
import com.example.latabledesgourmands.utilitaire.Models.User;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class entreeHelper {
    private static final String COLLECTION_NAME = "entrees";

    // --- COLLECTION REFERENCE ---

    public static CollectionReference getEntreeCollection(){
        return FirebaseFirestore.getInstance().collection(COLLECTION_NAME);
    }

    // --- CREATE ---

    public static Task<Void> createEntree(String nom, String listeIngredients, String recette, float prixParPersonne,
                                           float difficulte, Boolean vegetarien, Boolean vegan, Boolean sansGluten, String userID) {
        Entree entreeToCreate = new Entree(nom, listeIngredients, recette, prixParPersonne,
                difficulte, vegetarien, vegan, sansGluten);
        String path = "entree" + nom+userID;
        return entreeHelper.getEntreeCollection()
                .document(path)
                .set(entreeToCreate);
    }

    // --- GET ---

    public static Task<DocumentSnapshot> getEntree(String entreeID){
        return com.example.latabledesgourmands.utilitaire.API.entreeHelper.getEntreeCollection().document(entreeID).get();
    }

    // --- UPDATE ---

    public static Task<Void> updateEntree(String nom, String listeIngredients, String recette, float prixParPersonne,
                                           float difficulte, Boolean vegetarien, Boolean vegan, Boolean sansGluten, String userID) {
        return com.example.latabledesgourmands.utilitaire.API.entreeHelper.getEntreeCollection().
                document(userID).update(nom, listeIngredients, recette, prixParPersonne,
                difficulte, vegetarien, vegan, sansGluten, userID);
    }

    // --- DELETE ---

    public static Task<Void> deleteEntree(String entreeID) {
        return com.example.latabledesgourmands.utilitaire.API.entreeHelper.getEntreeCollection().document(entreeID).delete();
    }

}
