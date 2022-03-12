/**
* author: Javed Attar
*/
package learn.javed.algorithms.strings;

import java.util.Stack;

/**
 * 1249:
 * Given a string s of '(' , ')' and lowercase English characters.
 * 
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting
 * parentheses string is valid and return any valid string.
 * 
 * Formally, a parentheses string is valid if and only if:
 * 
 * It is the empty string, contains only lowercase characters, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 * 
 * 
 * Example 1:
 * 
 * Input: s = "lee(t(c)o)de)"
 * Output: "lee(t(c)o)de"
 * Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
 * Example 2:
 * 
 * Input: s = "a)b(c)d"
 * Output: "ab(c)d"
 * Example 3:
 * 
 * Input: s = "))(("
 * Output: ""
 * Explanation: An empty string is also valid.
 * 
 * @author jattar
 *
 */

public class MinimumRemoveToMakeValidParenthesis {

	public static void main(String[] args) {
		System.out.println(" Input= lee(t(c)o)de) output= " + minRemoveToMakeValid("lee(t(c)o)de)"));
		System.out.println(" Input= a)b(c)d output= " + minRemoveToMakeValid("a)b(c)d"));
		System.out.println(" Input= ))(( output= " + minRemoveToMakeValid("))(("));
		System.out.println(" Input= lee(t(c)o)de) output= " + minRemoveToMakeValidWithStacks("lee(t(c)o)de)"));
		System.out.println(" Input= a)b(c)d output= " + minRemoveToMakeValidWithStacks("a)b(c)d"));
		System.out.println(" Input= ))(( output= " + minRemoveToMakeValidWithStacks("))(("));
	}

	public static String minRemoveToMakeValid(String s) {

		Stack<Integer> openParenStack = new Stack<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) == '(') {

				sb.append(s.charAt(i));
				openParenStack.push(sb.length() - 1);
			} else if (s.charAt(i) == ')') {
				if (!openParenStack.isEmpty()) {
					openParenStack.pop();
					sb.append(s.charAt(i));
				}
			} else
				sb.append(s.charAt(i));
		}

		while (!openParenStack.isEmpty()) {
			int index = openParenStack.pop();
			sb.replace(index, index + 1, "");
		}

		return sb.toString();
	}

	public static String minRemoveToMakeValidWithStacks(String s) {

		Stack<Integer> openParenStack = new Stack<>();
		Stack<Integer> closeParenStack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(')
				openParenStack.push(i);
			else if (s.charAt(i) == ')')
				if (!openParenStack.isEmpty())
					openParenStack.pop();
				else
					closeParenStack.push(i);
		}
		StringBuilder sb = new StringBuilder(s);
		while (!openParenStack.isEmpty()) {

			int index = openParenStack.pop();
			sb.replace(index, index + 1, "");
		}
		while (!closeParenStack.isEmpty()) {
			int index = closeParenStack.pop();
			sb.replace(index, index + 1, "");
		}
		return sb.toString();
	}

}
