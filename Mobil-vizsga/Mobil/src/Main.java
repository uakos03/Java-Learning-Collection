
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {


            OkosMobil[] okosMobilok = new OkosMobil[4];


            System.out.println("=== OKOSMOBILOK ADATAINAK MEGADÁSA ===");


            for (int i = 0; i < 2; i++) {
                System.out.println("\n" + (i+1) + ". okosmobil (4 paraméteres):");
                okosMobilok[i] = beolvasOkosMobil4Param();
            }


            for (int i = 2; i < 4; i++) {
                System.out.println("\n" + (i+1) + ". okosmobil (3 paraméteres, magok=8):");
                okosMobilok[i] = beolvasOkosMobil3Param();
            }


            System.out.println("\n=== ÖSSZES OKOSMOBIL ADATAI ===");
            for (int i = 0; i < okosMobilok.length; i++) {
                System.out.println((i+1) + ". " + okosMobilok[i]);
            }


            System.out.println("\n=== ELSŐ KÉT OKOSMOBIL ÖSSZEHASONLÍTÁSA ===");
            OkosMobil nagyobb = OkosMobil.nagyobbArErtekAranyu(okosMobilok[0], okosMobilok[1]);
            System.out.println("Nagyobb ár/érték arányú: " + nagyobb.getTipus() +
                    " (ár/érték: " + String.format("%.2f", nagyobb.arErtekArany()) + ")");

            // 4. Okostelefonok átlagára
            double atlagAr = szamitAtlagAr(okosMobilok);
            System.out.println("\n=== ÁTLAGÁR SZÁMÍTÁSA ===");
            System.out.println("Az okostelefonok átlagára: " + String.format("%.2f", atlagAr) + " Ft");

            scanner.close();
        }

        // 4 paraméteres OkosMobil beolvasása
        private static OkosMobil beolvasOkosMobil4Param() {
            System.out.print("Típus: ");
            String tipus = scanner.nextLine();

            int ar = beolvasPozitivEgesz("Ár: ");
            int memoria = beolvasPozitivEgesz("Memória (GB): ");
            int magok = beolvasPozitivEgesz("Processzor magok száma: ");

            return new OkosMobil(tipus, ar, memoria, magok);
        }

        // 3 paraméteres OkosMobil beolvasása
        private static OkosMobil beolvasOkosMobil3Param() {
            System.out.print("Típus: ");
            String tipus = scanner.nextLine();

            int ar = beolvasPozitivEgesz("Ár: ");
            int memoria = beolvasPozitivEgesz("Memória (GB): ");
            // processzor magok száma automatikusan 8 lesz

            return new OkosMobil(tipus, ar, memoria);
        }


        private static int beolvasPozitivEgesz(String prompt) {
            int szam;
            do {
                System.out.print(prompt);
                while (!scanner.hasNextInt()) {
                    System.out.println("Hiba: Kérem pozitív egész számot adjon meg!");
                    scanner.next(); // hibás input eldobása
                    System.out.print(prompt);
                }
                szam = scanner.nextInt();
                if (szam <= 0) {
                    System.out.println("Hiba: A számnak pozitívnak kell lennie!");
                }
            } while (szam <= 0);
            scanner.nextLine();
            return szam;
        }

        // Átlagár számítása
        private static double szamitAtlagAr(OkosMobil[] tomb) {
            int osszeg = 0;
            for (OkosMobil om : tomb) {
                osszeg += om.getAr();
            }
            return (double) osszeg / tomb.length;
    }
}

