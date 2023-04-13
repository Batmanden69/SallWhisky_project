package application;

import java.time.LocalDate;
import java.util.ArrayList;

public class Whisky {
    private int batchId;
    private double antalLiter;
    private ArrayList<Destillat> destillatList = new ArrayList<>();

    private static int count = 1;

    public Whisky(double mængde) {
        this.antalLiter = mængde;
        this.batchId = count;
        count++;
    }

    public ArrayList<Destillat> getDestillatList() {
        return new ArrayList<>(destillatList);
    }

    public void addDestillat(Destillat destillat) {
        if (!destillatList.contains(destillat)) {
            destillatList.add(destillat);
        }
    }

    public void removeDestillat(Destillat destillat) {
        if (destillatList.contains(destillat)) {
            destillatList.remove(destillat);
        }
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
        return "BatchId:   " + batchId +
                "\nMængde:  " + antalLiter + " liter" +
                "\n-----------------------------------";
    }
}
