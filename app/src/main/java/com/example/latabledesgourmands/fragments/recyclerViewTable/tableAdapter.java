package com.example.latabledesgourmands.fragments.recyclerViewTable;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.latabledesgourmands.R;
import com.example.latabledesgourmands.fragments.recyclerViewMenu.menuViewHolder;
import com.example.latabledesgourmands.utilitaire.Models.Table;

import java.util.List;

public class tableAdapter extends RecyclerView.Adapter<tableViewHolder> {
    private List<Table> tableList;

    public tableAdapter(List<Table> tableList){
        this.tableList = tableList;
    }
    @Override
    public tableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.fragment_recycler_view_table_item, parent,false);

        return new tableViewHolder((view));
    }

    @Override
    public void onBindViewHolder(tableViewHolder holder, int position) {
        holder.updateWithTableList(this.tableList.get(position));
    }

    @Override
    public int getItemCount() {
        return this.tableList.size();
    }
}
