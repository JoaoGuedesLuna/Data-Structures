package std.guedes.searchalgorithms;

import std.guedes.searchalgorithms.util.Search;
import java.util.Arrays;

public class Main {

    /**
     * Exibe uma mensagem de que o elemento se encontra na posição de índice caso o index seja maior ou igual a zero ou
     * uma menssagem de que o elemento não foi encontrado caso o index seja negativo
     *
     * @param index Índice.
     *
     * @param element Elemento.
     */
    private static void showMessage(int index, Integer element) {
        if (index >= 0)
            System.out.printf("Valor %d encontrado na posição %d.\n", element, index);
        else
            System.out.printf("Valor %d não encontrado.\n", element);
    }

    public static void main(String[] args){
        Search<Integer> searchAlgorithm = new Search<>();
        Integer[] integerArray = new Integer[]{0,8,3,6,7,2,1,0,2,9};
        Integer elementSearched = 8;
        int index;
        System.out.println("================ Sequential Search ================");
        System.out.println(Arrays.toString(integerArray));
        index = searchAlgorithm.sequentialSearch(integerArray, elementSearched);
        Main.showMessage(index, elementSearched);
        System.out.println("========= Binary Search - Disordered Array ========");
        System.out.println(Arrays.toString(integerArray));
        index = searchAlgorithm.binarySearch(integerArray, elementSearched);
        Main.showMessage(index, elementSearched);
        System.out.println("========== Binary Search - Ordered Array ==========");
        Arrays.sort(integerArray);
        System.out.println(Arrays.toString(integerArray));
        index = searchAlgorithm.binarySearch(integerArray, elementSearched);
        Main.showMessage(index, elementSearched);
    }

}