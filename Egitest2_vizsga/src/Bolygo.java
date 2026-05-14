public class Bolygo extends Egitest {
    private float keringesiido;
    private int atmero;

    public Bolygo (String nev, float keringesiido, int atmero){
        super(nev);
        this.keringesiido = keringesiido;
        this.atmero = atmero;
    }

    public int getAtmero() {
        return atmero;
    }

    public float getKeringesiido() {
        return keringesiido;
    }
    @Override
    public String toString() {
        return "Adatok: " + "Név: " + getNev() + "Keringési idő: " + getKeringesiido() + "Átmérő: " + getAtmero();
    }
    public static Bolygo rovidebbKeringesiIdeju(Bolygo b1, Bolygo b2) {
        if (b1.getKeringesiido() < b2.getKeringesiido()) {
            return b1;
        } else if (b2.getKeringesiido() < b1.getKeringesiido()) {
            return b2;
        }
        else {
            return null;
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
                    konstans = 1.0f;
                    break;
            }

            return tomeg * konstans;
        }
}
