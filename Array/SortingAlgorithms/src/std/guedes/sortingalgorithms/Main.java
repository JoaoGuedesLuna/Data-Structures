package std.guedes.sortingalgorithms;

import std.guedes.sortingalgorithms.util.Sorting;
import java.util.Arrays;

public class Main {
     private static final Integer[] UNORDERED_ARRAY = {0,8,3,6,7,2,1,0,2,9};

     public static void main(String[] args) {
          Sorting<Integer> sort = new Sorting<>();
          Integer[] array = new Integer[Main.UNORDERED_ARRAY.length];
          System.out.println("===================== Selection Sort =====================");
          System.arraycopy(Main.UNORDERED_ARRAY, 0, array, 0, array.length);
          System.out.println(Arrays.toString(array));
          sort.selectionSort(array);
          System.out.println(Arrays.toString(array));
          System.out.println("====================== Bubble Sort =======================");
          System.arraycopy(Main.UNORDERED_ARRAY, 0, array, 0, array.length);
          System.out.println(Arrays.toString(array));
          sort.bubbleSort(array);
          System.out.println(Arrays.toString(array));
          System.out.println("===================== Insertion Sort =====================");
          System.arraycopy(Main.UNORDERED_ARRAY, 0, array, 0, array.length);
          System.out.println(Arrays.toString(array));
          sort.insertionSort(array);
          System.out.println(Arrays.toString(array));
          System.out.println("======================= Merge Sort =======================");
          System.arraycopy(Main.UNORDERED_ARRAY, 0, array, 0, array.length);
          System.out.println(Arrays.toString(array));
          sort.mergeSort(array);
          System.out.println(Arrays.toString(array));
          System.out.println("======================= Quick Sort =======================");
          System.arraycopy(Main.UNORDERED_ARRAY, 0, array, 0, array.length);
          System.out.println(Arrays.toString(array));
          sort.quickSort(array);
          System.out.println(Arrays.toString(array));
     }

}