package Szoftverek;

import java.time.LocalDate;
import java.util.Arrays;

public class JatekSzoftver extends Szoftver{
    private int korhatar;

    public JatekSzoftver(String nev, int ar, String[] OS, int korhatar) {
        super(nev, ar, OS,LocalDate.now().minusYears(1), Tipus.JATEK);
        this.korhatar = korhatar;
    }

    public int getKorhatar() {
        return korhatar;
    }

    public void setKorhatar(int korhatar) {
        this.korhatar = korhatar;
    }

    @Override
    public String toString() {
        return "Szoftver{" +
                "ar=" + getAr() +
                ", nev='" + getNev() + '\'' +
                ", OS=" + Arrays.toString(getOS()) +
                ", kiadasDatuma=" + getKiadasDatuma() +
                ", tipus=" + getTipus() + "Korhatár: " + getKorhatar() +
                '}';
    }
}
