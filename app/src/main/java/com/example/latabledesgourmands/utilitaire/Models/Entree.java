package com.example.latabledesgourmands.utilitaire.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class Entree implements Parcelable {
    private String nom;
    private String[] listeIngredients;
    private String recette;
    private Prix prixParPersonne;
    private String difficulte;
    private boolean vegetarien;
    private boolean vegan;
    private boolean sansGluten;

    public Entree(String nom, String[] listeIngredients, String recette, Prix prixParPersonne, String difficulte, boolean vegetarien, boolean vegan, boolean sansGluten) {
        this.nom = nom;
        this.listeIngredients = listeIngredients;
        this.recette = recette;
        this.prixParPersonne = prixParPersonne;
        this.difficulte = difficulte;
        this.vegetarien = vegetarien;
        this.vegan = vegan;
        this.sansGluten = sansGluten;
    }

    protected Entree(Parcel in) {
        nom = in.readString();
        listeIngredients = in.createStringArray();
        recette = in.readString();
        difficulte = in.readString();
        vegetarien = in.readByte() != 0;
        vegan = in.readByte() != 0;
        sansGluten = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nom);
        dest.writeStringArray(listeIngredients);
        dest.writeString(recette);
        dest.writeString(difficulte);
        dest.writeByte((byte) (vegetarien ? 1 : 0));
        dest.writeByte((byte) (vegan ? 1 : 0));
        dest.writeByte((byte) (sansGluten ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
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

    public String[] getListeIngredients() {
        return listeIngredients;
    }

    public void setListeIngredients(String[] listeIngredients) {
        this.listeIngredients = listeIngredients;
    }

    public String getRecette() {
        return recette;
    }

    public void setRecette(String recette) {
        this.recette = recette;
    }

    public Prix getPrixParPersonne() {
        return prixParPersonne;
    }

    public void setPrixParPersonne(Prix prixParPersonne) {
        this.prixParPersonne = prixParPersonne;
    }

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
}
