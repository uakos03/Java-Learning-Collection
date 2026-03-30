package galaxis;

public class Bolygo extends Egitest {
    private float keringesIdo;
    private int atmero;


    public Bolygo(String nev, float keringesIdo, int atmero){
        super(nev);
        this.keringesIdo = keringesIdo;
        this.atmero = atmero;
    }


    public float getKeringesIdo() {
        return keringesIdo;
    }
    public int getAtmero() {
        return atmero;
    }
    @Override
    public String toString(){
        return "Bolygo neve: " + getNev() + " Keringesi ideje: " + getKeringesIdo() + " Atmeroje: " + getAtmero();
    }
    public static Bolygo rovidebbKeringesIdeju(Bolygo b1, Bolygo b2) {
        if (b1.getKeringesIdo() < b2.getKeringesIdo()) {
            return b1;
        }else {
            return b2;
        }
    }
    @Override
    public float tomegAtvaltas(int tomeg) {
        float konstans;
        switch (getNev().toUpperCase()) {
            case "VÉNUSZ":
                konstans = 0.78f;
                break;
            case "MARS":
                konstans = 0.39f;
                break;
            case "JUPITER":
                konstans = 2.65f;
                break;
            case "SZATURNUSZ":
                konstans = 1.17f;
                break;
            case "URÁNUSZ":
                konstans = 1.05f;
                break;
            case "NEPTUNUSZ":
                konstans = 1.23f;
                break;
            default:
                konstans = 1.0f; // Föld vagy ismeretlen bolygó esetén
                break;
        }

        return tomeg * konstans;
    }
}














