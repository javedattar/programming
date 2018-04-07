import java.util.Arrays;

/**
 * Find a subarray resulting in max addition possible in the array
 * 
 * author: Javed Attar
 */

public class MaximumSumSubArray {

  private static int findSubArray(int[] inputArray) {
    int start = 0, end = 0;
    int prevMaxSumWithConsecutiveSubArray = Integer.MIN_VALUE;
    int maxSumWithConsecutiveSubArray = 0;

    for (int i = 0; i < inputArray.length; i++) {
      maxSumWithConsecutiveSubArray += inputArray[i];
      if (prevMaxSumWithConsecutiveSubArray < maxSumWithConsecutiveSubArray) {
        prevMaxSumWithConsecutiveSubArray = maxSumWithConsecutiveSubArray;
        end = i;
      }
      if (maxSumWithConsecutiveSubArray < 0) {
        maxSumWithConsecutiveSubArray = 0;
        start = i + 1;
      }
    }
    int[] resultantArray = new int[end - start + 1];
    int counter = 0;
    for (int i = start; i < end + 1; i++) {
      resultantArray[counter] = inputArray[i];
      counter++;
    }
    System.out.println(Arrays.toString(resultantArray));
    return end - start + 1;
  }

  public static void main(String[] args) {
    int[] inputArray = {
        -2,
        -3,
        4,
        -1,
        -2,
        1,
        5,
        -3
    };
    int[] inputArray2 = {
        2,
        3,
        4,
        1,
        2,
        1,
        5,
        3
    };
    System.out.println(MaximumSumSubArray.findSubArray(inputArray));
    System.out.println(MaximumSumSubArray.findSubArray(inputArray2));
  }
}
