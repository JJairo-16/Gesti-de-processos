package models;

public class Process {
    // * Propietats
    // Propietats del procés
    private int id;
    private int remaining;
    private final int burst;

    // Propietats de l'estat
    private int endTime;
    private int turnAround;
    private int wt;

    // #region Constructor i getters
    // * Constructor
    public Process(int id, int size) {
        this.id = id;
        this.burst = size;
        this.remaining = size;
    }

    public int getId() {
        return id;
    }

    public boolean isActive() {
        return remaining > 0;
    }

    // #endregion

    /**
     * Executa el procés durant un temps determinat.
     * 
     * @param now Temps actual.
     * @param q Quantum de temps.
     * @return Temps efectivament utilitzat per l'execució.
     */
    public int execute(int now, int q) {
        // * Simulació de cicles
        int used = Math.min(q, remaining);
        remaining -= used;

        if (remaining == 0) { // ? Finalitzat
            endProcess(now + used);
        }

        return used;
    }

    /**
     * Estat del procés.
     */
    public static record Status(
        int id,
        int endTime,
        int turnAround,
        int tw
    ) {}

    /**
     * Obté l'estat final del procés.
     * 
     * @return Estat final del procés.
     */
    public Status getStatus() {
        if (isActive()) {
            throw new IllegalStateException("El proceso no ha finalizado.");
        }

        return new Status(
            id,
            endTime,
            turnAround,
            wt
        );
    }

    /**
     * Finalitza el procés i calcula les seves mètriques.
     * 
     * @param finishTime Temps de finalització.
     */
    private void endProcess(int finishTime) {
        this.endTime = finishTime;
        this.turnAround = endTime;
        this.wt = turnAround - burst;
    }
}
