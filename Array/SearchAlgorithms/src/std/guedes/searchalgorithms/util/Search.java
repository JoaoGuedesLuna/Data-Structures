package std.guedes.searchalgorithms.util;

/**
 * Essa classe tem o objetivo de disponibilizar métodos de busca em arrays.
 *
 * @param <T> Tipo de dado que está contido no array.
 *
 * @author João Guedes.
 */
public class Search<T> {

    /**
     * Método de busca sequencial. O array é percorrido sequencialmente e cada elemento é verificado, caracterizando
     * uma pesquisa linear.
     *
     * @param array Array que será iterado.
     *
     * @param element Elemento procurado.
     *
     * @return Retorna o índice do elemento no array. Caso o elemento não se encontre no array o valor retornado será negativo.
     */
    public int sequentialSearch(T[] array, T element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(element))
                return i;
        }
        return -1;
    }

    /**
     * Método de busca binária. Consiste em comparar o valor pesquisado com o valor do item no meio do array e caso sejam
     * iguais, a posição do meio é retornada. Caso o valor pesquisado seja antecedente ao do meio, o algoritmo descarta
     * todos os valores posteriores. E caso o valor pesquisado seja posterior ao valor do meio, o algoritmo descarta todos
     * os valores anteriores, até que sobre apenas o item desejado. Se o item restante não for o que queremos, será retornado
     * um valor negativo. Para que a busca seja efetiva é necessário que o <strong>array esteja ordenado</strong>.
     *
     * @param array Array onde será feita a busca.
     *
     * @param element Elemento procurado.
     *
     * @return Retorna o índice do elemento no array. Caso o elemento não se encontre no array o valor retornado será negativo.
     */
    public int binarySearch(T[] array, T element) {
        int beginning = 0;
        int end = array.length-1;
        do {
            int middle = (end+beginning)/2;
            if(array[middle].equals(element))
                return middle;
            else if (beginning == end)
                return -1;
            else if (((Comparable)array[middle]).compareTo(element) > 0)
                end = middle-1;
            else
                beginning = middle+1;
        } while(true);
    }

}