public class Mobil {
    private String tipus;
    private int ar;

    public Mobil(String tipus, int ar) {
        this.tipus = tipus;
        this.ar = ar;
    }

    public String getTipus() {
        return tipus;
    }

    public int getAr() {
        return ar;
    }
    public double arErtekArany() {
        return ar;
    }
    @Override
    public String toString(){
        return "Mobil: " + tipus + "Ara: " + ar;
    }
}
