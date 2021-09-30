package learn.javed.algorithms.sorting;

import java.util.Arrays;

/**
 * Bubble sort bubbles each number to
 * 
 * Time: O(n^2) Space O(n)
 * 
 * author: Javed Attar
 */

public class BubbleSort {

  public static void sort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = 0; j < arr.length - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
          System.out.println(String.format("bubble %d => %s", arr[j + 1], Arrays.toString(arr)));
        } else {
          System.out.println(String.format("bubble %d => %s", arr[j + 1], Arrays.toString(arr)));
        }
      }
      System.out.println(String.format("Pass %d array state => %s", i + 1, Arrays.toString(arr)));
    }
  }

  public static void main(String[] args) {
    int[] arr = {
        4, 6, 7, 3, 2, 5, 1
    };
    BubbleSort.sort(arr);
    System.out.println(String.format("Sorted Array >> %s", Arrays.toString(arr)));

  }
}
