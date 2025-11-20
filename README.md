# Simulador de Round Robin - Jairo Linares

---

## Que és?

Aquest projecte és un simulador de l’algorisme de planificació Round Robin, utilitzat en sistemes operatius per repartir el temps de CPU entre diversos processos de manera equitativa.
El programa permet introduir un conjunt de processos amb el seu temps de ràfega i un quantum, i genera com a resultat:

* El temps de finalització de cada procés
* El turnaround time
* El waiting time (temps d’espera)
* Les mitjanes corresponents

L’objectiu del simulador és mostrar, de manera pràctica, com funciona el Round Robin i com afecta el valor del quantum al rendiment i al temps d’espera dels processos.

---

## Com funciona?

1. **Nombre de processos**  
   El nombre total de processos també està definit dins del codi:

   ```java
   int numberOfProcesses = 3;
   ```

2. **Definició dels processos**  
   Els processos i els seus temps de ràfega estan actualment definits directament al codi:

   ```java
   int[] processTime = {6, 2, 4};
    ```

    Cada valor representa el temps de CPU que necessita cada procés per completar-se.

3. **Definició del quantum**

    El temps de quantum també està fixat manualment al programa:

    ```java
    int q = 2;
    ```

    Aquest valor indica quantes unitats de temps pot utilitzar un procés abans de cedir la CPU al següent.

---

## Llicència

Aquest programa està baix la llicencia [MIT](LICENSE).
