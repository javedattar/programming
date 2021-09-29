package learn.javed.algorithms.sorting;

import java.util.Arrays;

/**
 * Insertion sort creates a hole in an array which is replaced by left element if it's greater than holeValue until
 * it sorts left side of the array.
 * 
 * author: Javed Attar
 */

public class InsertionSort {
  public static void sort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      int holeValue = arr[i];
      System.out.println(String.format("hole value => %d ", holeValue));
      int hole = i;
      while (hole > 0 && arr[hole - 1] > holeValue) {
        arr[hole] = arr[hole - 1];
        hole = hole - 1;
        System.out.println(String.format("new hole index => %d array state => %s", hole, Arrays.toString(arr)));
      }
      arr[hole] = holeValue;
      System.out.println(String.format("Pass %d array state => %s", i, Arrays.toString(arr)));
    }
  }

  public static void main(String[] args) {
    int[] arr = {
        4, 6, 7, 3, 2, 5, 1
    };
    InsertionSort.sort(arr);
    System.out.println(String.format("Sorted Array >> %s", Arrays.toString(arr)));
  }
}
