package szgep;

public class Merevlemez extends Adathordozo implements Comparable<Merevlemez> { //comparable a listahoz

    private double foglaltTerulet;

    public Merevlemez(String marka, double kapacitas, double foglaltTerulet) {
        super(marka, kapacitas);
        this.foglaltTerulet = foglaltTerulet;
    }

    public double getFoglaltTerulet() {
        return foglaltTerulet;
    }
    @Override
    public double getSzabadhely(){
        return getKapacitas() - getFoglaltTerulet();
    }
    @Override
    public String toString(){
        return "Típus: " + getMarka() + " Kapacitás: " + getKapacitas() + " Foglalt terület: " + getFoglaltTerulet() + " Szabadhely: " + getSzabadhely();
    }
    public boolean tobbSzabadhely(Merevlemez masik) {
        return this.getSzabadhely() > masik.getSzabadhely();
    }
    public static Merevlemez nagyobbKapacitas(Merevlemez m1, Merevlemez m2){
        return (m1.getKapacitas()) >= m2.getKapacitas() ? m1 : m2;
    }

    //compare implementálása
    @Override
    public int compareTo(Merevlemez masik) {
        return Double.compare(this.getSzabadhely(), masik.getSzabadhely());
    }
}
