import java.time.LocalDate;

public abstract class Tejtermek {
    private int egysegAr;
    private String marka;
    private LocalDate gyartasIdo;
    private LocalDate lejaratIdo;

    public Tejtermek( int egysegAr, String marka, LocalDate gyartasIdo) {
        this.egysegAr = egysegAr;
        this.marka = marka;
        this.gyartasIdo = gyartasIdo;
        lejaratIdo = gyartasIdo.plusDays(7);
    }
    public final boolean ehetoE() {
        if(lejaratIdo.isAfter(LocalDate.now())) {
            return true;
        } else {
            return false;
        }
    }

    public int getEgysegAr() {
        return egysegAr;
    }

    public void setEgysegAr(int egysegAr) {
        this.egysegAr = egysegAr;
    }

    public LocalDate getGyartasIdo() {
        return gyartasIdo;
    }

    public void setGyartasIdo(LocalDate gyartasIdo) {
        this.gyartasIdo = gyartasIdo;
    }

    public LocalDate getLejaratIdo() {
        return lejaratIdo;
    }

    public void setLejaratIdo(LocalDate lejaratIdo) {
        this.lejaratIdo = lejaratIdo;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }
    public String toString() {
        return "Ár: " + getEgysegAr() + "Márka: " + getMarka() + " Gyártási idő_ " + getGyartasIdo() +
                " Lejárati idő: " + getLejaratIdo() + " Ehető-e: " + ehetoE();
    }
    public abstract int eladasiAr();
}
