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
        if (mængdeTilbage() == størrelse)
            return null;
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



//    public static Plads linearSearchKunde(ArrayList<Plads> list, String target) {
//        Plads plads = null;
//        int i = 0;
//        while (plads == null && i < list.size()) {
//            Plads p = list.get(i);
//            if (p.getNavn().equals(name))
//                kunde = k;
//            else {
//                i++;
//            }
//        }
//        return kunde;
//    }
//
//    private int søgLedigPlads(ArrayList<Plads> pladsListe, Plads target) {
//        //Tilføj try/catch-blok, der tjekker om lageret allerede er fuldt, og hvis det er, så kastes en exception.
//        int indeks = -1;
//        int i = 0;
//        while (indeks == -1 && i < pladsListe.size()) {
//            Plads k = pladsListe.get(i);
//            if (k.equals(target))
//                indeks = i;
//            else
//                i++;
//        }
//        return indeks;
//    }
//
//    public void lægPåPlads(Lager lager) {
//        setLager(lager);
//        int indeks = søgLedigPlads(lager.getPladsListe(),);
//        if (indeks != -1) {
//            Plads plads = lager.getPladsListe().get(indeks);
//            plads.setFad(this);
//            setLager(lager);
//        }
//    }
//
//    boolean found = false;
//        for (Plads p :  lager.getPladsListe()){
//        if (!p.isOptaget() && !found){
//            p.setOptaget(true);
//            p.setFad(this);
//            found = true;
//        }
//    }
//
//    public static int linearSearchList(ArrayList<String> list, String target) {
//        int indeks = -1;
//        int i = 0;
//        while (indeks == -1 && i < list.size()) {
//            String k = list.get(i);
//            if (k.equals(target))
//                indeks = i;
//            else
//                i++;
//        }
//        return indeks;
//    }


    public int mængdeTilbage() {
        return størrelse - antalLiterPåfyldt;
    }

    @Override
    public String toString() {
        return " " + id;
    }


}
