package learn.javed.algorithms.strings;

public class NumberStringsAddition {

	public static void main(String[] args) {
		String result = add("123", "1234");
		if ("1357".equals(result)) {
			System.out.println("Pass >> " + result);
		} else {
			System.out.println("Fail >> " + result);
		}
		System.out.println(add("9231", "1234"));
		System.out.println(add("1111", "889"));

	}

	private static String add(String s1, String s2) {
		StringBuilder result = new StringBuilder();
		// do some basic validation
		if (s1 == null || s2 == null || s1.isBlank() || s2.isBlank())
			return result.toString();

		int i = s1.length() - 1;
		int j = s2.length() - 1;
		int carry = 0;
		while (i >= 0 || j >= 0) {
			int iSum = carry;
			if (i >= 0) {
				iSum += s1.charAt(i--) - '0';
			}
			if (j >= 0) {
				iSum += s2.charAt(j--) - '0';
			}

			carry = iSum / 10;
			result.insert(0, iSum % 10);

		}
		if (carry == 1) {
			result.insert(0, carry);
		}
		return result.toString();
	}

}
