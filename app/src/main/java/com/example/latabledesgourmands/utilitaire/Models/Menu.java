package com.example.latabledesgourmands.utilitaire.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class Menu implements Parcelable {
    private Entree monEntree;
    private Plat monPlat;
    private Dessert monDessert;
    private boolean isEntreePicked;
    private boolean isDessertPicked;
    private Prix prixDuMenuParPersonne;
    private String difficulte;
    private boolean vegetarien;
    private boolean vegan;
    private boolean sansGluten;
    //Constructeurs


    public Menu(Entree monEntree, Plat monPlat, Dessert monDessert) {
        this.monEntree = monEntree;
        this.monPlat = monPlat;
        this.monDessert = monDessert;
        this.isEntreePicked = true;
        this.isDessertPicked = true;
        this.prixDuMenuParPersonne.setValeur(
                  monEntree.getPrixParPersonne().getValeur()
                + monPlat.getPrixParPersonne().getValeur()
                + monDessert.getPrixParPersonne().getValeur());
        this.difficulte= monPlat.getDifficulte(); //Set difficulte au plus entre l'entree plat et dessert
        if(monEntree.isVegetarien() && monPlat.isVegetarien() && monDessert.isVegetarien()){
        this.vegetarien = true;}
        else {
            this.vegetarien=false;
        }
        if(monEntree.isVegan() && monPlat.isVegan() && monDessert.isVegan()){
            this.vegan = true;}
        else{
            this.vegan=false;
        }
        if(monEntree.isSansGluten() && monPlat.isSansGluten() && monDessert.isSansGluten()){
            this.sansGluten = true;}
        else {
            this.sansGluten=false;
        }
    }
    public Menu(Plat monPlat, Dessert monDessert) {
        this.monPlat = monPlat;
        this.monDessert = monDessert;
        this.isEntreePicked = false;
        this.isDessertPicked = true;
        this.prixDuMenuParPersonne.setValeur(
                          monPlat.getPrixParPersonne().getValeur()
                        + monDessert.getPrixParPersonne().getValeur());
        this.difficulte= monPlat.getDifficulte(); //Set difficulte au plus entre  plat et dessert
        if(monPlat.isVegetarien() && monDessert.isVegetarien()){
            this.vegetarien = true;}
        else {
            this.vegetarien=false;
        }
        if(monPlat.isVegan() && monDessert.isVegan()){
            this.vegan = true;}
        else{
            this.vegan=false;
        }
        if(monPlat.isSansGluten() && monDessert.isSansGluten()){
            this.sansGluten = true;}
        else {
            this.sansGluten=false;
        }

    }

    public Menu(Entree monEntree, Plat monPlat) {
        this.monEntree = monEntree;
        this.monPlat = monPlat;
        this.isEntreePicked = true;
        this.isDessertPicked = false;
        this.prixDuMenuParPersonne.setValeur(
                monEntree.getPrixParPersonne().getValeur()
                        + monPlat.getPrixParPersonne().getValeur());
        this.difficulte= monPlat.getDifficulte(); //Set difficulte au plus entre l'entree plat
        if(monEntree.isVegetarien() && monPlat.isVegetarien()){
            this.vegetarien = true;}
        else {
            this.vegetarien=false;
        }
        if(monEntree.isVegan() && monPlat.isVegan()){
            this.vegan = true;}
        else{
            this.vegan=false;
        }
        if(monEntree.isSansGluten() && monPlat.isSansGluten()){
            this.sansGluten = true;}
        else {
            this.sansGluten=false;
        }

    }
    public Menu(Plat monPlat) {
        this.monPlat = monPlat;
        this.isEntreePicked = false;
        this.isDessertPicked = false;
        this.prixDuMenuParPersonne.setValeur(monPlat.getPrixParPersonne().getValeur());
        this.difficulte= monPlat.getDifficulte();
        if(monPlat.isVegetarien()){
            this.vegetarien = true;}
        else {
            this.vegetarien=false;
        }
        if(monPlat.isVegan()){
            this.vegan = true;}
        else{
            this.vegan=false;
        }
        if(monPlat.isSansGluten()){
            this.sansGluten = true;}
        else {
            this.sansGluten=false;
        }
    }

    protected Menu(Parcel in) {
        monEntree = in.readParcelable(Entree.class.getClassLoader());
        monPlat = in.readParcelable(Plat.class.getClassLoader());
        monDessert = in.readParcelable(Dessert.class.getClassLoader());
        isEntreePicked = in.readByte() != 0;
        isDessertPicked = in.readByte() != 0;
        difficulte = in.readString();
        vegetarien = in.readByte() != 0;
        vegan = in.readByte() != 0;
        sansGluten = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(monEntree, flags);
        dest.writeParcelable(monPlat, flags);
        dest.writeParcelable(monDessert, flags);
        dest.writeByte((byte) (isEntreePicked ? 1 : 0));
        dest.writeByte((byte) (isDessertPicked ? 1 : 0));
        dest.writeString(difficulte);
        dest.writeByte((byte) (vegetarien ? 1 : 0));
        dest.writeByte((byte) (vegan ? 1 : 0));
        dest.writeByte((byte) (sansGluten ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
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

    public String getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(String difficulte) {
        this.difficulte = difficulte;
    }

    public boolean isVegetarien() {
        return vegetarien;
    }

    public void setVegetarien(boolean vegetarien) {
        this.vegetarien = vegetarien;
    }

    public boolean isVegan() {
        return vegan;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }

    public boolean isSansGluten() {
        return sansGluten;
    }

    public void setSansGluten(boolean sansGluten) {
        this.sansGluten = sansGluten;
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

    public boolean isEntreePicked() {
        return isEntreePicked;
    }

    public void setEntreePicked(boolean entreePicked) {
        isEntreePicked = entreePicked;
    }

    public boolean isDessertPicked() {
        return isDessertPicked;
    }

    public void setDessertPicked(boolean dessertPicked) {
        isDessertPicked = dessertPicked;
    }

    public Prix getPrixDuMenuParPersonne() {
        return prixDuMenuParPersonne;
    }

    public void setPrixDuMenuParPersonne(Prix prixDuMenuParPersonne) {
        this.prixDuMenuParPersonne = prixDuMenuParPersonne;
    }

    @Override
    public String toString() {
        return "Menu : " +
                "monEntree = " + monEntree.getNom() +
                ", monPlat = " + monPlat.getNom() +
                ", monDessert = " + monDessert.getNom() +
                '}';
    }


}
