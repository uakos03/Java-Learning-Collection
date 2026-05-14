import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Bolygo[] b1 = new Bolygo[8];
        ellenorzottBeolvas(b1);
        szamolRovidebb(b1);
        veletlenSzam(b1);

    }
    public static void ellenorzottBeolvas(Bolygo[] tomb) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i< tomb.length; i++) {
            boolean sikeres = false;

            while(!sikeres) {
                try {
                    String nev;
                    do {
                        System.out.println("Add meg a bolygó nevét: ");
                        nev = scanner.nextLine();

                    }while(nev == null || nev.isBlank());

                    float keringesiIdo;
                    do {
                        System.out.println("Add meg a keringési időt: ");
                        keringesiIdo = Float.parseFloat(scanner.nextLine());
                        if(keringesiIdo <= 0) {
                            System.out.println("A keringés nem lehet 0  vagy negatív");
                        }
                    } while(keringesiIdo <= 0);

                    int atmero;
                    do {
                        System.out.println("Add meg az átmérőt: ");
                        atmero = Integer.parseInt(scanner.nextLine());
                        if (atmero <= 0) {
                            System.out.println("Az átmérő nem lehet 0 vagy negatív");
                        }
                    } while (atmero <= 0);

                    tomb[i] = new Bolygo(nev, keringesiIdo, atmero);
                    sikeres = true;

                } catch (Exception e) {
                    System.out.println("Hibás adat!");
                }
            }
        }
    }
    public static void kiIratas(Bolygo[] tomb) {
        for(int i =0; i<tomb.length; i++) {
            System.out.println("Bolygó adatai: " + tomb[i]);
        }
    }
    public static int szamolRovidebb(Bolygo[] tomb) {
        Bolygo fold=null;
        int db = 0;
        for (Bolygo value : tomb) {
            if (value != null && value.getNev().equalsIgnoreCase("Föld")) {
                fold = value;
                break;
            }
        }
        if(fold!=null) {
            for (Bolygo bolygo : tomb) {
                if (bolygo != null && bolygo != fold) {
                    if (Bolygo.rovidebbKeringesiIdeju(fold, bolygo) == bolygo) {
                        db++;
                    }
                }
            }

            }
        return db;
            }


    public static void veletlenSzam(Bolygo[] tomb) {
        Random rand = new Random();
        int tomeg = rand.nextInt(100) + 1;

        for(int i=0; i<tomb.length; i++) {
            float eredmeny = tomb[i].tomegAtvaltas(tomeg);
            System.out.println(tomeg);
        }
    }
}
