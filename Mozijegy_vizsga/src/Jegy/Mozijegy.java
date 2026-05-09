package Jegy;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;

public class Mozijegy extends Jegy {
    private String filmcim;
    private int alapar;
    private int[] hely;

    public Mozijegy(String filmcim, int[] hely, LocalDate datum, Kedvezmeny kedvezmeny) {
        super(datum, kedvezmeny);
        this.alapar = new Random().nextInt(1001) + 1000;
        this.filmcim = filmcim;
        this.hely = hely;
    }
    public Mozijegy(String filmcim, int[] hely) {
        this(filmcim,
                hely,
                LocalDate.now(),
                Kedvezmeny.TELJESARU
        );
    }

    public int getAlapar() {
        return alapar;
    }

    public void setAlapar(int alapar) {
        this.alapar = alapar;
    }

    public String getFilmcim() {
        return filmcim;
    }

    public void setFilmcim(String filmcim) {
        this.filmcim = filmcim;
    }

    public int[] getHely() {
        return hely;
    }

    public void setHely(int[] hely) {
        this.hely = hely;
    }

    @Override
    public int jegyarSzamitas() {
        double kedvezmenyszorzo = 1.0;

        if(getKedvezmeny() == Kedvezmeny.DIAK) {
            kedvezmenyszorzo = 0.5;
        } else if (getKedvezmeny() == Kedvezmeny.NYUGDIJAS) {
            kedvezmenyszorzo = 0.8;
        }
        double kalk = getAlapar() * kedvezmenyszorzo;

        double hetfoiKedvezmeny = 0;
        if(getDatum().getDayOfWeek().name().equals("MONDAY")) {
            hetfoiKedvezmeny = kalk * 0.1;
        }
        double vegsoAr = kalk - hetfoiKedvezmeny;
        return (int) vegsoAr;
    }

    @Override
    public String toString() {
        return "Jegy{\" +\n" +
                "                \"datum=\" + datum +\n" +
                "                \", kedvezmeny=\" + kedvezmeny +\n" +
                "                '}';Mozijegy{" +
                "alapar=" + alapar +
                ", filmcim='" + filmcim + '\'' +
                ", hely=" + Arrays.toString(hely) +
                '}' + "Kedvezmény: " + jegyarSzamitas();
    }
}
