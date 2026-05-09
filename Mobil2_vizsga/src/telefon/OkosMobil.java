package telefon;

public class OkosMobil extends Mobil {
    private static String OS = "ANDROID";
    private int memoria;
    private int magokSzama;

    public OkosMobil(String tipus, int ar, int memoria, int magokSzama) {
        super(tipus, ar);
        this.memoria = memoria;
        this.magokSzama = magokSzama;
    }
    public OkosMobil(String tipus, int ar, int memoria) {
        this(tipus,
                ar,
                memoria,
                8);
    }

    public int getMagokSzama() {
        return magokSzama;
    }

    public void setMagokSzama(int magokSzama) {
        this.magokSzama = magokSzama;
    }

    public int getMemoria() {
        return memoria;
    }

    public void setMemoria(int memoria) {
        this.memoria = memoria;
    }

    public static String getOS() {
        return OS;
    }

    @Override
    public double arErtekarany(){
        return (double) getAr() / (getMemoria() * getMagokSzama());
    }
    @Override
    public String toString() {
        return super.toString() + "OS: " + getOS() + "Memória: " + getMemoria() + "Magok száma: " + getMagokSzama();
    }

    public static OkosMobil nagyobbarertekAranyu(OkosMobil m1, OkosMobil m2) {
        if (m1.arErtekarany() > m2.arErtekarany()) {
            return m1;
        } else
            return m2;
    }
}

