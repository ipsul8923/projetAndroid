package com.example.latabledesgourmands.cuisinier.creerMaTable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.latabledesgourmands.R;
import com.example.latabledesgourmands.fragments.recyclerViewMenu.menuAdapter;
import com.example.latabledesgourmands.utilitaire.ItemClickSupport;
import com.example.latabledesgourmands.utilitaire.Models.Dessert;
import com.example.latabledesgourmands.utilitaire.Models.Entree;
import com.example.latabledesgourmands.utilitaire.Models.Menu;
import com.example.latabledesgourmands.utilitaire.Models.Plat;

import java.util.ArrayList;
import java.util.List;

public class importMenu extends AppCompatActivity {
    menuAdapter adapter;
    RecyclerView recyclerView;
    List<Menu> menuList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        menuList = new ArrayList<>();
        setContentView(R.layout.activity_import_menu);
        setUpRecyclerViewFragment();
        manualMenuCreationDebugAim();

    }

    private void manualMenuCreationDebugAim(){
        Entree entree1test = new Entree("apero1");
        Entree entree2test = new Entree("apero2");
        Entree entree3test = new Entree("apero3");
        Entree entree4test = new Entree("apero4");
        Entree entree5test = new Entree("apero5");
        Plat plat1test = new Plat("plat1");
        Plat plat2test = new Plat("plat2");
        Plat plat3test = new Plat("plat3");
        Plat plat4test = new Plat("plat4");
        Plat plat5test = new Plat("plat5");
        Dessert dessert1test = new Dessert("dessert1");
        Dessert dessert2test = new Dessert("dessert2");
        Dessert dessert3test = new Dessert("dessert3");
        Dessert dessert4test = new Dessert("dessert4");
        Dessert dessert5test = new Dessert("dessert5");

        Menu menu1test = new Menu(entree1test, plat1test, dessert1test);
        Menu menu2test = new Menu(entree2test, plat2test, dessert2test);
        Menu menu3test = new Menu(entree3test, plat3test, dessert3test);
        Menu menu4test = new Menu(entree4test, plat4test, dessert4test);
        Menu menu5test = new Menu(entree5test, plat5test, dessert5test);
        menuList.add(menu1test);
        menuList.add(menu2test);
        menuList.add(menu3test);
        menuList.add(menu4test);
        menuList.add(menu5test);
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

        ItemClickSupport.addTo(recyclerView, R.layout.fragment_recycler_view_menu)
                .setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                        //Ici action au clic sur un item de la recycler VIEW
                    }
                });
    }

    private void startCreerMaTableStep2bisActivity(){
        Intent intent = new Intent(this, creerMaTableStep2bis.class);
        startActivity(intent);
    }
    public void onClickImportButton(View view) {
        startCreerMaTableStep2bisActivity();
    }
}