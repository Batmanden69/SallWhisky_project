package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Lagring {
    private Fad fad;
    private Destillat destillat;
    private LocalDate startDato;
    private LocalDate slutDato;

    public Lagring(Fad fad, Destillat destillat, LocalDate startDato) {
        this.fad = fad;
        this.destillat = destillat;
        this.startDato = startDato;
    }

    public void setSlutDato(LocalDate slutDato) {
        this.slutDato = slutDato;
    }

    public Fad getFad() {
        return fad;
    }

    public Destillat getDestillat() {
        return destillat;
    }

    public void setFad(Fad fad) {
        if (this.fad != fad) {
            Fad oldFad = this.fad;
            if (oldFad != null) {
                oldFad.removeLagring(this);
            }
            this.fad = fad;
            if (fad != null) {
                fad.addLagring(this);

            }
        }
    }

    public void setDestillat(Destillat destillat) {
        if (this.destillat != destillat) {
            Destillat oldDestillat = this.destillat;
            if (oldDestillat != null) {
                oldDestillat.removeLagring(this);
            }
            this.destillat = destillat;
            if (destillat != null) {
                destillat.addLagring(this);

            }
        }
    }

    public LocalDate getSlutDato() {
        return slutDato;
    }

    @Override
    public String toString() {
        return "Fad: " + fad + ",    " + "destillat: " + destillat + ",     " + "Startdato: " + startDato;
    }
}
