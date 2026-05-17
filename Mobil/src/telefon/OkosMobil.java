package telefon;

public class OkosMobil extends Mobil {
    private static final String OS = "Andorid";
    private int memoria;
    private int magokSzama;

    public OkosMobil(String tipus, int ar, int memoria, int magokSzama) {
        super(tipus, ar);
        this.memoria = memoria;
        this.magokSzama = magokSzama;
    }

    public OkosMobil(String tipus, int ar, int memoria) {
        this(tipus, ar, memoria, 8);
    }

    public int getMagokSzama() {
        return magokSzama;
    }

    public int getMemoria() {
        return memoria;
    }

    public static String getOs() {
        return OS;
    }

    @Override
    public double arErtekArany() {
        return (double) getAr() / (getMemoria() * getMagokSzama());
    }
    public String toString() {
        return super.toString() + " OS: " + getOs() + " Memória: " + getMemoria() + " Magok száma: " + getMagokSzama() + " Ár érték arány: " + arErtekArany();
    }

    public static OkosMobil nagyobbArErtek(OkosMobil m1, OkosMobil m2) {
        if (m1.arErtekArany() > m2.arErtekArany()) {
            return m1;
        } else if (m1.arErtekArany() < m2.arErtekArany()) {
            return m2;
        }
        return m1;
    }
}
