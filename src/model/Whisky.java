package model;

import java.util.ArrayList;

public class Whisky {
    private int batchId;
    private double mængde;
    private ArrayList <Fad> fadList = new ArrayList<>();

    public Whisky(int batchId, double mængde) {
        this.batchId = batchId;
        this.mængde = mængde;
    }

    public int getBatchId() {
        return batchId;
    }

    public double getMængde() {
        return mængde;
    }

    public ArrayList<Fad> getFadList() {
        return new ArrayList<>(fadList);
    }
    public void addFad(Fad fad){
        if (!fadList.contains(fad)){
            fadList.add(fad);
        }
    }
    public void removeFad(Fad fad){
        if (fadList.contains(fad)){
            fadList.remove(fad);
        }
    }
}
