package application;

import java.util.ArrayList;

public class Fad {
    private int id;
    private double størrelse;
    private double antalLiterPåfyldt;
    private boolean tømt;
    private String fadType;
    private String leverandør;
    private Plads plads;
    private ArrayList<Lagring> lagringList = new ArrayList<>();
    private static int count = 1;


    public Fad(double størrelse, String fadType, String leverandør) {
        this.størrelse = størrelse;
        this.fadType = fadType;
        this.leverandør = leverandør;
        this.id = count;
        count++;
    }

    // Try-Catch setup.
    public void fyldPå(double mængde) {
            double ledigPladsFør = størrelse - antalLiterPåfyldt;
            if (this.antalLiterPåfyldt + mængde > this.størrelse) {
                throw new RuntimeException("Der er ikke plads til den valgte mængde. fadet hat kun "+ ledigPladsFør + " liter plads ledig");
            } else {
                this.antalLiterPåfyldt += mængde;
            }
    }

    //Try-Catch setup igen.
    public void hældFra(double mængde) {
        if (this.antalLiterPåfyldt - mængde < 0) {
            throw new RuntimeException("Der er kun " + antalLiterPåfyldt +" liter væske påfyldt");
        } else {
            this.antalLiterPåfyldt -= mængde;
            if (this.antalLiterPåfyldt == 0) {
                tømFad();
            }
        }
    }


    public ArrayList<Lagring> getNuværendeIndhold() {
        ArrayList<Lagring> results = new ArrayList<>();
        if (antalLiterLedig() == størrelse)
            return null;
        else {
            for (Lagring lagring : lagringList) {
                results.add(lagring);
            }
            return results;
        }
    }

    public ArrayList<Destillat> getDestillater() {
        ArrayList<Destillat> results = new ArrayList<>();
        if (antalLiterLedig() == størrelse)
            return null;
        else {
            for (Lagring lagring : lagringList) {
                results.add(lagring.getDestillat());
            }
            return results;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getStørrelse() {
        return størrelse;
    }

    public void setStørrelse(double størrelse) {
        this.størrelse = størrelse;
    }

    public double getAntalLiterPåfyldt() {
        return antalLiterPåfyldt;
    }

    public void setAntalLiterPåfyldt(double antalLiterPåfyldt) {
        this.antalLiterPåfyldt = antalLiterPåfyldt;
    }

    public String getFadType() {
        return fadType;
    }

    public Plads getPlads() {
        return plads;
    }

    public ArrayList<Lagring> getLagringList() {
        return new ArrayList<>(lagringList);
    }

    public void setFadType(String fadType) {
        this.fadType = fadType;
    }

    public String getLeverandør() {
        return leverandør;
    }

    public void setLeverandør(String leverandør) {
        this.leverandør = leverandør;
    }

    public void setPlads(Plads plads) {
        if (this.plads != plads) {
            this.plads = plads;
        }
    }

    public void removeLagring(Lagring lagring) {
        if (lagringList.contains(lagring)) {
            lagringList.remove(lagring);
            lagring.setFad(this);
        }
    }

    public void addLagring(Lagring lagring) {
        if (!lagringList.contains(lagring)) {
            lagringList.add(lagring);
            lagring.setFad(this);
        }
    }

    public Lagring createLagring(Fad fad, Destillat destillat) {
        Lagring lagring = new Lagring(fad, destillat);
        lagringList.add(lagring);
        setAntalLiterPåfyldt(destillat.getMængde());
        destillat.addLagring(lagring);
        return lagring;
    }

    public void lægPåPlads(Lager lager) {
        Plads plads = lager.findLedigPlads(lager.getPladsListe(), false);
        if (plads != null) {
            plads.setOptaget(true);
            plads.setFad(this);
        }
    }


    public double antalLiterLedig() {
        return størrelse - antalLiterPåfyldt;
    }

    @Override
    public String toString() {
        return "FadID: " + id + "   " + "Str: " + størrelse + " L";
    }

    public void tømFad() {
        tømt = true;
        antalLiterPåfyldt = 0;
    }

    public void omhældFad2(Fad nytFad) {
        if (lagringList.size() == 0) {
            tømFad();
        }
        while (lagringList.size() > 0) {
            Lagring lagring = this.getLagringList().get(0);
            nytFad.createLagring(nytFad, lagring.getDestillat());
            hældFra(lagring.getDestillat().getMængde());
            nytFad.fyldPå(lagring.getDestillat().getMængde());
            this.removeLagring(lagring);
            omhældFad2(nytFad);
        }
    }


    public int getFadId() {
        return id;
    }
}

