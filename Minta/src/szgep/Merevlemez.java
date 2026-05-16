package szgep;

public class Merevlemez extends Adathordozo {
    private double foglaltTerulet;

    public Merevlemez (String marka, double kapacitas, double foglaltTerulet){
        super(marka, kapacitas);
        this.foglaltTerulet = foglaltTerulet;
    }

    public double getFoglaltTerulet() {
        return foglaltTerulet;
    }
    @Override
    public double mennyiSzabad() {
        return getKapacitas() - getFoglaltTerulet();
    }
    @Override
    public String toString() {
        return "Márka: " + getMarka() + " Kapacitás: " + getKapacitas() + "GB" + " Foglalt: " + getFoglaltTerulet() +
                " GB" + " Szabad: " + mennyiSzabad() + " GB";
    }
    public boolean többSzabad(Merevlemez masik) {
        return this.mennyiSzabad() > masik.mennyiSzabad();
    }
    public static Merevlemez nagyobbKapacitas(Merevlemez m1, Merevlemez m2) {
        if(m1.getKapacitas() > m2.getKapacitas()) {
            return m1;

        }
        else {
            return m2;
        }
    }
}
