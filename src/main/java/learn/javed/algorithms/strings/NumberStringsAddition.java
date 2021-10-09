package learn.javed.algorithms.strings;

public class NumberStringsAddition {

	public static void main(String[] args) {
		String result = add("123","1234");
		if ("1357".equals(result)) {
			System.out.println("Pass >> " + result);
		} else {
			System.out.println("Fail >> " + result);
		}

	}
	
	private static String add(String s1, String s2) {
		String result = new String();
		//do some basic validation
		if (s1 == null || s2 == null || s1.isBlank() || s2.isBlank())
			return result;
		
		int i = s1.length()-1;
		int j = s2.length()-1;
		int carry = 0;
		while(i >=0 || j >=0) {
			int iSum = carry;
			if ( i>=0) {
				iSum += s1.charAt(i--) - '0';
			}
			if ( j>=0) {
				iSum += s2.charAt(j--) - '0';
			}
			
			carry = iSum / 10;
			result = iSum % 10 + result;
			
			
		}
		return result;
	}

}
