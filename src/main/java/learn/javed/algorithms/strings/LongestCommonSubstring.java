/**
* author: Javed Attar
*/
package learn.javed.algorithms.strings;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		System.out.println("Common substring length >> " + lengthCommonSubString("abcd", "xbc"));

	}

	private static int lengthCommonSubString(String s1, String s2) {
		String shortString = s1.length() > s2.length() ? s2 : s1;
		String longString = s1.length() < s2.length() ? s2 : s1;
		int sStart = 0, sEnd = 0;
		int lStart = 0, lEnd = 0;
		int max = 0;
		while (sStart < shortString.length() && sEnd < shortString.length()) {
			while (sEnd < shortString.length() && lStart < longString.length()) {
				if (shortString.substring(sStart, sEnd).equals(longString.substring(lStart, lStart + sEnd))) {
					sEnd++;
					max = Math.max(max, sEnd - sStart);
				} else {
					lStart++;
				}
			}
			if(sEnd < shortString.length())
				sStart++;
			lStart = 0;

		}
		System.out.println("Common substring >> " + shortString.substring(sStart, sEnd));
		return max;
	}

}
