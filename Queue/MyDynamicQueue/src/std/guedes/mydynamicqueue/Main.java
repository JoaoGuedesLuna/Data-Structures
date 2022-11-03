package std.guedes.mydynamicqueue;

import std.guedes.mydynamicqueue.util.MyDynamicQueue;

public class Main {

    public static void main(String[] args) {
        MyDynamicQueue<Integer> queue = new MyDynamicQueue<>();
        System.out.println("Fila : " + queue);
        System.out.println("Tamanho da fila : " + queue.size());
        System.out.println("Fila está vazia ? " + queue.isEmpty());
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        System.out.println("Fila : " + queue);
        System.out.println("Primeiro elemento : " + queue.peek());
        System.out.println("Removendo o primeiro elemento : " + queue.dequeue());
        System.out.println("Fila : " + queue);
        System.out.println("Tamanho da fila : " + queue.size());
        System.out.println("Fila está vazia ? " + queue.isEmpty());
        System.out.println("Limpando fila ... ");
        queue.clear();
        System.out.println("Fila : " + queue);
        System.out.println("Fila está vazia ? " + queue.isEmpty());
    }

}