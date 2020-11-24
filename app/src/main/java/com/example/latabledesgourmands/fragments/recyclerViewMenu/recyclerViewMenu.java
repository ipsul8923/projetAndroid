package com.example.latabledesgourmands.fragments.recyclerViewMenu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.latabledesgourmands.R;
import com.example.latabledesgourmands.utilitaire.ItemClickSupport;
import com.example.latabledesgourmands.utilitaire.Models.Menu;

import java.util.ArrayList;
import java.util.List;


public class recyclerViewMenu extends Fragment {
    List<Menu> menuList;
    menuAdapter adapter;
    RecyclerView recyclerView;

    public recyclerViewMenu() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        menuList = new ArrayList<>();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recycler_view_menu, container, false);
    }




}