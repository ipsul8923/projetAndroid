package com.example.latabledesgourmands.utilitaire.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class Dessert implements Parcelable {
    String nom;

    public Dessert(String nom) {
        this.nom = nom;
    }

    protected Dessert(Parcel in) {
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

    public static final Creator<Dessert> CREATOR = new Creator<Dessert>() {
        @Override
        public Dessert createFromParcel(Parcel in) {
            return new Dessert(in);
        }

        @Override
        public Dessert[] newArray(int size) {
            return new Dessert[size];
        }
    };

}
