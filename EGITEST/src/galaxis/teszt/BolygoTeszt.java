package galaxis.teszt;
import galaxis.*;

import java.util.Random;
import java.util.Scanner;

public class BolygoTeszt {
    public static void main(String[] args) {
        Bolygo[] b1 = new Bolygo[8];
        ellenorzottBeolvasas(b1);
        kiiratas(b1);
        int redivideFold = mennyinekRovidebbFold(b1);
        System.out.println("Ennyi bolygónak rövidebb a keringési ideje a földnél: " + redivideFold);
        randomTomeg(b1);


    }
    public static void ellenorzottBeolvasas(Bolygo[] tomb) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < tomb.length; i++) {
            boolean sikeres = false;
            while (!sikeres) {
                try {
                    System.out.println((i + 1) + ". Bolygo adatainak megadása:");

                    String nev;
                    do {
                        System.out.print("Add meg a bolygó nevét: ");
                        nev = sc.nextLine().toUpperCase();
                    } while (nev.isBlank());

                    float keringes;
                    do {
                        System.out.print("Add meg a keringési időt: ");
                        keringes = Float.parseFloat(sc.nextLine());
                        if (keringes <= 0) {
                            System.out.println("Hibás érték! Nem lehet negatív.");
                        }
                    } while (keringes <= 0);

                    int atmero;
                    do {
                        System.out.println("Add meg az átmérőt: ");
                        atmero = Integer.parseInt(sc.nextLine());
                        if (atmero <= 0) {
                            System.out.println("Az átmérő nem lehet 0 vagy negatív!");
                        }
                    } while (atmero <= 0);

                    tomb[i] = new Bolygo(nev,keringes,atmero);

                    sikeres = true;

                } catch (Exception e) {
                    System.out.println("Hiba: " + e.getMessage());
                }
            }
        }
    }
    public static void kiiratas(Bolygo[] tomb) {
        for (Bolygo elem : tomb) {
            System.out.println(elem);
        }
    }
    public static int mennyinekRovidebbFold(Bolygo[] tomb) {
        Bolygo fold = null;
        int db = 0;
        for (Bolygo value : tomb) {
            if (value != null && value.getNev().equals("FÖLD")) {
                fold = value;
                break;
            }
        }
        if (fold !=null) {
            for (Bolygo bolygo : tomb) {
                if (bolygo != null && !bolygo.getNev().equals("FÖLD")) {
                    if (Bolygo.rovidebbKeringesIdeju(bolygo, fold) == bolygo) {
                        db++;
                    }
                }
            }
        }
        return db;
    }
    public static void randomTomeg(Bolygo[] tomb) {
        Random rand = new Random();
        int tomeg = rand.nextInt(100) + 1;

        for (Bolygo bolygo : tomb) {
            float eredmeny = bolygo.tomegAtvaltas(tomeg);
            System.out.println(eredmeny);
        }
    }
}