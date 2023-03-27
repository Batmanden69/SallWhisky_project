package model;

import java.util.ArrayList;

public class Whisky {
    private int batchId;
    private double mængde;
    private ArrayList <Destillat> desillatList = new ArrayList(); ;

    public Whisky(int batchId, double mængde) {
        this.batchId = batchId;
        this.mængde = mængde;
        this.desillatList = desillatList;
    }

    public int getBatchId() {
        return batchId;
    }

    public double getMængde() {
        return mængde;
    }

    public ArrayList<Destillat> getDesillatList() {
        return desillatList;
    }

}
