package model;

public class Plads {

    private int reolNr;
    private int hyldeNr;
    private Lager lager;

    public Plads(int reolNr, int hyldeNr, Lager lager) {
        this.reolNr = reolNr;
        this.hyldeNr = hyldeNr;
        this.lager = lager;
    }

    public int getReolNr() {
        return reolNr;
    }

    public void setReolNr(int reolNr) {
        this.reolNr = reolNr;
    }

    public int getHyldeNr() {
        return hyldeNr;
    }

    public void setHyldeNr(int hyldeNr) {
        this.hyldeNr = hyldeNr;
    }

    public void setLager(Lager lager) {
        if (this.lager != lager) {
            Lager oldLager = this.lager;
            if (oldLager != null) {
                oldLager.removePlads(this);
            }
            this.lager = lager;
            if (lager != null) {
                lager.addPlads(this);
            }
        }
    }
}
