package gep;

public class Laptop extends Szamitogep {
    private int memoria;
    private int tarhely;
    private static final String OS = "Windows 11";

    public Laptop(String marka, int alapAr, int memoria, int tarhely) {
        super(marka, alapAr);
        this.memoria = memoria;
        this.tarhely = tarhely;
    }
    public Laptop(String marka, int alapAr, int memoria) {
        this(marka, alapAr, memoria, 512);
    }

    public int getMemoria() {
        return memoria;
    }

    public int getTarhely() {
        return tarhely;
    }
    public String getOs() {
        return OS;
    }
    @Override
    public float szamitottAr() {
        float konstans;
        switch (getMarka().toUpperCase()) {
            case "APPLE":
                konstans = 1.5f;
                break;
            case "DELL":
                konstans = 1.2f;
                break;
            case "LENOVO":
                konstans = 1.1f;
                break;
            default:
                konstans = 1.0f;
                break;
        }
        return getAlapAr() * konstans;
    }
    public String toString() {
        return super.toString() + " Memória: " + getMemoria() + " Tárhely: " + getTarhely() + " GB " + " OS: " + getOs() + " Számított ár: " + szamitottAr();
    }
    public static Laptop nagyobbSzamitottAr(Laptop l1, Laptop l2) {
        if(l1.szamitottAr() > l2.szamitottAr()) {
            return l1;
        } else if (l1.szamitottAr() < l2.szamitottAr()) {
            return l2;
        } else {
            return l1;
        }
    }
}
