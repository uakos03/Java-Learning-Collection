package telefon.teszt;
import telefon.*;

import java.util.Scanner;

public class Mobilteszt {
    public static void main(String[] args) {
        OkosMobil[] m1 = new OkosMobil[4];
        ellenorzottBeolvasas(m1);
        kiiratas(m1);
        OkosMobil nagyobb = OkosMobil.nagyobbArErtek(m1[0], m1[1]);
        System.out.println("Nagyobb árértékű telefon: " +nagyobb);
        double atlag = atlag(m1);
        System.out.println("Telefonok átlag ára: " + atlag + " FT");

    }
    public static void ellenorzottBeolvasas(OkosMobil[] tomb) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < tomb.length; i++) {
            boolean sikeres = false;
            while (!sikeres) {
                try {
                    System.out.println((i + 1) + ". OkosMobil adatainak megadása");

                    String tipus;
                    do {
                        System.out.print("Add meg a típust!: ");
                        tipus = sc.nextLine();
                    } while (tipus == null || tipus.isBlank());

                    int ar;
                    do {
                        System.out.print("Add meg az árat: ");
                        ar = Integer.parseInt(sc.nextLine());
                        if (ar <= 0) {
                            System.out.println("Hibás ertek! Nem lehet 0 vagy negatív!");
                        }
                    } while (ar <= 0);

                    int memoria;
                    do {
                        System.out.print("Add meg az memoriat: ");
                        memoria = Integer.parseInt(sc.nextLine());
                        if (memoria <= 0) {
                            System.out.println("Hibás ertek! Nem lehet 0 vagy negatív!");
                        }
                    } while (memoria <= 0);

                    if (i<2) {
                        int magokSzama;
                        do {
                            System.out.print("Add meg a magok számát: ");
                            magokSzama = Integer.parseInt(sc.nextLine());
                            if (magokSzama <= 0) {
                                System.out.println("Hibás ertek! Nem lehet 0 vagy negatív!");
                            }
                        } while (magokSzama <= 0);
                        tomb[i] = new OkosMobil(tipus,ar,memoria,magokSzama);
                    } else {
                        tomb[i] = new OkosMobil(tipus,ar,memoria);
                    }
                    sikeres = true;
                } catch (Exception e) {
                    System.out.println("Hiba!: " + e.getMessage());
                }
            }
        }
    }
    public static void kiiratas(OkosMobil[] tomb) {
        for (OkosMobil elem : tomb) {
            System.out.println(elem);
        }
    }
    public static double atlag(OkosMobil[] tomb) {
        double osszeg = 0;
        for (OkosMobil okosMobil : tomb) {
            osszeg += okosMobil.getAr();
        }
        return osszeg / tomb.length;
    }
}
