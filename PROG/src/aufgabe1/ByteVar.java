package aufgabe1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * ByteVar zeigt den Umgang mit Variablen vom Typ byte.
 * &Uuml;bungsaufgabe 1 zur Programmiertechnik 1.
 * @author <a href="mailto:dr411ber@htwg-konstanz.de">Drilon Berisha</a>
 * @version 1.0.0
 * @since 29.04.2020
 */
public final class ByteVar {

    private ByteVar() { }

    private static byte maxV = -1;
    private static byte minV = -1;

    private static final Scanner EINGABE = new Scanner(System.in);

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(String[] args) throws InputMismatchException {

        String minS = Byte.toString(Byte.MIN_VALUE);
        String maxS = Byte.toString(Byte.MAX_VALUE);

        System.out.print("Zwei ganze Zahlen zwischen ");
        System.out.print(minS);
        System.out.print(" und ");
        System.out.print(maxS);
        System.out.println(" eingeben:");

        try {
            System.out.print("Setze maxV: ");
            maxV = EINGABE.nextByte();
            System.out.print("Setze minV: ");
            minV = EINGABE.nextByte();
            System.out.println(maxV + " " + minV);

            System.out.printf(maxV + " ist Oktal " + "%o", maxV);
            System.out.printf(" und Hexadezimal " + "%x%n", maxV);
            System.out.printf(minV + " ist Oktal " + "%o", minV);
            System.out.printf(" und Hexadezimal " + "%x%n", minV);

            //System.out.println("Arithmetische Operatoren:");

            System.out.println(maxV + " + " + minV + " ist " + maxV + minV);

            byte sub = (byte) (maxV - minV);
            System.out.println(maxV + " - " + minV + " ist " + sub);

            System.out.println(maxV + " * " + minV + " ist " + maxV * minV);

            System.out.println(maxV + " / " + minV + " ist " + maxV / minV);

            System.out.println(maxV + " % " + minV + " ist " + maxV % minV);

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
