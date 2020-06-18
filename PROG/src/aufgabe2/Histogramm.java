package aufgabe2;

import java.util.Scanner;

/**
 * Histogramm liest ganze Zahlen zwischen 1 und 6 ein und
 * gibt deren H&auml;ufigkeitsverteilung als Histogramm aus.
 * @author <a href="mailto:dr411ber@htwg-konstanz.de">Drilon Berisha</a>
 * @since 13.05.2020
 */
public final class Histogramm {
    private Histogramm() { }

    private static final Scanner EINGABE = new Scanner(System.in);

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(String[] args) {
        int[] counter = {0, 0, 0, 0, 0, 0};

        System.out.printf("Ganze Zahlen zwischen 1 und 6 eingeben"
                + " (Ende mit Strg-D):%n");

        while (EINGABE.hasNextInt()) {
            int number = EINGABE.nextInt();

            if (number >= 1 && number <= 6) {

                if (number == 1) {
                    counter[0]++;
                }
                if (number == 2) {
                    counter[1]++;
                }
                if (number == 3) {
                    counter[2]++;
                }
                if (number == 4) {
                    counter[3]++;
                }
                if (number == 5) {
                    counter[4]++;
                }
                if (number == 6) {
                    counter[5]++;
                }
            } else {
                System.out.println("Falsche Eingabe wird ignoriert: "
                    + number);
            }

        }

        System.out.println("Histogramm:");

        for (int i = 0; i <= counter.length - 1; i++) {

            int number = counter[i];
            System.out.println("");
            int walker = 0;

            while (number > 0) {

                if (walker >= 4) {
                    System.out.print("$");
                    walker = 0;
                    number = number - 1;
                } else {
                    System.out.print(i + 1);
                    number = number - 1;
                    walker = walker + 1;
                }
            }

            number = counter[i];
            System.out.println(" (" + number + ") ");

        }
    }
}