package com.example.latabledesgourmands.utilitaire.API;

import com.example.latabledesgourmands.utilitaire.Models.Dessert;
import com.example.latabledesgourmands.utilitaire.Models.User;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class dessertHelper {
    private static final String COLLECTION_NAME = "desserts";

    // --- COLLECTION REFERENCE ---

    public static CollectionReference getDessertCollection(){
        return FirebaseFirestore.getInstance().collection(COLLECTION_NAME);
    }

    // --- CREATE ---

    public static Task<Void> createDessert(String nom, String listeIngredients, String recette, float prixParPersonne,
                                        float difficulte, Boolean vegetarien, Boolean vegan, Boolean sansGluten, String userID) {
        Dessert dessertToCreate = new Dessert(nom, listeIngredients, recette, prixParPersonne,
                difficulte, vegetarien, vegan, sansGluten);
        String path = "dessert" + nom+userID;
        return dessertHelper.getDessertCollection()
                .document(path)
                .set(dessertToCreate);
    }

    // --- GET ---

    public static Task<DocumentSnapshot> getDessert(String dessertID){
        return com.example.latabledesgourmands.utilitaire.API.dessertHelper.getDessertCollection().document(dessertID).get();
    }

    // --- UPDATE ---

    public static Task<Void> updateDessert(String nom, String listeIngredients, String recette, float prixParPersonne,
                                        float difficulte, Boolean vegetarien, Boolean vegan, Boolean sansGluten, String userID) {
        return com.example.latabledesgourmands.utilitaire.API.dessertHelper.getDessertCollection().document(userID).update(nom, listeIngredients, recette, prixParPersonne,
                difficulte, vegetarien, vegan, sansGluten, userID);
    }

    // --- DELETE ---

    public static Task<Void> deleteDessert(String dessertId) {
        return com.example.latabledesgourmands.utilitaire.API.dessertHelper.getDessertCollection().document(dessertId).delete();
    }

}
