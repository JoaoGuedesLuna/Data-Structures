package std.guedes.emergencyroom;

import std.guedes.emergencyroom.service.Enqueue;
import std.guedes.emergencyroom.model.Patient;
import std.guedes.emergencyroom.service.Dequeue;
import java.util.Queue;
import java.util.PriorityQueue;

/**
 * @author João Guedes.
 */
public class EmergencyRoom {

    public static final int GREEN = 2;
    public static final int YELLOW = 1;
    public static final int RED = 0;

    public static void main(String [] args) {
       Queue<Patient> patientQueue = new PriorityQueue<>();
       patientQueue.add(new Patient("Paciente1", GREEN));
       patientQueue.add(new Patient("Paciente2", YELLOW));
       patientQueue.add(new Patient("Paciente3", RED));
       patientQueue.add(new Patient("Paciente4", GREEN));
       patientQueue.add(new Patient("Paciente5", GREEN));
       patientQueue.add(new Patient("Paciente6", RED));
       Dequeue dequeue = new Dequeue(patientQueue);
       Enqueue enqueue = new Enqueue(patientQueue);
       Thread t1 = new Thread(dequeue);
       Thread t2 = new Thread(enqueue);
       t1.start();
       t2.start();
    }

} 