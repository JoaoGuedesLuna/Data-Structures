package std.guedes.emergencyroom.service;

import std.guedes.emergencyroom.model.Patient;
import java.util.Queue;
import java.util.Random;

/**
 * Essa classe tem a função de ir enfileirando a fila de pacientes com um novo paciente de tempos em tempos.
 *
 * @author João Guedes.
 */
public class Enqueue implements Runnable {

    /**
     * Fila em que o paciente será inserido.
     */
    private Queue<Patient> patienteQueue;
    /**
     * Número do paciente.
     */
    private int cont = 7;
    /**
     * Random que gerará a prioridade do paciente.
     */
    private Random priority = new Random();

    /**
     * Essa classe tem a função de ir enfileirando a fila de pacientes com um novo paciente de tempos em tempos.
     *
     * @param patienteQueue Fila em que o paciente será inserido.
     *
     * @author João Guedes.
     */
    public Enqueue(Queue<Patient> patienteQueue) {
        this.patienteQueue = patienteQueue;
    }

    /**
     * Faz um pausa na execução do programa.
     *
     * @param millis Tempo da pausa em milissegundos.
     */
    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 8; i++) {
            this.sleep(8000);
            Patient newPatient = new Patient("Paciente" + cont++, priority.nextInt(3));
            patienteQueue.add(newPatient);
            System.out.println(newPatient.getName() + " adicionado a fila.");
        }
    }

}