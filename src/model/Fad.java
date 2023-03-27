package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Fad {
    private int id;
    private int størrelse;
    private int antalLiterPåfyldt;
    private String fadType;
    private String leverandør;
    private Lager lager;
    private Plads plads;
    private final ArrayList<Lagring> lagringList = new ArrayList<>();


    public Fad(int id, int størrelse, String fadType, String leverrandør) {
        this.id = id;
        this.størrelse = størrelse;
        this.fadType = fadType;
        this.leverandør = leverrandør;
    }

    public Lagring getNuværendeLagring() {
        if (mængdeTilbage() == størrelse)
            return null;
        else {
            return lagringList.get(lagringList.size() - 1);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStørrelse() {
        return størrelse;
    }

    public void setStørrelse(int størrelse) {
        this.størrelse = størrelse;
    }

    public int getAntalLiterPåfyldt() {
        return antalLiterPåfyldt;
    }

    public void setAntalLiterPåfyldt(int antalLiterPåfyldt) {
        this.antalLiterPåfyldt = antalLiterPåfyldt;
    }

    public String getFadType() {
        return fadType;
    }

    public Plads getPlads() {
        return plads;
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

    public void setPlads (Plads plads){
        if (this.plads !=plads){
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

    public Lagring createLagring(Destillat destillat, LocalDate startDato) {
        Lagring lagring = new Lagring(this, destillat, startDato);
        lagringList.add(lagring);
        setAntalLiterPåfyldt(destillat.getMængde());
        return lagring;
    }

    public void lægPåPlads(Lager lager) {
        Plads plads = lager.findLedigPlads(lager.getPladsListe(), false);
        if (plads != null) {
            plads.setOptaget(true);
            plads.setFad(this);
        }
    }


    public int mængdeTilbage() {
        return størrelse - antalLiterPåfyldt;
    }

    @Override
    public String toString() {
        return " " + id;
    }


}
