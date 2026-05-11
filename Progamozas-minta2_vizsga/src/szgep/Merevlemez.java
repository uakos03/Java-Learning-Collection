package szgep;

public class Merevlemez extends Adathordozo {
    private double foglaltTerulet;

    public Merevlemez(String tipus, double kapacitas, double foglaltTerulet) {
        super(tipus, kapacitas);
        this.foglaltTerulet = foglaltTerulet;
    }

    public double getFoglaltTerulet() {
        return foglaltTerulet;
    }
    @Override
    public double getSzabadhely() {
        return getKapacitas() - getFoglaltTerulet();
    }
    @Override
    public String toString() {
        return "Tipus: " + getTipus() + "Kapacitas: " + getKapacitas() + "FoglaltTerulet: " + getFoglaltTerulet() + "Szabadterület: " + getSzabadhely();
    }
        public boolean tobbSzabadhely(Merevlemez masik) {
            return this.getSzabadhely() > masik.getSzabadhely();
        }
        public static Merevlemez nagyobbKapacitas(Merevlemez m1, Merevlemez m2) {
            if (m1.getKapacitas() > m2.getKapacitas()) {
                return m1;
            } else {
                return m2;
            }
        }

}
