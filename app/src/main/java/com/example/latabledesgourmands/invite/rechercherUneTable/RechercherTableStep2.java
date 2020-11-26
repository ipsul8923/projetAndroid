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
import com.example.latabledesgourmands.utilitaire.Models.Informations;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tableList = new ArrayList<>();
        setContentView(R.layout.activity_recherche_table_step2);
        setUpRecyclerViewFragment();
        manualTableCreationDebugAim();
    }

    private void manualTableCreationDebugAim() {
        Entree entree1 = new Entree("entrée1");
        Plat plat1 = new Plat("plat1");
        Dessert dessert1 = new Dessert("dessert1");
        Prix prix1 = new Prix(3.5f);
        Informations informations1 = new Informations("Chez Michel");
        Theme theme1 = new Theme("Pirate");

        Table table1 = new Table(entree1, plat1, dessert1, prix1, informations1, theme1);
        tableList.add(table1);

        Entree entree2 = new Entree("entrée2");
        Plat plat2 = new Plat("plat2");
        Dessert dessert2 = new Dessert("dessert2");
        Prix prix2 = new Prix(4.5f);
        Informations informations2 = new Informations("Chez Pierre, à Nancy");
        Theme theme2 = new Theme("Pas de thème");

        Table table2 = new Table(entree2, plat2, dessert2, prix2, informations2, theme2);

        tableList.add(table2);
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
                    }
                });
    }

    public void onClickChoisirTableButton(View view){
        startRechercherTableStep3Activity();
    }

    private void startRechercherTableStep3Activity(){
        Intent intent = new Intent(this, RechercherTableStep3.class);
        startActivity(intent);
    }

}
