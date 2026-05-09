package telefon.teszt;
import telefon.*;

import java.util.Scanner;

public class Mobilteszt {
    public static void main(String[] args) {
        OkosMobil[] m1 = new OkosMobil[4];

        ellenorzottBeolvasas(m1);

        kiListzas(m1);

        OkosMobil nagyobb = OkosMobil.nagyobbarertekAranyu(m1[0], m1[1]);
        System.out.println(nagyobb);

        double atlagAr = atlagAr(m1);
        System.out.println(atlagAr);

    }
    public static void ellenorzottBeolvasas (OkosMobil[] tomb) {
        Scanner scanner = new Scanner(System.in);
        for (int i=0; i< tomb.length; i++) {
            boolean sikeres = false;
            while(!sikeres) {
                try {
                    System.out.println("Add meg a(z)" + (i+1) + ". adatait!");

                    System.out.println("Típus: ");
                    String nev = scanner.nextLine();

                    int ar;
                    do {
                        System.out.println("Add meg az árát: ");
                        ar = Integer.parseInt(scanner.nextLine());
                        if (ar <= 0) {
                            System.out.println("Hiba, az ár nem lehet 0 vagy kisebb!");
                        }
                    } while( ar <= 0);

                    int memoria;
                    do {
                        System.out.println("Add meg a memóriát: ");
                        memoria = Integer.parseInt(scanner.nextLine());
                        if (memoria <= 0) {
                            System.out.println("Hiba, a memória nem lehet 0 vagy kisebb!");
                        }
                    } while( memoria <= 0);

                    int magokSzama=0;
                    if (i < 2) {
                        do {
                            System.out.println("Add meg a magok számát: ");
                            magokSzama = Integer.parseInt(scanner.nextLine());
                            if (magokSzama <= 0) {
                                System.out.println("Hiba, az ár nem lehet 0 vagy kisebb!");
                            }
                        } while (magokSzama <= 0);
                    }

                    if (i > 1) {
                        tomb[i] = new OkosMobil(nev, ar, memoria);
                    } else {
                        tomb[i] = new OkosMobil(nev, ar,memoria,magokSzama);
                    }
                    sikeres = true;

                } catch (Exception e) {
                    System.out.println("Hiba a megadott paraméterrel!");
                }
            }
        }
    }
    public static void kiListzas(OkosMobil[] tomb) {
        for(OkosMobil mobil : tomb) {
            System.out.println(mobil);
        }
    }
    public static double atlagAr(OkosMobil[] tomb) {
        double atlag = 0;
        for(int i=0; i< tomb.length; i++) {
            atlag += tomb[i].getAr();
        }
        return atlag/tomb.length;
    }
}