package szgep.teszt;
import szgep.*;

import java.util.Scanner;

public class Taroloteszt {
    public static void main(String[] args) {
            Merevlemez[] m1 = new Merevlemez[5];
            ellenorzottBeolvasas(m1);
            legnagyobbKapacitas(m1);
            int szamlalo = szamlalOssz(m1);
            System.out.println(szamlalo);
    }

    private static void ellenorzottBeolvasas(Merevlemez[] tomb) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < tomb.length; i++) {
            boolean sikeres = false;
            while (!sikeres) {
                try {

                    String nev;
                    do {
                        System.out.println("Add meg a márkát: ");
                        nev = sc.nextLine();
                    } while (nev == null || nev.isBlank());

                    double kapacitas;
                    do {
                        System.out.println("Kapacitas: ");
                        kapacitas = Double.parseDouble(sc.nextLine());
                        if (kapacitas <= 0) {
                            System.out.println("Kapacitas hibas!");
                        }
                    } while(kapacitas < 0);

                    double foglalt;
                    do {
                        System.out.println("Foglalt terulet: ");
                        foglalt = Double.parseDouble(sc.nextLine());
                        if ( foglalt < 0 || foglalt > kapacitas) {
                            System.out.println("Foglalt terulet hiba!");
                        }
                    } while ( foglalt < 0 || foglalt > kapacitas);
                    tomb[i] = new Merevlemez(nev, kapacitas, foglalt);

                    sikeres = true;

                } catch (Exception e) {
                    System.out.println("Hiba az adatok megadásakor");
                }
            }
        }
    }
    public static void kiIratas(Merevlemez[] tomb) {
        for (Merevlemez m : tomb) {
            System.out.println(m);
        }
    }
    private static void legnagyobbKapacitas(Merevlemez[] tomb) {
        Merevlemez legnagyobb = tomb[0];
        for (Merevlemez m : tomb) {
            legnagyobb = Merevlemez.nagyobbKapacitas(legnagyobb, m);
        }
        System.out.println(legnagyobb);
    }
    private static int szamlalOssz(Merevlemez[] tomb) {
        int szamlal = 0;
        for (Merevlemez m : tomb) {
            if(m.getSzabadhely() > m.getFoglaltTerulet()) {
                szamlal++;
            }
        }
        return szamlal;
    }

}