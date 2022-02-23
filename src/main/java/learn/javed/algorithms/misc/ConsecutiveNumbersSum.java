/**
* author: Javed Attar
*/
package learn.javed.algorithms.misc;

/**
 * Given an integer n, return the number of ways you can write n as the sum of consecutive positive integers.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 5
 * Output: 2
 * Explanation: 5 = 2 + 3
 * Example 2:
 * 
 * Input: n = 9
 * Output: 3
 * Explanation: 9 = 4 + 5 = 2 + 3 + 4
 * Example 3:
 * 
 * Input: n = 15
 * Output: 4
 * Explanation: 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5
 *
 */
public class ConsecutiveNumbersSum {

	public static void main(String[] args) {
		System.out.println(consecutiveNumbersSum(9));
		System.out.println(consecutiveNumbersSum(15));
		System.out.println(consecutiveNumbersSum(3));
		System.out.println(consecutiveNumbersSum(835066812));
		System.out.println(consecutiveNumSum(9));
		System.out.println(consecutiveNumSum(15));
		System.out.println(consecutiveNumSum(3));
		System.out.println(consecutiveNumSum(835066812));

	}

	public static int consecutiveNumbersSum(int n) {
		int counter = 1;
		if (n < 3) {
			return counter;
		}
		int numIteration = n / 2 + 1;
		int sum = 0;

		int startPointer = numIteration;
		while (numIteration >= 0) {

			if (sum >= n) {
				if (sum == n)
					counter++;
				sum -= startPointer--;

			}
			sum += numIteration--;
//			System.out.println(numIteration + " sum => " + sum + " startPointer => " + startPointer);
		}
		return counter;
	}

	/**
	 * With Mathematical formula to find out factors
	 * 
	 * N = addition of consecutive numbers
	 * that means there is common factor consecutive numbers that can be extracted, so N can be represented as
	 * 
	 * N = (x+1) + (x+2) + (x+3) +... (x+k)
	 * N = xk + (1+2+3+....+k)
	 * Addition of 1 through k consecutive numbers can be represented as
	 * 
	 * N = xk + (k (k+1)/2)
	 * N = xk + k^2/2 + k/2
	 * 2N = 2xk + k^2 + k
	 * 2N = k^2 + 2xk + k
	 * 2N = (k+x)^2
	 * sqrt of 2N = k+x
	 * k = sqrt 2N - x
	 * 
	 * 
	 */

	public static int consecutiveNumSum(int n) {
		int k = (int) Math.sqrt(2 * n) + 1;
		int counter = 0;
		for (int i = 1; i <= k; i++) {
			n -= i;
			if (n != 0 && n % i == 0)
				counter++;
		}
		return counter;
	}

}
