import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;
public class FesztivalTeszt {
    public static void main(String[] args) {
        VIPJegy[] v1 = new VIPJegy[4];
        ellenorzottBeolvasas(v1);
        kiIr(v1);

        VIPJegy[] jegyek = valogatas(v1);
        for(VIPJegy j: jegyek) {
            if(j != null) {
                System.out.println(Arrays.toString(jegyek));
            }
        }

    }
    public static void ellenorzottBeolvasas(VIPJegy[] tomb) {
        Scanner scanner = new Scanner(System.in);
        boolean sikeres = false;
        while (!sikeres) {
            try {
                for (int i = 0; i< tomb.length; i++) {
                    System.out.println("Add meg a(z)" + (i+1) + ". adatait!");

                    System.out.println("Add meg a tulajt: ");
                    String nev = scanner.nextLine();

                    System.out.println("Add meg az árat: ");
                    int ar = Integer.parseInt(scanner.nextLine());

                    System.out.println("Add meg a dátumot (ÉÉÉÉ-HH-NN): ");
                    LocalDate datum = LocalDate.parse(scanner.nextLine());

                    tomb[i] = new VIPJegy(nev, ar, datum);

                    tomb[i].setAr(ar);

                    sikeres = true;
            }
            } catch (GyanusArException e) {
                System.out.println("Hiba: " + e.getMessage());
            }
            catch (Exception e) {
                System.out.println("Hiba az adatok megadásakor!");
            }

        }
    }
    public static void kiIr(VIPJegy[] tomb) {
        for(VIPJegy v1 : tomb) {
            System.out.println(v1);
        }
    }
    //Egy új tömbbe rendezés!!
    public static VIPJegy[] valogatas(VIPJegy[] tomb) {
        VIPJegy[] ujtomb = new VIPJegy[tomb.length];
        int db=0;

        for(int i=0; i< tomb.length; i++) {
            if(tomb[i].getVasarlasDatuma() != null && tomb[i].getVasarlasDatuma().getYear() == LocalDate.now().getYear()) {
                ujtomb[db] = tomb[i];
                db++;
            }
        }
        return ujtomb;
    }



}