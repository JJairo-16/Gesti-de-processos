package services;

import java.util.ArrayList;
import java.util.Arrays;

import models.Process;

public class Executer {
    // * Propietats
    // Propietats del processos
    private ArrayList<Process> processes;
    private int[] finalized;
    private Process.Status[] statuses;

    // Propietats de l'executor
    private int numberOfProcesses;
    private int q;

    // * Constructor
    public Executer(int numberOfProcesses, int[] processTime, int q) {
        // * Inicialitzar propietats de l'executor
        this.q = q;
        this.numberOfProcesses = numberOfProcesses;

        // * Inicialitzar processos
        this.processes = new ArrayList<>(numberOfProcesses);
        for (int i = 0; i < numberOfProcesses; i++) {
            processes.add(new Process(i + 1, processTime[i]));
        }

        // * Inicialitzar estats i finalitzats
        this.statuses = new Process.Status[numberOfProcesses];
        this.finalized = new int[numberOfProcesses];
    }

    // * Mètodes
    /**
     * Executa l'algorisme de Round Robin sobre els processos.
     */
    public void execute() {
        // * Declaració de variables
        int now = 0;
        int idx = 0;
        int remainingCount = numberOfProcesses;

        do {
            // * Obtenir valors actuals
            Process current = processes.get(idx);
            int id = current.getId();

            // * Omet processos finalitzats
            if (isFinalized(id)) {
                idx = updateIdx(idx);
                continue;
            }

            // * Executar procés actual
            int executedTime = current.execute(now, q);
            now += executedTime;

            // * Finalitzar procés si no està actiu
            if (!current.isActive()) {
                Process.Status status = current.getStatus();
                statuses[idx] = status;
                finalized[idx] = id;
                remainingCount--;
            }

            idx = updateIdx(idx);
        } while (remainingCount > 0);
    }

    /**
     * Obté els estats finals dels processos.
     * 
     * @return Array de Process.Status amb els estats finals.
     */
    public Process.Status[] getStatuses() {
        if (!Arrays.stream(finalized).allMatch(n -> n != 0)) {
            throw new IllegalStateException("No tots els processos han finalitzat.");
        }
        return statuses;
    }

    // #region Helpers
    private boolean isFinalized(int id) {
        return Arrays.stream(finalized).anyMatch(n -> n == id);
    }

    private int updateIdx(int idx) {
        idx++;
        return (idx == numberOfProcesses) ? 0 : idx;
    }

    // #endregion
}
