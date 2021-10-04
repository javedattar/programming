/**
 * author: Javed Attar
 */
package learn.javed.algorithms.selection;

public class KnapsackProblem {

	/**
	 * Knapsack problem is a problem in combinational optimization. Given a set of
	 * items with weight(lbs) and value
	 * ($), determine the number of each item to include in collection so that total
	 * weight is less than or equals to
	 * given limit / capacity and total value is as large as possible.
	 * 
	 * WeightValue[][] = {{2lbs, $2}, {4lbs, $10}, {12lbs, $4}, {1lb, $1}}
	 * 
	 * Given above input total value for limit of 7lbs is $13 ({2lbs,$2},
	 * {4lbs,$10}, {1lb, $1})
	 * Given above input total value for limit of 10lbs is $22 (2x{4lbs, $10},
	 * {2lbs, $2})
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		int inputItems[][] = { { 1, 1 }, { 2, 4 }, { 4, 10 }, { 5, 8 }, { 12, 5 } };
		System.out.println("Capacity 7 maxValuePossible >>   " + knapsackIterative(inputItems, 7));
		System.out
				.println("Capacity 7 knapsackRecurssive >>   " + knapsackRecurssive(inputItems, 7, inputItems.length));
		System.out.println("Capacity 10 maxValuePossible >>   " + knapsackIterative(inputItems, 10));
		System.out.println("Capacity 15 maxValuePossible >>   " + knapsackIterative(inputItems, 15));
		int[] weights = { 1, 2, 4, 5 };
		int[] values = { 1, 4, 10, 8 };
		System.out.println(knapSackWithRecurssion(7, weights, values, weights.length));
		System.out.println(knapSackWithRecurssion(10, weights, values, weights.length));
		System.out.println(knapSackWithRecurssion(15, weights, values, weights.length));

	}

	private static int knapsackIterative(int[][] inputItems, int capacity) {
		int maxValue = 0;

		for (int i = inputItems.length - 1; i >= 0; i--) {
			int value = 0;
			int remainingCapacity = capacity;
			for (int j = i; j >= 0; j--) {
				if (inputItems[j][0] <= remainingCapacity) {
					value = value + inputItems[j][1];
					remainingCapacity = remainingCapacity - inputItems[j][0];
				}
			}

			if (maxValue < value) {
				maxValue = value;
			}
		}
		return maxValue;
	}

	private static int knapsackRecurssive(int[][] inputItems, int remainingCapacity, int j) {
		if (remainingCapacity == 0 || j == 0)
			return 0;

		if (inputItems[j - 1][0] > remainingCapacity) {

			return knapsackRecurssive(inputItems, remainingCapacity, j - 1);
		}
//		remainingCapacity = remainingCapacity - inputItems[j - 1][0];
		return Math.max(
				inputItems[j - 1][1] + knapsackRecurssive(inputItems, remainingCapacity - inputItems[j - 1][0], j - 1),
				knapsackRecurssive(inputItems, remainingCapacity, j - 1));
	}

	private static int knapSackWithRecurssion(int W, int wt[], int val[], int n) {
		// Base Case
		if (n == 0 || W == 0)
			return 0;

		// If weight of the nth item is
		// more than Knapsack capacity W,
		// then this item cannot be included
		// in the optimal solution
		if (wt[n - 1] > W)
			return knapSackWithRecurssion(W, wt, val, n - 1);

		// Return the maximum of two cases:
		// (1) nth item included
		// (2) not included
		else
			return Math.max(val[n - 1] + knapSackWithRecurssion(W - wt[n - 1], wt, val, n - 1),
					knapSackWithRecurssion(W, wt, val, n - 1));
	}

}
