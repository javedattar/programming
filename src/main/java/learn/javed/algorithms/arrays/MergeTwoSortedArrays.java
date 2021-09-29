package learn.javed.algorithms.arrays;

/**
 * author: Javed Attar
 */

public class MergeTwoSortedArrays {
  static int arr1[] = {
      1, 3, 5, 7, 9, 11, 12, 13, 14, 15
  };
  static int arr2[] = {
      2, 4, 6, 8, 10
  };

  public static int[] mergeArrays(int arr1[], int arr2[]) {
    int i = 0, j = 0, k = 0;
    int totalLength = arr1.length + arr2.length;
    int resultArray[] = new int[totalLength];
    while (k < totalLength) {
      if (j == arr2.length || arr1[i] < arr2[j]) {
        resultArray[k] = arr1[i];
        i++;
      } else if (i == arr1.length || arr1[i] > arr2[j]) {
        resultArray[k] = arr2[j];
        j++;
      }
      k++;
    }

    return resultArray;
  }

  public static void main(String[] args) {
    int[] mergeArrays = MergeTwoSortedArrays.mergeArrays(arr1, arr2);
    System.out.println("Array 1");
    for (int i : arr1) {
      System.out.print(i + ", ");
    }
    System.out.println("\nArray 2");
    for (int i : arr2) {
      System.out.print(i + ", ");
    }
    System.out.println("\nMerged array");
    for (int i : mergeArrays) {
      System.out.print(i + ", ");
    }
  }
}
