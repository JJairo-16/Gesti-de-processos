import java.util.Arrays;

import models.Process.Status;
import services.Executer;

import utils.ui.Getter;

public class App {
    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    public void run() {
        boolean continueSimulation;

        do {
            buildSimulation();
            continueSimulation = Getter.getYesOrNo("Vol continuar la simulació?");
            System.out.println();
        } while (continueSimulation);

        System.out.println("Fins aviat!");
    }

    /**
     * Construeix la simulació demanant les dades a l'usuari.
     */
    private void buildSimulation() {
        int numberOfProcesses = Getter.getNumberOfProcesses();
        int[] processTime = new int[numberOfProcesses];

        for (int i = 0; i < numberOfProcesses; i++) {
            processTime[i] = Getter.getProcessTime(i + 1);
        }

        int q = Getter.getQuantum();

        System.out.println();

        executeSimulation(numberOfProcesses, processTime, q);
    }

    /**
     * Executa la simulació i mostra els resultats.
     * 
     * @param numberOfProcesses Nombre de processos.
     * @param processTime Temps de cada procés.
     * @param q Quantum.
     */
    private void executeSimulation(int numberOfProcesses, int[] processTime, int q) {
        // * Execució
        Executer executer = new Executer(numberOfProcesses, processTime, q);
        executer.execute();

        // * Resultats
        Status[] statuses = executer.getStatuses();
        double wtAvg = Arrays.stream(statuses).mapToInt(Status::tw).average().orElse(0);
        double tatAvg = Arrays.stream(statuses).mapToInt(Status::turnAround).average().orElse(0);

        // * Parse del id
        int maxIdLength = Arrays.stream(statuses)
            .mapToInt(s -> String.valueOf(s.id()).length())
            .max()
            .orElse(2);
        String parse = "P%" + maxIdLength + "d";

        // * Mostrar resultats
        System.out.println("ID\tET\tTAT\tTW");
        for (Status status : statuses) {
            int id = status.id();
            String parsedId = String.format(parse, id);

            System.out.printf(
                "%s\t%d\t%d\t%d%n",
                parsedId,
                status.endTime(),
                status.turnAround(),
                status.tw()
            );
        }

        // Mitjanes
        System.out.println();
        System.out.printf("Average WT: %.2f%n", wtAvg);
        System.out.printf("Average TAT: %.2f%n", tatAvg);
    }
}