
package szgep.teszt;
import szgep.Merevlemez;
import java.util.Scanner;
import java.util.Arrays;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;


public class Taroloteszt {
    public static void main(String[] args) {
        Merevlemez[] tomb = new Merevlemez[5];

        readInt(tomb);

        legnagyobbKapacitas(tomb);

        int db = szamlalOssz(tomb);
        System.out.println("Lemezek szama, ahol nagyobb a terület mint a foglalt: " + db);

        osszesAdatkiir(tomb);

        //sort, rendezes, és ujra kiiratas
        Arrays.sort(tomb);
        System.out.println("Rendezett kiiras, szabad terulet alapjan: ");
        osszesAdatkiir(tomb);

        fajlbaIras(tomb, "merevlemezek.txt");

    }

    //ADATOK BEOLVASÁSA ELLENŐRZÖTT MÓDON
    private static void readInt(Merevlemez[] tomb) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i<tomb.length; i++) {
            System.out.println((i+1) + " Merevlemez adatai: ");
            System.out.println(" Típus: ");
            String tipus = scanner.nextLine();

            double kapacitas = 0;
            boolean helyesAdat = false;
            while(!helyesAdat) {
                try {
                    System.out.println("Kapacitás: ");
                    kapacitas = Double.parseDouble(scanner.nextLine());
                    if(kapacitas > 0){
                        helyesAdat = true;
                    } else {
                        System.out.println("A kapacitásnak pozitiv szamnak kell lennie!");
                    }
                } catch (NumberFormatException e){
                    System.out.println("Hibás formátum!");
                }
            }
            double foglalt = 0;
            helyesAdat = false;
            while(!helyesAdat) {
                try {
                    System.out.println("Foglalt terület: ");
                    foglalt = Double.parseDouble(scanner.nextLine());
                    if (foglalt >= 0 && foglalt <= kapacitas){
                        helyesAdat = true;
                    }else {
                        System.out.println("A foglalt terület 0 és " + kapacitas + "között kell legyen!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Számot adj meg!");
                }
            }
            tomb[i] = new Merevlemez(tipus, kapacitas, foglalt);
        }
        scanner.close();

    }
    //összes elem kiiratasa
    private static void osszesAdatkiir(Merevlemez[] tomb){
        for(Merevlemez m : tomb) {
            System.out.println(m);
        }
    }
    private static int szamlalOssz(Merevlemez[] tomb) {
        int db = 0;
        for(Merevlemez m : tomb) {
            if(m.getSzabadhely() > m.getFoglaltTerulet()) {
                db++;
            }
        }
        return db;
    }
    private static void legnagyobbKapacitas(Merevlemez[] tomb){
        Merevlemez legnagyobb = tomb[0];
        for(Merevlemez m : tomb) {
            legnagyobb = Merevlemez.nagyobbKapacitas(legnagyobb, m);
        }
        System.out.println("Legnagyobb kapacitasu: " + legnagyobb);
    }

    private static void fajlbaIras(Merevlemez[] tomb, String fajlnev) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fajlnev))) {
            for (Merevlemez m : tomb) {
                writer.println(m);
            }
        }catch (IOException e){
            System.out.println("Hibas fajl iras" + e.getMessage());
        }
    }

}

