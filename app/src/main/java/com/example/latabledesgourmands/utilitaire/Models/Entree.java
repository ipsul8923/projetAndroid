package com.example.latabledesgourmands.utilitaire.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class Entree implements Parcelable {
    private String nom;
    private String listeIngredients;
    private String recette;
    private float prixParPersonne;
    private float difficulte;
    private Boolean vegetarien;
    private Boolean vegan;
    private Boolean sansGluten;

    public Entree (){}

    public Entree(String nom) {
        this.nom = nom;
    }

    public Entree(String nom, String listeIngredients, String recette, float prixParPersonne, float difficulte, Boolean vegetarien, Boolean vegan, Boolean sansGluten) {
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
        listeIngredients = in.readString();
        recette = in.readString();
        prixParPersonne = in.readFloat();
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
        dest.writeString(nom);
        dest.writeString(listeIngredients);
        dest.writeString(recette);
        dest.writeFloat(prixParPersonne);
        dest.writeFloat(difficulte);
        dest.writeByte((byte) (vegetarien == null ? 0 : vegetarien ? 1 : 2));
        dest.writeByte((byte) (vegan == null ? 0 : vegan ? 1 : 2));
        dest.writeByte((byte) (sansGluten == null ? 0 : sansGluten ? 1 : 2));
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

    public String getListeIngredients() {
        return listeIngredients;
    }

    public void setListeIngredients(String listeIngredients) {
        this.listeIngredients = listeIngredients;
    }

    public String getRecette() {
        return recette;
    }

    public void setRecette(String recette) {
        this.recette = recette;
    }

    public float getPrixParPersonne() {
        return prixParPersonne;
    }

    public void setPrixParPersonne(float prixParPersonne) {
        this.prixParPersonne = prixParPersonne;
    }

    public float getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(float difficulte) {
        this.difficulte = difficulte;
    }

    public boolean getVegetarien() {
        return vegetarien;
    }

    public void setVegetarien(boolean vegetarien) {
        this.vegetarien = vegetarien;
    }

    public boolean getVegan() {
        return vegan;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }

    public boolean getSansGluten() {
        return sansGluten;
    }

    public void setSansGluten(boolean sansGluten) {
        this.sansGluten = sansGluten;
    }
}
