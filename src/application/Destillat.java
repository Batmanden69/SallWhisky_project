package application;

import java.time.LocalDate;
import java.util.ArrayList;

public class Destillat {
    private ArrayList<Lagring> destillatHistorik = new ArrayList<>();
    private Destillering destillering;
    private int destillatId;
    private static int count = 1;
    private int mængde;

    public Destillat(int mængde, Destillering destillering) {
        this.mængde = mængde;
        this.destillering = destillering;
        this.destillatId = count;
        count++;

    }

    public void setDestillering(Destillering destillering) {
        if (this.destillering != destillering) {
            Destillering oldDestillering = this.destillering;
            if (oldDestillering != null) {
                oldDestillering.removeDestillat(this);
            }
            this.destillering = destillering;
            if (destillering != null) {
                destillering.addDestillat(this);
            }
        }
    }

    public int getDestillatId() {
        return destillatId;
    }


    public ArrayList<Lagring> getDestillatHistorik() {
        return new ArrayList<>(destillatHistorik);
    }

    public Destillering getDestillering() {
        return destillering;
    }

    public int getMængde() {
        return mængde;
    }

    public void setMængde(int mængde) {
        this.mængde = mængde;
    }

    public void addLagring(Lagring lagring) {
        if (!destillatHistorik.contains(lagring)) {
            destillatHistorik.add(lagring);
            lagring.setDestillat(this);
        }
    }

    public void removeLagring(Lagring lagring) {
        if (destillatHistorik.contains(lagring)) {
            destillatHistorik.remove(lagring);
            lagring.setDestillat(null);
        }
    }

    public String destillatDestilleringOversigt(){
        return "Destillering:\n" +
                "New Make Nr: " + this.getDestillering().getNewMakeNr() + "\n" +
                "Malt Batch Nr: " + this.getDestillering().getMaltBatch() + "\n" +
                "Kornsort: " + this.getDestillering().getKornsort() + "\n" +
                "Rygemateriale: " + this.getDestillering().getRygemateriale() + "\n" +
                "Antal liter: " + this.getDestillering().getAntalLiter() + "\n" +
                "Alkoholprocent: " + this.getDestillering().getAlkoholProcent() + "\n" +
                "Kommentar: " + this.getDestillering().getKommentar();
    }

    public String destillatLagringOversigt(){
        String oversigt = "\n";
        for (Lagring lagring : destillatHistorik) {
            oversigt += "Fad ID: " + lagring.getFad().getFadId() + "\n" +
                    "Dato påfyldt: " + lagring.getStartDato() + "\n" +
                    "Lagringsperiode: " + lagring.getLagringsperiode() + "\n" +
                    "------------------------------\n";
        }
        return oversigt;
    }

    public void hældPåFad(Fad fad, int mængde) {
        Lagring lagring = new Lagring(fad, this);
        lagring.setStartDato(LocalDate.now());
        fad.setAntalLiterPåfyldt(mængde);
        fad.addLagring(lagring);
        this.addLagring(lagring);
    }

    @Override
    public String toString() {
        return "DestillatID: " + destillatId + ",    New Make Nummer: " + destillering.getNewMakeNr() + ",    " +
                mængde + " liter";
    }


}