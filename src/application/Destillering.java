package application;

import java.util.ArrayList;

public class Destillering {

    private double antalLiterTilbage;
    private final double antalLiterOprindeligt;
    private int maltBatch;
    private String kornsort;
    private int newMakeNr;
    private double alkoholProcent;
    private String rygemateriale;
    private String kommentar;
    private String medarbejder;
    private static int count = 1;

    private final ArrayList<Destillat> destillatList = new ArrayList<>();

    public Destillering(double antalLiterTilbage, int maltBatch, String kornsort, double alkoholProcent, String rygemateriale, String kommentar) {
        this.antalLiterTilbage = antalLiterTilbage;
        this.antalLiterOprindeligt = antalLiterTilbage;
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

    public Destillat createDestillat(double mængde) {
        Destillat des = new Destillat(mængde, this);
        destillatList.add(des);
        return des;
    }

    public double getAntalLiterTilbage() {
        return antalLiterTilbage;
    }

    public void setAntalLiterTilbage(double antalLiterTilbage) {
        this.antalLiterTilbage = antalLiterTilbage;
    }

    public double getAntalLiterOprindeligt() {
        return antalLiterOprindeligt;
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

    /**
     * @param fad pre: dette kræver at fadet er stort nok
     */
    public void hældPåFad(Fad fad) {
        Destillat destillat = createDestillat(fad.getStørrelse());
        Lagring lagring = fad.createLagring(fad, destillat);
        destillat.addLagring(lagring);
        fad.fyldPå(fad.getStørrelse());

    }

    public void hældPåFad2(Fad fad, double mængde) {
//        antalLiterTilbage -= mængde;

        Destillat destillat = createDestillat(mængde);
        Lagring lagring = fad.createLagring(fad, destillat);
        destillat.addLagring(lagring);
        fad.fyldPå(mængde);

    }

    @Override
    public String toString() {
        return "NewMakeNR: " + newMakeNr +
                "\nAntal liter tilbage: " + antalLiterTilbage +
                "\nMaltBatch: " + maltBatch +
                "\nKornSort: " + kornsort +
                "\nAlkohol procent: " + alkoholProcent +
                "\nRygemateriale: " + rygemateriale +
                "\nKommentar: " + kommentar +
                "\n-------------------------------";
    }

    public int getMaltBatch() {
        return maltBatch;
    }

    public String getKornsort() {
        return kornsort;
    }

    public String getRygemateriale() {
        return rygemateriale;
    }

    public double getAlkoholProcent() {
        return alkoholProcent;
    }

    public String getKommentar() {
        return kommentar;
    }
}
