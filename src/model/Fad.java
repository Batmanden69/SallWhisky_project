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
    private final ArrayList<Lagring> lagringsList = new ArrayList<>();


    public Fad(int id, int størrelse, String fadType, String leverrandør) {
        this.id = id;
        this.størrelse = størrelse;
        this.fadType = fadType;
        this.leverandør = leverrandør;
    }

    public Lagring getNuværendeLagring() {
        if (mængdeTilbage() == størrelse) return null;
        else {
            return lagringsList.get(lagringsList.size() - 1);
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

    public void setFadType(String fadType) {
        this.fadType = fadType;
    }

    public String getLeverandør() {
        return leverandør;
    }

    public void setLeverandør(String leverandør) {
        this.leverandør = leverandør;
    }

    public Lager getLager() {
        return lager;
    }

    public void setLager(Lager lager) {
        if (this.lager != lager) {
            Lager oldLager = this.lager;
            if (oldLager != null) {
                oldLager.removeFad(this);
            }
            this.lager = lager;
            if (lager != null) {
                lager.addFad(this);
            }
        }
    }

    public void removeLagring(Lagring lagring) {
        if (lagringsList.contains(lagring)) {
            lagringsList.remove(lagring);
            lagring.setFad(this);
        }
    }

    public void addLagring(Lagring lagring) {
        if (!lagringsList.contains(lagring)) {
            lagringsList.add(lagring);
            lagring.setFad(this);
        }
    }

    public Lagring createLagring(Destillat destillat, LocalDate startDato) {
        Lagring lagring = new Lagring(this, destillat, startDato);
        lagringsList.add(lagring);
        setAntalLiterPåfyldt(destillat.getMængde());
        return lagring;
    }

    private static Plads findLedigPlads(ArrayList<Plads> list, boolean target) {
        Plads plads = null;
        int i = 0;
        while (plads == null && i < list.size()) {
            Plads p = list.get(i);
            if (p.isOptaget() == target) plads = p;
            else {
                i++;
            }
        }
        return plads;
    }

    public void lægPåPlads(Lager lager) {
        setLager(lager);
        Plads plads = findLedigPlads(lager.getPladsListe(), false);
        if (plads.isOptaget() == false) {
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
