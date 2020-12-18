package com.example.latabledesgourmands.invite.rechercherUneTable;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.latabledesgourmands.R;
import com.example.latabledesgourmands.cuisinier.creerMaTable.importMenu;
import com.example.latabledesgourmands.fragments.recyclerViewMenu.menuAdapter;
import com.example.latabledesgourmands.fragments.recyclerViewTable.tableAdapter;
import com.example.latabledesgourmands.utilitaire.API.menuHelper;
import com.example.latabledesgourmands.utilitaire.API.tableHelper;
import com.example.latabledesgourmands.utilitaire.ItemClickSupport;
import com.example.latabledesgourmands.utilitaire.Models.Dessert;
import com.example.latabledesgourmands.utilitaire.Models.Entree;
import com.example.latabledesgourmands.utilitaire.Models.Evenement;
import com.example.latabledesgourmands.utilitaire.Models.Menu;
import com.example.latabledesgourmands.utilitaire.Models.Plat;
import com.example.latabledesgourmands.utilitaire.Models.Table;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class RechercherTableStep2 extends AppCompatActivity {
    tableAdapter adapter;
    RecyclerView recyclerView;
    List<Table> tableList;
    List<Table> sortedTableList;
    public Table tableSelected;
    Table monFiltre;

    String pirates;
    String haloween;
    String aucun;
    String tout;

    public interface MyCallback {
        void onCallback(List<Table> tableListLink);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tableList = new ArrayList<>();
        sortedTableList = new ArrayList<>();
        setContentView(R.layout.activity_recherche_table_step2);
        recyclerView = findViewById(R.id.tableRecyclerView);
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("monFiltre")) {
                monFiltre = intent.getParcelableExtra("monFiltre");
            }
        }
        manualTableCreationDebugAim();
        setUpRecyclerViewFragment();
    }



    private void manualTableCreationDebugAim() {
        getDataFromFirebase(new MyCallback() {
            @Override
            public void onCallback(List<Table> tableListLink) {
                for(int i=0; i<tableListLink.size(); i++){
                    tableList.add(tableListLink.get(i));
                }
            }
        });
            }


    private void getDataFromFirebase (MyCallback myCallback) {
        //GetDataFromFirestore
        Task<QuerySnapshot> query = tableHelper.getTableCollection()
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            List<Table> tableListWithinOnComplete = new ArrayList<>();
                            for (DocumentSnapshot document : task.getResult()) {
                                Table table = document.toObject(Table.class);
                                tableListWithinOnComplete.add(table);
                            }
                            configureRecyclerView(getSortedTableList(tableListWithinOnComplete, monFiltre));
                            myCallback.onCallback(tableListWithinOnComplete);
                            if (task.getResult().size()==0){
                                Toast.makeText(getApplicationContext(), "Aucune table présente dans la base de donnée", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Error, check logs", Toast.LENGTH_SHORT).show();
                        }

                    }
                });

    }

    private List<Table> getSortedTableList (List<Table> listeComplete, Table filtre){

        for(int i=0; i<listeComplete.size(); i++){
            if(testDateFiltre(listeComplete.get(i), filtre))
                if(testHeureFiltre(listeComplete.get(i), filtre))
                    if(testAdresseFiltre(listeComplete.get(i), filtre))
                        if(testConvivesFiltre(listeComplete.get(i), filtre))
                            if(testPrixFiltre(listeComplete.get(i), filtre))
                                if(testThemeFiltre(listeComplete.get(i), filtre))
                                    if(testFumeurFiltre(listeComplete.get(i), filtre))
                                        if(testAnimauxFiltre(listeComplete.get(i), filtre))
                                            if(testAlcoolFiltre(listeComplete.get(i), filtre))
                                                if(testMenuToutFiltre(listeComplete.get(i), filtre))
                                                    sortedTableList.add(listeComplete.get(i));
                                                else if(testMenuVegeFiltre(listeComplete.get(i), filtre))
                                                    sortedTableList.add(listeComplete.get(i));
                                                else if(testMenuVeganFiltre(listeComplete.get(i), filtre))
                                                    sortedTableList.add(listeComplete.get(i));
                                                else if(testMenuSansGlutenFiltre(listeComplete.get(i), filtre))
                                                    sortedTableList.add(listeComplete.get(i));
        }
    return sortedTableList;
    }

    private Boolean testDateFiltre(Table tableTestee, Table filtre){
        if(filtre.getMonEvenement().getDate() != null){
            if(tableTestee.getMonEvenement().getDate().equals(filtre.getMonEvenement().getDate())){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return true;
        }
    }

    private Boolean testHeureFiltre(Table tableTestee, Table filtre){
        if(filtre.getMonEvenement().getHeure() != null){
            if(tableTestee.getMonEvenement().getHeure().equals(filtre.getMonEvenement().getHeure())){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return true;
        }
    }

    private Boolean testAdresseFiltre(Table tableTestee, Table filtre){
        if(filtre.getMonEvenement().getAdresse() != null){
            if(tableTestee.getMonEvenement().getAdresse().equals(filtre.getMonEvenement().getAdresse())){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return true;
        }
    }

    private Boolean testConvivesFiltre(Table tableTestee, Table filtre){
        if(filtre.getMonEvenement().getNombreConvive() != 0f){
            if(tableTestee.getMonEvenement().getNombreConvive() == filtre.getMonEvenement().getNombreConvive()){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return true;
        }
    }

    private Boolean testMenuToutFiltre(Table tableTestee, Table filtre){
        if(filtre.getMonMenu().getVegetarien() != null && filtre.getMonMenu().getVegan() != null && filtre.getMonMenu().getSansGluten() != null){
            if(tableTestee.getMonMenu().getVegetarien() == filtre.getMonMenu().getVegetarien()
                    && tableTestee.getMonMenu().getVegan() == filtre.getMonMenu().getVegan()
                    && tableTestee.getMonMenu().getSansGluten() == filtre.getMonMenu().getSansGluten()){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return true;
        }
    }

    private Boolean testMenuVegeFiltre(Table tableTestee, Table filtre){
        if(filtre.getMonMenu().getVegetarien() != null){
            if(tableTestee.getMonMenu().getVegetarien() == filtre.getMonMenu().getVegetarien()){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return true;
        }
    }

    private Boolean testMenuVeganFiltre(Table tableTestee, Table filtre){
        if(filtre.getMonMenu().getVegan() != null){
            if(tableTestee.getMonMenu().getVegan() == filtre.getMonMenu().getVegan()){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return true;
        }
    }

    private Boolean testMenuSansGlutenFiltre(Table tableTestee, Table filtre){
        if(filtre.getMonMenu().getSansGluten() != null){
            if(tableTestee.getMonMenu().getSansGluten() == filtre.getMonMenu().getSansGluten()){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return true;
        }
    }

    private Boolean testPrixFiltre(Table tableTestee, Table filtre){
        if(filtre.getMonMenu().getPrixDuMenuParPersonne() != 0f){
            if(tableTestee.getMonMenu().getPrixDuMenuParPersonne() <= filtre.getMonMenu().getPrixDuMenuParPersonne()){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return true;
        }
    }

    private Boolean testThemeFiltre(Table tableTestee, Table filtre){
        if(filtre.getMonEvenement().getTheme() != null){
            if(tableTestee.getMonEvenement().getTheme() == filtre.getMonEvenement().getTheme()){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return true;
        }
    }

    private Boolean testFumeurFiltre(Table tableTestee, Table filtre){
        if(filtre.getMonEvenement().getFumeurOk() != null){
            if(tableTestee.getMonEvenement().getFumeurOk() == filtre.getMonEvenement().getFumeurOk()){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return true;
        }
    }

    private Boolean testAnimauxFiltre(Table tableTestee, Table filtre){
        if(filtre.getMonEvenement().getAnimalOk() != null){
            if(tableTestee.getMonEvenement().getAnimalOk() == filtre.getMonEvenement().getAnimalOk()){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return true;
        }
    }

    private Boolean testAlcoolFiltre(Table tableTestee, Table filtre){
        if(filtre.getMonEvenement().getAlcoolOk() != null){
            if(tableTestee.getMonEvenement().getAlcoolOk() == filtre.getMonEvenement().getAlcoolOk()){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return true;
        }
    }

    private void setUpRecyclerViewFragment(){
        configureOnClickRecyclerView();
    }

    private void configureRecyclerView(List<Table> sortedTableListArgument) {
        if(sortedTableListArgument.size() != 0){

        adapter = new tableAdapter(sortedTableListArgument);
            Log.i("TEST", "liste des tables filtrées " + sortedTableListArgument.size() + sortedTableListArgument.get(0));
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));}
        else{
            Toast.makeText(getApplicationContext(), "Aucune table ne correspond à vos critères", Toast.LENGTH_LONG).show();
        }
    }
    private void configureOnClickRecyclerView() {

        ItemClickSupport.addTo(recyclerView, R.layout.fragment_recycler_view_table)
                .setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                        //Ici action au clic sur un item de la recycler VIEW
                        tableSelected = tableList.get(position);
                        startRechercherTableStep3Activity();
                    }
                });
    }


    private void startRechercherTableStep3Activity(){
        Intent intent = new Intent(this, RechercherTableStep3.class);
        intent.putExtra("tableSelected", tableSelected);
        startActivity(intent);
    }


    private void startRechercherTableStep1Activity(){
        Intent intent = new Intent(this, RechercherTableStep1.class);
        intent.putExtra("tableSelected", tableSelected);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
       super.onBackPressed();
       startRechercherTableStep1Activity();
    }
}
