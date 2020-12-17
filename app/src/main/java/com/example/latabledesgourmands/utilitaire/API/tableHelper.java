package com.example.latabledesgourmands.utilitaire.API;

import android.app.Application;
import android.widget.Toast;

import com.example.latabledesgourmands.utilitaire.Models.Dessert;
import com.example.latabledesgourmands.utilitaire.Models.Entree;
import com.example.latabledesgourmands.utilitaire.Models.Evenement;
import com.example.latabledesgourmands.utilitaire.Models.Menu;
import com.example.latabledesgourmands.utilitaire.Models.Plat;
import com.example.latabledesgourmands.utilitaire.Models.Table;
import com.example.latabledesgourmands.utilitaire.Models.User;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class tableHelper {
    private static final String COLLECTION_NAME = "tables";

    // --- COLLECTION REFERENCE ---

    public static CollectionReference getTableCollection(){
        return FirebaseFirestore.getInstance().collection(COLLECTION_NAME);
    }

    // --- CREATE ---

    public static Task<Void> createTable(Evenement evenement, Menu menu, String userID) {
        Table tableToCreate = new Table(menu, evenement);
        String path = "table"+ tableToCreate.getMonEvenement().getDate()+tableToCreate.getMonEvenement().getAdresse()+userID;
        return  tableHelper.getTableCollection()
                .document(path)
                .set(tableToCreate);
    }


    // --- GET ---

    public static Task<DocumentSnapshot> getTable(String tableID){
        return com.example.latabledesgourmands.utilitaire.API.tableHelper.getTableCollection().document(tableID).get();
    }

    // --- UPDATE ---

    //public static Task<Void> updateTable(Evenement evenement, Menu menu,String userID) {
    //   return com.example.latabledesgourmands.utilitaire.API.tableHelper.
    //           getTableCollection().document(user.getUid()).update(menu, evenement, user.getUid());
    //}

    // --- DELETE ---

    public static Task<Void> deleteTable(String tableID) {
        return com.example.latabledesgourmands.utilitaire.API.tableHelper.getTableCollection().document(tableID).delete();
    }
}
