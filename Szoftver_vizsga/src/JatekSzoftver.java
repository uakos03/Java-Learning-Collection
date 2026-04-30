import java.time.LocalDate;

public class JatekSzoftver extends Szoftver {
    private int korhatar;
    private String name;
    private int id;

    



    public JatekSzoftver(String nev, int ar, Tipus tipus, String[] tamogatottOS, LocalDate date, int korhatar) {
        super(nev, ar, tipus, tamogatottOS, date);
        this.korhatar = korhatar;
    }

    public JatekSzoftver(String nev, String[] tamogatottOS, int korhatar) {
        super(nev, tamogatottOS);
        this.korhatar = korhatar;
    }
}
