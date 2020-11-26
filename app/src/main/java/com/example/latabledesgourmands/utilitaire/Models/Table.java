package com.example.latabledesgourmands.utilitaire.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class Table implements Parcelable {
    Entree monEntree;
    Plat monPlat;
    Dessert monDessert;
    Prix monPrix;
    Informations mesInformations;
    Theme monTheme;

    public Table(Entree monEntree, Plat monPlat, Dessert monDessert, Prix monPrix, Informations mesInformations, Theme monTheme){
        this.monDessert=monDessert;
        this.monPlat=monPlat;
        this.monEntree=monEntree;
        this.monPrix = monPrix;
        this.mesInformations = mesInformations;
        this.monTheme = monTheme;
    }

    protected Table(Parcel in) {
    }

    public static final Creator<Table> CREATOR = new Creator<Table>() {
        @Override
        public Table createFromParcel(Parcel in) {
            return new Table(in);
        }

        @Override
        public Table[] newArray(int size) {
            return new Table[size];
        }
    };

    public Entree getMonEntree() {
        return monEntree;
    }

    public void setMonEntree(Entree monEntree) {
        this.monEntree = monEntree;
    }

    public Plat getMonPlat() {
        return monPlat;
    }

    public void setMonPlat(Plat monPlat) {
        this.monPlat = monPlat;
    }

    public Dessert getMonDessert() {
        return monDessert;
    }

    public void setMonDessert(Dessert monDessert) {
        this.monDessert = monDessert;
    }

    public Prix getMonPrix() {
        return monPrix;
    }

    public void setMonPrix(Prix monPrix) {
        this.monPrix = monPrix;
    }

    public Informations getMesInformations() {
        return mesInformations;
    }

    public void setMesInformations(Informations mesInformations) {
        this.mesInformations = mesInformations;
    }

    public Theme getMonTheme() {
        return monTheme;
    }

    public void setMonTheme(Theme monTheme) {
        this.monTheme = monTheme;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(String.valueOf(monEntree));
        dest.writeString(String.valueOf(monPlat));
        dest.writeString(String.valueOf(monDessert));
        dest.writeString(String.valueOf(monPrix));
        dest.writeString(String.valueOf(mesInformations));
        dest.writeString(String.valueOf(monTheme));
    }
}
