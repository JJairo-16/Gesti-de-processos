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

El simulador funciona de manera interactiva a través de la línia d’ordres.  
Quan l’usuari l’executa, el programa segueix aquest procés:

1. **Introduir el nombre de processos**  
   El programa demana quants processos es volen simular.  
   Si s’introdueix `0`, es pregunta si es vol sortir del programa.

2. **Introduir el temps de cada procés**  
   Per a cada procés, l’usuari introdueix el seu temps de ràfega (temps de CPU necessari).

3. **Introduir el quantum**  
   Finalment, es demana el valor del *quantum*, que és la quantitat màxima de temps que pot utilitzar cada procés abans de cedir la CPU.

4. **Execució de la simulació**  
   El simulador aplica l’algorisme Round Robin amb les dades introduïdes i calcula:

   * el temps de finalització de cada procés,
   * el *turnaround time* (TAT),
   * el *waiting time* (WT),
   * i les mitjanes de tots dos valors.

5. **Visualització dels resultats**  
   Es mostra una taula amb els resultats de tots els processos i les mitjanes finals.

6. **Repetició opcional**  
   En acabar, el programa pregunta si l’usuari vol fer una nova simulació.  
   Si es respon “sí”, el procés es repeteix des del principi; si es respon “no”, el programa finalitza.

---

## Llicència

Aquest programa està baix la llicencia [MIT](LICENSE).
