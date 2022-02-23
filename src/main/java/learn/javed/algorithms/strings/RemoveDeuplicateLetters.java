/**
* author: Javed Attar
*/
package learn.javed.algorithms.strings;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your
 * result is the smallest in lexicographical order among all possible results.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "bcabc"
 * Output: "abc"
 * Example 2:
 * 
 * Input: s = "cbacdcbc"
 * Output: "acdb"
 * 
 * @author jattar
 *
 */
public class RemoveDeuplicateLetters {

	public static void main(String[] args) {
		System.out.println(removeDuplicateLetters("bcabc"));
		System.out.println(removeDuplicateLetters("cbacdcbc"));
		System.out.println(removeDuplicateLettersMono("bcabc"));
		System.out.println(removeDuplicateLettersMono("cbacdcbc"));
		System.out.println(removeDuplicateLettersMono("cbacdcca"));
	}

	public static String removeDuplicateLetters(String s) {
		if (s == null || s.isEmpty()) {
			return "";
		}
		// Map<Character, Interger> map = new HashMap<>();

		int markCharacters[] = new int[26];

		for (char c : s.toCharArray()) {
			// map.put(c-'a', map.getOrDefault(c-'a', 0)+1)
			markCharacters[c - 'a'] += 1;
		}
		StringBuilder result = new StringBuilder();
		PriorityQueue<Character> uniqueChars = new PriorityQueue<>();
		for (int i = 0; i < markCharacters.length; i++) {
			if (markCharacters[i] > 0)
				uniqueChars.add((char) (i + 'a'));
		}

		for (int i = 0; i < s.length(); i++) {
			System.out.println(uniqueChars.peek());
			// if(!visited.contains(s.charAt(i))) {
			char c = s.charAt(i);
			int index = c - 'a';
			markCharacters[index] -= 1;
			if (markCharacters[index] == 0) {
				result.append(c);
				uniqueChars.remove(c);
			} else if (markCharacters[index] > 0) {
				if (uniqueChars.peek() == c) {
					result.append(c);
					uniqueChars.remove(c);
				}
//				if (index == lexOrder + 1) {
//					result.append(c);
//					markCharacters[index] = -1;
//					lexOrder++;
//				} else {
//					markCharacters[index] -= 1;
//				}
			}
		}
		return result.toString();
	}

	public static String removeDuplicateLettersMono(String s) {

		Stack<Character> monoStack = new Stack<>();

		int[] numCharacters = new int[26];  // Record the number of times per character ;

		for (int i = 0; i < s.length(); i++) {

			numCharacters[s.charAt(i) - 'a']++;

		}
		// O(1) lookup for is in stack or not.
		// Can use hashset as well
		boolean[] instack = new boolean[26];

		for (Character currChar : s.toCharArray()) {
			// get index
			int currIndex = (int) (currChar - 'a');
			// Reduce count as we process the character
			numCharacters[currIndex]--;
			//
			// if element is in the stack already then no need to process it further;
			if (instack[currIndex])
				continue;

			// Maintain a monotonically increasing stack ;
			// the top of the stack is larger than current char lexicographically

			while (!monoStack.isEmpty() && currChar < monoStack.peek()) {

				// if peek of the stack is already reached count 0 that means there are no more elements proceed
				// Hence we can't pop it so break out of the loop and push current char to stack
				if (numCharacters[monoStack.peek() - 'a'] == 0)
					break;

				instack[monoStack.pop() - 'a'] = false;

			}

			monoStack.push(currChar);

			instack[currIndex] = true;

		}

		StringBuilder result = new StringBuilder();

		while (!monoStack.isEmpty()) {

			result.insert(0, monoStack.pop());

		}

		return result.toString();

	}

}
