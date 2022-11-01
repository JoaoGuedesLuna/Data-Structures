package std.guedes.emergencyroom.service;

import std.guedes.emergencyroom.model.Patient;
import java.util.Queue;

/**
 * Essa classe tem a função de ir desenfileirando a fila de pacientes de tempos em tempos.
 *
 * @author João Guedes.
 */
public class Dequeue implements Runnable {

    /**
     * Fila de pacientes que será desenfileirada.
     */
    private Queue<Patient> patientQueue;

    /**
     * Essa classe tem a função de ir desenfileirando a fila de pacientes de tempos em tempos.
     *
     * @param patientQueue Fila de pacientes que será desenfileirada.
     *
     * @author João Guedes.
     */
    public Dequeue(Queue<Patient> patientQueue) {
        this.patientQueue = patientQueue;
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
        while(!patientQueue.isEmpty()) {
            System.out.println(patientQueue.remove().getName() + " atendido.");
            this.sleep(5000);
        }
        System.out.println("Atendimento concluido.");
    }

}