package std.guedes.mystaticqueue2.util;

/**
 * O paradigma por trás da fila (queue) é o FIFO - First In, First Out, ou “o primeiro a entrar é o primeiro a sair”, em tradução livre.
 * Sendo assim,  há somente duas formas de se manipular uma fila: 1) Inserir um elemento no final da fila e 2) remover um elemento do início da fila.
 *
 * @param <T> Tipo de dados que será armazenado na fila.
 *
 * @author João Guedes.
 */
public class MyStaticQueue2<T> {

    // <editor-fold defaultstate="collapsed" desc="@Attributes">
    /**
     * Vetor interno da fila.
     */
    private T[] array;
    /**
     * Índice do primeiro elemento.
     */
    private int firstIndex;
    /**
     * Índice onde o último elemento pode ser inserido.
     */
    private int lastIndex;
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
    public MyStaticQueue2(int size) {
        this.array = (T[]) new Object[size];
        this.firstIndex = 0;
        this.lastIndex = 0;
    }

    /**
     * O paradigma por trás da fila (queue) é o FIFO - First In, First Out, ou “o primeiro a entrar é o primeiro a sair”, em tradução livre.
     * Sendo assim,  há somente duas formas de se manipular uma fila: 1) Inserir um elemento no final da fila e 2) remover um elemento do início da fila.
     *
     * @author João Guedes.
     */
    public MyStaticQueue2() {
        this.array = (T[]) new Object[10];
        this.firstIndex = 0;
        this.lastIndex = 0;
    }
    // </editor-fold>

    /**
     * Retorna o tamanho da fila. Leva em consideração as posições ocupadas e não o tamanho literal do estrutura.
     *
     * @return Tamanho da fila.
     */
    public int size() {
        return lastIndex - firstIndex;
    }

    /**
     * Caso a quantidade de elementos contidos na estrutura seja igual o tamanho do array interno, este método
     * fará com que o array interno dobre sua capacidade de armazenamento.
     */
    private void expandSize() {
        if (this.array.length != this.size())
            return;
        int length = this.array.length;
        T[] newArray = (T[]) new Object[length * 2];
        for (int i = this.firstIndex, j = 0; i < this.lastIndex; i++, j++)
            newArray[j] = this.array[i % length];
        this.array = newArray;
        this.firstIndex = 0;
        this.lastIndex = length;
    }

    /**
     * Caso o tamanho do array interno seja maior que 10 e o número de posições livres no array seja maior que 125% das
     * das posições ocupadas o array interno terá sua capacidade de armazenamento reduzida pela metade.
     */
    private void decreaseSize() {
        int size = this.size();
        if (!(this.array.length > 10 && (this.array.length - size) > (int) Math.ceil(size*1.25)))
            return;
        int length = this.array.length;
        T[] newArray = (T[]) new Object[length / 2];
        for (int i = 0, j = this.firstIndex; i < newArray.length; i++, j++)
            newArray[i] = this.array[j % length];
        this.array = newArray;
        this.firstIndex = 0;
        this.lastIndex = size;
    }

    /**
     * Adiciona um elemento no fim da fila.
     *
     * @param element Elemento que será enfileirado.
     */
    public void enqueue(T element) {
        this.expandSize();
        this.array[this.lastIndex % this.array.length] = element;
        this.lastIndex++;
    }

    /**
     * Retorna o elemento que está no início da fila.
     *
     * @return Elemento que está no início da fila.
     */
    public T peek() {
        if (this.isEmpty())
            return null;
        return this.array[(this.firstIndex % this.array.length)];
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
        this.array[this.firstIndex++] = null;
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
        int currentIndex = this.firstIndex;
        for (int i = 0 ; i < index; i++, currentIndex++) {}
        return this.array[currentIndex];
    }

    /**
     * Retorna a primeira posição de um elemento contido na estrutura. Caso o elemento não esteja contido na estrutura o valor retornado será -1.
     *
     * @param element elemento pela qual está se buscado a posição.
     *
     * @return primeira posição do elemento na estrutura. Caso ele não esteja contido na estrutura o valor retornado será -1.
     */
    public int indexOf(T element) {
        int size = this.size();
        for (int i = 0, currentIndex = this.firstIndex; i < size; i++, currentIndex++) {
            if (this.array[currentIndex].equals(element))
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
        for (int i = this.size()-1, currentIndex = this.lastIndex-1; i >= 0; i--, currentIndex--) {
            if (this.array[currentIndex].equals(element))
                return i;
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
     * Faz a limpeza da estrutura, removendo todos os elementos contidos.
     */
    public void clear() {
        this.array = (T[]) new Object[10];
        this.firstIndex = 0;
        this.lastIndex = 0;
    }

    /**
     * Diz se a fila está vazia, se não contém elementos.
     *
     * @return true caso a fila esteja vazia ou false caso contenha algum elemento.
     */
    public boolean isEmpty() {
        return this.firstIndex == this.lastIndex;
    }

    /**
     * Verifica se um índice (posição) passado como parâmetro é válido.
     *
     * @param index índice que será verificado.
     */
    private void indexCheck(int index) {
        if(!(index >= 0 && index < this.size()))
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
        for (int i = this.firstIndex; i < this.lastIndex-1; i++) {
            string.append(this.array[i % this.array.length]);
            string.append(", ");
        }
        if (!this.isEmpty())
            string.append(this.array[this.lastIndex-1]);
        string.append("]");
        return string.toString();
    }

}