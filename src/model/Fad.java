package model;

public class Fad {
    private int id;
    private int størrelse;
    private int antalLiterPåfyldt;
    private String fadType;
    private String leverrandør;
    private Lager lager;

    public Fad(int id, int størrelse, int antalLiterPåfyldt, String fadType, String leverrandør) {
        this.id = id;
        this.størrelse = størrelse;
        this.antalLiterPåfyldt = antalLiterPåfyldt;
        this.fadType = fadType;
        this.leverrandør = leverrandør;
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

    public String getLeverrandør() {
        return leverrandør;
    }

    public void setLeverrandør(String leverrandør) {
        this.leverrandør = leverrandør;
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

    public String lægPåPlads (Lager lager){
        for (Plads p :  lager.getPladsListe()){
            if (!p.isOptaget()){
                setLager(lager);
            }
        }

        return null;
    }
}
