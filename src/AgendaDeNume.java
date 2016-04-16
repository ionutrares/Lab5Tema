import javax.swing.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by icondor on 26/03/16.
 */
public class AgendaDeNume {

    /* utility methods for INPUT/OUTPUT using a GUI or Console, please leave them as they are */

    // GUI
    public static int readIntGUI(String label) {
        String input = JOptionPane.showInputDialog(null,
                label);
        int returnValue = Integer.parseInt(input);
        return returnValue;
    }

    public static double readDoubleGUI(String label) {
        String input = JOptionPane.showInputDialog(null,
                label);
        double returnValue = Double.parseDouble(input);
        return returnValue;
    }

    public static String readStringGUI(String label) {
        String input = JOptionPane.showInputDialog(null,
                label);
        return input;
    }

    public static void printGUI(String text) {
        JOptionPane.showMessageDialog(null, text);
    }

    public static void printGUI(int text) {
        JOptionPane.showMessageDialog(null, text);
    }

    public static void printGUI(double text) {
        JOptionPane.showMessageDialog(null, text);
    }

    // CONSOLE
    public static String readStringConsole(String label) {
        System.out.print(label);
        String input = new Scanner(System.in).nextLine();
        return input;
    }

    public static int readIntConsole(String label) {
        System.out.print(label);
        int input = new Scanner(System.in).nextInt();
        return input;
    }

    public static double readDoubleConsole(String label) {
        System.out.print(label);
        double input = new Scanner(System.in).nextDouble();
        return input;
    }

    public static void printConsole(String text) {
        System.out.println(text);
    }

    public static void printConsole(int text) {
        System.out.println(text);
    }

    public static void printConsole(double text) {
        System.out.println(text);
    }
    /* end of utility methods*/


    // data members
    static String[] sirDeNume = new String[10];
    static int index=0;


    /* here starts the main class */
    public static void main(String[] arguments) {

        int optiune=0;
        do {
            printConsole("1 - listare");
            printConsole("2 - adaugare");
            printConsole("3 - cautare");
            printConsole("7 - exit");
            optiune = readIntConsole("Alegeti un numar:");
            if (optiune == 1)
                listare();
            else if (optiune == 2) {
                String v = readStringConsole("Numele:");
                creareFaraDuplicate(v);
            }

            // listare
            //adaugare
            // ACASA modificare
            // ACASA stergere
            //cautare
            // ACASA exit
        } while(optiune!=7);


    } // end main

    public static void listare() {
        for(int i=0;i<sirDeNume.length;i++) {
            if(sirDeNume[i]!=null) {
                printConsole(sirDeNume[i]);
            }
        }
    }

    public static void creare(String valoare) {
        sirDeNume[index]=valoare;
        index++;
    }

    public static void creareFaraDuplicate(String valoare) {
        int i =cautare( valoare);
        if(i==-1) { //negasita, deci scrie-o
            sirDeNume[index] = valoare;
            index++;
        }
        else
        {
            System.out.println("deja exista");
        }
    }

    public static int cautare(String valoare) {
        int r =-1; // negasit
        for(int i=0;i<sirDeNume.length;i++) {
            if(valoare.equals(sirDeNume[i])) {
                r = i; //gasit pe pozitia i
                break;
            }
        }
        return r;
    }


    public static void thenStatement(int index, String name) {
        sirDeNume[index] = null;
        printConsole("Contact " + name + " de la pozitia " + index + " a fost sters!");
    }


    public static void thenStatement(int index, String oldContact, String newContact) {
        sirDeNume[index] = newContact;
        printConsole("Contact " + oldContact + " de la pozitia " + index +
                " a fost modificat!");
    }

    public static void stergereTotala(String name) {
        boolean run = true;

        while (run) {
            int indexContact = cautare(name);
            if (indexContact != -1) {      //gasit
                thenStatement(indexContact, name);
            } else {
                run = false;
            }
        }
    }

    public static void stergereIndividuala(String name) {
        int indexContact = cautare(name);
        if (indexContact != -1) {      //gasit
            thenStatement(indexContact, name);
        }
    }

    public static void modificareTotala(String oldContact, String newContact) {
        boolean run = true;

        while (run) {
            int indexContact = cautare(oldContact);

            if (indexContact != -1) {      //gasit
                thenStatement(indexContact, oldContact, newContact);
            } else {
                run = false;
            }
        }
    }


    public static void modificareIndividuala(String oldContact, String newContact) {
        int indexContact = cautare(oldContact);

        if (indexContact != -1) {      //gasit
            thenStatement(indexContact, oldContact, newContact);
        }
    }


    public static void sortare(String[] array) {

        for (int i = 0; i < array.length; i++) {

            if (array[i] == null) {
                array[i] = "-";
            }
        }

        Arrays.sort(array);
        printConsole("Dupa sortare: ");
        listare(array);
    }

    public static boolean numaiCaractere(String name) {
        char[] chars = name.toCharArray();

        for (char c : chars) {
            if(!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    public static void adaugaNumeCorect(String name) {
        boolean run = true;

        do {
            if (numaiCaractere(name)) {
                sirDeNume[index] = name;
                run = false;
            } else {
                printConsole("Numele " + name + " trebuie sa contina numai caractere!");
                name = readStringConsole("Reintroduceti nume: ");
            }
        } while (run);

        index++;
    }
}
// end of class