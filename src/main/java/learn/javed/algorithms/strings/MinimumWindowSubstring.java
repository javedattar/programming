/**
* author: Javed Attar
*/
package learn.javed.algorithms.strings;

public class MinimumWindowSubstring {

	public String minWindow(String s, String target) {
		if (s.length() < 1 || s.length() > 100000) {
			return "";
		}
		if (target.length() < 1 || target.length() > 100000) {
			return "";
		}
		int start = 0, end = target.length();
		int min = Integer.MAX_VALUE;
		String result = "";
		while (start <= s.length() - target.length() && end <= s.length()) {
			String temp = s.substring(start, end);
			if (check(target, temp)) {
				if (min > temp.length()) {
					min = temp.length();
					result = temp;
				}
				start++;
			} else {
				end++;
			}

		}
		return result;

	}

	public boolean check(String target, String temp) {

		int[] ds = new int[256];
		char[] sa = target.toCharArray();
		char[] ta = temp.toCharArray();
		for (int i = 0; i < sa.length; i++) {
			ds[sa[i]] += 1;
		}
		for (int i = 0; i < ta.length; i++) {
			ds[ta[i]] -= 1;
		}
		for (int val : ds) {
			if (val > 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		MinimumWindowSubstring mws = new MinimumWindowSubstring();
		System.out.println("For given input s=ADOBECODEBANC and t=ABC expected \"BANC\" and actual >> "
				+ mws.minWindow("ADOBECODEBANC", "ABC"));
		System.out.println("For given input s=ADOBECODEANC and t=ABC expected \"BANC\" and actual >> "
				+ mws.minWindow("ADOBECODEANC", "ABC"));
		System.out.println("For given input s=A and t=AA expected \"\" and actual >> " + mws.minWindow("A", "AA"));
		System.out.println("For given input s=A and t=A expected \"A\" and actual >> " + mws.minWindow("A", "A"));
	}
}
