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
        this.antalLiterPåfyldt = 0;
        this.størrelse = størrelse;
        this.fadType = fadType;
        this.leverandør = leverandør;
        this.id = count;
        count++;
    }


    public void fyldPå(double mængde) {
        if (mængde < 0) {
            throw new RuntimeException("Mængden skal være større end 0");
        } else if (antalLiterPåfyldt + mængde > størrelse) {
            throw new RuntimeException("Der er ikke plads til den ønskede mængde");
        } else {
            antalLiterPåfyldt += mængde;
        }
    }

    public void hældFra(double mængde) {
        if (antalLiterPåfyldt - mængde < 0) {
            throw new RuntimeException("Der er kun " + antalLiterPåfyldt + " liter væske påfyldt");
        } else {
            antalLiterPåfyldt -= mængde;
            if (antalLiterPåfyldt == 0) {
                tømFad();
            }
        }
    }

    public ArrayList<Destillat> getDestillater() {
        ArrayList<Destillat> results = new ArrayList<>();
        if (antalLiterLedig() == størrelse)
            return results;
        else {
            for (Lagring lagring : lagringList) {
                results.add(lagring.getDestillat());
            }
            return results;
        }
    }


    public double getAntalLiterPåfyldt() {
        return antalLiterPåfyldt;
    }

    public void setAntalLiterPåfyldt(double antalLiterPåfyldt) {
        this.antalLiterPåfyldt = antalLiterPåfyldt;
    }

    public Plads getPlads() {
        return plads;
    }

    public ArrayList<Lagring> getLagringList() {
        return new ArrayList<>(lagringList);
    }


    public void removeLagring(Lagring lagring) {
        if (lagringList.contains(lagring)) {
            lagringList.remove(lagring);
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
        return "FadID: " + id + "   " + "" +
                "\nStr: " + størrelse + " L";
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

    public double samletMængde() {
        double sum = 0;
        for (Destillat d : this.getDestillater()) {
            sum += d.getMængde();
        }
        return sum;
    }

    public int getFadId() {
        return id;
    }
}

