package com.example.latabledesgourmands.utilitaire.Models;

public class Menu {
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
}
