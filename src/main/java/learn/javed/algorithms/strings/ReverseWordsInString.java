/**
* author: Javed Attar
*/
package learn.javed.algorithms.strings;

import java.util.Iterator;
import java.util.Stack;
import java.util.StringTokenizer;

public class ReverseWordsInString {

	public static void main(String[] args) {
		System.out.println(reverseWords("the sky is blue"));
		System.out.println(reverseWordsUsingStack("the sky is blue"));
		System.out.println(reverseWordsUsingStringSplit("the sky is blue"));
	}

	public static String reverseWords(String s) {
		if (s == null || s.isEmpty()) {
			return "";
		}
		s = s.trim();
		StringBuilder result = new StringBuilder();
		int index = 0;
		int spaceIndex = 0;
		while (spaceIndex != -1) {
			spaceIndex = s.indexOf(" ");
			if (spaceIndex != -1) {
				String word = s.substring(0, spaceIndex).trim();
				if (word.trim().length() > 0) {
					result.insert(0, word);
					// index += spaceIndex + 1;

					if (spaceIndex < s.length()) {
						result.insert(0, " ");
					}
				}
				s = s.substring(spaceIndex + 1);
			} else {
				break;
			}

		}
		if (spaceIndex == -1 && spaceIndex < s.length()) {
			result.insert(0, s.substring(0, s.length()));
		}
		return result.toString();
	}

	public static String reverseWordsUsingStack(String s) {
		if (s == null || s.isEmpty()) {
			return "";
		}
		StringTokenizer st = new StringTokenizer(s, " ");

		Stack<String> stack = new Stack<>();
		Iterator<Object> asIterator = st.asIterator();
		while (asIterator.hasNext()) {
			stack.push(((String) asIterator.next()).trim());
		}
		StringBuilder result = new StringBuilder();
		while (!stack.isEmpty()) {
			result.append(stack.pop());
			result.append(" ");
		}
		return result.toString().trim();
	}

	public static String reverseWordsUsingStringSplit(String s) {
		if (s == null || s.isEmpty()) {
			return "";
		}
		String[] split = s.split(" ");
		StringBuilder result = new StringBuilder();
		for (int i = split.length - 1; i >= 0; i--) {
			if (!split[i].isEmpty()) {
				result.append(split[i]);
				result.append(" ");
			}
		}

		return result.toString().trim();
	}
}
