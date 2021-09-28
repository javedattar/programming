import java.util.Arrays;

/**
 * Find a subarray resulting in max addition possible in the array for given
 * window OR number of elements
 * 
 * Example: Given an array {3,2,5,8,1,4} and window size 3 the max addition
 * subarray is {2,5,8}
 * 
 * Approach I: 
 * This is a sliding window pattern problem where window is given.
 * Traverse through input array and calculate sum of m elements from current index.
 * If the sum is greater than previous sum then update the output array
 * 
 * n is no. of elements in an array
 * m size of output array (window or number of elements to add)
 * Time: O(m)+O(n-m)*O(m)+O(m) so Big O is O(n-m)*O(m)
 * 
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
	
	private static int[] findSubArrayWithIndex(int[] inputArray, int numberOfElementsInSubArray) {
		int sum = 0, start = 0;
		int prevSum = Integer.MIN_VALUE;
		
		int[] outputArray = new int[numberOfElementsInSubArray];
		for(int i = 0; i<inputArray.length - numberOfElementsInSubArray; i++) {
			for (int j = i; j < i + numberOfElementsInSubArray; j++) {
				sum += inputArray[j];
			}
			if(prevSum < sum) {
				prevSum = sum;
				start = i;

			}
			sum = 0;
		}
		for (int k = 0; k < outputArray.length; k++) {
			outputArray[k] = inputArray[k+start];

		}
		return outputArray;
		
	}

	public static void main(String[] args) {
		int[] inputArray2 = { 2, 3, 4, 1, 2, 1, 5, 4, 9, 1, 7, 2, 4, 2 };
		System.out.println(Arrays.toString(findSubArray(inputArray2, 3)));
		System.out.println(Arrays.toString(findSubArrayWithIndex(inputArray2, 3)));
	}
}
