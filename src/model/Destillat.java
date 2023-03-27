package model;

import java.util.ArrayList;

public class Destillat {
    private ArrayList<Lagring> lagringList = new ArrayList<>();
    private Destillering destillering;
    private int mængde;
    private Whisky whisky;

    Destillat(int mængde, Destillering destillering) {
        this.mængde = mængde;
        this.destillering = destillering;
    }



    public ArrayList<Lagring> getLagringList() {
        return new ArrayList<>(lagringList);
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
        if (!lagringList.contains(lagring)) {
            lagringList.add(lagring);
            lagring.setDestillat(this);
        }
    }

    public void removeLagring(Lagring lagring) {
        if (lagringList.contains(lagring)) {
            lagringList.remove(lagring);
            lagring.setDestillat(null);
        }
    }
    public void setWhisky(Whisky whisky){
        if (this.whisky != whisky){
            Whisky oldWhisky = this.whisky;
            if (oldWhisky != null){
                oldWhisky.removeDestillat(this);
            }
            this.whisky = whisky;
            if (whisky != null){
                whisky.addDestillat(this);
            }
        }
    }

    @Override
    public String toString() {
        return destillering.getNewMakeNr() +
                ",  Mængde: " + mængde;
    }
}
