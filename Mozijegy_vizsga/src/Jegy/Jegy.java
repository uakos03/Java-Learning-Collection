package Jegy;

import java.time.LocalDate;

public abstract class Jegy {
    private LocalDate datum;
    private Kedvezmeny kedvezmeny;

    public enum Kedvezmeny {
        DIAK, NYUGDIJAS, TELJESARU
    }

    public Jegy(LocalDate datum, Kedvezmeny kedvezmeny) {
        this.datum = datum;
        this.kedvezmeny = kedvezmeny;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public Kedvezmeny getKedvezmeny() {
        return kedvezmeny;
    }

    public void setKedvezmeny(Kedvezmeny kedvezmeny) {
        this.kedvezmeny = kedvezmeny;
    }
    public abstract int jegyarSzamitas();

    @Override
    public String toString() {
        return "Jegy{" +
                "datum=" + datum +
                ", kedvezmeny=" + kedvezmeny +
                '}';
    }
}
