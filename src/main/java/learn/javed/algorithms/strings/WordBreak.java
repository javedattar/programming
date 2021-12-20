/**
* author: Javed Attar
*/
package learn.javed.algorithms.strings;

import java.util.Arrays;
import java.util.List;

public class WordBreak {

	public static void main(String[] args) {
		WordBreak w = new WordBreak();
		List<String> wordDict = Arrays.asList("apple", "pen");
//		System.out.println(w.wordBreak("applepenapple", wordDict));
		wordDict = Arrays.asList("car", "ca", "rs");
		System.out.println(w.wordBreak("cars", wordDict));
		wordDict = Arrays.asList("bc", "ca");
		System.out.println(w.wordBreak("cbca", wordDict));

		wordDict = Arrays.asList("bc", "ca");
		System.out.println(w.findImproved("cbca", wordDict));

		wordDict = Arrays.asList("car", "ca", "rs");
		System.out.println(w.findImproved("cars", wordDict));

	}

	public boolean wordBreak(String s, List<String> wordDict) {
		for (int i = 0; i < wordDict.size(); i++) {

			if (_wordBreak(s, i, wordDict)) {
				return true;
			}
		}
		return s.isEmpty();

	}

	private boolean _wordBreak(String s, int i, List<String> wordDict) {
		StringBuilder sb = new StringBuilder(s);
		for (int j = i; j < wordDict.size(); j++) {

			if (sb.indexOf(wordDict.get(j)) == 0) {
				sb.replace(0, wordDict.get(j).length(), "");
			}
		}
		return sb.toString().isEmpty();
	}

	public boolean findImproved(String phrase, List<String> dict) {
		boolean[] result = new boolean[phrase.length() + 1];
		result[0] = true; // we added 0th position to hold empty char. Which is always part of dict

		for (int i = 1; i <= phrase.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (result[j] && dict.contains(phrase.substring(j, i))) {
					result[i] = true;
					break; // as string till j'th position was valid and remaining string between
					// j and i is valid, string till i is valid
				}
			}
		}

		return result[phrase.length()];
	}
}
