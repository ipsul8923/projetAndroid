package com.example.latabledesgourmands.utilitaire.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class Menu implements Parcelable {
    private Entree monEntree;
    private Plat monPlat;
    private Dessert monDessert;
    private boolean isEntreePicked;
    private boolean isDessertPicked;
    private float prixDuMenuParPersonne;
    private float difficulte;
    private Boolean vegetarien;
    private Boolean vegan;
    private Boolean sansGluten;
    //Constructeurs

    public Menu(){    } //Pour la méthode toObject
    public Menu(Entree monEntree, Plat monPlat, Dessert monDessert) {
        this.monEntree = monEntree;
        this.monPlat = monPlat;
        this.monDessert = monDessert;
        this.isEntreePicked = true;
        this.isDessertPicked = true;
        this.prixDuMenuParPersonne =
                monEntree.getPrixParPersonne()
                + monPlat.getPrixParPersonne()
               + monDessert.getPrixParPersonne();
        this.difficulte= monPlat.getDifficulte(); //Set difficulte au plus entre l'entree plat et dessert
        if(monEntree.getVegetarien() && monPlat.getVegetarien() && monDessert.getVegetarien()){
        this.vegetarien = true;}
        else {
            this.vegetarien=false;
        }
       if(monEntree.getVegan() && monPlat.getVegan() && monDessert.getVegan()){
           this.vegan = true;}
        else{
          this.vegan=false;
       }
       if(monEntree.getSansGluten() && monPlat.getSansGluten() && monDessert.getSansGluten()){
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
        this.prixDuMenuParPersonne =
                          monPlat.getPrixParPersonne()
                        + monDessert.getPrixParPersonne();
        this.difficulte= monPlat.getDifficulte(); //Set difficulte au plus entre  plat et dessert
        if(monPlat.getVegetarien() && monDessert.getVegetarien()){
            this.vegetarien = true;}
        else {
            this.vegetarien=false;
        }
        if(monPlat.getVegan() && monDessert.getVegan()){
            this.vegan = true;}
        else{
            this.vegan=false;
        }
        if(monPlat.getSansGluten() && monDessert.getSansGluten()){
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
        this.prixDuMenuParPersonne =
                        monEntree.getPrixParPersonne()
                        + monPlat.getPrixParPersonne();
        this.difficulte= monPlat.getDifficulte(); //Set difficulte au plus entre l'entree plat
        if(monEntree.getVegetarien() && monPlat.getVegetarien()){
            this.vegetarien = true;}
        else {
            this.vegetarien=false;
        }
        if(monEntree.getVegan() && monPlat.getVegan()){
            this.vegan = true;}
        else{
            this.vegan=false;
        }
        if(monEntree.getSansGluten() && monPlat.getSansGluten()){
            this.sansGluten = true;}
        else {
            this.sansGluten=false;
        }

    }
    public Menu(Plat monPlat) {
        this.monPlat = monPlat;
        this.isEntreePicked = false;
        this.isDessertPicked = false;
        this.prixDuMenuParPersonne= monPlat.getPrixParPersonne();
        this.difficulte= monPlat.getDifficulte();
        if(monPlat.getVegetarien()){
            this.vegetarien = true;}
        else {
            this.vegetarien=false;
        }
        if(monPlat.getVegan()){
            this.vegan = true;}
        else{
            this.vegan=false;
        }
        if(monPlat.getSansGluten()){
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
        prixDuMenuParPersonne = in.readFloat();
        difficulte = in.readFloat();
        byte tmpVegetarien = in.readByte();
        vegetarien = tmpVegetarien == 0 ? null : tmpVegetarien == 1;
        byte tmpVegan = in.readByte();
        vegan = tmpVegan == 0 ? null : tmpVegan == 1;
        byte tmpSansGluten = in.readByte();
        sansGluten = tmpSansGluten == 0 ? null : tmpSansGluten == 1;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(monEntree, flags);
        dest.writeParcelable(monPlat, flags);
        dest.writeParcelable(monDessert, flags);
        dest.writeByte((byte) (isEntreePicked ? 1 : 0));
        dest.writeByte((byte) (isDessertPicked ? 1 : 0));
        dest.writeFloat(prixDuMenuParPersonne);
        dest.writeFloat(difficulte);
        dest.writeByte((byte) (vegetarien == null ? 0 : vegetarien ? 1 : 2));
        dest.writeByte((byte) (vegan == null ? 0 : vegan ? 1 : 2));
        dest.writeByte((byte) (sansGluten == null ? 0 : sansGluten ? 1 : 2));
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

    public float getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(float difficulte) {
        this.difficulte = difficulte;
    }

    public Boolean getVegetarien() {
        return vegetarien;
    }

    public void setVegetarien(Boolean vegetarien) {
        this.vegetarien = vegetarien;
    }

    public Boolean getVegan() {
        return vegan;
    }

    public void setVegan(Boolean vegan) {
        this.vegan = vegan;
    }

    public Boolean getSansGluten() {
        return sansGluten;
    }

    public void setSansGluten(Boolean sansGluten) {
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

    public float getPrixDuMenuParPersonne() {
        return prixDuMenuParPersonne;
    }

    public void setPrixDuMenuParPersonne(float prixDuMenuParPersonne) {
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
