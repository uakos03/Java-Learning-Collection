import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GamerLaptop[] l1 = new GamerLaptop[4];
        ellenorzottBeolvasas(l1);
        kiListaz(l1);
        double atlag = atlagAr(l1);
        System.out.println(atlag);
        GamerLaptop dupla = GamerLaptop.nagyobbVga(l1[0], l1[1]);
        System.out.println(dupla);

    }
    public static void ellenorzottBeolvasas(GamerLaptop[] tomb){
        Scanner scanner = new Scanner(System.in);
        for(int i=0; i< tomb.length; i++) {
            boolean sikeres = false;
            while(!sikeres) {
                try {
                    System.out.println("Add meg a(z) " + (i+1) + ". laptop adatait!");

                    int ar;
                    do {
                        System.out.println("Add meg az árát!: ");
                        ar = Integer.parseInt(scanner.nextLine());
                        if(ar<=0){
                            System.out.println("Az ár csak pozitiv egész szam lehet! ");
                        }
                    }while(ar <= 0);

                    System.out.println("Add meg a gyártó nevét: ");
                    String nev = scanner.nextLine();

                    System.out.println("Van benne RBG?: (TRUE OR FALSE)");
                    boolean rgb = Boolean.parseBoolean(scanner.nextLine());

                    int memoria;
                    do {
                        System.out.println("Add meg a memoriat(4,8,12,16): ");
                        memoria = Integer.parseInt(scanner.nextLine());
                        if(memoria != 4 && memoria != 8 && memoria != 12 && memoria != 16) {
                            System.out.println("Hibás adatot adtál meg!");
                        }
                    } while (memoria != 4 && memoria != 8 && memoria != 12 && memoria != 16);
                    if (i < 2) {
                        tomb[i] = new GamerLaptop(ar, nev, rgb, memoria);
                    } else {
                        tomb[i] = new GamerLaptop(nev, ar, memoria);
                    }
                    sikeres = true;

                } catch (Exception e) {
                    System.out.println("Hiba az adatok megadásakor!");
                }
            }
        }
    }
    public static void kiListaz(GamerLaptop[] tomb) {
        for(GamerLaptop l1 : tomb) {
            System.out.println(l1);
        }
    }

    public static double atlagAr(GamerLaptop[] tomb) {
        double vegsoSzam = 0;
        for (int i=0; i<tomb.length; i++) {
            vegsoSzam += tomb[i].arKalkulator();
        }
        return vegsoSzam/ tomb.length;
    }

}