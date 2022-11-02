package std.guedes.mypriorityqueue.util;

/**
 * A fila com prioridade é muito semelhante a fila normal, com exceção de que ela mantém sempre na primeira posição o elemento
 * de maior prioridade armazenado, note que, a estrutura não mantém os elementos ordenados, ela apenas garante que o elemento
 * mais a frente é o de maior prioridade. O paradigma por trás da fila é o FIFO - First In, First Out, ou “o primeiro a entrar
 * é o primeiro a sair”, em tradução livre. Sendo assim,  há somente duas formas de se manipular uma fila: 1) Inserir um elemento
 * no final da fila e 2) remover um elemento do início da fila.
 *
 * @param <T> Tipo de dados que será armazenado na fila.
 *
 * @author João Guedes.
 */
public class MyPriorityQueue<T> {

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
     * A fila com prioridade é muito semelhante a fila normal, com exceção de que ela mantém sempre na primeira posição o elemento
     * de maior prioridade armazenado, note que, a estrutura não mantém os elementos ordenados, ela apenas garante que o elemento
     * mais a frente é o de maior prioridade. O paradigma por trás da fila é o FIFO - First In, First Out, ou “o primeiro a entrar
     * é o primeiro a sair”, em tradução livre. Sendo assim,  há somente duas formas de se manipular uma fila: 1) Inserir um elemento
     * no final da fila e 2) remover um elemento do início da fila.
     *
     * @param size Tamanho inicial da fila.
     *
     * @author João Guedes.
     */
    public MyPriorityQueue(int size) {
        this.array = (T[]) new Object[size];
        this.size = 0;
    }

    /**
     * A fila com prioridade é muito semelhante a fila normal, com exceção de que ela mantém sempre na primeira posição o elemento
     * de maior prioridade armazenado, note que, a estrutura não mantém os elementos ordenados, ela apenas garante que o elemento
     * mais a frente é o de maior prioridade. O paradigma por trás da fila é o FIFO - First In, First Out, ou “o primeiro a entrar
     * é o primeiro a sair”, em tradução livre. Sendo assim,  há somente duas formas de se manipular uma fila: 1) Inserir um elemento
     * no final da fila e 2) remover um elemento do início da fila.
     *
     * @author João Guedes.
     */
    public MyPriorityQueue() {
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
        if (this.size == 0)
            this.array[this.size++] = element;
        else {
            this.expandSize();
            Comparable<T> key = (Comparable<T>) element;
            int index;
            for (index = 0; index < this.size; index++) {
                if (key.compareTo(this.array[index]) < 0)
                    break;
            }
            for (int i = this.size-1; i >= index; i--)
                this.array[i+1] = this.array[i];
            this.array[index] =  element;
            this.size++;
        }
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
     * Retorna um elemento contido na estrutura com base em sua posição. Caso a posição seja inválida será lançada uma
     * exceção.
     *
     * @param index posição do elemento na estrutura que está sendo buscado.
     *
     * @return um elemento contido na estrutura com base em sua posição.
     */
    public T get(int index) {
        this.indexCheck(index);
        return this.array[index];
    }

    /**
     * Retorna a primeira posição de um elemento contido na estrutura. Caso o elemento não esteja contido na estrutura o valor retornado será -1.
     *
     * @param element elemento pela qual está se buscado a posição.
     *
     * @return primeira posição do elemento na estrutura. Caso ele não esteja contido na estrutura o valor retornado será -1.
     */
    public int indexOf(T element) {
        for (int i = 0; i < this.size; i++) {
            if (this.array[i].equals(element))
                return i;
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
        for (int i = this.size-1; i >= 0; i--) {
            if (this.array[i].equals(element))
                return i;
        }
        return -1;
    }

    /**
     * Verifica se um elemento está contido na estrutura.
     *
     * @param elements elemento buscado.
     *
     * @return true caso o elemento esteja contido na estrutura ou false caso ele não esteja contido na estrutura.
     */
    public boolean contains(T element) {
        return this.indexOf(element) >= 0;
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
     * Verifica se um índice (posição) passado como parâmetro é válido.
     *
     * @param index índice que será verificado.
     */
    private void indexCheck(int index) {
        if(!(index >= 0 && index < this.size))
            throw new IllegalArgumentException("ERROR: invalid index!");
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