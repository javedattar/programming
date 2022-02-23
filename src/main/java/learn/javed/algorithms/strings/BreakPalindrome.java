/**
* author: Javed Attar
*/
package learn.javed.algorithms.strings;

public class BreakPalindrome {

	public static void main(String[] args) {
		System.out.println(breakPalindrome("abccba"));
		System.out.println(breakPalindrome("aaaa"));
		System.out.println(breakPalindrome("aba"));
		System.out.println(breakPalindrome("zbccbz"));

	}

	public static String breakPalindrome(String palindrome) {

		// validate input string
		if (palindrome == null || palindrome.isEmpty() || palindrome.length() < 2) {
			return "";
		}
		StringBuilder sbr = new StringBuilder(palindrome);
		// since it's palindrome, half of the string
		int index = -1;
		int length = palindrome.length() / 2;
		for (int i = 0; i < length; i++) {
			if (palindrome.charAt(i) != 'a') {
				index = i;
				break;
			}
		}
		if (index == -1) {
			sbr.replace(palindrome.length() - 1, palindrome.length(), "b");
		} else {
			sbr.replace(index, index + 1, "a");
		}
		return sbr.toString();
	}
}
