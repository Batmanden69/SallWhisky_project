package application;

public class Plads {

    private int reol;
    private int hylde;
    private boolean optaget;
    private Lager lager;
    private Fad fad;

    Plads(int reol, int hylde, Lager lager) {
        this.reol = reol;
        this.hylde = hylde;
        this.lager = lager;
        this.optaget = false;
    }

    public Lager getLager() {
        return lager;
    }

    public void setOptaget(boolean optaget) {
        this.optaget = optaget;
    }

    public boolean isOptaget() {
        return optaget;
    }

    public Fad getFad() {
        return fad;
    }

    public void setFad(Fad fad) {
        if (this.fad != fad) {
            this.fad = fad;
        }
    }

    @Override
    public String toString() {
        return "reol " + reol + " - hylde " + hylde + " - " + optaget;

    }
}

