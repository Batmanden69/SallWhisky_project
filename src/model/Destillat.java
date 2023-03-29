package model;

import java.util.ArrayList;

public class Destillat {
    private ArrayList<Lagring> destillatHistorik = new ArrayList<>();
    private Destillering destillering;
    private int destillatId;
    private static int count = 1;
    private int mængde;

    Destillat(int mængde, Destillering destillering) {
        this.mængde = mængde;
        this.destillering = destillering;
        this.destillatId = count;
        count++;

    }

    public int getDestillatId() {
        return destillatId;
    }


    public ArrayList<Lagring> getDestillatHistorik() {
        return new ArrayList<>(destillatHistorik);
    }

    public Destillering getDestillering() {
        return destillering;
    }

    public int getMængde() {
        return mængde;
    }

    public void setMængde(int mængde) {
        this.mængde = mængde;
    }

    public void addLagring(Lagring lagring) {
        if (!destillatHistorik.contains(lagring)) {
            destillatHistorik.add(lagring);
            lagring.setDestillat(this);
        }
    }

    public void removeLagring(Lagring lagring) {
        if (destillatHistorik.contains(lagring)) {
            destillatHistorik.remove(lagring);
            lagring.setDestillat(null);
        }
    }

    @Override
    public String toString() {
        return "DestillatID: " + destillatId + ",    New Make Nummer: " + destillering.getNewMakeNr() + ",    " +
                mængde + " liter";
    }
}
