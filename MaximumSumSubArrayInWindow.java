import java.util.Arrays;

/**
 * Find a subarray resulting in max addition possible in the array for given window OR number of elements
 * 
 * author: Javed Attar
 */

public class MaximumSumSubArrayInWindow {

  private static int[] findSubArray(int[] inputArray, int numberOfElementsInSubArray) {
    int sum = 0;
    // Default copy first given target window elements to output array
    int[] outputArray = new int[numberOfElementsInSubArray];
    for (int k = 0; k < outputArray.length; k++) {
      outputArray[k] = inputArray[k];
      sum += outputArray[k];
    }

    for (int i = 1; i < inputArray.length - numberOfElementsInSubArray + 1; i++) {
      int tempSum = 0;
      for (int j = i; j < numberOfElementsInSubArray + i; j++) {
        tempSum += inputArray[j];
      }
      // if new sum is great than before then capture new elements
      if (tempSum > sum) {
        sum = tempSum;
        for (int k = 0; k < outputArray.length; k++) {
          outputArray[k] = inputArray[k + i];

        }
      }
    }
    return outputArray;
  }

  public static void main(String[] args) {
    int[] inputArray2 = {
        2,
        3,
        4,
        1,
        2,
        1,
        5,
        4,
        9,
        1,
        7,
        2,
        4,
        2
    };
    System.out.println(Arrays.toString(findSubArray(inputArray2, 3)));
  }
}
