package std.guedes.mybinarysearchtree.util;

/**
 * Essa classe representa um árvore binária. Numa árvore binária cada elemento é representado por um nó, e cada nó
 * deve conter no máximo dois filhos.
 *
 * @param <T> Tipo de dado que estará contido na árvore.
 *
 * @author João Guedes.
 */
public class MyBinaryTree<T> {

    /**
     * Raiz da árvore.
     */
    private Node<T> root;

    /**
     * Essa classe representa um árvore binária. Numa árvore binária cada elemento é representado por um nó, e cada nó
     * deve conter no máximo dois filhos.
     *
     * @param root Nó raiz da árvore.
     *
     * @author João Guedes.
     */
    public MyBinaryTree(Node<T> root) {
        this.root = root;
    }

    /**
     * Essa classe representa um árvore binária. Numa árvore binária cada elemento é representado por um nó, e cada nó
     * deve conter no máximo dois filhos.
     *
     * @param data Dado que estará armazenado na raiz da árvore.
     *
     * @author João Guedes.
     */
    public MyBinaryTree(T data) {
        this.root = new Node<T>(data);
    }

    /**
     * Essa classe representa um árvore binária. Numa árvore binária cada elemento é representado por um nó, e cada nó
     * deve conter no máximo dois filhos.
     *
     * @author João Guedes.
     */
    public MyBinaryTree(){
    }

    /**
     * Retorna a raiz da árvore.
     *
     * @return A raiz da árvore.
     */
    public Node<T> getRoot() {
        return this.root;
    }

    /**
     * Altera a raiz da árvore.
     *
     * @param root raiz que será atribuida a árvore.
     */
    public void setRoot(Node<T> root) {
        this.root = root;
    }

    /**
     * Retorna a altura de toda árvore, começando pela raiz, com base na quantidade de arestas.
     *
     * @return A altura de toda árvore, começando pela raiz, com base na quantidade de arestas.
     */
    public int height() {
        if (this.root == null)
            return 0;
        return this.height(this.root);
    }

    /**
     * Retorna a altura de uma subárvore da árvore, com base na quantidade de arestas. Caso o valor passado como parâmetro
     * seja a raiz o valor retornado será a altura de toda árvore.
     *
     * @param root Nó inícial.
     *
     * @return A altura de uma subárvore da árvore, ccom base na quantidade de arestas. Caso o valor passado como parâmetro
     * seja a raiz o valor retornado será a altura de toda árvore.
     */
    private int height(Node<T> root) {
        int heightLeft = -1, heightRight = -1;
        if (root.getLeft() != null)
            heightLeft = this.height(root.getLeft());
        if (root.getRight() != null)
            heightRight = this.height(root.getRight());
        return heightRight > heightLeft ? ++heightRight : ++heightLeft;
    }

    /**
     * Limpa toda a árvore, removendo todos os elementos.
     */
    public void clear() {
        if (this.root == null)
            throw new RuntimeException("ERROR: Tree is empty!");
        this.setRoot(this.clear(this.root));
    }

    /**
     * Limpa toda a árvore, removendo todos os elementos.
     *
     * @param root Nó incial (raiz).
     */
    private Node<T> clear(Node<T> root) {
        if (root == null)
            return null;
        root.setLeft(this.clear(root.getLeft()));
        root.setRight(this.clear(root.getRight()));
        return null;
    }

    /**
     * Faz um percurso em pré ordem  (primeiro a raiz, depois todos os da esquerda e por último os elementos da direita),
     * começando pela raiz.
     *
     * @return Todos os elementos da árvore em pré ordem.
     */
    public String preorderTraversal() {
        return this.preorderTraversal(this.root);
    }

    /**
     * Faz um percurso em pré ordem  (primeiro a raiz, depois todos os da esquerda e por último os elementos da direita),
     * começando pela raiz.
     *
     * @param root Nó inicial (raiz).
     *
     * @return Todos os elementos da árvore em pré ordem.
     */
    public String preorderTraversal(Node<T> root) {
        StringBuilder stringBuilder = new StringBuilder("[");
        this.preorderTraversal(root, stringBuilder);
        if (stringBuilder.length() > 1)
            stringBuilder.setCharAt(stringBuilder.length()-1, ']');
        else
            stringBuilder.append(']');
        return stringBuilder.toString();
    }

