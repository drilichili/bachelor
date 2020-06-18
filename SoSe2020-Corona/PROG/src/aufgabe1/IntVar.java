package aufgabe1;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * IntVar zeigt den Umgang mit Variablen vom Typ int.
 * &Uuml;bungsaufgabe 1 zur Programmiertechnik 1.
 * @author <a href="mailto:dr411ber@htwg-konstanz.de">Drilon Berisha</a>
 * @since 29.04.2020
 */

public final class IntVar {

    private IntVar() { }

    private static String invalidVal1 = "Operator noch nicht implementiert.";
    private static String invalidVal2 = "Dieser Wert ist unzul\u00e4ssig.";
    private static String invalidVal3 = " liegt ausserhalb des Wertebereichs.";

    private static final Scanner EINGABE = new Scanner(System.in);

     /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.*/
    public static void main(String[] args) {

        String minS = Integer.toString(Integer.MIN_VALUE);
        String maxS = Integer.toString(Integer.MAX_VALUE);

        System.out.println("Zwei ganze Zahlen zwischen"
                + minS + " und " + maxS + " eingeben");

        try {
            System.out.print("Setze maxV: ");
            final long maxV = EINGABE.nextLong();
            System.out.print("Setze minV: ");
            final long minV = EINGABE.nextLong();

            /*
            Der Weg, dies mit mehreren If-Anweisungen darzustellen
            erschien mir nicht n\u00f6tig.
            */
            boolean eq = minV == maxV;
            boolean unEq = minV != maxV;
            boolean less = minV < maxV;
            boolean lessEq = minV <= maxV;
            boolean great = minV > maxV;
            boolean grEq = minV >= maxV;

            if (checkConv(maxV) && checkConv(minV)) {
                System.out.println(maxV + " " + minV);

                String dezMax = String.format("%d", maxV);    //dezimalMaxV
                String oktMax = String.format("%o", maxV);
                String hexMax = String.format("%x", maxV);
                String dezMin = String.format("%d", minV);
                String oktMin = String.format("%o", minV);
                String hexMin = String.format("%x", minV);

                String oktS = " ist Oktal ";    //Oktal-Satz
                String hexS = " ist Hexadezimal ";
                System.out.println(dezMax + oktS + oktMax + hexS + hexMax);
                System.out.println(dezMin + oktS + oktMin + hexS + hexMin);

                String inS = "W\u00e4hlen Sie einen arithmetischen Operator: ";
                System.out.print(inS);
                String arOp = EINGABE.next();   //arithmeticOperator

                switch (arOp) {

                //Arithmetische Operationen
                case "+":
                    long summ = maxV + minV;

                    //additionString
                    String addS = maxV + " + " + minV + " ist ";

                    if (checkConv(summ)) {  //falls checkConv == true
                        System.out.println(addS + summ);
                    }
                    break;

                case "-":
                    long diff = maxV - minV;
                    String diffS = maxV + " - " + minV + " ist ";

                    if (checkConv(diff)) {
                        System.out.println(diffS + diff);
                    }
                    break;

                case "*":
                    long prod = maxV * minV;
                    String prodS = maxV + " * " + minV + " ist ";

                    if (checkConv(prod)) {
                        System.out.println(prodS + prod);
                    }
                    break;

                case "/":
                    long quot = maxV / minV;
                    String quotS = maxV + " / " + minV + " ist ";

                    if (checkConv(quot)) {
                        System.out.println(quotS + quot);
                    }
                    break;

                case "%":
                    long rDiv = maxV % minV;
                    String rDivS = maxV + " % " + minV + " ist ";

                    if (checkConv(rDiv)) {
                        System.out.println(rDivS + rDiv);
                    }
                    break;

                case "==":
                    System.out.println(minV + " == " + maxV + " ist " + eq);
                    break;

                case "!=":
                    System.out.println(minV + " != " + maxV + " ist " + unEq);
                    break;

                case "<":
                    System.out.println(minV + " < " + maxV + " ist " + less);
                    break;

                case "<=":
                    System.out.println(minV + " <= " + maxV + " ist " + lessEq);
                    break;

                case ">":
                    System.out.println(minV + " > " + maxV + " ist " + great);
                    break;

                case ">=":
                    System.out.println(minV + " >= " + maxV + " ist " + grEq);
                    break;

                default:
                    System.out.println(invalidVal1);
                }
            }

        } catch (InputMismatchException ineRR) {
            System.out.println(invalidVal2);
        } catch (NoSuchElementException eleRR) {
            System.out.println(invalidVal2);
        } catch (Exception eRR) {
            System.out.println(eRR.getMessage());
        }


    }

    /**
     * Private Methode um zu \u00fcberpr\u00fcfen ob ein @param l vom Typ long,
     * im Wertebereich des Typen int liegt.
     * @param l
     * @return
     */
    private static boolean checkConv(Long l) {

        if (l > Integer.MAX_VALUE) {
            String exitA = l.toString() + invalidVal3;
            System.out.println(exitA);
            return false;

        } else if (l < Integer.MIN_VALUE) {
            String exitB = l.toString() + invalidVal3;
            System.out.println(exitB);
            return false;
        }
        return true;
    }
}