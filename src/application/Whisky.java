package application;

import java.time.LocalDate;
import java.util.ArrayList;

public class Whisky {
    private int batchId;
    private double antalLiter;
    private ArrayList<Destillat> destillatList = new ArrayList<>();

    public Whisky(int batchId, double mængde) {
        this.batchId = batchId;
        this.antalLiter = mængde;
    }

    public int getBatchId() {
        return batchId;
    }

    public double getAntalLiter() {
        return antalLiter;
    }

    public ArrayList<Destillat> getDestillatList() {
        return new ArrayList<>(destillatList);
    }

    public void addDestillat(Destillat destillat) {
        if (!destillatList.contains(destillat)) {
            destillatList.add(destillat);
            destillat.getDestillatHistorik().get(destillat.getDestillatHistorik().size()-1).setSlutDato(LocalDate.now());
        }
    }

    public void removeDestillat(Destillat destillat) {
        if (destillatList.contains(destillat)) {
            destillatList.remove(destillat);
        }
    }


    public ArrayList<Fad> fadHistorik() {
        ArrayList<Fad> fadHistorik = new ArrayList<>();
        for (Destillat d : getDestillatList()) {
            for (Lagring l : d.getDestillatHistorik()) {
                fadHistorik.add(l.getFad());
            }
        }
        return fadHistorik;
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
                ", mængde=" + antalLiter +
                ", destillatList=" + destillatList +
                '}';
    }
}
