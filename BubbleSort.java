/**
 * Bubble sort bubbles each number to
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
        }
      }
      System.out.println("Pass " + (i + 1));
      for (int k : arr) {
        System.out.print(k + " ");
      }
      System.out.println("");
    }
  }

  public static void main(String[] args) {
    int[] arr = {
        4,
        6,
        7,
        3,
        2,
        5,
        1
    };
    BubbleSort.sort(arr);
    System.out.println("Sorted Array >>");
    for (int i : arr) {
      System.out.print(i + " ");
    }
  }
}
