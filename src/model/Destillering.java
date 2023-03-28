package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Destillering {

    private int antalLiter;
    private int maltBatch;
    private String kornsort;
    private int newMakeNr;
    private double alkoholProcent;
    private String rygematriale;
    private String kommentar;

    private final ArrayList<Destillat> destillatList = new ArrayList<>();

    public Destillering(int antalLiter, int maltBatch, String kornsort, int newMakeNr, double alkoholProcent, String rygematriale, String kommentar) {
        this.antalLiter = antalLiter;
        this.maltBatch = maltBatch;
        this.kornsort = kornsort;
        this.newMakeNr = newMakeNr;
        this.alkoholProcent = alkoholProcent;
        this.rygematriale = rygematriale;
        this.kommentar = kommentar;
    }

    public ArrayList<Destillat> getDestillatList() {
        return new ArrayList<>(destillatList);
    }
    public Destillat createDestillat(int mængde){
        Destillat des = new Destillat(mængde,this);
        destillatList.add(des);
        return des;
    }

    public int getAntalLiter() {
        return antalLiter;
    }

    public int getNewMakeNr() {
        return newMakeNr;
    }

    public void removeDestillat(Destillat destillat){
        if (destillatList.contains(destillat)){
            destillatList.remove(destillat);
        }
    }

    //Opretter et destillat på størrelse med fadets størrelse og tilføjer det til destillatList.
    public void hældPåFad(Fad fad){
        Destillat destillat = createDestillat(fad.getStørrelse());
        Lagring lagring = fad.createLagring(destillat,LocalDate.now());
        destillat.addLagring(lagring);
        antalLiter -= fad.getStørrelse();
    }


}
