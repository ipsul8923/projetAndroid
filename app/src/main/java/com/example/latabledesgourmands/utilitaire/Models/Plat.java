package com.example.latabledesgourmands.utilitaire.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class Plat implements Parcelable {
    String nom;

    public Plat(String nom) {
        this.nom = nom;
    }

    protected Plat(Parcel in) {
        nom = in.readString();
    }




    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nom);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Plat> CREATOR = new Creator<Plat>() {
        @Override
        public Plat createFromParcel(Parcel in) {
            return new Plat(in);
        }

        @Override
        public Plat[] newArray(int size) {
            return new Plat[size];
        }
    };}
