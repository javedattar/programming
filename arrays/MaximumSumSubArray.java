import java.util.Arrays;

/**
 * Find a subarray resulting in max addition possible in the array
 * Assumption is to have sum greater than zero (non negative)
 * 
 * Approach: 
 * <p>Traverse through array, start adding up number to max and keep track of prev max and current max. 
 * Update previous max if current max is greater than it.
 * If current max goes below 0 reset it to 0.</p> 
 * 
 * Time: O(n) + O(length of sub-array), since n is dominating, O(n) and worst case O(2n)
 * Space: O(n) + O(length of sub-array), since n is dominating, O(n)
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
