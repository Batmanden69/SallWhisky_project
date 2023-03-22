package model;

import java.util.ArrayList;

public class Lager {
    private String navn;
    private int ledigePladser;
    private ArrayList<Fad> fadListe;
    private ArrayList<Plads> pladsListe;

    public Lager(String navn, int ledigePladser) {
        this.navn = navn;
        this.ledigePladser = ledigePladser;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getLedigePladser() {
        return ledigePladser;
    }

    public void setLedigePladser(int ledigePladser) {
        this.ledigePladser = ledigePladser;
    }

    public ArrayList<Fad> getFadListe() {
        return new fadListe;
    }

    public void addFad(Fad fad){
        if(!fadListe.contains(fad)){
            fadListe.add(fad);
            fad.setLager(this);
        }
    }

    public void removeFad(Fad fad){
        if(fadListe.contains(fad)){
            fadListe.remove(fad);
            fad.setLager(null);
        }
    }

    public void addPlads(Plads plads){
        if(!pladsListe.contains(plads)){
            pladsListe.add(plads);
            plads.setLager(this);
        }
    }

    public void removePlads(Plads plads){
        if(pladsListe.contains(plads)){
            pladsListe.remove(plads);
            plads.setLager(null);
        }
    }
}
