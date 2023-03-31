package application;

import java.util.ArrayList;

public class Whisky {
    private int batchId;
    private double mængde;
    private ArrayList<Destillat> destillatList = new ArrayList<>();

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

    public ArrayList<Destillat> getDestillatList() {
        return new ArrayList<>(destillatList);
    }

    public void addDestillat(Destillat destillat) {
        if (!destillatList.contains(destillat)) {
            destillatList.add(destillat);
//            fad.tømFad();
        }
    }

    public void removeDestillat(Destillat destillat) {
        if (destillatList.contains(destillat)) {
            destillatList.remove(destillat);
        }
    }

    public ArrayList<Destillering> destilleringHistorik() {
        ArrayList<Destillering> destilleringHistorik = new ArrayList<>();
        for (Destillat d : getDestillatList()) {
            destilleringHistorik.add(d.getDestillering());
        }
        return destilleringHistorik;
    }

    public ArrayList<Lagring> lagringHistorik() {
        ArrayList<Lagring> lagringHistorik = new ArrayList<>();
        for (Destillat d : getDestillatList()) {
            lagringHistorik.addAll(d.getDestillatHistorik());
        }
        return lagringHistorik;
    }

    @Override
    public String toString() {
        return "Whisky{" +
                "batchId=" + batchId +
                ", mængde=" + mængde +
                ", destillatList=" + destillatList +
                '}';
    }
}
