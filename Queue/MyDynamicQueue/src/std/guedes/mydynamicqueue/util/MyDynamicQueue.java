package std.guedes.mydynamicqueue.util;

/**
 * O paradigma por trás da fila (queue) é o FIFO - First In, First Out, ou “o primeiro a entrar é o primeiro a sair”, em tradução livre.
 * Sendo assim,  há somente duas formas de se manipular uma fila: 1) Inserir um elemento no final da fila e 2) remover um elemento do início da fila.
 *
 * @param <T> Tipo de dados que será armazenado na fila.
 *
 * @author João Guedes.
 */
public class MyDynamicQueue<T> {

    /**
     * Primeiro nó da estrutura.
     */
    private Node<T> first = null;
    /**
     * Último nó da estrutura.
     */
    private Node<T> last = null;
    /**
     * Tamanho da fila. Leva em consideração as posições ocupadas e não o tamanho literal do estrutura.
     */
    private int size = 0;

    /**
     * Retorna o tamanho da fila. Leva em consideração as posições ocupadas e não o tamanho literal do estrutura.
     *
     * @return Tamanho da fila.
     */
    public int size() {
        return this.size;
    }

    /**
     * Adiciona um elemento no fim da fila.
     *
     * @param element Elemento que será enfileirado.
     */
    public void enqueue(T element) {
        Node<T> newNode = new Node<>(element);
        if (this.last == null)
            this.last = newNode;
        else {
            this.last.setNext(newNode);
            this.last = newNode;
        }
        if (this.first == null)
            this.first = newNode;
        this.size++;
    }

    /**
     * Retorna o elemento que está no início da fila.
     *
     * @return Elemento que está no início da fila.
     */
    public T peek() {
        if (this.isEmpty())
            throw new RuntimeException("ERROR: Queue is empty!");
        return this.first.getData();
    }

    /**
     * Remove o elemento que está no início da fila.
     *
     * @return Elemento que será desenfileirado.
     */
    public T dequeue() {
        if (this.isEmpty())
            throw new RuntimeException("ERROR: Queue is empty!");
        T data = this.first.getData();
        this.first = this.first.getNext();
        this.size--;
        return data;
    }

    /**
     * Faz a limpeza da estrutura, removendo todos os elementos contidos.
     */
    public void clear() {
        for (Node<T> current = this.first; current != null;) {
            Node<T> next = current.getNext();
            current.setData(null);
            current.setNext(null);
            current = next;
        }
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    /**
     * Verifica se um elemento está contido na estrutura.
     *
     * @param element elemento buscado.
     *
     * @return true caso o elemento esteja contido na estrutura ou false caso ele não esteja contido na estrutura.
     */
    public boolean contains(T element) {
        Node<T> auxNode = this.first;
        for (int i = 0; i < this.size; i++) {
            if (element.equals(auxNode.getData()))
                return true;
            else
                auxNode = auxNode.getNext();
        }
        return false;
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
     * Retorna todo o conteúdo da estrutura em forma de texto (String).
     *
     * @return Todo o conteúdo da estrutura em forma de texto (String).
     */
    @Override
    public String toString() {
        StringBuilder sbuilder = new StringBuilder("[");
        if (this.first != null)
            sbuilder.append(this.first);
        sbuilder.append("]");
        return sbuilder.toString();
    }

}