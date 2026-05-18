package gep.teszt;
import gep.*;

import java.util.Scanner;

public class LaptopTeszt {
    public static void main(String[] args) {
        Laptop[] l1 = new Laptop[4];
        ellenorzottBeolvasas(l1);
        kiiratas(l1);
        Laptop n = Laptop.nagyobbSzamitottAr(l1[0], l1[1]);
        System.out.println("AZ első kettő közül ez a nagyobb szamitott ára van: " + n);
        double atlag = atlag(l1);
        System.out.println("A laptopok számított árának átlaga: " + atlag);


    }
    public static void ellenorzottBeolvasas(Laptop[] tomb) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < tomb.length; i++) {
            boolean sikeres = false;
            while (!sikeres) {
                try {
                    System.out.println((i + 1) + ". Laptop adatainak megadása");

                    String marka;
                    do {
                        System.out.print("Add meg a márkát: ");
                        marka= sc.nextLine().toUpperCase();
                    } while (marka.isBlank());

                    int alapAr ;
                    do {
                        System.out.print("Add meg az alapárat: ");
                        alapAr = Integer.parseInt(sc.nextLine());
                        if (alapAr <= 0) {
                            System.out.println("Hibás érték! Nem lehet negatív.");
                        }
                    } while (alapAr <= 0);

                    int memoria;
                    do {
                        System.out.print("Add meg a memoriat: ");
                        memoria = Integer.parseInt(sc.nextLine());
                        if (memoria <= 0) {
                            System.out.println("Hibás érték! Nem lehet negatív.");
                        }
                    } while (memoria <= 0);
                    
                    if (i<2) {
                        int tarhely;
                        do {
                            System.out.print("Add meg a tárhelyet: ");
                            tarhely = Integer.parseInt(sc.nextLine());
                            if (tarhely <= 0) {
                                System.out.println("Hibás érték! Nem lehet negatív.");
                            }
                        } while (tarhely <= 0);
                        tomb[i] = new Laptop(marka,alapAr,memoria,tarhely);
                    } else {
                        tomb[i] = new Laptop(marka,alapAr,memoria);
                    }
                    sikeres = true;
                } catch (Exception e) {
                    System.out.println("Hiba: " + e.getMessage());
                }
            }
        }
    }
    public static void kiiratas(Laptop[] tomb) {
        for (Laptop elem : tomb) {
            System.out.println(elem);
        }
    }
    public static double atlag(Laptop[] tomb) {
        double osszeg = 0;
        for (Laptop laptop : tomb) {
            osszeg += laptop.szamitottAr();
        }
        return osszeg / tomb.length;
    }
}
