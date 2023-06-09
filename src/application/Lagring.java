package application;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Lagring {
    private Fad fad;
    private Destillat destillat;
    private final LocalDate startDato;
    private LocalDate slutDato;

    public Lagring(Fad fad, Destillat destillat) {
        this.fad = fad;
        this.destillat = destillat;
        this.startDato = LocalDate.now();
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

    public LocalDate getStartDato() {
        return startDato;
    }

    public long getLagringsperiode() {
        long daysBetween;
        if (slutDato == null) {
            daysBetween = ChronoUnit.DAYS.between(startDato, LocalDate.now());
        } else {
            daysBetween = ChronoUnit.DAYS.between(startDato, slutDato);
        }
        return daysBetween;
    }

    @Override
    public String toString() {
        return "Fad: " + fad + "\n" + destillat + "\n" + "Lagringsperiode: " + getLagringsperiode() + " dage";
    }

}
