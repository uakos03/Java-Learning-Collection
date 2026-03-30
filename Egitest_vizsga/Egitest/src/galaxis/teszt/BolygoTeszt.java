package galaxis.teszt;
import galaxis.Bolygo;
import java.util.Random;
import java.util.Scanner;

public class BolygoTeszt {
    public static void main(String[] args) {

        Bolygo[] bolygok = new Bolygo[8];
        String[] nevek = {"Merkúr", "Vénusz", "Föld", "Mars", "Jupiter", "Szaturnusz", "Uránusz", "Neptunusz"};
        float[] keringesiIdok = {0.24f, 0.62f, 1.0f, 1.88f, 11.86f, 29.46f, 84.01f, 164.79f};
        int[] atmerok = {4878, 12104, 12756, 6794, 142800, 120000, 50800, 48600};

        Scanner scanner = new Scanner(System.in);

        System.out.println("Adja meg a bolygók adatait ellenőrzött módon:");

        for (int i = 0; i < bolygok.length; i++) {
            System.out.println("\n" + (i+1) + ". bolygó (" + nevek[i] + "):");

            // Név ellenőrzése
            String nev = nevek[i]; // Előre definiált név
            System.out.println("Név: " + nev);

            // Keringési idő ellenőrzése
            float keringesiIdo;
            do {
                System.out.print("Keringési idő (év): ");
                keringesiIdo = scanner.nextFloat();
                if (keringesiIdo <= 0) {
                    System.out.println("A keringési idő nem lehet 0 vagy negatív!");
                }
            } while (keringesiIdo <= 0);

            // Átmérő ellenőrzése
            int atmero;
            do {
                System.out.print("Átmérő (km): ");
                atmero = scanner.nextInt();
                if (atmero <= 0) {
                    System.out.println("Az átmérő nem lehet 0 vagy negatív!");
                }
            } while (atmero <= 0);

            bolygok[i] = new Bolygo(nev, keringesiIdo, atmero);
        }

        // 2. Összes bolygó adatainak kiírása
        System.out.println("\n=== BOLYGÓK ADATAI ===");
        for (Bolygo bolygo : bolygok) {
            System.out.println(bolygo.toString());
        }

        // 3. Hány bolygónak rövidebb a keringési ideje, mint a Földnek
        int darab = 0;
        Bolygo fold = null;

        // Megkeressük a Föld objektumot
        for (Bolygo bolygo : bolygok) {
            if (bolygo.getNev().equals("Föld")) {
                fold = bolygo;
                break;
            }
        }

        if (fold != null) {
            for (Bolygo bolygo : bolygok) {
                if (Bolygo.rovidebbKeringesIdeju(bolygo, fold) == bolygo &&
                        bolygo != fold) {
                    darab++;
                }
            }
        }

        System.out.println("\nA Földnél rövidebb keringési idejű bolygók száma: " + darab);

        // 4. Tömegátszámítási művelet
        Random random = new Random();
        int foldiTomeg = random.nextInt(100) + 1; // 1-100 közötti véletlenszám

        System.out.println("\n=== TÖMEGÁTSZÁMÍTÁS ===");
        System.out.println("Véletlenszerű földi tömeg: " + foldiTomeg);

        for (Bolygo bolygo : bolygok) {
            float atszamitottTomeg = bolygo.tomegAtvaltas(foldiTomeg);
            System.out.println(bolygo.getNev() + " bolygón mérhető tömeg: " +
                    String.format("%.2f", atszamitottTomeg));
        }

        scanner.close();
    }
}

