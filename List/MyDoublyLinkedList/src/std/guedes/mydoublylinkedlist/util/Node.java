package std.guedes.mydoublylinkedlist.util;

import java.util.Objects;

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
     * Nó anterior.
     */
    private Node<T> previous;
    /**
     * Próximo nó.
     */
    private Node<T> next;

    /**
     * Essa classe representa um nó.
     *
     * @param data Dado que estará contido dentro do nó.
     *
     * @param previous Nó anterior.
     *
     * @param next Próximo nó.
     *
     * @author João Guedes.
     */
    public Node(T data, Node<T> previous, Node<T> next) {
        this.data = data;
        this.previous = previous;
        this.next = next;
    }

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
        this.previous = null;
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
        this.previous = null;
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
     * Retorna o nó anterior.
     *
     * @return O nó anterior.
     */
    public Node<T> getPrevious() {
        return this.previous;
    }

    /**
     * Altera o nó anterior.
     *
     * @param previous Nó anterior que se fará referência.
     */
    public void setPrevious(Node<T> previous) {
        this.previous = previous;
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
     * Verifica se dois nós são iguais.
     *
     * @param o Nó que será comparado.
     *
     * @return true caso os nós sejam iguais ou false caso sejam diferentes.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;
        Node<?> node = (Node<?>) o;
        return  Objects.equals(this.data, node.data) &&
                Objects.equals(this.previous, node.previous) &&
                Objects.equals(this.next, node.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.data, this.previous, this.next);
    }

    /**
     * Retorna todos os atributos do nó em forma de texto.
     *
     * @return Todos os atributos do nó em forma de texto.
     */
    @Override
    public String toString() {
        StringBuilder sbuilder = new StringBuilder();
        sbuilder.append(this.data);
        if (this.next != null)
            sbuilder.append(" -> ").append(this.next);
        return sbuilder.toString();
    }

}