package com.example.latabledesgourmands.utilitaire.API;

import com.example.latabledesgourmands.utilitaire.Models.Plat;
import com.example.latabledesgourmands.utilitaire.Models.User;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class platHelper {
    private static final String COLLECTION_NAME = "plats";

    // --- COLLECTION REFERENCE ---

    public static CollectionReference getPlatCollection(){
        return FirebaseFirestore.getInstance().collection(COLLECTION_NAME);
    }

    // --- CREATE ---

    public static Task<Void> createPlat(String nom, String listeIngredients, String recette, float prixParPersonne,
                                        float difficulte, Boolean vegetarien, Boolean vegan, Boolean sansGluten,
                                        Boolean isWineWanted, String userId) {
        Plat platToCreate = new Plat(nom, listeIngredients, recette, prixParPersonne,
        difficulte, vegetarien, vegan, sansGluten, isWineWanted);
        String path = "plat" + nom+userId;
        return platHelper.getPlatCollection()
                .document(path)
                .set(platToCreate);
    }

    // --- GET ---

    public static Task<DocumentSnapshot> getPlat(String platId){
        return com.example.latabledesgourmands.utilitaire.API.platHelper.getPlatCollection().document(platId).get();
    }

    // --- UPDATE ---

    public static Task<Void> updatePlat(String nom, String listeIngredients, String recette, float prixParPersonne,
                                        float difficulte, Boolean vegetarien, Boolean vegan, Boolean sansGluten, Boolean isWineWanted, String userId) {
        return com.example.latabledesgourmands.utilitaire.API.platHelper.getPlatCollection().document(userId).update(nom, listeIngredients, recette, prixParPersonne,
        difficulte, vegetarien, vegan, sansGluten, isWineWanted, userId);
    }

    // --- DELETE ---

    public static Task<Void> deletePlat(String platId) {
        return com.example.latabledesgourmands.utilitaire.API.platHelper.getPlatCollection().document(platId).delete();
    }

}
