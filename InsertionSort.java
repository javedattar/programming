/**
 * author: Javed Attar
 */

public class InsertionSort {
  public static void sort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      int holeValue = arr[i];
      int hole = i;
      while (hole > 0 && arr[hole - 1] > holeValue) {
        arr[hole] = arr[hole - 1];
        hole = hole - 1;
      }
      arr[hole] = holeValue;
      System.out.println("Pass " + (i));
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
    InsertionSort.sort(arr);
    System.out.println("Sorted Array >>");
    for (int i : arr) {
      System.out.print(i + " ");
    }
  }
}
