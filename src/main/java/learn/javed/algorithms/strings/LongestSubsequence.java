/**
* author: Javed Attar
*/
package learn.javed.algorithms.strings;

import java.util.HashSet;
import java.util.Set;

public class LongestSubsequence {

	public static void main(String[] args) {
		System.out
				.println("Longest subsequence for pwwkew is pwke, length 4 and actual is => " + subSequence("pwwkew"));
		System.out.println(
				"Longest subsequence for aaaabaaab is ab, length 2 and actual is => " + subSequence("aaaabaaab"));

	}

	/**
	 * Longest subsequence without repeating characters.
	 * 
	 * A subsequence of a string is a new string generated from the original string
	 * with some characters (can be none) deleted without changing the relative
	 * order of the remaining characters.
	 * 
	 * For example, "ace" is a subsequence of "abcde".
	 * 
	 * @param s
	 * @return
	 */
	private static String subSequence(String s) {
		Set<Character> ds = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (!ds.contains(s.charAt(i))) {
				sb.append(s.charAt(i));
				ds.add(s.charAt(i));
			}
		}
		return sb.toString();
	}

}
