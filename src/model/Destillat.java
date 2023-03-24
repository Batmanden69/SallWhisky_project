package model;

import java.util.ArrayList;

public class Destillat {
    private ArrayList<Lagring> lagringer = new ArrayList<>();
    private Destillering destillering;
    private final ArrayList<Fad> fadList = new ArrayList<>();
    private double mængde;

    Destillat(double mængde, Destillering destillering) {
        this.mængde = mængde;
        this.destillering = destillering;
    }

    public ArrayList<Lagring> getLagringer() {
        return new ArrayList<>(lagringer);
    }

    public Destillering getDestillering() {
        return destillering;
    }

    public ArrayList<Fad> getFadList() {
        return fadList;
    }

    public void addLagring(Lagring lagring) {
        if (!lagringer.contains(lagring)) {
            lagringer.add(lagring);
            lagring.setDestillat(this);
        }
    }

    public void removeFad(Fad fad) {
        if (fadList.contains(fad)) {
            fadList.remove(fad);
            fad.setDestillat(null);
        }
    }

}
