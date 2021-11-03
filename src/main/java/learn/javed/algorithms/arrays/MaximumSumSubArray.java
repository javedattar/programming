package learn.javed.algorithms.arrays;

import java.util.Arrays;

/**
 * Find a subarray resulting in max addition possible in the array Assumption is to have sum greater than zero (non
 * negative)
 * 
 * Approach:
 * <p>
 * Traverse through array, start adding up number to max and keep track of prev max and current max. Update
 * previous max if current max is greater than it. If current max goes below 0 reset it to 0.
 * </p>
 * 
 * Time: O(n) + O(length of sub-array), since n is dominating, O(n) and worst case O(2n)
 * Space: O(n) + O(length of sub-array), since n is dominating, O(n)
 * 
 * author: Javed Attar
 */

public class MaximumSumSubArray {

	public static void main(String[] args) {
		int[] inputArray = { -2, -3, 4, -1, -2, 1, 5, -3 };
		int[] inputArray2 = { 2, 3, 4, 1, 2, 1, 5, 3 };
		System.out.println(MaximumSumSubArray.findSubArray(inputArray));
		System.out.println(MaximumSumSubArray.findSubArray(inputArray2));
//		System.out.println(MaximumSumSubArray.maxSubArray(inputArray));
//		System.out.println(MaximumSumSubArray.maxSubArray(inputArray2));
		inputArray2 = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(MaximumSumSubArray.maxSubArray(inputArray2));
	}

	private static int findSubArray(int[] nums) {
		int start = 0, end = 0;
		int prevMaxSumWithConsecutiveSubArray = Integer.MIN_VALUE;
		int maxSumWithConsecutiveSubArray = 0;

		for (int i = 0; i < nums.length; i++) {
			maxSumWithConsecutiveSubArray += nums[i];

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
			resultantArray[counter] = nums[i];
			counter++;
		}
		System.out.println(Arrays.toString(resultantArray));
		return end - start + 1;
	}

	public static int maxSubArray(int[] nums) {
		int i = 0, start = 0, end = -1;
		int max = Integer.MIN_VALUE, sum = 0;
		while (i < nums.length) {
			// START
			if (nums[i] > sum + nums[i]) {
				sum = nums[i];
				start = i;
				end = start;
			} else {
				sum += nums[i];
			}
			if (max < sum) {
				max = sum;
				end++;
			}
			// END
			// Above block can be replaced with following for max sum
//			prevMax = Math.max(prevMax + nums[i], nums[i]);
//			max = Math.max(max, sum);
			i++;
		}
		System.out.println("Start >> " + start + " End >> " + end);

		return max;

	}

}
