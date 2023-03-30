package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Fad implements Subject {
    private int id;
    private int størrelse;
    private int antalLiterPåfyldt;
    private boolean tømt;
    private String fadType;
    private String leverandør;
    private Plads plads;
    private ArrayList<Lagring> lagringList = new ArrayList<>();
    private Set<Observer> observers;


    public Fad(int id, int størrelse, String fadType, String leverandør) {
        this.id = id;
        this.størrelse = størrelse;
        this.fadType = fadType;
        this.leverandør = leverandør;
        observers = new HashSet<Observer>();
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
        return lagring;
    }

    public void lægPåPlads(Lager lager) {
        Plads plads = lager.findLedigPlads(lager.getPladsListe(), false);
        if (plads != null) {
            plads.setOptaget(true);
            plads.setFad(this);
        }
    }


    public int antalLiterLedig() {
        return størrelse - antalLiterPåfyldt;
    }

    @Override
    public String toString() {
        return " " + id;
    }

    // Observer pattern -------------------------------------------------------------------------------------------
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        Iterator<Observer> itr = observers.iterator();
        while (itr.hasNext()) {
            Observer o = itr.next();
            o.update(LocalDate.now());
        }

    }

    //----------------------------------------------------------------------------------------------
    public void tømFad() {
        notifyObservers();
        while (lagringList.size() > 0) {
            Lagring lagring = lagringList.get(0);
            removeLagring(lagring);
        }
//        for (Lagring lagring : lagringList) {
//            this.removeLagring(lagring);
//        }
//        tømt = true;
//        this.antalLiterPåfyldt = 0;

    }

    public void omhældFad(Fad nytFad) {
        ArrayList<Lagring> nyLagringList = new ArrayList<>();
        for (Lagring lagring : lagringList) {
            Lagring nyLagring = nytFad.createLagring(nytFad, lagring.getDestillat());
            nyLagringList.add(nyLagring);
        }
        this.tømFad();
//
//
//        System.out.println(nyLagring.getDestillat());
//        nytFad.addLagring(nyLagring);
//        System.out.println(nytFad.getLagringList());
//        int mængde = getNuværendeIndhold().getMængde();
//        System.out.println(nytFad.getNuværendeIndhold());
//        tømFad();
////        nyLagring.setDestillat(this.getNuværendeIndhold());
//
//        nytFad.setAntalLiterPåfyldt(nytFad.getAntalLiterPåfyldt()+mængde);
    }
}
