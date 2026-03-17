public class OkosMobil extends Mobil {
    private static final String OP_RENDSZER = "Android";
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

    public String getOpRendszer() {
        return OP_RENDSZER;
    }

    public int getMemoria() {
        return memoria;
    }

    public int getMagokSzama() {
        return magokSzama;
    }

    @Override
    public double arErtekArany() {
        return (double) getAr() / (memoria * magokSzama);
    }

    @Override
    public String toString() {
        return super.toString() + "Op rendszer: " + OP_RENDSZER + "memoria: " + memoria + "Magok: " + magokSzama + "ar ertek arany: " + arErtekArany();
    }

    public static OkosMobil nagyobbArErtekAranyu(OkosMobil o1, OkosMobil o2) {
        if (o1.arErtekArany() > o2.arErtekArany()) {
            return o1;
        } else {
            return o2;
        }
    }
}
