package std.guedes.mybinarysearchtree.util;

/**
 * Em Ciência da computação, uma árvore binária de busca é uma estrutura de dados de árvore binária baseada em nós,
 * onde todos os nós da subárvore esquerda possuem um valor numérico inferior ao nó raiz e todos os nós da subárvore
 * direita possuem um valor superior ao nó raiz. O objetivo desta árvore é estruturar os dados de forma a permitir
 * busca binária.
 *
 * @param <T> Tipo de dado que estará contido na árvore.
 *
 * @author João Guedes.
 */
public class MyBinarySearchTree<T> extends MyBinaryTree<T> {

    /**
     * Em Ciência da computação, uma árvore binária de busca é uma estrutura de dados de árvore binária baseada em nós,
     * onde todos os nós da subárvore esquerda possuem um valor numérico inferior ao nó raiz e todos os nós da subárvore
     * direita possuem um valor superior ao nó raiz. O objetivo desta árvore é estruturar os dados de forma a permitir
     * busca binária.
     *
     * @param root Nó raiz da árvore.
     *
     * @author João Guedes.
     */
    public MyBinarySearchTree(Node<T> root) {
        super(root);
    }

    /**
     * * Em Ciência da computação, uma árvore binária de busca é uma estrutura de dados de árvore binária baseada em nós,
     *  * onde todos os nós da subárvore esquerda possuem um valor numérico inferior ao nó raiz e todos os nós da subárvore
     *  * direita possuem um valor superior ao nó raiz. O objetivo desta árvore é estruturar os dados de forma a permitir
     *  * busca binária.
     *
     * @param data Dado que estará armazenado na raiz da árvore.
     *
     * @author João Guedes.
     */
    public MyBinarySearchTree(T data) {
        super(data);
    }

    /**
     * Em Ciência da computação, uma árvore binária de busca é uma estrutura de dados de árvore binária baseada em nós,
     * onde todos os nós da subárvore esquerda possuem um valor numérico inferior ao nó raiz e todos os nós da subárvore
     * direita possuem um valor superior ao nó raiz. O objetivo desta árvore é estruturar os dados de forma a permitir
     * busca binária.
     *
     * @author João Guedes.
     */
    public MyBinarySearchTree() {
        super();
    }

    /**
     * Adiciona um elemento na árvore.
     *
     * @param data Elemento que será adicionado na árvore.
     */
    public void add(T data) {
        this.setRoot(this.add(data, this.getRoot()));
    }

    /**
     * Adiciona um elemento na árvore.
     *
     * @param data Elemento que será adicionado na árvore.
     *
     * @param root Nó inicial (raiz).
     *
     * @return Um nó.
     */
    private Node<T> add(T data, Node<T> root) {
        if (root == null)
            return new Node<>(data);
        Comparable<T> dataComparable = (Comparable) data;
        if (dataComparable.compareTo(root.getData()) < 0)
            root.setLeft(this.add(data, root.getLeft()));
        else
            root.setRight(this.add(data, root.getRight()));
        return root;
    }

    /**
     * Remove um elemento da árvore.
     *
     * @param data Elemento da árvore.
     */
    public void remove(T data) {
        if (this.getRoot() == null)
            throw new RuntimeException("ERROR: Tree is empty!");
        this.setRoot(this.remove(data, this.getRoot()));
    }

    /**
     * Remove um elemento da árvore.
     *
     * @param data Elemento da árvore.
     *
     * @param root Raiz da árvore.
     */
    private Node<T> remove(T data, Node<T> root) {
        if (root == null)
            throw new RuntimeException("ERROR: Data not founded!");
        Comparable<T> dataComparable = (Comparable) data;
        if (dataComparable.compareTo(root.getData()) < 0)
            root.setLeft(this.remove(data, root.getLeft()));
        else if (dataComparable.compareTo(root.getData()) > 0)
            root.setRight(this.remove(data, root.getRight()));
        else {
            if (root.getLeft() == null)
                return root.getRight();
            if (root.getRight() == null)
                return root.getLeft();
            root.setData(this.min(root.getRight()));
            root.setRight(this.remove(root.getData(), root.getRight()));
        }
        return root;
    }

    /**
     * Retorna o menor elemento da árvore.
     *
     * @return O menor elemento da árvore.
     */
    public T min() {
        return this.min((this.getRoot()));
    }

    /**
     * Retorna o menor elemento da árvore.
     *
     * @param root Raiz da árvore.
     *
     * @return O menor elemento da árvore.
     */
    public T min(Node<T> root) {
        if (root == null)
            throw new RuntimeException("ERROR: Tree is empty!");
        Node<T> currentNode = root;
        while (currentNode.getLeft() != null)
            currentNode = currentNode.getLeft();
        return currentNode.getData();
    }

    /**
     * Retorna o maior elemento da árvore.
     *
     * @return O maior elemento da árvore.
     */
    public T max() {
        return this.max(this.getRoot());
    }

    /**
     * Retorna o maior elemento da árvore.
     *
     * @param root Raiz da árvore.
     *
     * @return O maior elemento da árvore.
     */
    public T max(Node<T> root) {
        if (root == null)
            throw new RuntimeException("ERROR: Tree is empty!");
        Node<T> currentNode = root;
        while (currentNode.getRight() != null)
            currentNode = currentNode.getRight();
        return currentNode.getData();
    }

    /**
     * Faz a busca de um elemento e retorna uma árvore a partir desse elemento.
     *
     * @param data Elemento buscado.
     *
     * @return uma subárvore.
     */
    public MyBinarySearchTree<T> search(T data) {
        return this.search(data, this.getRoot());
    }

    /**
     * Faz a busca de um elemento e retorna uma árvore a partir desse elemento.
     *
     * @param data Elemento buscado.
     *
     * @param root Nó inicial (raiz).
     *
     * @return uma subárvore.
     */
    private MyBinarySearchTree<T> search(T data, Node<T> root) {
        Comparable<T> dataComparable = (Comparable) data;
        if (root == null || dataComparable.compareTo(root.getData()) == 0)
            return new MyBinarySearchTree<>(root);
        else if(dataComparable.compareTo(root.getData()) < 0)
            return this.search(data, root.getLeft());
        return this.search(data, root.getRight());
    }

}