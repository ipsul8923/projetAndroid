package com.example.latabledesgourmands.fragments.recyclerViewTable;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.latabledesgourmands.R;
import com.example.latabledesgourmands.utilitaire.Models.Table;

import java.util.ArrayList;
import java.util.List;

public class recyclerViewTable extends Fragment {
    List<Table> tableList;
    tableAdapter adapter;
    RecyclerView recyclerView;

    public recyclerViewTable(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        tableList = new ArrayList<>();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recycler_view_table, container, false);
    }
}
