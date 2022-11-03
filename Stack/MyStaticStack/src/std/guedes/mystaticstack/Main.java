package std.guedes.mystaticstack;

import std.guedes.mystaticstack.util.MyStaticStack;

public class Main {

    public static void main(String[] args) {
        MyStaticStack<Integer> stack = new MyStaticStack<>();
        System.out.println(stack);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("Pilha : " + stack);
        System.out.println("Último elemento : " + stack.peek());
        System.out.println("Elemento removido : " + stack.pop());
        System.out.println("Pilha : " + stack);
        System.out.println("Último elemento : " + stack.peek());
        System.out.println("Índice do último elemento : " + stack.lastIndexOf(stack.peek()));
    }
}