package Szoftverek;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;

public class Szoftver {
    private final String nev;
    private int ar;
    private String[] OS;
    private LocalDate kiadasDatuma;
    private Tipus tipus;

    public enum Tipus {
        IRODAI, JATEK, MEDIA
    }
    public Szoftver(String nev, int ar, String[] OS, LocalDate kiadasDatuma, Tipus tipus) {
        this.nev = nev;
        this.ar = ar;
        this.OS = OS;
        this.kiadasDatuma = kiadasDatuma;
        this.tipus = tipus;
    }
    public Szoftver(String nev, String[] OS) {
        this(nev,
                new Random().nextInt(10001) + 10000,
                OS,
                LocalDate.now(),
                Tipus.IRODAI
        );
    }

    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }

    public LocalDate getKiadasDatuma() {
        return kiadasDatuma;
    }

    public void setKiadasDatuma(LocalDate kiadasDatuma) {
        this.kiadasDatuma = kiadasDatuma;
    }

    public String getNev() {
        return nev;
    }

    public String[] getOS() {
        return OS;
    }

    public void setOS(String[] OS) {
        this.OS = OS;
    }

    public Tipus getTipus() {
        return tipus;
    }

    public void setTipus(Tipus tipus) {
        this.tipus = tipus;
    }

    @Override
    public String toString() {
        return "Szoftver{" +
                "ar=" + ar +
                ", nev='" + nev + '\'' +
                ", OS=" + Arrays.toString(OS) +
                ", kiadasDatuma=" + kiadasDatuma +
                ", tipus=" + tipus +
                '}';
    }
    public static int osszehasonlitas(Szoftver sz1, Szoftver sz2) {
        return Integer.compare(sz1.getAr(), sz2.getAr());
    }
}
