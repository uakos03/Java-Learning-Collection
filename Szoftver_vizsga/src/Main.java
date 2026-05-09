import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //java01.png
        Szoftver[] sz1 = new Szoftver[4];
        beolvas(sz1);
        kiIr(sz1);
        int maxIndex = maxIndex(sz1);
        System.out.println(sz1[maxIndex].toString());

    }

    public static void beolvas(Szoftver[] tomb) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < tomb.length; i++) {
            boolean sikeresBeolvasas = false;

            while (!sikeresBeolvasas) {
                try {
                    System.out.println("Kérem a(z) " + (i+1) + ". adatait!");

                    System.out.println("Név: ");
                    String nev = scanner.nextLine();

                    System.out.println("OS (vesszővel elválasztva!) : ");
                    String[] osTomb = scanner.nextLine().split(",");

                    System.out.println("Rövid vagy hosszú? (r=rövid, h=hosszú!): ");
                    String valasz = scanner.nextLine();

                    if(valasz.equalsIgnoreCase("r")) {
                        tomb[i] = new Szoftver(nev,osTomb);
                        sikeresBeolvasas = true;
                    }
                    else {
                        int ar;
                        do {
                            System.out.println("Ár (10000 - 100000): ");
                            ar = Integer.parseInt(scanner.nextLine());
                        } while(ar < 10000 || ar > 100000);
                        System.out.println("Tipusa: (IRODAI, JATEK, MEDIA): ");
                        Szoftver.Tipus tipus = Szoftver.Tipus.valueOf(scanner.nextLine());

                        if (tipus == Szoftver.Tipus.JATEK) {
                            int korhatar;
                            do {
                                System.out.println("Kor (6-18): ");
                                korhatar = Integer.parseInt(scanner.nextLine());
                            } while(korhatar < 6 || korhatar > 18);
                            tomb[i] = new JatekSzoftver(nev, ar, osTomb, korhatar);
                        } else {
                            tomb[i] = new Szoftver(nev, ar, tipus, osTomb, LocalDate.now());
                        }
                        sikeresBeolvasas = true;
                    }
                } catch (Exception e) {
                    System.out.println("Rossz bevitt adat!");
                }
            }
        }
    }
    public static void kiIr(Szoftver[] tomb){
        for(Szoftver sz : tomb) {
            System.out.println(sz.toString());
        }
    }

    public static int maxIndex(Szoftver[] tomb) {
        int maxIndex = 0;
        for(int i=1; i<tomb.length; i++) {
            if(Szoftver.osszehasonlit(tomb[i], tomb[maxIndex]) > 0) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}



