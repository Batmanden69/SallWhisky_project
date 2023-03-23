package model;

import java.util.ArrayList;

public class Destillering {

    private int antalLiter;
    private int maltBatch;
    private String kornsort;
    private int newMakeNr;
    private double alkoholProcent;
    private String rygmatriale;
    private String kommentar;

    private final ArrayList<Destillat>destillatList = new ArrayList<>();

    public Destillering(int antalLiter, int maltBatch, String kornsort, int newMakeNr, double alkoholProcent, String rygmatriale, String kommentar) {
        this.antalLiter = antalLiter;
        this.maltBatch = maltBatch;
        this.kornsort = kornsort;
        this.newMakeNr = newMakeNr;
        this.alkoholProcent = alkoholProcent;
        this.rygmatriale = rygmatriale;
        this.kommentar = kommentar;
    }

    public ArrayList<Destillat> getDestillatList() {
        return new ArrayList<>(destillatList);
    }
    public Destillat createDestillat(String historie, double mængde, Destillering destillering){
        Destillat des = new Destillat(historie,mængde,this);
        destillatList.add(des);
        return des;
    }
}
