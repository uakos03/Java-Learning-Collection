import java.time.LocalDate;

public class JatekSzoftver extends Szoftver {
    private int korhatar;

    public JatekSzoftver(String nev, int ar, String[] tamogatottOS, int korhatar) {
        super(nev,
                ar,
                Tipus.JATEK, // Ezt fixen bedrótoztad, így nem kell paraméterként kérni
                tamogatottOS,
                LocalDate.now().withYear(LocalDate.now().getYear() - 1)); // Ezt is kiszámolja, nem kell bekérni
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