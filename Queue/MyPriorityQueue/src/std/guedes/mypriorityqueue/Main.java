package std.guedes.mypriorityqueue;

import std.guedes.mypriorityqueue.util.MyPriorityQueue;

public class Main {

    public static void main(String[] args) {
        MyPriorityQueue<Integer> priorityQueue = new MyPriorityQueue<>();
        System.out.println("Fila : " + priorityQueue);
        System.out.println("Tamanho da fila : " + priorityQueue.size());
        System.out.println("Fila está vazia ? " + priorityQueue.isEmpty());
        System.out.println("Adicionando elementos na fila ...");
        priorityQueue.enqueue(2);
        priorityQueue.enqueue(3);
        priorityQueue.enqueue(4);
        priorityQueue.enqueue(6);
        System.out.println("Fila : " + priorityQueue);
        System.out.println("Tamanho da fila : " + priorityQueue.size());
        System.out.println("Fila está vazia ? " + priorityQueue.isEmpty());
        System.out.println("Primeiro elemento : " + priorityQueue.peek());
        System.out.println("Removendo o primeiro elemento : " + priorityQueue.dequeue());
        System.out.println("Fila : " + priorityQueue);
        System.out.println("Tamanho da fila : " + priorityQueue.size());
        System.out.println("Adicionando elemento 9 na fila ...");
        priorityQueue.enqueue(9);
        System.out.println("Fila : " + priorityQueue);
        System.out.println("Adicionando elemento 1 na fila ...");
        priorityQueue.enqueue(1);
        System.out.println("Fila : " + priorityQueue);
        System.out.println("Adicionando elemento 5 na fila ...");
        priorityQueue.enqueue(5);
        System.out.println("Fila : " + priorityQueue);
        System.out.println("Limpando fila ... ");
        priorityQueue.clear();
        System.out.println("Fila : " + priorityQueue);
        System.out.println("Fila está vazia ? " + priorityQueue.isEmpty());
    }

}