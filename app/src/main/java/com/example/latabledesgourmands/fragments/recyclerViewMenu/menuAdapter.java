package com.example.latabledesgourmands.fragments.recyclerViewMenu;

import android.content.Context;
import android.icu.util.Measure;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.latabledesgourmands.R;
import com.example.latabledesgourmands.utilitaire.Models.Menu;

import java.util.List;

public class menuAdapter extends RecyclerView.Adapter<menuViewHolder> {
    private List<Menu> menuList;
    public menuAdapter (List<Menu> menuList){this.menuList=menuList;}
    @NonNull
    @Override
    public menuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.fragment_recycler_view_menu_item, parent,false);

        return new menuViewHolder((view));
    }

    @Override
    public void onBindViewHolder(@NonNull menuViewHolder holder, int position) {
        holder.updateWithMenuList(this.menuList.get(position));
    }

    @Override
    public int getItemCount() {
        return this.menuList.size();
    }
}
