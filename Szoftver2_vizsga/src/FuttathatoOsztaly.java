import Szoftverek.*;

import java.time.LocalDate;
import java.util.Scanner;

public class FuttathatoOsztaly {
    public static void main(String[] args) {
        Szoftver[] sz1 = new Szoftver[4];
        ellenorzottBeolvasas(sz1);
        kiiratas(sz1);
        int maximumIndex = legNagyobbIndex(sz1);
        System.out.println(sz1[maximumIndex]);
    }

    public static void ellenorzottBeolvasas(Szoftver[] tomb) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < tomb.length; i++) {
            boolean sikeres = false;
            while (!sikeres) {
                try {
                    System.out.println("--- " + (i + 1) + ". Szoftver adatainak megadása ---");

                    String nev;
                    do {
                        System.out.print("Add meg a nevet : ");
                        nev= sc.nextLine();
                    } while (nev == null || nev.isBlank());

                    String[] os;
                        System.out.print("Add meg az OS-t : ");
                        os = sc.nextLine().split(",");

                    String input;
                        System.out.println("Rövid vagy hosszú beolvasást akarsz? (r=rövid, hosszú=h): ");
                        input = sc.nextLine();

                        if (input.equalsIgnoreCase("r")) {
                            tomb[i] = new Szoftver(nev, os);
                            sikeres = true;
                        } else {
                            int ar;
                            do {

                                System.out.println("Add meg az árat: ");
                                ar = Integer.parseInt(sc.nextLine());
                                if (ar < 10000 || ar > 100000) {
                                    System.out.println("Hibás érték!");
                                }
                            } while (ar < 10000 || ar > 100000);

                            Szoftver.Tipus tipus;
                                System.out.println("Add meg a típust_ ");
                                tipus = Szoftver.Tipus.valueOf(sc.nextLine().toUpperCase());

                            if(tipus == Szoftver.Tipus.JATEK) {
                                int kor;
                                do {
                                    System.out.println("Kor: (6-18): ");
                                    kor = Integer.parseInt(sc.nextLine());
                                    if(kor < 6 || kor > 18) {
                                        System.out.println("Hibás!");
                                    }
                                    } while (kor < 6 || kor > 18);
                                    tomb[i] = new JatekSzoftver(nev, ar, os, kor);
                            } else {
                                LocalDate datum;
                                System.out.println("Add meg a kiadás dátumat: ");
                                datum = LocalDate.parse(sc.nextLine());
                                tomb[i] = new Szoftver(nev, ar, os, datum, tipus);
                            }
                            sikeres = true;
                            }
                        }catch (Exception e) {
                    System.out.println("Kritikus hiba az adatmegadásnál!");
                }
            }
        }
    }
    public static void kiiratas(Szoftver[] tomb) {
        if (tomb == null) return;
        for (Szoftver elem : tomb) {
            System.out.println(elem);
        }
    }
    public static int legNagyobbIndex(Szoftver[] tomb) {
        int maxIndex = 0;
        for (int i = 1; i < tomb.length; i++) {
            if (Szoftver.osszehasonlitas(tomb[i], tomb[maxIndex]) > 0) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}