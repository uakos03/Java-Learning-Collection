import java.time.LocalDate;

public class Sajt extends Tejtermek {
    private double tomeg;
    private Tipus tipus;
    private double zsirtartalom;
    private int eladasiAr;


    public enum Tipus {
        DARABOLT, SZELETELT, OMLESZTETT
    }
    public Sajt(int egysegAr, String marka, LocalDate gyartasIdo, double tomeg, Tipus tipus, double zsirtartalom) {
        super(egysegAr, marka, gyartasIdo);
        this.tomeg = tomeg;
        this.tipus = tipus;
        this.zsirtartalom = zsirtartalom;
        eladasiAr = eladasiAr();
    }
    @Override
    public int eladasiAr() {
        double szorzo;
        if(tipus == Tipus.DARABOLT) {
            return (int) (getEgysegAr()*tomeg*(zsirtartalom/21*1));
        } else if(tipus == Tipus.SZELETELT) {
            return (int) (getEgysegAr()*tomeg*(zsirtartalom/21*1.2));
        } else if(tipus == Tipus.OMLESZTETT) {
            return (int) (getEgysegAr()*tomeg*(zsirtartalom/21*1.4));
        }
        else {
            return 0;
        }
    }
    public Sajt(int egysegAr,String marka, double tomeg, Tipus tipus) {
        this(egysegAr,
                marka,
                LocalDate.now(),
                tomeg,
                tipus,
                21);
    }

    public void setEladasiAr(int eladasiAr) {
        this.eladasiAr = eladasiAr;
    }

    public Tipus getTipus() {
        return tipus;
    }

    public void setTipus(Tipus tipus) {
        this.tipus = tipus;
    }

    public double getTomeg() {
        return tomeg;
    }

    public void setTomeg(double tomeg) {
        this.tomeg = tomeg;
    }

    public double getZsirtartalom() {
        return zsirtartalom;
    }

    public void setZsirtartalom(double zsirtartalom) {
        this.zsirtartalom = zsirtartalom;
    }
    @Override
    public String toString() {
        return "Ár: " + getEgysegAr() + "Márka: " + getMarka() + " Gyártási idő_ " + getGyartasIdo() +
                " Lejárati idő: " + getLejaratIdo() + " Ehető-e: " + ehetoE() + getTomeg() + getTipus() + getZsirtartalom() + eladasiAr;
    }
}
