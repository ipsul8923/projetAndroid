package com.example.latabledesgourmands.utilitaire.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class Theme implements Parcelable {
    String nom;
    //A remplir plus tard

    public Theme(String nom){
        this.nom = nom;
    }

    protected Theme(Parcel in) {
        nom = in.readString();
    }

    public static final Creator<Theme> CREATOR = new Creator<Theme>() {
        @Override
        public Theme createFromParcel(Parcel in) {
            return new Theme(in);
        }

        @Override
        public Theme[] newArray(int size) {
            return new Theme[size];
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
