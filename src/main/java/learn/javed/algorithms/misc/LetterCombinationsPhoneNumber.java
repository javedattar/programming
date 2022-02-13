/**
* author: Javed Attar
*/
package learn.javed.algorithms.misc;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsPhoneNumber {
	public static void main(String[] args) {
		System.out.println(letterCombinations("234"));
		System.out.println(letterCombinations("7979"));
	}

	// 4^n
	public static List<String> letterCombinations(String digits) {
		List<String> results = new ArrayList<>();
		if (digits.isEmpty() || digits.contains("0") || digits.contains("1"))
			return results;

		String[] letters = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		int[] digitsArray = new int[digits.length()];

		for (int i = 0; i < digits.length(); i++)
			digitsArray[i] = Integer.valueOf(digits.charAt(i) - '0');

		StringBuilder combo = new StringBuilder();
		findCombo(letters, digitsArray, 0, combo, results);
		System.out.println(results.size());
		return results;
	}

	private static void findCombo(String[] letters, int[] digitsArray, int digitIndex, StringBuilder combo,
			List<String> results) {

		if (digitsArray.length == combo.length()) {
			results.add(combo.toString());
			return;
		}
		for (int j = 0; j < letters[digitsArray[digitIndex]].length(); j++) {
			combo.append(letters[digitsArray[digitIndex]].charAt(j));
			findCombo(letters, digitsArray, digitIndex + 1, combo, results);
			combo.deleteCharAt(combo.length() - 1);
		}

	}
}
