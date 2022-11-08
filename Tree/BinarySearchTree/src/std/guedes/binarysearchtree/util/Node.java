package std.guedes.binarysearchtree.util;

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
     * Nó da esquerda.
     */
    private Node<T> left;
    /**
     * Nó da direita.
     */
    private Node<T> right;

    /**
     * Essa classe representa um nó.
     *
     * @param data Dado que estará contido dentro do nó.
     *
     * @param left Nó da esquerda.
     *
     * @param right Nó da direita.
     *
     * @author João Guedes.
     */
    public Node(T data, Node<T> left, Node<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    /**
     * Essa classe representa um nó.
     *
     * @param data Dado que estará contido dentro do nó.
     *
     * @author João Guedes.
     */
    public Node (T data) {
        this.data = data;
        this.left = null;
        this.right = null;
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
     * Retorna o nó da esquerda.
     *
     * @return O nó da esquerda.
     */
    public Node<T> getLeft() {
        return this.left;
    }

    /**
     * Altera o nó da esquerda.
     *
     * @param left Nó da esquerda que se fará referência.
     */
    public void setLeft(Node<T> left) {
        this.left = left;
    }

    /**
     * Retorna o nó da direita.
     *
     * @return O nó da direita.
     */
    public Node<T> getRight() {
        return this.right;
    }

    /**
     * Altera o nó da direita.
     *
     * @param right Nó da direita que se fara referência.
     */
    public void setRight(Node<T> right) {
        this.right = right;
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
                Objects.equals(this.left, node.left) &&
                Objects.equals(this.right, node.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.data, this.left, this.right);
    }

    /**
     * Retorna todos os atributos do nó em forma de texto.
     *
     * @return Todos os atributos do nó em forma de texto.
     */
    @Override
    public String toString() {
        return this.data.toString();
    }

}