package Torta;

public abstract class Torta {
    private int szeletekSzama;
    private String iz;
    private Meret meret;

    public enum Meret {
        KICSI, KÖZEPES, NAGY
    }
    public Torta(String iz, Meret meret) {
        this.iz = iz;
        this.meret = meret;
        if(meret == Meret.NAGY) {
            this.szeletekSzama = 20;
        } else if (meret == Meret.KÖZEPES) {
            this.szeletekSzama = 16;
        } else if (meret == Meret.KICSI) {
            this.szeletekSzama = 8;
        }
    }

    public String getIz() {
        return iz;
    }

    public void setIz(String iz) {
        this.iz = iz;
    }

    public Meret getMeret() {
        return meret;
    }

    public void setMeret(Meret meret) {
        this.meret = meret;
    }

    public int getSzeletekSzama() {
        return szeletekSzama;
    }

    public void setSzeletekSzama(int szeletekSzama) {
        this.szeletekSzama = szeletekSzama;
    }

    @Override
    public String toString() {
        return "Torta{" +
                "iz='" + iz + '\'' +
                ", szeletekSzama=" + szeletekSzama +
                ", meret=" + meret +
                '}';
    }
    public abstract int ar();
}