    /**
     * Faz um percurso em pré ordem  (primeiro a raiz, depois todos os da esquerda e por último os elementos da direita),
     * começando pela raiz.
     *
     * @param root Nó inicial (raiz).
     *
     * @param stringBuilder StringBuilder que armazenará os dados.
     */
    public void preorderTraversal(Node<T> root, StringBuilder stringBuilder) {
        if (root == null)
            return;
        if (root == this.root)
            stringBuilder.append("\u001B[33m").append(root).append("\u001B[0m").append(" ");
        else
            stringBuilder.append(root).append(" ");
        this.preorderTraversal(root.getLeft(), stringBuilder);
        this.preorderTraversal(root.getRight(), stringBuilder);
    }

    /**
     * Faz um percurso em ordem simétrica (todos os da esquerda primeiro, depois vem a raiz e por último os elementos da direita),
     * começando pela raiz.
     *
     * @return Todos os elementos da árvore em ordem simétrica.
     */
    public String inorderTraversal() {
        return this.inorderTraversal(this.root);
    }

    /**
     * Faz um percurso em ordem simétrica (todos os da esquerda primeiro, depois vem a raiz e por último os elementos da direita),
     * começando a partir de um nó qualquer da árvore.
     *
     * @param root Nó inicial (raiz).
     *
     * @return Todos os elementos da árvore em ordem simétrica.
     */
    public String inorderTraversal(Node<T> root) {
        StringBuilder stringBuilder = new StringBuilder("[");
        this.inorderTraversal(root, stringBuilder);
        if (stringBuilder.length() > 1)
            stringBuilder.setCharAt(stringBuilder.length()-1, ']');
        else
            stringBuilder.append(']');
        return stringBuilder.toString();
    }

    /**
     * Faz um percurso em ordem simétrica (todos os da esquerda primeiro, depois vem a raiz e por último os elementos da direita),
     * começando a partir de um nó qualquer da árvore.
     *
     * @param root Nó inicial (raiz).
     *
     * @param stringBuilder StringBuilder que armazenará os dados.
     */
    private void inorderTraversal(Node<T> root, StringBuilder stringBuilder) {
        if (root == null)
            return;
        this.inorderTraversal(root.getLeft(), stringBuilder);
        if (root == this.root)
            stringBuilder.append("\u001B[33m").append(root).append("\u001B[0m").append(" ");
        else
            stringBuilder.append(root).append(" ");
        this.inorderTraversal(root.getRight(), stringBuilder);
    }

    /**
     * Faz um percurso em pós ordem (todos os da esquerda primeiro. Só se visita a raiz depois de se visitar todos os outros nós),
     * começando pela raiz.
     *
     * @return Todos os elementos da árvore em pós ordem.
     */
    public String postorderTraversal() {
        return this.postorderTraversal(this.root);
    }

    /**
     * Faz um percurso em pós ordem (todos os da esquerda primeiro. Só se visita a raiz depois de se visitar todos os outros nós),
     * começando por um nó qualquer da árvore.
     *
     * @param root Nó inicial (raiz).
     *
     * @return Todos os elementos da árvore em pós ordem.
     */
    public String postorderTraversal(Node<T> root) {
        StringBuilder stringBuilder = new StringBuilder("[");
        this.postorderTraversal(root, stringBuilder);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    /**
     * Faz um percurso em pós ordem (todos os da esquerda primeiro. Só se visita a raiz depois de se visitar todos os outros nós),
     * começando por um nó qualquer da árvore.
     *
     * @param root Nó inicial (raiz).
     *
     * @param stringBuilder StringBuilder que armazenará os dados.
     */
    private void postorderTraversal(Node<T> root, StringBuilder stringBuilder) {
        if (root == null)
            return;
        this.postorderTraversal(root.getLeft(), stringBuilder);
        this.postorderTraversal(root.getRight(), stringBuilder);
        if (root == this.root)
            stringBuilder.append("\u001B[33m").append(root).append("\u001B[0m");
        else
            stringBuilder.append(root).append(" ");
    }

    /**
     * Retrona se a árvore está vazia.
     *
     * @return true caso a árvore não contenha elementos ou false caso ela contenha.
     */
    public boolean isEmpty() {
        return this.root == null;
    }

    /**
     * Retorna todos os elementos da árvore em formato de texto.
     *
     * @return Todos os elementos da árvore em formato de texto.
     */
    @Override
    public String toString() {
        return this.inorderTraversal();
    }

}