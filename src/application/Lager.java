package application;

import java.util.ArrayList;

public class Lager {
    private String navn;
    private int pladserTotal;
    private ArrayList<Plads> pladsListe;

    public Lager(String navn, int ledigePladser) {
        this.navn = navn;
        this.pladserTotal = ledigePladser;
        this.pladsListe = new ArrayList<>();
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getPladserTotal() {
        return pladserTotal;
    }

    public void setPladserTotal(int pladserTotal) {
        this.pladserTotal = pladserTotal;
    }


    public Plads createPlads(int reol, int hylde, Lager lager) {
        Plads plads = new Plads(reol, hylde, this);
        pladsListe.add(plads);
        return plads;
    }


    public void removePlads(Plads plads) {
        if (pladsListe.contains(plads)) {
            pladsListe.remove(plads);
        }
    }

    public ArrayList<Plads> getPladsListe() {
        return new ArrayList<>(pladsListe);
    }

    public Plads findLedigPlads(ArrayList<Plads> list, boolean target){
        Plads plads = null;
        int i = 0;
        while (plads == null && i < list.size()){
            Plads p = list.get(i);
            if (p.isOptaget() == target)
                plads = p;
            else {
                i++;
            }
        }
        return plads;
    }



    @Override
    public String toString() {
        return "Navn: " + navn + " pladser: " + pladserTotal;
    }
}
