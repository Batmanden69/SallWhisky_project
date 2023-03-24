package model;

import java.util.ArrayList;

public class Destillat {
    private String historie;
    private Destillering destillering;
    private final ArrayList<Fad> fadList = new ArrayList<>();
    private double mængde;

     Destillat(String historie,double mængde, Destillering destillering) {
        this.historie = historie;
        this.mængde = mængde;
        this.destillering = destillering;
    }

    public String getHistorie() {
        return historie;
    }

    public void setHistorie(String historie) {
        this.historie = historie;
    }

    public Destillering getDestillering() {
        return destillering;
    }

    public ArrayList<Fad> getFadList() {
        return fadList;
    }


    public void removeLagring(Lagring lagring) {
         if()
    }

    public void addLagring(Lagring lagring) {
    }
}
