/**
* author: Javed Attar
*/
package learn.javed.algorithms.strings;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

	public static void main(String[] args) {
		MinimumWindowSubstring mws = new MinimumWindowSubstring();
//		System.out.println("For given input s=ADOBECODEBANC and t=ABC expected \"BANC\" and actual >> "
//				+ mws.minWindow("ADOBECODEBANC", "ABC"));
//		System.out.println("For given input s=ADOBECODEANC and t=ABC expected \"ADOBEC\" and actual >> "
//				+ mws.minWindow("ADOBECODEANC", "ABC"));
//		System.out.println("For given input s=A and t=AA expected \"\" and actual >> " + mws.minWindow("A", "AA"));
//		System.out.println("For given input s=A and t=A expected \"A\" and actual >> " + mws.minWindow("A", "A"));
		System.out.println("For given input s=ADOBECODEBANC and t=ABC expected \"BANC\" and actual >> "
				+ mws.minWindowSlidingWindowMemo("ADOBECODEBANC", "ABC"));
		System.out.println("For given input s=ADOBECODEANC and t=ABC expected \"ADOBEC\" and actual >> "
				+ mws.minWindowSlidingWindowMemo("ADOBECODEANC", "ABC"));
		System.out.println("For given input s=A and t=AA expected \"\" and actual >> "
				+ mws.minWindowSlidingWindowMemo("A", "AA"));
		System.out.println(
				"For given input s=A and t=A expected \"A\" and actual >> " + mws.minWindowSlidingWindowMemo("A", "A"));
		System.out.println("For given input s=BBA and t=AB expected \"BA\" and actual >> "
				+ mws.minWindowSlidingWindowMemo("BBA", "AB"));

	}

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
			if (check(target, s, start, end)) {
				if (min > end-start) {
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

	public boolean check(String target, String source, int start, int end) {

		int[] ds = new int[256];
		char[] sa = target.toCharArray();
//		char[] ta = temp.toCharArray();
		for (int i = 0; i < sa.length; i++) {
			ds[sa[i]] += 1;
		}
		for (int i = start; i < end; i++) {
			ds[source.charAt(i)] -= 1;
		}
		for (int val : ds) {
			if (val > 0) {
				return false;
			}
		}
		return true;
	}

	public String minWindowSlidingWindowMemo(String s, String target) {
		if (s.length() < 1 || s.length() > 100000) {
			return "";
		}
		if (target.length() < 1 || target.length() > 100000) {
			return "";
		}
		StringBuilder result = new StringBuilder();
		int start = 0, end = 0, minWindowLength = 100001;
		Map<Character, Integer> targetMap = new HashMap<>();
		Map<Character, Integer> windowMap = new HashMap<>();
		// populate target map
		for (int i = 0; i < target.length(); i++) {
			char currChar = target.charAt(i);
			targetMap.put(currChar, targetMap.getOrDefault(currChar, 0) + 1);
		}
		int required = target.length();
		int formed = 0;

		while (end < s.length()) {
			char currChar = s.charAt(end);
			// add character to window map with counts
			if (targetMap.containsKey(currChar)) {
				windowMap.put(currChar, windowMap.getOrDefault(currChar, 0) + 1);
				if (windowMap.get(currChar) <= targetMap.get(currChar))
					formed++;
			}
			// Try to remove chars until
			while (required == formed && start <= end) {
				if (minWindowLength > end - start + 1) {
					result = new StringBuilder(s.substring(start, end + 1));
					minWindowLength = end - start + 1;
				}

				char leftChar = s.charAt(start);
				if (windowMap.containsKey(leftChar)) {
					windowMap.put(leftChar, windowMap.get(leftChar) - 1);
					if (windowMap.get(leftChar) < targetMap.get(leftChar)) {
						formed--;
					}
				}
				start++;
			}

			end++;
		}
		System.out.println(minWindowLength);
		return result.toString();

	}

}
