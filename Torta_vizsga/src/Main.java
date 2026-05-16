import Torta.SzulinapiTorta;
import Torta.Torta;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SzulinapiTorta[] sz1 = new SzulinapiTorta[4];
        int ujSzam = ellenorzottBeolvasas();
        sz1[0] = new SzulinapiTorta("Karamellás", Torta.Meret.KICSI, 5);
        sz1[1] = new SzulinapiTorta("Meggyes", Torta.Meret.KÖZEPES, 13);
        sz1[2] = new SzulinapiTorta("Csokis", Torta.Meret.KÖZEPES, 15);
        sz1[3] = new SzulinapiTorta("ErdeiGyumolcs", Torta.Meret.NAGY, 30);
        kiiratas(sz1);
        int maximumIndex = legNagyobbIndex(sz1);
        System.out.println(sz1[maximumIndex]);
        double atlag = atlag(sz1);
        System.out.println("Átlag: " + atlag);
        Arrays.sort(sz1);
        kiiratas(sz1);


    }
    public static int ellenorzottBeolvasas() {
        Scanner sc = new Scanner(System.in);
            boolean sikeres = false;
            int szam=0;
           do {
               try {
                   System.out.println("Add meg a feladat sorszámát!: ");
                   szam = Integer.parseInt(sc.nextLine());
                   if(szam >= 1 && szam <= 6) {
                    sikeres = true;
                   }
               } catch (Exception e) {
                   System.out.println("Hiba: " + e.getMessage());
               }

            } while (!sikeres);
           return  szam;
    }
    public static int legNagyobbIndex(SzulinapiTorta[] tomb) {
        int maxIndex = 0;
        for (int i = 1; i < tomb.length; i++) {
            if (tomb[i].nagyobbAru(tomb[maxIndex])) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
        public static double atlag(SzulinapiTorta[] tomb) {

            double osszeg = 0;
            for (int i = 0; i < tomb.length; i++) {
                osszeg += tomb[i].ar();
            }
            return osszeg / tomb.length;
        }
        public static void kiiratas(SzulinapiTorta[] tomb) {

            for (SzulinapiTorta elem : tomb) {
                System.out.println(elem);
            }
        }
    }
