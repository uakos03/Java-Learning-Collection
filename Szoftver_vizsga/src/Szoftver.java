import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;

public class Szoftver {
    private final String nev;
    private int ar;
    private String[] tamogatottOS;
    private LocalDate date;



    //torolt
    

    private Tipus tipus;

    public enum Tipus {
        IRODAI, JATEK, MEDIA
    }


    public Szoftver(String nev, int ar, Tipus tipus, String[] tamogatottOS, LocalDate date) {
        this.nev = nev;
        this.ar = ar;
        this.tipus = tipus;
        this.tamogatottOS = tamogatottOS;
        this.date = date;
    }


    public Szoftver(String nev, String[] tamogatottOS) {
        this(
                nev,
                new Random().nextInt(10001) + 10000,
                Tipus.IRODAI,
                tamogatottOS,
                LocalDate.now()
        );
    }

    public String getNev() {
        return nev;
    }

    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }

    public String[] getTamogatottOS() {
        return tamogatottOS;
    }

    public void setTamogatottOS(String[] tamogatottOS) {
        this.tamogatottOS = tamogatottOS;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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
                "nev='" + nev + '\'' +
                ", ar=" + ar +
                ", tamogatottOS=" + Arrays.toString(tamogatottOS) +
                ", date=" + date +
                ", tipus=" + tipus +
                '}';
    }

}