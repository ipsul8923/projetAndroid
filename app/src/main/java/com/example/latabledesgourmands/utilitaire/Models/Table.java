package com.example.latabledesgourmands.utilitaire.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class Table implements Parcelable {
    Menu monMenu;
    //Prix compris dans menu
    Evenement monEvenement;
    //Theme compris dans evenement

    public Table (){}
    public Table(Menu monMenu, Evenement monEvenement) {
        this.monMenu = monMenu;
        this.monEvenement = monEvenement;
    }

    protected Table(Parcel in) {
        monMenu = in.readParcelable(Menu.class.getClassLoader());
        monEvenement = in.readParcelable(Evenement.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(monMenu, flags);
        dest.writeParcelable(monEvenement, flags);
    }

    @Override
    public int describeContents() {
        return 0;
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

    public Evenement getMonEvenement() {
        return monEvenement;
    }

    public void setMonEvenement(Evenement monEvenement) {
        this.monEvenement = monEvenement;
    }

    public Menu getMonMenu() {
        return monMenu;
    }

    public void setMonMenu(Menu monMenu) {
        this.monMenu = monMenu;
    }
}