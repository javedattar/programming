package learn.javed.algorithms.arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Largest Triple Products
 * You're given a list of n integers arr[0..(n-1)]. You must compute a list output[0..(n-1)] such that, for each index i
 * (between 0 and n-1, inclusive),
 * output[i] is equal to the product of the three largest elements out of arr[0..i] (or equal to -1 if i < 2, as
 * arr[0..i] then includes fewer than three elements).
 * Note that the three largest elements used to form any product may have the same values as one another, but they must
 * be at different indices in arr.
 * Signature
 * int[] findMaxProduct(int[] arr)
 * Input
 * n is in the range [1, 100,000].
 * Each value arr[i] is in the range [1, 1,000].
 * Output
 * Return a list of n integers output[0..(n-1)], as described above.
 * 
 * Example 1
 * n = 5
 * arr = [1, 2, 3, 4, 5]
 * output = [-1, -1, 6, 24, 60]
 * The 3rd element of output is 3*2*1 = 6, the 4th is 4*3*2 = 24, and the 5th is 5*4*3 = 60.
 * 
 * Example 2
 * n = 5
 * arr = [2, 1, 2, 1, 2]
 * output = [-1, -1, 4, 4, 8]
 * The 3rd element of output is 2*2*1 = 4, the 4th is 2*2*1 = 4, and the 5th is 2*2*2 = 8.
 * 
 * @author javedattar
 *
 */
public class LargestTripleProducts {

	public static void main(String[] args) {

		new LargestTripleProducts().run();
	}

	public void run() {
		int[] arr_1 = { 1, 2, 3, 4, 5 };
		int[] expected_1 = { -1, -1, 6, 24, 60 };
		int[] output_1 = findMaxProduct(arr_1);
		System.out.println(Arrays.toString(output_1));

		int[] arr_2 = { 2, 4, 7, 1, 5, 3 };
		int[] expected_2 = { -1, -1, 56, 56, 140, 140 };
		int[] output_2 = findMaxProduct(arr_2);
		System.out.println(Arrays.toString(output_2));

		int[] arr_3 = { 2, 4, 7, 1, 5, 3 };
		int[] output_3 = findMaxProduct(arr_3);
		System.out.println(Arrays.toString(output_3));

		int[] arr_4 = { 2, 4, 7, 1000, 5, 1000 };
		int[] output_4 = findMaxProduct(arr_4);
		System.out.println(Arrays.toString(output_4));

		int[] arr_5 = { 2, 4 };
		int[] output_5 = findMaxProduct(arr_5);
		System.out.println(Arrays.toString(output_5));

		int[] arr_6 = {};
		int[] output_6 = findMaxProduct(arr_6);
		System.out.println(Arrays.toString(output_6));

		// Add your own test cases here

	}

	int[] findMaxProduct(int[] arr) {
		int[] result = new int[arr.length];
		PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> Integer.compare(y, x));

		for (int i = 0; i < arr.length; i++) {
			pq.offer(arr[i]);
			if (i < 2) {
				result[i] = -1;
			} else {
				int counter = 0;
				int[] temp = new int[3];

				while (counter < 3) {
					temp[counter] = pq.poll();
					counter++;
				}
				while (counter > 0) {
					pq.offer(temp[--counter]);
				}
				result[i] = temp[0] * temp[1] * temp[2];
			}
		}
		return result;
	}

//	int[] findMaxProduct(int[] arr) {
//		int[] result = new int[arr.length];
//
//		for (int i = 0; i < 2 && i < arr.length; i++) {
//			result[i] = -1;
//		}
//		if (arr.length <= 2)
//			return result;
//
//		int firstMax = arr[0];
//		int secondMax = arr[1];
//		int thirdMax = arr[2];
//		result[2] = firstMax * secondMax * thirdMax;
//
//		for (int i = 3; i < arr.length; i++) {
//			if (arr[i] > firstMax) {
//				firstMax = arr[i];
//			} else if (arr[i] > secondMax) {
//				secondMax = arr[i];
//			} else if (arr[i] > thirdMax) {
//				thirdMax = arr[i];
//
//			}
//
//			result[i] = firstMax * secondMax * thirdMax;
//
//		}
//
//		return result;
//	}

}
