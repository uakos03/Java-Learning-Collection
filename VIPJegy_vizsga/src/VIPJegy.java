import java.time.LocalDate;

public class VIPJegy {
    private String tulajdonos;
    private int ar;
    private LocalDate vasarlasDatuma;
    private String jegykod;

    public VIPJegy (String tulajdonos, int ar, LocalDate vasarlasDatuma) {
        this.tulajdonos = tulajdonos;
        this.ar = ar;
        this.vasarlasDatuma = vasarlasDatuma;
        jegykod = "VIP" + (int) (Math.random() * 9000) + 1000;
    }

    public int getAr() {
        return ar;
    }

    public void setAr(int ar) throws GyanusArException {
        if (ar < 15000) {
            throw new GyanusArException("Túl olcsó a VIP jegyhez!");
        }
        this.ar = ar;
    }

    public String getJegykod() {
        return jegykod;
    }

    public void setJegykod(String jegykod) {
        this.jegykod = jegykod;
    }

    public String getTulajdonos() {
        return tulajdonos;
    }

    public void setTulajdonos(String tulajdonos) {
        this.tulajdonos = tulajdonos;
    }

    public LocalDate getVasarlasDatuma() {
        return vasarlasDatuma;
    }

    public void setVasarlasDatuma(LocalDate vasarlasDatuma) {
        this.vasarlasDatuma = vasarlasDatuma;
    }

    @Override
    public String toString() {
        return "VIPJegy{" +
                "ar=" + ar +
                ", tulajdonos='" + tulajdonos + '\'' +
                ", vasarlasDatuma=" + vasarlasDatuma +
                ", jegykod='" + jegykod + '\'' +
                '}';
    }
}
