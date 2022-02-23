/**
* author: Javed Attar
*/
package learn.javed.algorithms.arrays;

public class ContigiousSubArrayTargetSum {

	public static void main(String[] args) {
		System.out.println("ContigiousSubArrayTargetSum.main() countSubarraysSlidingWindow "
				+ countSubarraysSlidingWindow(new int[] { 10, 2, -2, -20, 10 }, -10));
		System.out.println("ContigiousSubArrayTargetSum.main() countSubarraysSlidingWindow "
				+ countSubarraysSlidingWindow(new int[] { 10, 2, -2, -20, 10 }, -11));
		System.out.println("ContigiousSubArrayTargetSum.main() countSubarraysSlidingWindow "
				+ countSubarraysSlidingWindow(new int[] { 2, 3, 4, 5, 9 }, 9));
		System.out.println("ContigiousSubArrayTargetSum.main() countSubarraysSlidingWindow "
				+ countSubarraysSlidingWindow(new int[] { 1, 1, 1, 1 }, 2));
		System.out.println("ContigiousSubArrayTargetSum.main() countSubarraysSlidingWindow "
				+ countSubarraysSlidingWindow(new int[] { 9, 4, 20, 3, 10, 5 }, 33));

	}

	private static int counter = 0;

	private static int countSubarraysSlidingWindow(int[] arr, int target) {
		counter = 0;
		int i = 0, j = 0;
		while (i < arr.length) {
			countCombo(arr, target, i++, j++);
		}
		return counter;
	}

	private static void countCombo(int[] arr, int target, int i, int j) {
		int subArraySum = 0;
		while (j <= arr.length) {
			if (target == subArraySum) {
				counter++;
			}
			if (j == arr.length)
				break;

			subArraySum += arr[j++];
		}

	}
}
