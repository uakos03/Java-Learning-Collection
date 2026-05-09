public class GamerLaptop extends Szamitogep {
    private int vgaMemoria;
    private boolean rgbBillentyuzet;
    private static final double KIJELZO_MERET = 15.6;

    public GamerLaptop(int alapAr, String gyarto, boolean rgbBillentyuzet, int vgaMemoria) {
        super(alapAr, gyarto);
        this.rgbBillentyuzet = rgbBillentyuzet;
        this.vgaMemoria = vgaMemoria;
    }
    public GamerLaptop(String gyarto, int alapAr, int vgaMemoria) {
        this(alapAr, gyarto, true, vgaMemoria);
    }

    public boolean isRgbBillentyuzet() {
        return rgbBillentyuzet;
    }

    public void setRgbBillentyuzet(boolean rgbBillentyuzet) {
        this.rgbBillentyuzet = rgbBillentyuzet;
    }

    public int getVgaMemoria() {
        return vgaMemoria;
    }

    public void setVgaMemoria(int vgaMemoria) {
        this.vgaMemoria = vgaMemoria;
    }

    @Override
    public int arKalkulator() {
        int szam = 0;
        if (isRgbBillentyuzet() == true) {
            szam = getAlapAr() + (getVgaMemoria() * 5000);
            szam += 15000;
        } else if (isRgbBillentyuzet() == false) {
            szam = getAlapAr() + (getVgaMemoria() * 5000);
        }
        return szam;
    }
    public String toString() {
        return super.toString() + " vgaMemoria: " + getVgaMemoria() + " rgb: " + isRgbBillentyuzet() + " Kijelzo: " + KIJELZO_MERET + " Végösszeg: " + arKalkulator();
    }
    public static GamerLaptop nagyobbVga (GamerLaptop l1, GamerLaptop l2) {
        if (l1.getVgaMemoria() > l2.getVgaMemoria()) {
            return l1;
        }
        else if (l1.getVgaMemoria() < l2.getVgaMemoria()) {
            return l2;
        }
        else {
            return l1;
        }
    }
}

