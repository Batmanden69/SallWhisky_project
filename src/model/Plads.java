package model;

import java.util.ArrayList;

public class Plads {

    private int reol;
    private int hylde;
    private boolean optaget;
    private Lager lager;

    Plads(int reol, int hylde, Lager lager) {
        this.reol = reol;
        this.hylde = hylde;
        this.lager = lager;
        this.optaget = false;
    }

    public Lager getLager() {
        return lager;
    }

    public void setLager(Lager lager) {
        this.lager = lager;
    }

    public int getReol() {
        return reol;
    }

    public void setReol(int reol) {
        this.reol = reol;
    }

    public int getHylde() {
        return hylde;
    }

    public void setHylde(int hylde) {
        this.hylde = hylde;
    }

    public void setOptaget(boolean optaget) {
        this.optaget = optaget;
    }

    public boolean isOptaget() {
        return optaget;
    }

    @Override
    public String toString() {
        return "reol " + reol + " - hylde " + hylde + " - " + optaget;

    }
}

