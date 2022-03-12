/**
* author: Javed Attar
*/
package learn.javed.algorithms.strings;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1190
 * You are given a string s that consists of lower case English letters and brackets.
 * 
 * Reverse the strings in each pair of matching parentheses, starting from the innermost one.
 * 
 * Your result should not contain any brackets.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "(abcd)"
 * Output: "dcba"
 * Example 2:
 * 
 * Input: s = "(u(love)i)"
 * Output: "iloveu"
 * Explanation: The substring "love" is reversed first, then the whole string is reversed.
 * Example 3:
 * 
 * Input: s = "(ed(et(oc))el)"
 * Output: "leetcode"
 * Explanation: First, we reverse the substring "oc", then "etco", and finally, the whole string.
 * 
 * @author jattar
 *
 */
public class ReverseSubstringsBetweenParenthesis {

	public static void main(String[] args) {
		System.out.println(" Input (u(love)i) >> " + reverseParentheses("(u(love)i)"));
		System.out.println(" Input (abcd) >> " + reverseParentheses("(abcd)"));
		System.out.println(" Input (ed(et(oc))el) >> " + reverseParentheses("(ed(et(oc))el)"));

	}

	public static String reverseParentheses(String s) {
		Deque<Character> queue = new ArrayDeque<>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ')') {
				StringBuilder word = new StringBuilder();
				while (!queue.isEmpty() && (queue.peek() != '(')) {
					word.append(queue.pop());
				}
				int j = 0;
				queue.pop();
				while (j < word.length())
					queue.push(word.charAt(j++));
			} else {
				queue.push(s.charAt(i));
			}

		}
		StringBuilder sb = new StringBuilder();
		while (!queue.isEmpty())
			sb.append(queue.removeLast());
		return sb.toString();
	}

}
