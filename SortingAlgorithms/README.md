# Algoritmos de Ordenação 🔴

Aqui estão alguns métodos de ordenação muito conhecidos que eu decidi implementar para praticar.  Os algoritmos de ordenação servem para ordenar/organizar uma lista de números ou palavras de acordo com a sua necessidade. As linguagens de programação já possuem métodos de ordenação, mas é bom saber como funcionam os algoritmos, pois há casos de problemas em que o algoritmo de ordenação genérico não resolve, às vezes é necessário modificá-lo.



### 🔺 Selection Sort



A ordenação por seleção (do inglês, selection sort) é um algoritmo de ordenação baseado em se passar sempre o menor valor do vetor para a primeira posição (ou o maior dependendo da ordem requerida), depois o de segundo menor valor para a segunda posição, e assim é feito sucessivamente com os n-1 elementos restantes, até os últimos dois elementos.



### 🔺 Bubble Sort



O bubble sort, ou ordenação por flutuação (literalmente "por bolha"), é um algoritmo de ordenação dos mais simples. A ideia é percorrer o vetor diversas vezes, e a cada passagem fazer flutuar para o topo o maior elemento da sequência. Essa movimentação lembra a forma como as bolhas em um tanque de água procuram seu próprio nível, e disso vem o nome do algoritmo.



### 🔺 Insertion Sort



O insertion sort ou ordenação por inserção percorre as posições do array, começando com o índice 1. Cada nova posição é como a nova carta que você recebeu, e você precisa inseri-la no lugar correto no subarray ordenado à esquerda daquela posição.



### 🔺 Merge Sort



O merge sort, ou ordenação por mistura, é um algoritmo recursivo que divide uma lista continuamente pela metade. Se a lista estiver vazia ou tiver um único item, ela está ordenada por definição (o caso base). Se a lista tiver mais de um item, dividimos a lista e invocamos recursivamente um merge sort em ambas as metades. Assim que as metades estiverem ordenadas, a operação fundamental, chamada de intercalação, é realizada. Intercalar é o processo de pegar duas listas menores ordenadas e combiná-las de modo a formar uma lista nova, única e ordenada.



### 🔺 Quick Sort



 O algoritmo Quicksort utiliza o paradigma de programação Dividir para Conquistar ou divide and conquer. Esse paradigma é uma abordagem recursiva em que a entrada do algoritmo é ramificada múltiplas vezes a fim de quebrar o problema maior em problema menores da mesma natureza. Dado a sequência de entrada, deve-se primeiramente escolher um elemento que chamaremos de pivô. Em seguida iterar sobre toda a sequência a fim de posicionar todos elementos menores do que esse pivô à sua esquerda. A escolha do pivô pode ser feita aleatoriamente, ser o primeiro elemento ou o último. Assim, temos que à esquerda da posição atual do nosso pivô, todos elementos são menores do que ele. Consequentemente, por termos iterado toda a sequência, todos os elementos à direita são maiores do que o pivô. É importante ressaltar que, tanto à esquerda quanto à direita, os elementos não estão completamente ordenados. Mas podemos afirmar com certeza que em relação ao pivô estão. Nesse momento podemos então chamar recursivamente a subsequência à esquerda e à direita até elas estejam completamente ordenada.
