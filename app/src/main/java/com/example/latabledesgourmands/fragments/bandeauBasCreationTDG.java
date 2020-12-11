package com.example.latabledesgourmands.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.latabledesgourmands.R;


public class bandeauBasCreationTDG extends Fragment {


    public bandeauBasCreationTDG() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bandeau_bas_creation_t_d_g, container, false);
    }
}