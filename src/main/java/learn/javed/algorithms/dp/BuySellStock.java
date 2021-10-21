/**
* author: Javed Attar
*/
package learn.javed.algorithms.dp;

/**
 * You are given an array prices where prices[i] is the price of a given stock
 * on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock
 * and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you
 * cannot achieve any profit, return 0.
 * 
 * @author jattar
 * 
 *         Example: [7,1,5,3,6,4] => max profit = 5 (Buy 1 and Sell 6)
 */
public class BuySellStock {
	public static void main(String[] args) {
		int prices[] = { 7, 1, 5, 3, 6, 4 };
		System.out.println(maxProfit(prices));
		System.out.println(maxProfitOn(prices));
		int prices2[] = { 7, 1, 5, 8, 0, 5, 6, 7 };
//		System.out.println(maxProfit(prices2));
		System.out.println(maxProfitOn(prices2));

		int prices3[] = { 7, 4, 4, 2, 1 };
//		System.out.println(maxProfit(prices3));
		System.out.println(maxProfitOn(prices3));

		System.out.println("BuySellStock max profit multiple transactions >> " + maxProfitMultipleTransactions(prices));
		System.out
				.println("BuySellStock max profit multiple transactions >> " + maxProfitMultipleTransactions(prices2));
		System.out
				.println("BuySellStock max profit multiple transactions >> " + maxProfitMultipleTransactions(prices3));

		System.out.println(
				"BuySellStock max profit multiple transactions 2 >> " + maxProfitMultipleTransactions2(prices));
		System.out.println(
				"BuySellStock max profit multiple transactions 2 >> " + maxProfitMultipleTransactions2(prices2));
		System.out.println(
				"BuySellStock max profit multiple transactions 2 >> " + maxProfitMultipleTransactions2(prices3));
		prices3 = new int[] { 3, 2, 6, 5, 0, 3 };
		System.out.println("BuySellStock max profit K transactions >> " + maxProfitKTransactions(2, prices3));

	}

	// Time: O(n^2)
	private static int maxProfit(int[] prices) {
		int max = 0;
		for (int i = 0; i < prices.length; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				max = Math.max(prices[j] - prices[i], max);
			}
		}
		return max;
	}

	// Time: O(n)
	private static int maxProfitOn(int[] prices) {
		int max = -1, min = Integer.MAX_VALUE;

		for (int i = 0; i < prices.length; i++) {
			if (min > prices[i]) {
				min = prices[i];
			} else {
				max = Math.max(max, prices[i] - min);
			}
		}
		return max;
	}

	// Time: O(n)
	private static int maxProfitMultipleTransactions(int[] prices) {
		int max = 0, min = Integer.MAX_VALUE;

		for (int i = 0; i < prices.length - 1; i++) {
			min = Math.min(min, prices[i]);
			if (prices[i + 1] < prices[i]) {
				max += (prices[i] - min);
				min = prices[i + 1];
			}
		}
		if (prices[prices.length - 1] > min) {
			max += (prices[prices.length - 1] - min);
		}
		return max;
	}

	// Time: O(n)
	private static int maxProfitMultipleTransactions2(int[] prices) {
		int max = 0;

		for (int i = 1; i < prices.length; i++) {
			if (prices[i - 1] < prices[i]) {
				// Sell when current price is greater than previous
				max += prices[i] - prices[i - 1];
			}
		}

		return max;
	}

	// Time: O(n)
	private static int maxProfitKTransactions(int k, int[] prices) {
		int max = 0, min = Integer.MAX_VALUE;

		for (int i = 1; i < prices.length; i++) {
			min = Math.min(min, prices[i]);
			if (prices[i - 1] < prices[i] && k != 0) {
				max += (prices[i] - min);
				min = prices[i];
				k--;
			}
		}

		return max;
	}
}
