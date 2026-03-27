package galaxis;

public class Bolygo extends Egitest {
    private float keringesIdo;
    private int atmero;
    private int hossz;

//Konstruktor
    public Bolygo(String nev, float keringesIdo, int atmero){
        super(nev);
        this.keringesIdo = keringesIdo;
        this.atmero = atmero;
    }
//dezkelll!! /iiigy


    public float getKeringesIdo() {
        return keringesIdo;
    }
    public int getAtmero() {
        return atmero;
    }
    public String toString(){
        return "Bolygo neve: " + getNev() + " Keringesi ideje: " + getKeringesIdo() + " Atmeroje: " + getAtmero();
    }
}








