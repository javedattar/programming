/**
* author: Javed Attar
*/
package learn.javed.algorithms.strings;

public class LongestPalindromicSubStrImproved {

	public static void main(String[] args) {
		System.out.println(new LongestPalindromicSubStrImproved().longestPalindrome("tattarrattat"));
		System.out.println(new LongestPalindromicSubStrImproved().longestPalindrome("dsfasdabbaasdasddasad"));
		System.out.println(new LongestPalindromicSubStrImproved().longestPalindrome("dsfasdabbaasdaswsed"));
		System.out.println(new LongestPalindromicSubStrImproved().longestPalindrome("werkasdabcbaxcvopxcp"));
	}

	/**
	 * Missing few usecases with even number..
	 * .. example "tattarrattat", abba
	 */
	public String longestPalindrome(String x) {
		int startIndex = 0;
		int maxLen = Integer.MIN_VALUE;

		for (int i = 0; i < x.length(); i++) {
			int oddLengthPalindrome = expandMiddle(x, i, i);
			int evenLengthPalindrome = expandMiddle(x, i, i + 1);

			int currMax = Math.max(oddLengthPalindrome, evenLengthPalindrome);

			if (maxLen < currMax) {
				startIndex = i - (currMax - 1) / 2;
				maxLen = currMax;
//				endIndex = i + (currMax) / 2;
			}
		}

		return x.substring(startIndex, startIndex + maxLen);
	}

	public int expandMiddle(String s, int start, int end) {
		if (s == null || end < start)
			return 0;

		while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
			start--;
			end++;
		}

		return end - start - 1;
	}

}
