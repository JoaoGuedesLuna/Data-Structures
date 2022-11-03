package std.guedes.mydynamicstack.util;

/**
 * Stack (pilha, em português) é uma coleção de itens ou estrutura de dados, onde a adição e a remoção de um item é feita
 * pela mesma saída. Essa saída é comumente chamada de “top” e o extremo oposto é chamado de “base”. O item mais recentemente
 * adicionado será o primeiro removido em caso de remoção, já que estará no topo (ou “top”).
 *
 * @param <T> Tipo de dado que estará contido dentro da pilha.
 *
 * @author  João Guedes.
 */
public class MyDynamicStack<T> {

    /**
     * Nó do topo estrutura.
     */
    private Node<T> top = null;
    /**
     * Tamanho da pilha. Leva em consideração as posições ocupadas e não o tamanho literal do estrutura.
     */
    private int size = 0;

    /**
     * Retorna o tamanho da pilha. Leva em consideração as posições ocupadas e não o tamanho literal do estrutura.
     *
     * @return Tamanho da pilha.
     */
    public int size() {
        return this.size;
    }

    /**
     * Adiciona um elemento no topo da pilha.
     *
     * @param element Elemento que será empilhado.
     */
    public void push(T element) {
        this.top = new Node<>(element, this.top);
        this.size++;
    }

    /**
     * Retorna o elemento do topo da pilha.
     *
     * @return Elemento do topo da pilha.
     */
    public T peek () {
        if (this.isEmpty())
            throw new RuntimeException("ERROR: Stack is empty!");
        return this.top.getData();
    }

    /**
     * Remove o elemento do topo da pilha.
     *
     * @return Elemento desempilhado.
     */
    public T pop() {
        if (this.isEmpty())
            throw new RuntimeException("ERROR: Stack is empty!");
        T topData = this.top.getData();
        this.top = this.top.getPrevious();
        this.size--;
        return topData;
    }

    /**
     * Retorna um elemento contido na estrutura com base em sua posição. Caso a posição seja inválida será lançada uma
     * exceção.
     *
     * @param index posição do elemento na estrutura que está sendo buscado.
     *
     * @return um elemento contido na estrutura com base em sua posição.
     */
    public T get(int index) {
        this.indexCheck(index);
        return this.getNode(index).getData();
    }

    /**
     * Faz a substituição de um elemento da estrutura com base em sua posição. Caso a posição seja inválida será
     * lançada uma exceção.
     *
     * @param index posição do elemento que será substituído.
     *
     * @param element novo elemento que ocupará a posição substituída.
     */
    public void set(int index, T element) {
        this.indexCheck(index);
        this.getNode(index).setData(element);
    }

    /**
     * Retorna o nó de uma posição específica. Caso a posição seja inválida será lançada uma exceção.
     *
     * @param index Posição do nó buscado.
     *
     * @return Um nó contido na estrutura com base em sua posição.
     */
    private Node<T> getNode(int index) {
        this.indexCheck(index);
        Node<T> auxNode = this.top;
        for (int i = 0; i < index; i++)
            auxNode = auxNode.getPrevious();
        return auxNode;
    }

    /**
     * Faz a limpeza da estrutura, removendo todos os elementos contidos.
     */
    public void clear() {
        for (Node<T> current = this.top; current != null;) {
            Node<T> previous = current.getPrevious();
            current.setData(null);
            current.setPrevious(null);
            current = previous;
        }
        this.top = null;
        this.size = 0;
    }

    /**
     * Retorna a primeira posição de um elemento contido na estrutura. Caso o elemento não esteja contido na estrutura o valor retornado será -1.
     *
     * @param element elemento pela qual está se buscado a posição.
     *
     * @return primeira posição do elemento na estrutura. Caso ele não esteja contido na estrutura o valor retornado será -1.
     */
    public int indexOf(T element) {
        Node<T> auxNode = this.top;
        for (int i = 0; i < this.size; i++) {
            if (element.equals(auxNode.getData()))
                return i;
            else
                auxNode = auxNode.getPrevious();
        }
        return -1;
    }

    /**
     * Retorna a última posição de um elemento contido na estrutura. Caso o elemento não esteja contido na estrutura o valor retornado será -1.
     *
     * @param element elemento pela qual está se buscado a posição.
     *
     * @return última posição do elemento na estrutura. Caso ele não esteja contido na estrutura o valor retornado será -1.
     */
    public int lastIndexOf(T element) {
        int lastIndex = -1;
        Node<T> auxNode = this.top;
        for (int i = 0; i < this.size; i++) {
            if (element.equals(auxNode.getData()))
                lastIndex = i;
            else
                auxNode = auxNode.getPrevious();
        }
        return lastIndex;
    }

    /**
     * Verifica se um elemento está contido na estrutura.
     *
     * @param element elemento buscado.
     *
     * @return true caso o elemento esteja contido na estrutura ou false caso ele não esteja contido na estrutura.
     */
    public boolean contains(T element) {
        return this.indexOf(element) >= 0;
    }

    /**
     * Diz se a estrutura está vazia, se não contém elementos.
     *
     * @return true caso a estrutura esteja vazia ou false caso contenha algum elemento.
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Verifica se um índice (posição) passado como parâmetro é válido.
     *
     * @param index índice que será verificado.
     */
    private void indexCheck(int index) {
        if (index < 0 || index >= this.size)
            throw new IllegalArgumentException("ERROR: invalid index!");
    }

    /**
     * Retorna todo o conteúdo da estrutura em forma de texto (String).
     *
     * @return Todo o conteúdo da estrutura em forma de texto (String).
     */
    @Override
    public String toString() {
        StringBuilder sbuilder = new StringBuilder("MyDynamicStack [");
        if (this.top != null)
            sbuilder.append(this.top);
        sbuilder.append("]");
        return sbuilder.toString();
    }

}