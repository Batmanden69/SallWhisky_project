package application;

import java.util.ArrayList;

public class Destillering {

    private int antalLiter;
    private int maltBatch;
    private String kornsort;
    private int newMakeNr;
    private double alkoholProcent;
    private String rygemateriale;
    private String kommentar;
    private String medarbejder;
    private static int count = 1;

    private final ArrayList<Destillat> destillatList = new ArrayList<>();

    public Destillering(int antalLiter, int maltBatch, String kornsort, double alkoholProcent, String rygemateriale, String kommentar) {
        this.antalLiter = antalLiter;
        this.maltBatch = maltBatch;
        this.kornsort = kornsort;
        this.newMakeNr = count;
        count++;
        this.alkoholProcent = alkoholProcent;
        this.rygemateriale = rygemateriale;
        this.kommentar = kommentar;
    }

    public ArrayList<Destillat> getDestillatList() {
        return new ArrayList<>(destillatList);
    }

    public Destillat createDestillat(int mængde) {
        Destillat des = new Destillat(mængde, this);
        destillatList.add(des);
        return des;
    }

    public int getAntalLiter() {
        return antalLiter;
    }

    public int getNewMakeNr() {
        return newMakeNr;
    }

    public void removeDestillat(Destillat destillat) {
        if (destillatList.contains(destillat)) {
            destillatList.remove(destillat);
            destillat.setDestillering(this);
        }
    }

    public void addDestillat(Destillat destillat) {
        if (!destillatList.contains(destillat)) {
            destillatList.add(destillat);
            destillat.setDestillering(this);
        }
    }

    //Opretter et destillat på størrelse med fadets størrelse og tilføjer det til destillatList.
    public void hældPåFad(Fad fad) {
        Destillat destillat = createDestillat(fad.getStørrelse());
        Lagring lagring = fad.createLagring(fad, destillat);
        destillat.addLagring(lagring);
        antalLiter -= fad.getStørrelse();
    }

    @Override
    public String toString() {
        return newMakeNr + "    " + maltBatch + "   " + kornsort + "   " + rygemateriale;
    }

    public int getMaltBatch() {
        return maltBatch;
    }

    public String getKornsort() {
        return kornsort;
    }

    public String getRygemateriale(){
        return rygemateriale;
    }

    public double getAlkoholProcent() {
        return alkoholProcent;
    }

    public String getKommentar() {
        return kommentar;
    }
}
