package std.guedes.mydoublylinkedlist.util;

/**
 * As listas duplamente encadeadas são estruturas de dados e sua alocação da memória é feita durante a execução.
 * A conexão entre os elementos é feita através de dois ponteiros (um que aponta para o elemento anterior e o outro
 * para o seguinte). O ponteiro anterior ao primeiro elemento deve apontar para NULL (o início da lista), bem como o
 * ponteiro seguinte ao último elemento.
 *
 * @param <T> Tipo de dado que estará contido na lista.
 *
 * @author João Guedes.
 */
public class MyDoublyLinkedList<T> {

    /**
     * Primeiro nó da estrutura.
     */
    private Node<T> first = null;
    /**
     * Último nó da estrutura.
     */
    private Node<T> last = null;
    /**
     * Tamanho da LinkedList. Leva em consideração as posições ocupadas e não o tamanho literal do estrutura.
     */
    private int size = 0;

    /**
     * Retorna o número de posições ocupadas na estrutura.
     *
     * @return número de elementos contidos na estrutura.
     */
    public int size() {
        return this.size;
    }

    /**
     * Adiciona um elemento na estrutura.
     *
     * @param element elemento que será adicionado na estrutura.
     */
    public void add(T element) {
        if (this.isEmpty()) {
            this.first = new Node<>(element);
            this.last = this.first;
        }
        else {
            Node<T> newNode = new Node<>(element, this.last, null);
            this.last.setNext(newNode);
            this.last = newNode;
        }
        this.size++;
    }

    /**
     * Adiciona um elemento na estrutura na posição indicada. Caso a posição indicada não seja válida será lançada uma
     * exceção.
     *
     * @param index posição em que o elemento será adicionado.
     *
     * @param element elemento que será adicionado na estrutura.
     */
    public void add(int index, T element) {
        this.indexCheck(index);
        if (index == 0) {
            Node<T> newNode = new Node<>(element, this.first);
            this.first.setPrevious(newNode);
            this.first = newNode;
        }
        else if (index == size)
            this.add(element);
        else {
            Node<T> previousNode = this.getNode(index-1);
            Node<T> newNode = new Node<>(element, previousNode, previousNode.getNext());
            previousNode.setNext(newNode);
            newNode.getNext().setPrevious(newNode);
        }
        this.size++;
    }

    /**
     * Remove um elemento da estrutura com base em sua posição. Caso a posição indicada não seja válida será lançada uma
     * exceção.
     *
     * @param index posição do elemento que será removido.
     */
    public void remove(int index) {
        this.indexCheck(index);
        if (index == 0) {
            this.first = this.first.getNext();
            this.first.setPrevious(null);
        }
        else if (index == size-1) {
            this.last = this.last.getPrevious();
            this.last.setNext(null);
        }
        else {
            Node<T> auxNode = getNode(index-1);
            auxNode.setNext(auxNode.getNext().getNext());
            auxNode.getNext().setPrevious(auxNode);
        }
        this.size--;
    }

    /**
     * Remove um elemento da estrutura. Caso o elemento não esteja contido na estrutura será lançada um exceção.
     *
     * @param element Elemento que será removido.
     */
    public void remove(T element) {
        int index = this.indexOf(element);
        if (index < 0)
            throw new IllegalArgumentException("ERROR: element does not exist!");
        this.remove(index);
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
        if (index == 0)
            return this.first.getData();
        else if (index == this.size-1)
            return this.last.getData();
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
        if (index == 0)
            this.first.setData(element);
        else if (index == this.size-1)
            this.last.setData(element);
        else
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
        Node<T> auxNode = this.first;
        for (int i = 0; i < index; i++)
            auxNode = auxNode.getNext();
        return auxNode;
    }

    /**
     * Faz a limpeza da estrutura, removendo todos os elementos contidos.
     */
    public void clear() {
        for (Node<T> current = this.first; current != null;) {
            Node<T> next = current.getNext();
            current.setData(null);
            current.setPrevious(null);
            current.setNext(null);
            current = next;
        }
        this.first = null;
        this.last = null;
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
        Node<T> auxNode = this.first;
        for (int i = 0; i < this.size; i++) {
            if (element.equals(auxNode.getData()))
                return i;
            else
                auxNode = auxNode.getNext();
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
        Node<T> auxNode = this.last;
        for (int i = this.size-1; i >= 0; i--) {
            if (element.equals(auxNode.getData()))
                return i;
            else
                auxNode = auxNode.getPrevious();
        }
        return -1;
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
        StringBuilder sbuilder = new StringBuilder("MyLinkedList [");
        if (this.first != null)
            sbuilder.append(this.first);
        sbuilder.append("]");
        return sbuilder.toString();
    }

}