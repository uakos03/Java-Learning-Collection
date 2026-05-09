public class Szamitogep {
    private String gyarto;
    private int alapAr;

    public Szamitogep(int alapAr, String gyarto) {
        this.alapAr = alapAr;
        this.gyarto = gyarto;
    }

    public int getAlapAr() {
        return alapAr;
    }

    public String getGyarto() {
        return gyarto;
    }

    public void setGyarto(String gyarto) {
        this.gyarto = gyarto;
    }

    public void setAlapAr(int alapAr) {
        this.alapAr = alapAr;
    }
    public int arKalkulator() {
        return alapAr;
    }

    @Override
    public String toString() {
        return "Gyártó: " + getGyarto() + " Alapár: " + getAlapAr();
    }
}
