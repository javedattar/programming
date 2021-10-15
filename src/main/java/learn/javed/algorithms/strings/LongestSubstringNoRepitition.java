package learn.javed.algorithms.strings;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringNoRepitition {

	
	public static void main(String[] args) {
		System.out.println("Length of aaaaaabcdabcbb expected 4 and actual=>" + lengthOfLongestSubstring("aaaaaabcdabcbb"));
		System.out.println("Length of pwwkew expected 3 and actual=>" + lengthOfLongestSubstring("pwwkew"));
		System.out.println("Length of jjjjj expected 1 and actual=>" + lengthOfLongestSubstring("jjjjj"));
		System.out.println("Length of empty string expected 0 and actual=>" + lengthOfLongestSubstring(""));
		System.out.println("Length of dvdf expected 3 and actual=>" + lengthOfLongestSubstring("dvdf"));
		System.out.println("Length of dvvdf expected 3 and actual=>" + maxLength("dvvdf"));
	}
	// First attempt with sliding window

	public static int lengthOfLongestSubstring(String s) {
		if (s == null || s.isEmpty()) {
			return 0;
		}
		
//		StringBuilder result = new StringBuilder();
		HashSet<Character> ds = new HashSet<>();

		int i = 0, j = 0, length = 0;
		while (i < s.length()) {
//			StringBuilder sb = new StringBuilder();
			int counter = 0;
			for (int k = i; k < s.length(); k++) {
				if (!ds.contains(s.charAt(k))) {
//					sb.append(s.charAt(k));
					ds.add(s.charAt(k));
					counter++;
				} else {
					break;
				}
			}

			ds.clear();
			if (length < counter) {
				length = counter;
//				result = new StringBuilder(sb.toString());
				
			}
			i++;
		}
//		System.out.println("Substring =>" + result);
		return length;
	}
	
	public static int maxLength(String input) {
        int start = 0;
        int end = 0;
        int max = 0;

        Set<Character> chars = new HashSet<>();

        while (start < input.length() && end < input.length()) {
            if (!chars.contains(input.charAt(end))) {
                chars.add(input.charAt(end++));
                max = Math.max(max, end - start);
            } else {
                chars.remove(input.charAt(start++));
            }
        }

        return max;
    }

}
