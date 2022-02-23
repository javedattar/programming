/**
* author: Javed Attar
*/
package learn.javed.algorithms.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Amazon
 * Given a text txt[0..n-1] and a pattern pat[0..m-1], find all start indices of pat’ anagrams in txt.
 * text: “cbaebabacd” pat=“abc”
 * output = [0,6]
 * 
 * // lower case
 * // output start indices of anargam in the text
 * 
 * // Examples
 * text="abc" pat = "bc"
 * output 1
 * 
 * text = "adcbdac" pat = "acd"
 * output 0,4
 * 
 * text ="xyz" pat = "ab"
 * output []
 * 
 * @author jattar
 *
 */
public class FindAnagramPatternInText {

	public static void main(String[] args) {
		System.out.println(findPatternInText("abc", "bc"));
		System.out.println(findPatternInText("cbaebabacd", "abc"));
		System.out.println(findPatternInText("xyz", "bc"));

	}

	public static List<Integer> findPatternInText(String text, String pattern) {

		List<Integer> result = new ArrayList<>();
		// validation for lengths
		if (pattern == null || text == null || pattern.length() > text.length()) {
			return result;
		}

		int textLength = text.length();
		int patternLength = pattern.length();
		int startIndex = 0;

		while (startIndex < textLength - patternLength + 1) {
			if (isAnagram(startIndex, startIndex + patternLength, text, pattern)) {
				result.add(startIndex);
			}
			startIndex++;
		}

		return result;
	}

	private static boolean isAnagram(int startIndex, int endIndex, String text, String pattern) {
		int[] anagramArray = new int[256];

		for (int i = 0; i < pattern.length(); i++)
			anagramArray[pattern.charAt(i)] += 1;

		for (int i = startIndex; i < endIndex; i++)
			anagramArray[text.charAt(i)] -= 1;

		for (int i = 0; i < anagramArray.length; i++) {
			if (anagramArray[i] != 0) {
				return false;
			}
		}
		return true;

	}
}
