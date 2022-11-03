package std.guedes.mydynamicstack.util;

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
     * Essa classe representa um nó.
     *
     * @param data Dado que estará contido dentro do nó.
     *
     * @param previous Nó anterior.
     *
     * @author João Guedes.
     */
    public Node(T data, Node<T> previous) {
        this.data = data;
        this.previous = previous;
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
                Objects.equals(this.previous, node.previous);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.data, this.previous);
    }

    /**
     * Retorna todos os atributos do nó em forma de texto.
     *
     * @return Todos os atributos do nó em forma de texto.
     */
    @Override
    public String toString() {
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append(this.data);
        if (this.previous!= null)
            sBuilder.append(" || ").append(this.previous);
        return sBuilder.toString();
    }

}