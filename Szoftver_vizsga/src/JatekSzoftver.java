import java.time.LocalDate;

public class JatekSzoftver extends Szoftver {
    private int korhatar;

    public JatekSzoftver(String nev, int ar, Tipus tipus, String[] tamogatottOS, LocalDate date, int korhatar) {
        super(nev,
                ar,
                Tipus.JATEK,
                tamogatottOS,
                LocalDate.now().withYear(LocalDate.now().getYear() -1 ));
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
        return "JatekSzoftver adatai: " + super.toString() +
                "korhatar=" + korhatar +
                '}';
    }
}