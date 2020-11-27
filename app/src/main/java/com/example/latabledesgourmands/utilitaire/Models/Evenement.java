package com.example.latabledesgourmands.utilitaire.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class Evenement implements Parcelable {
    String date;
    String adresse;
    String heure;
    int nombreConvive;
    int nombreCuisinier;
    Theme  theme;
    Boolean isFumeurOk;
    Boolean isAnimalOk;
    Boolean isAlcoolOk;

    public Evenement(String date) {
        this.date = date;
    }

    public Evenement(String date, String adresse, String heure, int nombreConvive,int nombreCuisinier, Theme theme, Boolean isFumeurOk, Boolean isAnimalOk, Boolean isAlcoolOk) {
        this.date = date;
        this.adresse = adresse;
        this.heure = heure;
        this.nombreConvive = nombreConvive;
        this.nombreCuisinier=nombreCuisinier;
        this.theme = theme;
        this.isFumeurOk = isFumeurOk;
        this.isAnimalOk = isAnimalOk;
        this.isAlcoolOk = isAlcoolOk;
    }


    protected Evenement(Parcel in) {
        date = in.readString();
        adresse = in.readString();
        heure = in.readString();
        nombreConvive = in.readInt();
        nombreCuisinier = in.readInt();
        theme = in.readParcelable(Theme.class.getClassLoader());
        isFumeurOk = in.readByte() != 0;
        isAnimalOk = in.readByte() != 0;
        isAlcoolOk = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(date);
        dest.writeString(adresse);
        dest.writeString(heure);
        dest.writeInt(nombreConvive);
        dest.writeInt(nombreCuisinier);
        dest.writeParcelable(theme, flags);
        dest.writeByte((byte) (isFumeurOk == null ? 0 : isFumeurOk ? 1 : 2));
        dest.writeByte((byte) (isAnimalOk == null ? 0 : isAnimalOk ? 1 : 2));
        dest.writeByte((byte) (isAlcoolOk == null ? 0 : isAlcoolOk ? 1 : 2));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Evenement> CREATOR = new Creator<Evenement>() {
        @Override
        public Evenement createFromParcel(Parcel in) {
            return new Evenement(in);
        }

        @Override
        public Evenement[] newArray(int size) {
            return new Evenement[size];
        }
    };

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public int getNombreConvive() {
        return nombreConvive;
    }

    public void setNombreConvive(int nombreConvive) {
        this.nombreConvive = nombreConvive;
    }

    public int getNombreCuisinier() {
        return nombreCuisinier;
    }

    public void setNombreCuisinier(int nombreCuisinier) {
        this.nombreCuisinier = nombreCuisinier;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public Boolean getFumeurOk() {
        return isFumeurOk;
    }

    public void setFumeurOk(Boolean fumeurOk) {
        isFumeurOk = fumeurOk;
    }

    public Boolean getAnimalOk() {
        return isAnimalOk;
    }

    public void setAnimalOk(Boolean animalOk) {
        isAnimalOk = animalOk;
    }

    public Boolean getAlcoolOk() {
        return isAlcoolOk;
    }

    public void setAlcoolOk(Boolean alcoolOk) {
        isAlcoolOk = alcoolOk;
    }


}
