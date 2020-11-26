package com.example.latabledesgourmands.utilitaire.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class Menu implements Parcelable {
    Entree monEntree;
    Plat monPlat;
    Dessert monDessert;
    //Constructeurs
    //Menu COMPLET
    public Menu(Entree monEntree, Plat monPlat, Dessert monDessert){
        this.monDessert=monDessert;
        this.monPlat=monPlat;
        this.monEntree=monEntree;
    }
    //PLAT DESSERT
    public Menu(Plat monPlat, Dessert monDessert){
        this.monDessert=monDessert;
        this.monPlat=monPlat;
    }
    //Entree PLAT
    public Menu(Entree monEntree, Plat monPlat){
        this.monPlat=monPlat;
        this.monEntree=monEntree;
    }
    //PLAT
    public Menu( Plat monPlat){
        this.monPlat=monPlat;

    }
    //Constructeur pour les données on verra ça plus tard je pense
    public Menu(){
        this.monDessert=monDessert;
        this.monPlat=monPlat;
        this.monEntree=monEntree;
    }


    protected Menu(Parcel in) {
        monEntree = in.readParcelable(Entree.class.getClassLoader());
        monPlat = in.readParcelable(Plat.class.getClassLoader());
        monDessert = in.readParcelable(Dessert.class.getClassLoader());
    }

    public static final Creator<Menu> CREATOR = new Creator<Menu>() {
        @Override
        public Menu createFromParcel(Parcel in) {
            return new Menu(in);
        }

        @Override
        public Menu[] newArray(int size) {
            return new Menu[size];
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

    @Override
    public String toString() {
        return "Menu : " +
                "monEntree = " + monEntree.getNom() +
                ", monPlat = " + monPlat.getNom() +
                ", monDessert = " + monDessert.getNom() +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(monEntree, flags);
        dest.writeParcelable(monPlat, flags);
        dest.writeParcelable(monDessert, flags);
    }
}
