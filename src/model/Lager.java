package model;

import java.util.ArrayList;

public class Lager {
    private String navn;
    private int pladserTotal;
    private ArrayList<Fad> fadListe;
    private ArrayList<Plads> pladsListe;

    public Lager(String navn, int ledigePladser) {
        this.navn = navn;
        this.pladserTotal = ledigePladser;
        this.fadListe = new ArrayList<>();
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

    public ArrayList<Fad> getFadListe() {
        return new ArrayList<>(fadListe);
    }

    public void addFad(Fad fad) {
        if (!fadListe.contains(fad)) {
            fadListe.add(fad);
            fad.setLager(this);
        }
    }

    public void removeFad(Fad fad) {
        if (fadListe.contains(fad)) {
            fadListe.remove(fad);
            fad.setLager(null);
        }
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

    @Override
    public String toString() {
        return "lager "+navn+ " pladserTotal "+pladserTotal+ " Fade "+fadListe+" pladser "+pladsListe;
    }
}
