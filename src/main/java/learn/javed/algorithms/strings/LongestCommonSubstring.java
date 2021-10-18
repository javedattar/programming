/**
* author: Javed Attar
*/
package learn.javed.algorithms.strings;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		int result = lengthCommonSubString("abcd", "");

	}

	private static int lengthCommonSubString(String s1, String s2) {
		int i = s1.length() - 1, j = 0, max = 0;
		while (i > 0) {
			String temp = s1.substring(0, i);
			int k = 0;
			while (k < temp.length() || j < s2.length()) {
				if (temp.substring(k, i).equals(s2.substring(j))) {
					Math.max(max, temp.substring(k, i).length());
				}
				k++;
			}

		}
		return 0;
	}

}
