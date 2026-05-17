import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Sajt[] s1 = new Sajt[4];
    ellenorzottBeolvasas(s1);
    kiiratas(s1);
    int darab = szamol(s1);
    System.out.println(darab);


    }
    public static void ellenorzottBeolvasas(Sajt[] tomb) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < tomb.length; i++) {
            boolean sikeres = false;
            while (!sikeres) {
                try {
                    System.out.println((i + 1) + ". Sajt adatainak megadása!");

                    int egysegar;
                    do {
                        System.out.print("Add meg az egységárat: ");
                         egysegar = Integer.parseInt(sc.nextLine());
                         if(egysegar<2000|| egysegar> 8000) {
                             System.out.println("Hibás adat!");
                         }
                    } while (egysegar<2000|| egysegar> 8000);

                    String marka;
                    do {
                        System.out.print("Add meg a márkát : ");
                        marka = sc.nextLine();
                    } while (marka.isBlank());

                    Random rand = new Random();
                    double tomeg = rand.nextDouble() * 90.0 + 10.0;

                    Sajt.Tipus tipus;
                    System.out.println("Add meg a típust: ");
                    tipus = Sajt.Tipus.valueOf(sc.nextLine().toUpperCase());

                    String input;
                    System.out.println("Rövid vagy hosszú beolvasást akarsz?: ");
                    input = sc.nextLine();
                    if (input.equalsIgnoreCase("r")) {
                        tomb[i] = new Sajt(egysegar,marka, tomeg,tipus);

                    } else{

                        LocalDate gyartasideje;
                        System.out.println("Add meg a gyártási időt: ");
                        gyartasideje = LocalDate.parse(sc.nextLine());

                        double zsir;
                        System.out.println("Add meg a zsírtartalmat: ");
                        zsir = Double.parseDouble(sc.nextLine());

                        tomb[i] = new Sajt(egysegar, marka, gyartasideje,tomeg, tipus, zsir);

                    }
                    sikeres = true;
                } catch (Exception e) {
                    System.out.println("Kritikus hiba az adatmegadásnál! Kezdjük újra ezt az elemet.");
                }
            }
        }
    }
    public static void kiiratas(Sajt[] tomb) {

        for (Sajt elem : tomb) {
            System.out.println(elem);
        }
    }
    public static int szamol(Sajt[] tomb) {
        int db = 0;
        for (Sajt sajt : tomb) {
            if (!sajt.ehetoE()) {
                db++;
            }
        }
        return db;
    }
}