package com.example.latabledesgourmands.utilitaire.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class Dessert implements Parcelable {
    private String nom;
    private String listeIngredients;
    private String recette;
    private float prixParPersonne;
    private float difficulte;
    private Boolean vegetarien;
    private Boolean vegan;
    private Boolean sansGluten;

    public Dessert(String nom) {
        this.nom = nom;
    }
    public Dessert(){

    }
    public Dessert(String nom, String listeIngredients, String recette, float prixParPersonne, float difficulte, Boolean vegetarien, Boolean vegan, Boolean sansGluten) {
        this.nom = nom;
        this.listeIngredients = listeIngredients;
        this.recette = recette;
        this.prixParPersonne = prixParPersonne;
        this.difficulte = difficulte;
        this.vegetarien = vegetarien;
        this.vegan = vegan;
        this.sansGluten = sansGluten;
    }


    protected Dessert(Parcel in) {
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


}
