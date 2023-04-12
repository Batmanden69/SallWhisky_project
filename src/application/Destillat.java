package application;

import java.time.LocalDate;
import java.util.ArrayList;

public class Destillat {
    private ArrayList<Lagring> destillatHistorik = new ArrayList<>();
    private Destillering destillering;
    private int destillatId;
    private static int count = 1;
    private double mængde;

    public Destillat(double mængde, Destillering destillering) {
        this.mængde = mængde;
        this.destillering = destillering;
        this.destillatId = count;
        count++;
        destillering.setAntalLiterTilbage(destillering.getAntalLiterTilbage() - mængde);

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

    public double getMængde() {
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
                "Antal liter: " + this.getDestillering().getAntalLiterOprindeligt() + "\n" +
                "Alkoholprocent: " + this.getDestillering().getAlkoholProcent() + "\n" +
                "Kommentar: " + this.getDestillering().getKommentar();
    }

    public String destillatLagringOversigt(){
        String oversigt="";
        for (Lagring lagring : destillatHistorik) {
            oversigt += "Fad ID: " + lagring.getFad().getFadId() + "\n" +
                    "Dato påfyldt: " + lagring.getStartDato() + "\n" +
                    "Lagringsperiode: " + lagring.getLagringsperiode() + "\n" +
                    "------------------------------\n";
        }
        return oversigt;
    }
    public void hældPåFad(Fad fad, int mængde) {
        if (mængde > this.mængde) {
            throw new IllegalArgumentException("Den indtastede mængde overskrider mængden af destillat.");
        }
        if(mængde <=0){
            throw new IllegalArgumentException("Den indtastede mængde skal være større end 0.");
        }
        Lagring lagring = new Lagring(fad, this);
        fad.addLagring(lagring);
        this.addLagring(lagring);
        fad.fyldPå(mængde);
    }

    @Override
    public String toString() {
        return "DestillatID: " + destillatId +
                "\nNew Make Nummer: " + destillering.getNewMakeNr() + ",    " +
                mængde + " liter";
    }


}
