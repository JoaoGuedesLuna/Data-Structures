package std.guedes.mystaticqueue.util;

/**
 * O paradigma por trás da fila (queue) é o FIFO - First In, First Out, ou “o primeiro a entrar é o primeiro a sair”, em tradução livre.
 * Sendo assim,  há somente duas formas de se manipular uma fila: 1) Inserir um elemento no final da fila e 2) remover um elemento do início da fila.
 *
 * @param <T> Tipo de dados que será armazenado na fila.
 *
 * @author João Guedes.
 */
public class MyStaticQueue<T> {

    // <editor-fold defaultstate="collapsed" desc="@Attributes">
    /**
     * Vetor interno da fila.
     */
    private T[] array;
    /**
     * Tamanho da fila. Leva em consideração as posições ocupadas e não o tamanho literal do estrutura.
     */
    private int size;
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="@Constructors">
    /**
     * O paradigma por trás da fila (queue) é o FIFO - First In, First Out, ou “o primeiro a entrar é o primeiro a sair”, em tradução livre.
     * Sendo assim,  há somente duas formas de se manipular uma fila: 1) Inserir um elemento no final da fila e 2) remover um elemento do início da fila.
     *
     * @param size Tamanho inicial da fila.
     *
     * @author João Guedes.
     */
    public MyStaticQueue(int size) {
        this.array = (T[]) new Object[size];
        this.size = 0;
    }

    /**
     * O paradigma por trás da fila (queue) é o FIFO - First In, First Out, ou “o primeiro a entrar é o primeiro a sair”, em tradução livre.
     * Sendo assim,  há somente duas formas de se manipular uma fila: 1) Inserir um elemento no final da fila e 2) remover um elemento do início da fila.
     *
     * @author João Guedes.
     */
    public MyStaticQueue() {
        this.array = (T[]) new Object[10];
        this.size = 0;
    }
    // </editor-fold>

    /**
     * Retorna o tamanho da fila. Leva em consideração as posições ocupadas e não o tamanho literal do estrutura.
     *
     * @return Tamanho da fila.
     */
    public int size() {
        return this.size;
    }

    /**
     * Caso a quantidade de elementos contidos na estrutura seja igual o tamanho do array interno, este método
     * fará com que o array interno dobre sua capacidade de armazenamento.
     */
    private void expandSize() {
        if (this.array.length != this.size)
            return;
        T[] newArray = (T[]) new Object[this.array.length * 2];
        for (int i = 0; i < this.array.length; i++)
            newArray[i] = this.array[i];
        this.array = newArray;
    }

    /**
     * Caso o tamanho do array interno seja maior que 10 e o número de posições livres no array seja maior que 125% das
     * das posições ocupadas o array interno terá sua capacidade de armazenamento reduzida pela metade.
     */
    private void decreaseSize() {
        if (!(this.array.length > 10 && (this.array.length - this.size) > (int) Math.ceil(this.size*1.25)))
            return;
        T[] newArray = (T[]) new Object[this.array.length / 2];
        for (int i = 0; i < newArray.length; i++)
            newArray[i] = this.array[i];
        this.array = newArray;
    }

    /**
     * Adiciona um elemento no fim da fila.
     *
     * @param element Elemento que será enfileirado.
     */
    public void enqueue(T element) {
        this.expandSize();
        this.array[this.size++] = element;
    }

    /**
     * Retorna o elemento que está no início da fila.
     *
     * @return Elemento que está no início da fila.
     */
    public T peek() {
        if (this.isEmpty())
            return null;
        return this.array[0];
    }

    /**
     * Remove o elemento que está no início da fila.
     *
     * @return Elemento que será desenfileirado.
     */
    public T dequeue() {
        if (this.isEmpty())
            return null;
        T firstElements = this.peek();
        for(int i = 0; i < this.array.length-1; i++)
            this.array[i] = this.array[i+1];
        this.array[--this.size] = null;
        this.decreaseSize();
        return firstElements;
    }

    /**
     * Verifica se um elemento está contido na estrutura.
     *
     * @param element elemento buscado.
     *
     * @return true caso o elemento esteja contido na estrutura ou false caso ele não esteja contido na estrutura.
     */
    public boolean contains(T element) {
        for (int i = 0; i < this.size; i++) {
            if (this.array[i].equals(element))
                return true;
        }
        return false;
    }

    /**
     * Faz a limpeza da estrutura, removendo todos os elementos contidos.
     */
    public void clear() {
        this.array = (T[]) new Object[10];
        this.size = 0;
    }

    /**
     * Diz se a fila está vazia, se não contém elementos.
     *
     * @return true caso a fila esteja vazia ou false caso contenha algum elemento.
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Retorna todo o conteúdo da estrutura em forma de texto (String).
     *
     * @return todo o conteúdo da estrutura em forma de texto (String).
     */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("[");
        for (int i = 0; i < this.size-1; i++) {
            string.append(this.array[i]);
            string.append(", ");
        }
        if (!this.isEmpty())
            string.append(this.array[this.size-1]);
        string.append("]");
        return string.toString();
    }

}