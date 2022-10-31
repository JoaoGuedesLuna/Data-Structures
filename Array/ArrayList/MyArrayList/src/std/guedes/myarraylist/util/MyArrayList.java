package std.guedes.myarraylist.util;

/**
 * Essa classe é uma Estrutura de Dados ArrayList. Uma coleção indexada de objetos às vezes chamada de sequência.
 * Como nos vetores, índices da MyArrayList são baseados em zero, isto é, o índice do primeiro elemento é zero.
 * MyArrayList fornece métodos para manipular elementos baseado na sua posição (ou índice) numérica na lista,
 * remover determinado elemento, procurar as ocorrências de um dado elemento e percorrer sequencialmente (ListIterator)
 * todos os elementos da lista.
 *
 * @author João Guedes.
 * 
 * @param <T> Tipo de dados que a ArrayList armazenará.
 */
public class MyArrayList<T> {

    // <editor-fold defaultstate="collapsed" desc="@Attributes">
    /**
     * Vetor interno da ArrayList.
     */
    private T [] array;
    /**
     * Tamanho da ArrayList. Leva em consideração as posições ocupadas e não o tamanho literal do estrutura.
     */
    private int size;
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="@Constructors">
    /**
     * Essa classe é uma Estrutura de Dados ArrayList. Uma coleção indexada de objetos às vezes chamada de sequência.
     * Como nos vetores, índices da MyArrayList são baseados em zero, isto é, o índice do primeiro elemento é zero.
     * MyArrayList fornece métodos para manipular elementos baseado na sua posição (ou índice) numérica na lista,
     * remover determinado elemento, procurar as ocorrências de um dado elemento e percorrer sequencialmente (ListIterator)
     * todos os elementos da lista.
     *
     * @author João Guedes.
     *
     * @param size Tamanho inicial da ArrayList.
     */
    public MyArrayList(int size) {
        this.array = (T[]) new Object [size];
        this.size = 0;
    }

    /**
     * Essa classe é uma Estrutura de Dados ArrayList. Uma coleção indexada de objetos às vezes chamada de sequência.
     * Como nos vetores, índices da MyArrayList são baseados em zero, isto é, o índice do primeiro elemento é zero.
     * MyArrayList fornece métodos para manipular elementos baseado na sua posição (ou índice) numérica na lista,
     * remover determinado elemento, procurar as ocorrências de um dado elemento e percorrer sequencialmente (ListIterator)
     * todos os elementos da lista.
     *
     * @author João Guedes.
     */
    public MyArrayList() {
        this.array = (T[]) new Object [10];
        this.size = 0;
    }
    // </editor-fold>

    /**
     * Retorna o número de posições ocupadas na estrutura.
     *
     * @return número de elementos contidos na estrutura.
     */
    public int size() {
        return this.size;
    }

    /**
     * Caso a quantidade de elementos contidos na estrutura seja igual o tamanho do array interno, este método
     * fará com que o array interno dobre sua capacidade de armazenamento.
     */
    private void expandSize(){
        if (this.size != this.array.length)
            return;
        T [] newArray = (T[]) new Object[this.array.length * 2];
        for (int i = 0; i < this.array.length; i++)
            newArray[i] = this.array[i];
        this.array = newArray;
    }

    /**
     * Caso o tamanho do array interno seja maior que 10 e o número de posições livres no array seja maior que 125% das
     * das posições ocupadas o array interno terá sua capacidade de armazenamento reduzida pela metade.
     */
    private void decreaseSize() {
        if ((this.array.length > 10) && ((this.array.length - this.size) > (int) (Math.ceil(this.size*1.25)))) {
            T [] newArray = (T[]) new Object[this.array.length/2];
            for (int i = 0; i < newArray.length; i++)
                newArray[i] = this.array[i];
            this.array = newArray;
        }
    }

    /**
     * Adiciona um elemento na estrutura.
     *
     * @param element elemento que será adicionado na estrutura.
     */
    public void add(T element) {
        this.expandSize();
        this.array[this.size++] = element;
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
        this.expandSize();
        if (!(index >= 0 && index <= this.size))
            throw new IllegalArgumentException("ERROR: invalid index!");
        for (int i = this.size; i > index; i--)
            this.array[i]= this.array[i-1];
        this.array[index] = element;
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
        for (int i = index; i < this.size-1; i++)
            this.array[i] = this.array[i+1];
        this.array[--this.size] = null;
        this.decreaseSize();
    }

    /**
     * Remove um elemento da estrutura. Caso o elemento não esteja contido na estrutura será lançada um exceção.
     *
     * @param element elemento que será removido.
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
        return this.array[index];
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
        this.array[index] = element;
    }

    /**
     * Faz a limpeza da estrutura, removendo todos os elementos contidos.
     */
    public void clear() {
        this.array = (T[]) new Object[10];
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
    public boolean contains(T elements) {
        return this.indexOf(elements) >= 0;
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
        if (this.size > 0) {
            string.append(this.array[this.size-1]);
        }
        string.append("]");
        return string.toString();
    }

}