package std.guedes.sortingalgorithms.util;

/**
 * Essa classe disponibiliza alguns métodos de ordenação de arrays.
 *
 * @param <T> Tipo de dado do array.
 *
 * @author João Guedes.
 */
public class Sorting<T> {

    /**
     * A ordenação por seleção (do inglês, selection sort) é um algoritmo de ordenação baseado em se passar sempre o menor
     * valor do vetor para a primeira posição (ou o maior dependendo da ordem requerida), depois o de segundo menor valor
     * para a segunda posição, e assim é feito sucessivamente com os n-1 elementos restantes, até os
     * últimos dois elementos.
     *
     * @param array Array que será ordenado.
     */
    public void selectionSort(T[] array) {
        for (int left = 0; left < array.length-1; left++){
            for (int right = left+1; right < array.length; right++) {
                if (((Comparable)array[left]).compareTo(array[right]) > 0)
                    this.swap(array, left, right);
            }
        }
    }

    /**
     * O bubble sort, ou ordenação por flutuação (literalmente "por bolha"), é um algoritmo de ordenação dos mais simples.
     * A ideia é percorrer o vetor diversas vezes, e a cada passagem fazer flutuar para o topo o maior elemento da sequência.
     * Essa movimentação lembra a forma como as bolhas em um tanque de água procuram seu próprio nível, e disso vem o nome do algoritmo.
     *
     * @param array Array que será ordenado.
     */
    public void bubbleSort(T[] array) {
        boolean swappedSomething;
        do {
            swappedSomething = false;
            for (int i = 0; i < array.length-1; i++) {
                if (((Comparable)array[i]).compareTo(array[i+1]) > 0) {
                    this.swap(array, i, i+1);
                    swappedSomething = true;
                }
            }
        } while(swappedSomething);
    }

    /**
     * O insertion sort ou ordenação por inserção percorre as posições do array, começando com o índice 1. Cada nova posição
     * é como a nova carta que você recebeu, e você precisa inseri-la no lugar correto no subarray ordenado à esquerda daquela posição.
     *
     * @param array Array que será ordenado.
     */
    public void insertionSort(T[] array) {
        for (int i = 1; i < array.length; i++){
            T currentValue = array[i];
            int j = i-1;
            while ((j >= 0) && (((Comparable)currentValue).compareTo(array[j])) < 0)
                array[j+1] = array[j--];
            array[j+1] = currentValue;
        }
    }

    /**
     * O merge sort, ou ordenação por mistura, é um algoritmo recursivo que divide uma lista continuamente pela metade.
     * Se a lista estiver vazia ou tiver um único item, ela está ordenada por definição (o caso base). Se a lista tiver
     * mais de um item, dividimos a lista e invocamos recursivamente um merge sort em ambas as metades. Assim que as metades
     * estiverem ordenadas, a operação fundamental, chamada de intercalação, é realizada. Intercalar é o processo de pegar
     * duas listas menores ordenadas e combiná-las de modo a formar uma lista nova, única e ordenada.
     *
     * @param array Array que será ordenado.
     */
    public void mergeSort(T[] array) {
        if (array.length < 2)
            return;
        int middleIndex = array.length/2;
        T[] leftHalf = (T[]) new Object [middleIndex];
        T[] rightHalf = (T[]) new Object [array.length-middleIndex];
        for (int i = 0; i < leftHalf.length; i++)
            leftHalf[i] = array[i];
        for (int i = 0; i < rightHalf.length; i++)
            rightHalf[i] = array[middleIndex+i];
        this.mergeSort(leftHalf);
        this.mergeSort(rightHalf);
        this.merge(array, leftHalf, rightHalf);
    }

    /**
     * Esse método trabalha em auxílio ao método mergeSort(). Adiciona os elementos do array da esquerda e do array da
     * direita no array principal, de maneira ordenada.
     *
     * @param mainArray Array principal.
     *
     * @param leftHalf Array com os elementos da esquerda do array principal.
     *
     * @param rightHalf Array com os elementos da direita do array dprincipal.
     */
    private void merge(T[] mainArray, T[] leftHalf, T[] rightHalf) {
        int topLeft = 0, topRight = 0;
        for (int i = 0; i < mainArray.length; i++) {
            if (topLeft >= leftHalf.length)
                mainArray[i] = rightHalf[topRight++];
            else if (topRight >= rightHalf.length)
                mainArray[i] = leftHalf[topLeft++];
            else if (((Comparable)leftHalf[topLeft]).compareTo(rightHalf[topRight]) <= 0)
                mainArray[i] = leftHalf[topLeft++];
            else
                mainArray[i] = rightHalf[topRight++];
        }
    }

