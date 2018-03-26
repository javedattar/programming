/**
 * Selection sort sets index of minimum element as 0 to begin and then finds minimum number to swap with first
 * index. Then increases index and repeats the same process until all elements are put in right sorted order
 * 
 * author: Javed Attar
 */

public class SelectionSort {
  public static void sort(int[] arr) {

    for (int i = 0; i < arr.length - 1; i++) {
      int imin = i;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[imin] > arr[j]) {
          imin = j;
        }
      }
      int temp = arr[i];
      arr[i] = arr[imin];
      arr[imin] = temp;
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
    SelectionSort.sort(arr);
    System.out.println("Sorted Array >>");
    for (int i : arr) {
      System.out.print(i + " ");
    }
  }
}
