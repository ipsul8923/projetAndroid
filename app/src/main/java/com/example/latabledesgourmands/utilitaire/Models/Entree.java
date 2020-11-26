package com.example.latabledesgourmands.utilitaire.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class Entree implements Parcelable {
    String nom;

    public Entree(String nom) {
        this.nom = nom;
    }

    protected Entree(Parcel in) {
        nom = in.readString();
    }

    public static final Creator<Entree> CREATOR = new Creator<Entree>() {
        @Override
        public Entree createFromParcel(Parcel in) {
            return new Entree(in);
        }

        @Override
        public Entree[] newArray(int size) {
            return new Entree[size];
        }
    };

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(nom);
    }
}
