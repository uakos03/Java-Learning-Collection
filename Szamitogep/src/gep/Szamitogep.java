package gep;

public abstract class Szamitogep {
    private String marka;
    private int alapAr;

    public Szamitogep(String marka, int alapAr) {
        this.marka = marka;
        this.alapAr = alapAr;
    }

    public int getAlapAr() {
        return alapAr;
    }

    public String getMarka() {
        return marka;
    }
    public String toString() {
        return "Márka: " + getMarka() + " Alap ára: " + getAlapAr() + " Ft";
    }
    public abstract float szamitottAr();
}
