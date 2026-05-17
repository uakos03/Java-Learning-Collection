package telefon;

public abstract class Mobil {
    private String tipus;
    private int ar;

    public Mobil(String tipus, int ar) {
        this.tipus = tipus;
        this.ar = ar;
    }

    public int getAr() {
        return ar;
    }

    public String getTipus() {
        return tipus;
    }
    public String toString() {
        return "Típus: " + getTipus() + " Ára: " + getAr() + " Ft ";
    }
    public abstract double arErtekArany();
}
