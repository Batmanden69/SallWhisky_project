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


    public Fad(int id, int størrelse, int antalLiterPåfyldt, String fadType, String leverrandør) {
        this.id = id;
        this.størrelse = størrelse;
        this.antalLiterPåfyldt = antalLiterPåfyldt;
        this.fadType = fadType;
        this.leverandør = leverrandør;
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
        if (lagringsList.contains(lagring)){
            lagringsList.remove(lagring);
            lagring.setFad(this);
        }
    }

    public void addLagring(Lagring lagring) {
        if (!lagringsList.contains(lagring)){
            lagringsList.add(lagring);
            lagring.setFad(this);
        }
    }
    public Lagring createLagring (Destillat destillat, LocalDate startDato, LocalDate slutDato){
        Lagring lagring = new Lagring(this,destillat,startDato,slutDato);
        lagringsList.add(lagring);
        return lagring;
    }

    public void lægPåPlads (Lager lager){
        setLager(lager);
        boolean found = false;
        for (Plads p :  lager.getPladsListe()){
            if (!p.isOptaget() && !found){
                p.setOptaget(true);
                p.setFad(this);
                found = true;
            }
        }
    }

    @Override
    public String toString() {
        return " " + id;
    }



}
