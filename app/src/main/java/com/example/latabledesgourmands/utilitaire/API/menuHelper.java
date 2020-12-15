package com.example.latabledesgourmands.utilitaire.API;

import com.example.latabledesgourmands.utilitaire.Models.Dessert;
import com.example.latabledesgourmands.utilitaire.Models.Entree;
import com.example.latabledesgourmands.utilitaire.Models.Menu;
import com.example.latabledesgourmands.utilitaire.Models.Plat;
import com.example.latabledesgourmands.utilitaire.Models.User;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class menuHelper {
    private static final String COLLECTION_NAME = "menus";

    // --- COLLECTION REFERENCE ---

    public static CollectionReference getMenuCollection(){
        return FirebaseFirestore.getInstance().collection(COLLECTION_NAME);
    }

    // --- CREATE ---

    public static Task<Void> createMenuPlat(Plat plat, String userID) {
        Menu menuToCreate = new Menu(plat);
        String path = "menu"+ menuToCreate.getMonPlat().getNom()+userID;
        return menuHelper.getMenuCollection()
                .document(path)
                .set(menuToCreate);
    }
    public static Task<Void> createMenuEntreePlat(Entree entree, Plat plat, String userID) {
        Menu menuToCreate = new Menu(entree, plat);
        String path = "menu"+ menuToCreate.getMonEntree() + menuToCreate.getMonPlat().getNom()+userID;
        return menuHelper.getMenuCollection()
                .document(path)
                .set(menuToCreate);
    }

    public static Task<Void> createMenuPlatDessert(Plat plat, Dessert dessert, String userID) {
        Menu menuToCreate = new Menu(plat, dessert);
        String path = "menu"+ menuToCreate.getMonPlat().getNom() + menuToCreate.getMonDessert()+userID;
        return menuHelper.getMenuCollection()
                .document(path)
                .set(menuToCreate);
    }
    public static Task<Void> createMenu(Entree entree, Plat plat, Dessert dessert, String userID) {
        Menu menuToCreate = new Menu(entree, plat, dessert);
        String path = "menu"+ menuToCreate.getMonEntree() +menuToCreate.getMonPlat().getNom()+ menuToCreate.getMonDessert()+userID;
        return menuHelper.getMenuCollection()
                .document(path)
                .set(menuToCreate);
    }


    // --- GET ---

    public static Task<DocumentSnapshot> getMenu(String menuID){
        return com.example.latabledesgourmands.utilitaire.API.menuHelper.getMenuCollection().document(menuID).get();
    }

    // --- UPDATE ---

    //public static Task<Void> updateMenu(Plat plat, String userID) {
     //   return com.example.latabledesgourmands.utilitaire.API.menuHelper.
     //           getMenuCollection().document(user.getUid()).update(plat, user.getUid());
    //}

    // --- DELETE ---

    public static Task<Void> deleteMenu(String menuID) {
        return com.example.latabledesgourmands.utilitaire.API.menuHelper.getMenuCollection().document(menuID).delete();
    }
}
