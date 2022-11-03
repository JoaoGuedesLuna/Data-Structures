package std.guedes.mystaticqueue2;

import std.guedes.mystaticqueue2.util.MyStaticQueue2;

public class Main {

    public static void main(String[] args) {
        MyStaticQueue2<Integer> queue = new MyStaticQueue2<>(2);
        System.out.println("Fila : " + queue);
        System.out.println("Tamanho da fila : " + queue.size());
        System.out.println("Fila está vazia ? " + queue.isEmpty());
        System.out.println("Adicionando elementos na fila...");
        for (int i = 0; i < 50; i++)
            queue.enqueue(i);
        System.out.println("Fila : " + queue);
        System.out.println("Primeiro elemento : " + queue.peek());
        System.out.println("Removendo o primeiro elemento : " + queue.dequeue());
        System.out.println("Fila : " + queue);
        System.out.println("Tamanho da fila : " + queue.size());
        System.out.println("Fila está vazia ? " + queue.isEmpty());
        System.out.println("Removendo elementos da fila...");
        for (int i = 0; i < 14; i++)
            queue.dequeue();
        System.out.println("Fila : " + queue);
        System.out.println("Tamanho da fila : " + queue.size());
        System.out.println("Fila está vazia ? " + queue.isEmpty());
        System.out.println("Adicionando elementos na fila...");
        for (int i = 0; i < 50; i++)
            queue.enqueue(i);
        System.out.println("Fila : " + queue);
        System.out.println("Tamanho da fila : " + queue.size());
        System.out.println("Fila está vazia ? " + queue.isEmpty());
        System.out.println("Limpando fila ... ");
        queue.clear();
        System.out.println("Fila : " + queue);
        System.out.println("Fila está vazia ? " + queue.isEmpty());
    }

}