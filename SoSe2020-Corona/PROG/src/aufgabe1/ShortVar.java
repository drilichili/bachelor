package aufgabe1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * ShortVar zeigt den Umgang mit Variablen vom Typ short.
 * &Uuml;bungsaufgabe 1 zur Programmiertechnik 1.
 * @author <a href="mailto:dr411ber@htwg-konstanz.de">Drilon Berisha</a>
 * @version 1.0.0
 * @since 29.04.2020
 */
public final class ShortVar {

    private ShortVar() { }

    private static short maxV = -1;
    private static short minV = -1;

    private static final Scanner EINGABE = new Scanner(System.in);

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(String[] args) throws InputMismatchException {

        String minS = Short.toString(Short.MIN_VALUE);
        String maxS = Short.toString(Short.MAX_VALUE);

        System.out.print("Zwei ganze Zahlen zwischen ");
        System.out.print(minS);
        System.out.print(" und ");
        System.out.print(maxS);
        System.out.println(" eingeben:");

        try {
            System.out.print("Setze maxV: ");
            maxV = EINGABE.nextShort();
            System.out.print("Setze minV: ");
            minV = EINGABE.nextShort();
            System.out.println(maxV + " " + minV);

            System.out.printf(maxV + " ist Oktal " + "%o%n", maxV);
            System.out.printf(" und Hexadezimal " + "%x%n", maxV);
            System.out.printf(minV + " ist Oktal " + "%o%n", minV);
            System.out.printf(" und Hexadezimal " + "%x%n", minV);

            System.out.println(maxV + " + " + minV + " ist " + maxV + minV);

            System.out.println(maxV + " - " + minV + " ist " + (maxV - minV));

            System.out.println(maxV + " * " + minV + " ist " + maxV * minV);

            System.out.println(maxV + " / " + minV + " ist " + maxV / minV);

            System.out.println(maxV + " % " + minV + " ist " + maxV % minV);

            /*
            Variablen werden normalerweise oben instanziiert,
            hier dienen sie jedoch der \u00dcberschaubarkeit.
            Der Weg, dies mit mehreren If-Anweisungen darzustellen
            erschien mir nicht n\u00f6tig.
             */
            boolean a = minV == maxV;
            boolean b = minV != maxV;
            boolean c = minV < maxV;
            boolean d = minV <= maxV;
            boolean e = minV > maxV;
            boolean f = minV >= maxV;

            System.out.println(minV + " == " + maxV + " ist " + a);
            System.out.println(minV + " != " + maxV + " ist " + b);
            System.out.println(minV + " < " + maxV + " ist " + c);
            System.out.println(minV + " <= " + maxV + " ist " + d);
            System.out.println(minV + " > " + maxV + " ist " + e);
            System.out.println(minV + " >= " + maxV + " ist " + f);

        } catch (InputMismatchException e) {
            System.out.println("Dieser Wert ist unzul\u00e4ssig.");
        }
    }
}
