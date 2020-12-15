package com.example.latabledesgourmands.utilitaire.API;

import com.example.latabledesgourmands.utilitaire.Models.Entree;
import com.example.latabledesgourmands.utilitaire.Models.Evenement;
import com.example.latabledesgourmands.utilitaire.Models.User;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class evenementHelper {
    private static final String COLLECTION_NAME = "evenements";

    // --- COLLECTION REFERENCE ---

    public static CollectionReference getEvenementCollection(){
        return FirebaseFirestore.getInstance().collection(COLLECTION_NAME);
    }

    // --- CREATE ---

    public static Task<Void> createEvenement(String date, String adresse, String heure, int nombreConvive,
                                             int nombreCuisinier, String theme, Boolean isFumeurOk,
                                             Boolean isAnimalOk, Boolean isAlcoolOk, String userID) {
        Evenement evenementToCreate = new Evenement(date, adresse, heure, nombreConvive,
        nombreCuisinier, theme, isFumeurOk, isAnimalOk, isAlcoolOk);
        String path = date+adresse+userID;
        return evenementHelper.getEvenementCollection()
                .document(path)
                .set(evenementToCreate);
    }

    // --- GET ---

    public static Task<DocumentSnapshot> getEvenement(String evenementID){
        return com.example.latabledesgourmands.utilitaire.API.evenementHelper.getEvenementCollection().document(evenementID).get();
    }

    // --- UPDATE ---

    public static Task<Void> updateEvenement (String date, String adresse, String heure, int nombreConvive,
             int nombreCuisinier, String theme, Boolean isFumeurOk, Boolean isAnimalOk, Boolean isAlcoolOk, String userID) {
        return com.example.latabledesgourmands.utilitaire.API.evenementHelper.getEvenementCollection().document(userID).update(date, adresse, heure, nombreConvive,
                nombreCuisinier, theme, isFumeurOk, isAnimalOk, isAlcoolOk, userID);
    }

    // --- DELETE ---

    public static Task<Void> deleteEvenement(String evenementID) {
        return com.example.latabledesgourmands.utilitaire.API.evenementHelper.getEvenementCollection().document(evenementID).delete();
    }
}
