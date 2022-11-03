package std.guedes.mysinglylinkedlist.util;

/**
 * Essa classe representa um nó.
 *
 * @param <T> Tipo de dado que estará contido dentro do nó.
 *
 * @author João Guedes.
 */
public class Node<T> {

    /**
     * Dado contido dentro do nó.
     */
    private T data;
    /**
     * Próximo nó.
     */
    private Node<T> next;

    /**
     * Essa classe representa um nó.
     *
     * @param data Dado que estará contido dentro do nó.
     *
     * @param next Próximo nó.
     *
     * @author João Guedes.
     */
    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    /**
     * Essa classe representa um nó.
     *
     * @param data Dado que estará contido dentro do nó.
     *
     * @author João Guedes.
     */
    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    /**
     * Retorna o dado que está contido dentro do nó.
     *
     * @return O dado que está contido dentro do nó.
     */
    public T getData() {
        return this.data;
    }

    /**
     * Altera o dado que está contido dentro do nó.
     *
     * @param data Dado que será atribuído ao nó.
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Retorna o próximo nó.
     *
     * @return O próximo nó.
     */
    public Node<T> getNext() {
        return this.next;
    }

    /**
     * Altera o próximo nó.
     *
     * @param next Próximo nó que se fara referência.
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     * Retorna todos os atributos do nó em forma de texto.
     *
     * @return Todos os atributos do nó em forma de texto.
     */
    @Override
    public String toString() {
        return "Node : " + this.data + " -> " + this.next;
    }

}