/**
* author: Javed Attar
*/
package learn.javed.algorithms.nums;

public class MultiplyNumbers {

	public static void main(String[] args) {
		System.out.println(multiply(2, 3));
		System.out.println(multiply(-2, 3));
		System.out.println(multiply(-2, -3));
		System.out.println(multiply(0, -3));
		System.out.println(multiply(0, 0));
		System.out.println(multiply(0, 0));
		System.out.println(multiply(Integer.MAX_VALUE / 2, 3));
		System.out.println(multiply(Integer.MAX_VALUE, 1));
		// Max + 1 becomes negative
		System.out.println(Integer.MAX_VALUE + 1);

	}

	public static int multiply(int num1, int num2) {

		// validation in case of nulls
		if (num1 == Integer.MAX_VALUE || num2 == Integer.MAX_VALUE || num1 == Integer.MIN_VALUE
				|| num2 == Integer.MIN_VALUE) {
			return Integer.MAX_VALUE;
		}

		if (Math.abs(num1) < Math.abs(num2))
			return multiply(num2, num1);

		boolean signX = num1 < 0;
		boolean signY = num2 < 0;

		if (signX)
			num1 = Math.abs(num1);
		if (signY)
			num2 = Math.abs(num2);

		int result = 0;
		for (int i = 0; i < num2; i++) {
			// In java when int exceeds number max then it can will become negative
			// since numbers are positive while processing product should never become negative
			if (result + num1 < 0) {
				return Integer.MAX_VALUE;
			}
			result += num1;
		}

		if (signX)
			result = 0 - result;
		if (signY)
			result = 0 - result;

		return result;
	}

}
