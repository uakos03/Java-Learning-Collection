    package szgep.teszt;
    import szgep.*;

    import java.util.Scanner;

    public class Taroloteszt {
        public static void main(String[] args) {
            Merevlemez[] m1 = new Merevlemez[5];
            ellenorzottBeolvasas(m1);
            legnagyobbElem(m1);
            int darab = szamol(m1);
            System.out.println("Feltételnek megfelelő merevlemezek száma: " + darab);
            kiiratas(m1);


        }
        public static void ellenorzottBeolvasas(Merevlemez[] tomb) {
            Scanner sc = new Scanner(System.in);

            for (int i = 0; i < tomb.length; i++) {
                boolean sikeres = false;
                while (!sikeres) {
                    try {
                        System.out.println((i + 1) + ". Merevlemez adatainak megadása");

                        String nev;
                        do {
                            System.out.println("Add meg a Márkát: ");
                            nev = sc.nextLine();
                        } while (nev == null || nev.isBlank());

                        double kapacitas;
                        do {
                            System.out.println("Add meg a kapacitást: ");
                            kapacitas = Double.parseDouble(sc.nextLine());
                            if (kapacitas <= 0) {
                                System.out.println("Hibás érték! Nem lehet negatív.");
                            }
                        } while (kapacitas <= 0);

                        double foglaltTerulet;
                        do {
                            System.out.println("Add meg mekkora a foglalt területed: ");
                            foglaltTerulet = Double.parseDouble(sc.nextLine());
                            if (foglaltTerulet > kapacitas) {
                                System.out.println("Hiba a foglalt nem lehet több a kapacitásodnál!");
                            }
                        } while (foglaltTerulet > kapacitas);
                        tomb[i] = new Merevlemez(nev,kapacitas,foglaltTerulet);
                        sikeres = true;

                    } catch (Exception e) {
                        System.out.println("Hiba az adatmegadásnál! Kezdjük újra ezt az elemet.");
                    }
                }
            }
        }
        public static void kiiratas(Merevlemez[] tomb) {
            for (Merevlemez m : tomb) {
                System.out.println(m);
            }
        }
        public static void legnagyobbElem(Merevlemez[] tomb) {
            Merevlemez eredmeny = tomb[0];
            for (int i = 0; i < tomb.length; i++) {
                eredmeny = Merevlemez.nagyobbKapacitas(eredmeny, tomb[i]);
                }
            System.out.println("Legnagyobb elem: " + eredmeny);
        }

        public static int szamol(Merevlemez[] tomb) {
            int db = 0;
            for (int i = 0; i < tomb.length; i++) {
                if (tomb[i].mennyiSzabad() > tomb[i].getFoglaltTerulet()){
                    db++;
                }
            }
            return db;
        }
    }