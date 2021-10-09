package learn.javed.algorithms.strings;

public class BinaryStringAddition {
	
	

	public static void main(String[] args) {
		System.out.println(addBinary("10101010","0100"));
	}

	private static String addBinary(String s1, String s2) {
		StringBuilder result = new StringBuilder();
		int i =s1.length()-1, j=s2.length()-1;
		int carry = 0;
		while (i>=0 || j >=0) {
			int iSum = carry;
			if (i >= 0) {
				iSum += s1.charAt(i--) - '0';
			}
			if (j >= 0) {
				iSum += s2.charAt(j--) - '0';
			}
			// Since it's binary there can be carry of 1 max.
			// and number to appended in case of 0+0 = 0, 0+1 = 1, 1+1 = 1
			
			carry = iSum / 2;
			result.insert(0, iSum % 2);

		}
		if (carry == 1)
			result.insert(0,carry);
		return result.toString();
	}

}
