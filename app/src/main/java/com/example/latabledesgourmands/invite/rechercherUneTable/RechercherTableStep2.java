package com.example.latabledesgourmands.invite.rechercherUneTable;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.latabledesgourmands.R;
import com.example.latabledesgourmands.fragments.recyclerViewMenu.menuAdapter;
import com.example.latabledesgourmands.fragments.recyclerViewTable.tableAdapter;
import com.example.latabledesgourmands.utilitaire.ItemClickSupport;
import com.example.latabledesgourmands.utilitaire.Models.Dessert;
import com.example.latabledesgourmands.utilitaire.Models.Entree;
import com.example.latabledesgourmands.utilitaire.Models.Evenement;
import com.example.latabledesgourmands.utilitaire.Models.Menu;
import com.example.latabledesgourmands.utilitaire.Models.Plat;
import com.example.latabledesgourmands.utilitaire.Models.Table;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tableList = new ArrayList<>();
        sortedTableList = new ArrayList<>();
        setContentView(R.layout.activity_recherche_table_step2);
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
        // Table 1
        Entree entree1 = new Entree("entrée1", "listeIngredientsEntrée1", "recetteEntrée1", 1.5f, 2f, true, false, false);
        Plat plat1 = new Plat("plat1", "listeIngredientsPlat1", "recettePlat1", 2f, 3f, true, false, false, false);
        Dessert dessert1 = new Dessert("dessert1", "listeIngredientsDessert1", "recetteDessert1", 1f, 1f, true, false, false);
        Menu menu1 = new Menu(entree1, plat1, dessert1);
        Evenement evenement1 = new Evenement("12-12-2020", "Chez Michel", "19:30", 5, 1,  new Theme("pirates"), true, false, true);
        Table table1 = new Table(menu1, evenement1);

        // Table 2
        Entree entree2 = new Entree("entrée2", "listeIngredientsEntrée2", "recetteEntrée2", 1.6f, 2.5f, false, false, false);
        Plat plat2 = new Plat("plat2", "listeIngredientsPlat2", "recettePlat2", 3f, 3f, false, false, false, false);
        Dessert dessert2 = new Dessert("dessert2", "listeIngredientsDessert2", "recetteDessert2", .5f, 1f, false, false, false);
        Menu menu2 = new Menu(entree2, plat2, dessert2);
        Evenement evenement2 = new Evenement("12-12-2020", "Chez Jacques", "19:30", 5, 1,  new Theme("haloween"), true, true, true);
        Table table2 = new Table(menu2, evenement2);

        // Table 3
        Entree entree3 = new Entree("entrée3", "listeIngredientsEntrée3", "recetteEntrée3", 3f, 4f, false, false, true);
        Plat plat3 = new Plat("plat3", "listeIngredientsPlat3", "recettePlat3", 2f, 5f, false, false, false, false);
        Dessert dessert3 = new Dessert("dessert3", "listeIngredientsDessert3", "recetteDessert3", 2f, 1f, false, false, false);
        Menu menu3 = new Menu(entree3, plat3, dessert3);
        Evenement evenement3 = new Evenement("15-12-2020", "Chez Pierre", "20:30", 4, 2,  new Theme("aucun"), false, true, true);
        Table table3 = new Table(menu3, evenement3);

        //private void loadTableListe(){
        tableList.add(table1);
        tableList.add(table2);
        tableList.add(table3);
        //}
    }

    private List<Table> getSortedTableList (List<Table> listeComplete, Table filtre){
        List <Table> sortedTableList = new ArrayList<>();

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
        configureRecyclerView();
        configureOnClickRecyclerView();
    }

    private void configureRecyclerView() {
        recyclerView = findViewById(R.id.tableRecyclerView);
        sortedTableList = getSortedTableList(tableList, monFiltre);
        if(sortedTableList.size() != 0){
        adapter = new tableAdapter(sortedTableList);
            Log.i("TEST", "liste des tables filtrées " + sortedTableList.size() + sortedTableList.get(0));
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

    public void onClickChoisirTableButton(View view){
        startRechercherTableStep3Activity();
    }

    private void startRechercherTableStep3Activity(){
        Intent intent = new Intent(this, RechercherTableStep3.class);
        intent.putExtra("tableSelected", tableSelected);
        startActivity(intent);
    }

}
