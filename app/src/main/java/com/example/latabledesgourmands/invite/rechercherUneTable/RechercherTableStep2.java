package com.example.latabledesgourmands.invite.rechercherUneTable;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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
import com.example.latabledesgourmands.utilitaire.Models.Prix;
import com.example.latabledesgourmands.utilitaire.Models.Table;
import com.example.latabledesgourmands.utilitaire.Models.Theme;

import java.util.ArrayList;
import java.util.List;

public class RechercherTableStep2 extends AppCompatActivity {
    tableAdapter adapter;
    RecyclerView recyclerView;
    List<Table> tableList;
    public Table tableSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tableList = new ArrayList<>();
        setContentView(R.layout.activity_recherche_table_step2);
        setUpRecyclerViewFragment();
        manualTableCreationDebugAim();
    }

    private void manualTableCreationDebugAim() {
        // Table 1
        Entree entree1 = new Entree("entrée1");
        Plat plat1 = new Plat("plat1");
        Dessert dessert1 = new Dessert("dessert1");
        Menu menu1 = new Menu(entree1, plat1, dessert1);
        //Prix prix1 = new Prix(3.5f);
        Evenement evenement1 = new Evenement("Chez Michel");
        Table table1 = new Table(menu1, evenement1);
        tableList.add(table1);

        // Table 2
        Entree entree2 = new Entree("entrée2");
        Plat plat2 = new Plat("plat2");
        Dessert dessert2 = new Dessert("dessert2");
        Menu menu2 = new Menu(entree2, plat2, dessert2);
        //Prix prix2 = new Prix(3.5f);
        Evenement evenement2 = new Evenement("Chez adrien à Lyon");
        Table table2 = new Table(menu2, evenement2);
        tableList.add(table2);

        // Table 3
        Entree entree3 = new Entree("entrée3");
        Plat plat3 = new Plat("plat3");
        Dessert dessert3 = new Dessert("dessert3");
        Menu menu3 = new Menu(entree3, plat3, dessert3);
        //Prix prix3 = new Prix(6.5f);
        Evenement evenement3 = new Evenement("Chez Pierre à Marseilles");
        Table table3 = new Table(menu3, evenement3);
        tableList.add(table3);
    }
    private void setUpRecyclerViewFragment(){
        configureRecyclerView();
        configureOnClickRecyclerView();
    }

    private void configureRecyclerView() {
        recyclerView = findViewById(R.id.tableRecyclerView);
        adapter = new tableAdapter(tableList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
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
