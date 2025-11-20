package utils.ui;

import java.util.Scanner;

public class Getter {
    private Getter() {}

    private static Scanner scanner = new Scanner(System.in);

    /** Demana al usuari sí o no. */
    public static boolean getYesOrNo(String message) {
        System.out.print(message + " (y/n): ");
        String input = scanner.nextLine().trim();
        return input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes");
    }

    public static int getQuantum() {
        return getPositiveInteger("Introdueixi el quantum (enter positiu), si us plau");
    }

    public static int getProcessTime(int processId) {
        return getPositiveInteger(
            String.format("Introdueixi el temps de procés per al procés P%d (enter positiu), si us plau", processId)
        );
    }

    public static int getNumberOfProcesses() {
        return getPositiveInteger("Introdueixi el nombre de processos (enter positiu), si us plau");
    }

    /**
     * Demana un enter positiu a l'usuari.
     * 
     * @param message  Missatge a mostrar a l'usuari.
     * @return L'enter positiu introduït per l'usuari.
     */
    private static int getPositiveInteger(String message) {
        // * Declaració de variables
        String input;
        int value;

        do {
            System.out.print(message + ": ");
            input = scanner.nextLine().trim();

            if (input.isBlank()) {
                Prettier.warn("El nombre introduït no pot estar en blanc.");
            }

            try {
                value = Integer.parseInt(input);
                if (value > 0) {
                    return value;
                }

                Prettier.warn("El nombre introduït ha de ser un enter positiu.");
            } catch (NumberFormatException e) { // ? No és un enter
                Prettier.warn("El nombre introduït ha de ser un enter positiu.");
            } catch (Exception e) { // ? Error inesperat
                Prettier.error("S'ha produït un error inesperat: " + e.getMessage());
            }
        } while (true);
    }
}
