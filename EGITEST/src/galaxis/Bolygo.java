package galaxis;

public class Bolygo extends Egitest {
    private float keringesIdo;
    private int atmero;

    public Bolygo (String nev, float keringesIdo, int atmero) {
        super(nev);
        this.keringesIdo = keringesIdo;
        this.atmero = atmero;
    }

    public int getAtmero() {
        return atmero;
    }

    public float getKeringesIdo() {
        return keringesIdo;
    }

    @Override
    public String toString() {
        return "Név: " + getNev() + " Keringesi ido: " + getKeringesIdo() + " év" + " Atmero: " + getAtmero() + " km ";
    }
    public static Bolygo rovidebbKeringesIdeju(Bolygo b1, Bolygo b2) {
        if(b1.getKeringesIdo() < b2.getKeringesIdo()) {
            return b1;
        } else if (b2.getKeringesIdo() < b1.getKeringesIdo()) {
            return b2;
        }
        else {
            return b1;
        }
    }

    @Override
    public float tomegAtvaltas(int tomeg) {
        float konstans;
        switch (getNev().toUpperCase()) {
            case "VÉNUSZ":
                konstans = 0.78F;
                break;
            case "MARS":
                konstans = 0.39F;
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
            default:
                konstans = 1.0f;
                break;
        }
        return tomeg * konstans;
    }
}
