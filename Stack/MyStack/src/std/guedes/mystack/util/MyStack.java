package std.guedes.mystack.util;

/**
 * Stack (pilha, em português) é uma coleção de itens ou estrutura de dados, onde a adição e a remoção de um item é feita
 * pela mesma saída. Essa saída é comumente chamada de “top” e o extremo oposto é chamado de “base”. O item mais recentemente
 * adicionado será o primeiro removido em caso de remoção, já que estará no topo (ou “top”).
 *
 * @param <T> Tipo de dado que estará contido dentro da pilha.
 *
 * @author  João Guedes.
 */
public class MyStack<T> {

    // <editor-fold defaultstate="collapsed" desc="@Attributes">
    /**
     * Vetor interno da pilha.
     */
    private T [] array;
    /**
     * Tamanho da pilha. Leva em consideração as posições ocupadas e não o tamanho literal do estrutura.
     */
    private int size;
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="@Constructors">
    /**
     * Stack (pilha, em português) é uma coleção de itens ou estrutura de dados, onde a adição e a remoção de um item é feita
     * pela mesma saída. Essa saída é comumente chamada de “top” e o extremo oposto é chamado de “base”. O item mais recentemente
     * adicionado será o primeiro removido em caso de remoção, já que estará no topo (ou “top”).
     *
     * @param size Tamanho inicial da pilha.
     *
     * @author  João Guedes.
     */
    public MyStack(int size) {
        this.array = (T[]) new Object[size];
        this.size = 0;
    }

    /**
     * Stack (pilha, em português) é uma coleção de itens ou estrutura de dados, onde a adição e a remoção de um item é feita
     * pela mesma saída. Essa saída é comumente chamada de “top” e o extremo oposto é chamado de “base”. O item mais recentemente
     * adicionado será o primeiro removido em caso de remoção, já que estará no topo (ou “top”).
     *
     * @author  João Guedes.
     */
    public MyStack() {
        this.array = (T[]) new Object[10];
        this.size = 0;
    }
    // </editor-fold>

    /**
     * Retorna o tamanho da pilha. Leva em consideração as posições ocupadas e não o tamanho literal do estrutura.
     *
     * @return Tamanho da pilha.
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
        T [] newArray = (T[]) new Object[this.array.length*2];
        for (int i = 0; i < this.array.length; i++)
            newArray[i] = this.array[i];
        this.array = newArray;
    }

    /**
     * Caso o tamanho do array interno seja maior que 10 e o número de posições livres no array seja maior que 125% das
     * das posições ocupadas o array interno terá sua capacidade de armazenamento reduzida pela metade.
     */
    private void decreaseSize() {
        if ((this.array.length > 10) && ((this.array.length - this.size) > (int) (Math.ceil(size*1.25)))) {
            T [] newArray = (T[]) new Object[this.array.length/2];
            for (int i = 0; i < newArray.length; i++)
                newArray[i] = this.array[i];
            this.array = newArray;
        }
    }

    /**
     * Adiciona um elemento no topo da pilha.
     *
     * @param element Elemento que será empilhado.
     */
    public void push(T element) {
        this.expandSize();
        this.array[this.size++] = element;
    }

    /**
     * Retorna o elemento do topo da pilha.
     *
     * @return Elemento do topo da pilha.
     */
    public T peek() {
        if (this.isEmpty())
            return null;
        return this.array[this.size-1];
    }

    /**
     * Remove o elemento do topo da pilha.
     *
     * @return Elemento desempilhado.
     */
    public T pop() {
        if (this.isEmpty())
            return null;
        T elements = this.array[--this.size];
        this.array[this.size] = null;
        this.decreaseSize();
        return elements;
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
    public boolean contains(T elements) {
        return this.indexOf(elements) >= 0;
    }

    /**
     * Faz a limpeza da estrutura, removendo todos os elementos contidos.
     */
    public void clear() {
         this.array = (T[]) new Object[10];
    }

    /**
     * Diz se a pilha está vazia, se não contém elementos.
     *
     * @return true caso a pilha esteja vazia ou false caso contenha algum elemento.
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
        for(int i = 0; i < this.size-1; i++) {
            string.append(this.array[i]);
            string.append(", ");
        }
        if (this.size > 0)
            string.append(this.array[this.size-1]);
        string.append("]");
        return string.toString();
    }

}