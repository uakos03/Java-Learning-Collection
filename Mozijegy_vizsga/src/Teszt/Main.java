package Teszt;
import Jegy.*;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Mozijegy[] m1 = new Mozijegy[4];
        ellenorzottBeolvasas(m1);
        kiIratas(m1);
        int db = megszamol(m1);
        System.out.println(db);


    }

    public static void ellenorzottBeolvasas(Mozijegy[] tomb) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < tomb.length; i++) {
            boolean sikeres = false;
            while (!sikeres) {
                try {
                    System.out.println("Kérem a(z) " + (i+1) + ". jegy adatait!");

                    System.out.println("Film cime: ");
                    String nev = sc.nextLine();

                    int[] hely = new int[3];
                    String[] promptok = {"Terem", "Sor", "Szék"};

                    for(int j=0; j < 3; j++) {
                        do {
                            System.out.println(promptok[j] + "száma (1 és 10 között lehet): ");
                            hely[j] = Integer.parseInt(sc.nextLine());
                        }while(hely[j] < 1 || hely[j] > 10);
                    }
                    System.out.println("Teljes vagy rövid adatmegadást szeretnél? (r=rövid, t=teljes");
                    String valasz = sc.nextLine();

                    if (valasz.equalsIgnoreCase("r")) {
                        tomb[i] = new Mozijegy(nev,hely);
                        sikeres = true;
                    } else {
                        System.out.println("Dátum (év-hh-nn, pl: 2024-10-25): ");
                        LocalDate datum = LocalDate.parse(sc.nextLine());

                        System.out.println("Kedvezmény (DIAK, TELJESARU, NYUGIDJAS): ");
                        Jegy.Kedvezmeny kedvezmeny = Jegy.Kedvezmeny.valueOf(sc.nextLine());

                        tomb[i] = new Mozijegy(nev, hely,datum,kedvezmeny);
                        sikeres = true;
                    }
                } catch (Exception e) {
                    System.out.println("Helyetelen adatokat adtál meg!");
                }
            }
        }
    }
    public static void kiIratas(Mozijegy[] tomb) {
        for(Mozijegy jegy : tomb) {
            System.out.println(jegy.toString());
        }
    }
    public static int megszamol(Mozijegy[] tomb) {
        int db = 0;

        for(int i = 0; i < tomb.length; i++) {
            boolean marSzerepelt = false;
            for(int j=0; j < tomb.length; j++) {
                if(tomb[i].getFilmcim().equals(tomb[j].getFilmcim())) {
                    marSzerepelt=true;
                    break;
                }
                if(!marSzerepelt) {
                    db++;
                }
            }
        }
        return db;
    }
}
