package com.example.latabledesgourmands.cuisinier.creerMaTable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.example.latabledesgourmands.R;
import com.example.latabledesgourmands.fragments.recyclerViewMenu.menuAdapter;
import com.example.latabledesgourmands.utilitaire.ItemClickSupport;
import com.example.latabledesgourmands.utilitaire.Models.Dessert;
import com.example.latabledesgourmands.utilitaire.Models.Entree;
import com.example.latabledesgourmands.utilitaire.Models.Menu;
import com.example.latabledesgourmands.utilitaire.Models.Plat;
import com.example.latabledesgourmands.utilitaire.Models.Table;

import java.util.ArrayList;
import java.util.List;

public class importMenu extends AppCompatActivity {
    menuAdapter adapter;
    RecyclerView recyclerView;
    List<Menu> menuList;
    Table maTable;
    public Menu selectedMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_import_menu);
        menuList = new ArrayList<>();
        manualMenuCreationDebugAim();
        setUpRecyclerViewFragment();
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("maTable")) {
                maTable = intent.getParcelableExtra("maTable");
            }
        }

    }


    private void manualMenuCreationDebugAim(){
        Entree entree1test = new Entree("salade", "feuille de chêne, sauce", "bien laver la salade",
               1.5f, 1f, true, true, true);
        Entree entree2test = new Entree("boulette", "fêta, pesto", "laisser au frai 40 min",
                2f, 1.5f, true, false, true);

        Plat plat1test = new Plat("ribs de porc", "ribs, marinade", "cuire à 100 deg pendant 1h30, accompagné de riz",
                5f, 2f, false, false, false, true);
        Plat plat2test = new Plat("poulet à la creme", "poulet, crème fraiche", "cuire poulet dans la crème et ses oignons",
               5.5f, 2.5f, false, false, false, true);

        Dessert dessert1test = new Dessert("mugCake", "Chocolat, lait, farine", "préparer la pate, cuire en 1min30 au micron-onde",
                2f, 2f, true, false, false);


        Menu menu1test = new Menu(entree1test, plat1test, dessert1test);
        Menu menu2test = new Menu(entree2test, plat2test, dessert1test);

        menuList.add(menu1test);
        menuList.add(menu2test);

    }

    private void setUpRecyclerViewFragment(){
        configureRecyclerView();
        configureOnClickRecyclerView();
    }

    private void configureRecyclerView() {
        recyclerView=findViewById(R.id.menuRecyclerView);
        adapter=new menuAdapter(menuList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager( new LinearLayoutManager(getApplicationContext()));
    }
    private void configureOnClickRecyclerView() {

        ItemClickSupport.addTo(recyclerView, R.layout.activity_import_menu)
                .setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                        //Ici action au clic sur un item de la recycler VIEW
                        selectedMenu=menuList.get(position);
                        maTable.setMonMenu(selectedMenu);
                        startCreerMaTableStep2bisActivity();
                    }
                });
    }

    private void startCreerMaTableStep2bisActivity(){
        Intent intent = new Intent(this, creerMaTableStep2bis.class);
        intent.putExtra("maTable",maTable);
        startActivity(intent);
    }
}