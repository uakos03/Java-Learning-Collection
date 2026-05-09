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

    public void setAr(int ar) {
        this.ar = ar;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }
    public abstract double arErtekarany();

    @Override
    public String toString() {
        return "Típus: " + getTipus() + " Ára: " + getAr();
    }
}
