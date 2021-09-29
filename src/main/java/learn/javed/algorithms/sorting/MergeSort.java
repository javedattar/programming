package learn.javed.algorithms.sorting;

import java.util.Arrays;

/**
 * Given an array of integers, implement merge sort algorithm
 * 
 * Merge sort is divide and conquer algorithm. In merge sort array is divided upto single element, Then elements
 * are merged in sorted order
 * 
 * author: Javed Attar
 */

public class MergeSort {

  public static void main(String[] args) {
    int[] arr = {
        4, 9, 6, 7, 3, 8, 2, 5, 1,
    };
    System.out.println(String.format("Input Array >> %s\n", Arrays.toString(arr)));
    arr = sort(arr);
    System.out.println(String.format("Final sorted Array >> %s\n", Arrays.toString(arr)));
  }

  private static int[] sort(int[] inputArray) {
    return _sort(inputArray, 0, inputArray.length - 1);
  }

  private static int[] _sort(int[] inputArray, int leftIndex, int rightIndex) {
    if (leftIndex < rightIndex) {
      System.out.println(String.format("leftIndex=%d & rightIndex=%d", leftIndex, rightIndex));
      int mid = (rightIndex + leftIndex) / 2;
      int[] leftArray = _sort(inputArray, leftIndex, mid);
      int[] rightArray = _sort(inputArray, mid + 1, rightIndex);
      System.out.println(
          String.format("leftArray=%s & rightArray=%s", Arrays.toString(leftArray), Arrays.toString(rightArray)));
      return merge(leftArray, rightArray);
    }
    return new int[] {
        inputArray[leftIndex]
    };
  }

  private static int[] merge(int[] leftArray, int[] rightArray) {
    int[] sortedArray = new int[leftArray.length + rightArray.length];
    int countSorted = 0, countLeft = 0, countRight = 0;
    while (countLeft < leftArray.length && countRight < rightArray.length) {
      if (leftArray[countLeft] < rightArray[countRight]) {
        sortedArray[countSorted++] = leftArray[countLeft++];
      } else {
        sortedArray[countSorted++] = rightArray[countRight++];
      }
    }
    while (countLeft < leftArray.length) {
      sortedArray[countSorted++] = leftArray[countLeft++];
    }
    while (countRight < rightArray.length) {
      sortedArray[countSorted++] = rightArray[countRight++];
    }
    System.out.println(String.format("Sorted Array >> %s\n", Arrays.toString(sortedArray)));
    return sortedArray;
  }
}
