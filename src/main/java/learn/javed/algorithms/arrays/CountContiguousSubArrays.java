package learn.javed.algorithms.arrays;

import java.util.Arrays;

public class CountContiguousSubArrays {

	public void run() {
		int[] test_1 = { 3, 4, 1, 6, 2 };
		int[] expected_1 = { 1, 3, 1, 5, 1 };
		int[] output_1 = countSubarrays(test_1);
		int[] output_11 = countSubarrays2(test_1);
		System.out.println(Arrays.toString(expected_1) + " Actual >> " + Arrays.toString(output_1));
//	    check(expected_1, output_1);

		int[] test_2 = { 2, 4, 7, 1, 5, 3 };
		int[] expected_2 = { 1, 2, 6, 1, 3, 1 };
		int[] output_2 = countSubarrays(test_2);
		System.out.println(Arrays.toString(expected_2) + " Actual >> " + Arrays.toString(output_2));
//	    check(expected_2, output_2);

		// Add your own test cases here

	}

	public static void main(String[] args) {
		new CountContiguousSubArrays().run();
	}

	//O(n^2)
	int[] countSubarrays(int[] arr) {
		int arrayLength = arr.length;
		int[] resultArray = new int[arrayLength];

		int left = 0;
		int right = 0;
		int subarrayCount = 1;
		for (int i = 0; i < arr.length; i++) {
			int currElement = arr[i];
			left = i - 1;
			right = i + 1;

			while (left >= 0 && currElement > arr[left]) {
				left--;
				subarrayCount++;
			}
			while (right < arrayLength && currElement > arr[right]) {
				right++;
				subarrayCount++;
			}

			resultArray[i] = subarrayCount;
			subarrayCount = 1;
		}

		return resultArray;

	}

	//O(n)
	int[] countSubarrays2(int[] arr) {
		int arrayLength = arr.length;
		int[] resultArray = new int[arrayLength];

		int consec = 0;
		int maxNumIndex = 0;
		int prev = arr[0];
		int[] left = new int[arrayLength];
		Arrays.fill(left, 1);
		int[] right = new int[arrayLength];
		Arrays.fill(right, 1);
		
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[maxNumIndex]) {
				left[i] += left[maxNumIndex] + i - maxNumIndex - 1;
				maxNumIndex = i;
			} else if (arr[i] > prev) {
				left[i] += ++consec;

			} else {
				consec = 0;
			}
			prev = arr[i];
		}
		maxNumIndex = arr.length - 1;
		prev = arr[maxNumIndex];
		consec =0;
		for (int i = arr.length - 2; i >= 0; i--) {
			if (arr[i] > arr[maxNumIndex]) {
				right[i] += right[maxNumIndex] + maxNumIndex - i - 1;
				maxNumIndex = i;
			} else if (arr[i] > prev) {
				right[i] += ++consec;

			} else {
				consec = 0;
			}
			prev = arr[i];
		}
		for (int i = 0; i < arr.length; i++) {
			resultArray[i] = left[i] + right[i] - 1;
		}
		System.out.println(Arrays.toString(resultArray));
		return resultArray;

	}

}