    /**
     * O algoritmo Quicksort utiliza o paradigma de programação Dividir para Conquistar ou divide and conquer. Esse paradigma
     * é uma abordagem recursiva em que a entrada do algoritmo é ramificada múltiplas vezes a fim de quebrar o problema maior
     * em problema menores da mesma natureza. Dado a sequência de entrada, deve-se primeiramente escolher um elemento que
     * chamaremos de pivô. Em seguida iterar sobre toda a sequência a fim de posicionar todos elementos menores do que esse
     * pivô à sua esquerda. A escolha do pivô pode ser feita aleatoriamente, ser o primeiro elemento ou o último. Assim, temos
     * que à esquerda da posição atual do nosso pivô, todos elementos são menores do que ele. Consequentemente, por termos
     * iterado toda a sequência, todos os elementos à direita são maiores do que o pivô. É importante ressaltar que, tanto
     * à esquerda quanto à direita, os elementos não estão completamente ordenados. Mas podemos afirmar com certeza que em
     * relação ao pivô estão. Nesse momento podemos então chamar recursivamente a subsequência à esquerda e à direita até
     * elas estejam completamente ordenada.
     *
     * @param array Array que será ordenado.
     */
    public void quickSort(T[] array) {
        this.quickSort(array, 0, array.length-1);
    }

    /**
     * O algoritmo Quicksort utiliza o paradigma de programação Dividir para Conquistar ou divide and conquer. Esse paradigma
     * é uma abordagem recursiva em que a entrada do algoritmo é ramificada múltiplas vezes a fim de quebrar o problema maior
     * em problema menores da mesma natureza. Dado a sequência de entrada, deve-se primeiramente escolher um elemento que
     * chamaremos de pivô. Em seguida iterar sobre toda a sequência a fim de posicionar todos elementos menores do que esse
     * pivô à sua esquerda. A escolha do pivô pode ser feita aleatoriamente, ser o primeiro elemento ou o último. Assim, temos
     * que à esquerda da posição atual do nosso pivô, todos elementos são menores do que ele. Consequentemente, por termos
     * iterado toda a sequência, todos os elementos à direita são maiores do que o pivô. É importante ressaltar que, tanto
     * à esquerda quanto à direita, os elementos não estão completamente ordenados. Mas podemos afirmar com certeza que em
     * relação ao pivô estão. Nesse momento podemos então chamar recursivamente a subsequência à esquerda e à direita até
     * elas estejam completamente ordenada.
     *
     * @param array Array que será ordenado.
     *
     * @param lowIndex Primeiro índice do array.
     *
     * @param highIndex Último índice do array.
     */
    private void quickSort(T[] array, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex)
            return;
        T pivot = array[highIndex];
        int leftPointer = this.partition(array, lowIndex, highIndex, pivot);
        this.quickSort(array, lowIndex, leftPointer-1);
        this.quickSort(array, leftPointer+1, highIndex);
    }

    /**
     * Esse método tem o objetivo de mover os elementos menores que o pivô para a esqueda do pivô e os elementos maiores
     * para a direita do pivô.
     *
     * @param array Array que está tentando ser ordenar.
     *
     * @param lowIndex Menor índice que se deseja trabalhar na estrutura.
     *
     * @param highIndex Maior índice que se deseja trabalhar na estrutura.
     *
     * @param pivot Elemento escolhido como pivô.
     *
     * @return Retorna o índice onde o pivô após ocupar sua posição adequada se encontra.
     */
    private int partition(T[] array, int lowIndex, int highIndex, T pivot) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex;
        while (leftPointer < rightPointer) {
            while (((Comparable)array[leftPointer]).compareTo(pivot) <= 0 && leftPointer < rightPointer)
                leftPointer++;
            while (((Comparable)array[rightPointer]).compareTo(pivot) >= 0 && leftPointer < rightPointer)
                rightPointer--;
            this.swap(array, leftPointer, rightPointer);
        }
        this.swap(array, highIndex, leftPointer);
        return leftPointer;
    }

    /**
     * Faz a traca de elementos de um array. O elemento do primeiro índice irá para a posição do segundo índice e o elemento do
     * segundo índice irá para a posição do primeiro índice.
     *
     * @param array Array que terá os elementos trocados.
     *
     * @param index1 Primeiro índice.
     *
     * @param index2 Segundo índice.
     */
    private void swap(T[] array, int index1, int index2) {
        T aux = array[index1];
        array[index1] = array[index2];
        array[index2] = aux;
    }

}