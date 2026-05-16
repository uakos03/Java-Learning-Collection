package Torta;

public class SzulinapiTorta extends Torta implements Comparable<SzulinapiTorta> {
    private int gyertyakSzama;

    public SzulinapiTorta(String iz, Meret meret, int gyertyakSzama) {
        super(iz, meret);
        this.gyertyakSzama = gyertyakSzama;
    }

    public SzulinapiTorta(String iz, int gyertyakSzama) {
        this(iz, Meret.NAGY,gyertyakSzama);
    }

    public int getGyertyakSzama() {
        return gyertyakSzama;
    }

    public int ar() {
        return (getSzeletekSzama() * 450) + (getGyertyakSzama() * 50);
    }

    @Override
    public String toString() {
        return "Torta{" +
                "iz='" + getIz() + '\'' +
                ", szeletekSzama=" + getSzeletekSzama() +
                ", meret=" + getMeret() + "Gyertyák: " + getGyertyakSzama() + "Ár: " + ar() +
                '}';
    }
    public boolean nagyobbAru(SzulinapiTorta masik) {
        return this.ar() > masik.ar();
    }
    @Override
    public int compareTo(SzulinapiTorta masik) {
        return Integer.compare(this.gyertyakSzama, masik.gyertyakSzama);
    }
}
