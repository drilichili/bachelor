import java.util.Scanner;

/**
 * Klasse um den ggT zweier Zahlen zu bestimmen.
 * @author <a href="mailto:dr411ber@htwg-konstanz.de">Drilon Berisha</a>
 * @since 27.04.2020
 */
public class ggT {

    private static final Scanner EINGABE = new Scanner(System.in);

    public static void main(String[] args)
    {

        ggT A1 = new ggT();

        System.out.print("Bestimmen Sie m: ");
        int m = EINGABE.nextInt();

        System.out.print("Bestimmen Sie n: ");
        int n = EINGABE.nextInt();

        int x = divisor(m,n);
        System.out.println(x);

    }

    /**
     * Methode, welche den ggT(m,n) berechnet.
     * @param m
     * @param n
     * @return
     */
    public static int divisor(int m, int n)
    {
        //default case
        if (m == 0)
            return n;

        while (n != 0)
        {
            if (m > n)
                m = m - n;
            else
                n = n - m;
        }
        return m;
    }
}
