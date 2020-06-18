// Notenstatistik.java
package aufgabe3;

import java.util.Locale;
import java.util.Scanner;

/**
 * erstellt eine Notenstatistik.
 * <p>
 * Das Programm erwartet Pr&uuml;fungsnoten im Format
 * <code>Ganze,Zehntel</code> oder <code>Ganze.Zehntel</code>,
 * wobei <code>Ganze</code> und <code>Zehntel</code> nur aus
 * je einer Dezimalziffer bestehen d&uuml;rfen.
 * Andere Eingaben werden wegen Formatfehler ignoriert.
 * </p>
 * <p>
 * Das Programm gibt die folgende Statistik aus:
 * </p>
 * <ul>
 * <li>die Anzahl der ber&uuml;cksichtigten Noten</li>
 * <li>die Anzahl der Bestandenen</li>
 * <li>die beste Note</li>
 * <li>die schlechteste Note</li>
 * <li>den Durchschnitt der Bestandenen</li>
 * <li>die Durchfallquote in Prozent</li>
 * </ul>
 * <p>
 * Es werden in der Statistik nur die nach HTWG-Pr&uuml;fungsordnung
 * zul&auml;ssigen Noten (1,0 1,3 1,7 2,0 2,3 2,7 3,0 3,3 3,7 4,0 5,0)
 * ber&uuml;cksichtigt.
 * Andere Eingaben werden wegen falscher Vorkommastelle oder
 * falscher Nachkommastelle ignoriert.
 * Alle Noten bis 4,0 gelten als bestanden, nur die 5,0 als durchgefallen.
 * </p>
 *
 * @author <a href="mailto:dr411ber@htwg-konstanz.de">Drilon Berisha</a>
 * @version 15.06.2020
 */
public final class Notenstatistik {
    private Notenstatistik() { }

    private static final Scanner EINGABE = new Scanner(System.in);

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.GERMANY);
        float notenanzahl = 0;
        float bestandene = 0;
        float besteNote = 6;
        float schlechteNote = 0;
        float notensumme = 0;
        float durchfallquote = 0;
        //--------------------------------------------------- Noten einlesen
        System.out.println("Noten im Format Ganze,Zehntel "
                + "oder Ganze.Zehntel eingeben (Ende mit Strg-D):");

        while (EINGABE.hasNext()) {
            String note = EINGABE.next();
            //---------------------------------------------- Eingabe pruefen
            if (note.length() == 3 && (note.charAt(1) == ',' || note.charAt(1) == '.')) {
                if (Character.isDigit(note.charAt(0))) {
                    switch (note.charAt(0)) {
                        case '1':
                        case '2':
                        case '3':
                            if (Character.isDigit(note.charAt(2))) {
                                switch (note.charAt(2)) {
                                    case '0':
                                    case '3':
                                    case '7': //gültige Nachkommastellen
                                        ++notenanzahl;
                                        ++bestandene;
                                        //if (note.) {
                                        //    note = note.replace(",", ".");
                                        //}
                                        float f = Float.parseFloat(note);
                                        notensumme += f;
                                        if (f > schlechteNote) {
                                            schlechteNote = f;
                                        }
                                        if (f < besteNote) {
                                            besteNote = f;
                                        }
                                        break;
                                    default:
                                        System.out.printf("Note %s wird wegen "
                                                + "Nachkommastelle"
                                                + note.charAt(2)
                                                + " ignoriert!%n", note);
                                }
                            } else {
                                System.out.printf("Note %s wird wegen Formatfehler "
                                        + "ignoriert!%n", note);
                            }
                            break;
                        case '4':
                            if (note.charAt(2) == '0') {
                                ++notenanzahl;
                                ++bestandene;
                                if (note.charAt(1) == ',') {
                                    note = note.replace(",", ".");
                                }
                                float f = Float.parseFloat(note);
                                notensumme += f;
                                if (f > schlechteNote) {
                                    schlechteNote = f;
                                }
                                if (f < besteNote) {
                                    besteNote = f;
                                }
                            } else {
                                System.out.printf("Note %s wird wegen "
                                        + "Nachkommastelle "
                                        + note.charAt(2)
                                        + " ignoriert!%n", note);
                            }
                            break;
                        case '5':
                            if (note.charAt(2) == '0') {
                                ++notenanzahl;
                                if (note.charAt(1) == ',') {
                                    note = note.replace(",", ".");
                                }
                                float f = Float.parseFloat(note);
                                if (f > schlechteNote) {
                                    schlechteNote = f;
                                }
                                if (f < besteNote) {
                                    besteNote = f;
                                }
                            } else {
                                System.out.printf("Note %s wird wegen "
                                        + "Nachkommastelle "
                                        + note.charAt(2)
                                        + " ignoriert!%n", note);
                            }
                            break;
                        default:
                            System.out.printf("Note %s wird wegen "
                                    + "Vorkommastelle "
                                    + note.charAt(0)
                                    + " ignoriert!%n", note);
                    }
                } else {
                    System.out.printf("Note wird wegen Formatfehler "
                            + "ignoriert!%n", note);
                }
                //System.out.println(note);
                //float f = Float.parse.Float(note);
            } else {
                System.out.printf("Note wird wegen Formatfehler "
                        + "ignoriert!%n", note);
            }


            /* TODO: (1) die Zeichen im String note pruefen ... */
            //------------------------------------------------ Note erfassen

            /* TODO: (2) Notensumme Bestandene, Anzahl Bestandene,
                         Anzahl Durchgefallene sowie
                         beste und schlechteste Note aktualisieren ... */

        }// while

        //------------------------------------------ Notenstatistik ausgeben

        /* TODO: (3) Durchschnitt und Durchfallquote berechnen
                     und dann die gesamte Statistik ausgeben ... */
        System.out.printf("Anzahl der beruecksichtigeter Noten: %.0f%n", notenanzahl);
        System.out.printf("Anzahl Bestandene: %.0f%n", bestandene);
        System.out.printf("beste Note: %.!f%n", besteNote);
        System.out.printf("Schlechteste Note: %.1f%n", schlechteNote);
        System.out.printf("Durchschnitt bestandene: %.1f%n", notensumme/bestandene);
        durchfallquote = (1 - bestandene / notenanzahl) * 100;
        System.out.printf("Durchfallquote: %.1f%%%n", durchfallquote);

    } // main
}

