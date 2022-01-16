/**
* author: Javed Attar
*/
package learn.javed.algorithms.strings;

import java.util.HashSet;
import java.util.Set;

public class LongestPalindromeSubstring {

	public static void main(String[] args) {
		LongestPalindromeSubstring lps = new LongestPalindromeSubstring();
//		System.out.println(lps.longestPalindrome("babad"));
//		System.out.println(lps.longestPalindrome("cbbd"));
//		System.out.println(lps.longestPalindrome("ac"));
//		System.out.println(lps.longestPalindrome("a"));
//		System.out.println(lps.longestPalindrome("asfasabccbaetetete"));
		System.out.println(lps.longestPalindrome(
				"esbtzjaaijqkgmtaajpsdfiqtvxsgfvijpxrvxgfumsuprzlyvhclgkhccmcnquukivlpnjlfteljvykbddtrpmxzcrdqinsnlsteonhcegtkoszzonkwjevlasgjlcquzuhdmmkhfniozhuphcfkeobturbuoefhmtgcvhlsezvkpgfebbdbhiuwdcftenihseorykdguoqotqyscwymtjejpdzqepjkadtftzwebxwyuqwyeegwxhroaaymusddwnjkvsvrwwsmolmidoybsotaqufhepinkkxicvzrgbgsarmizugbvtzfxghkhthzpuetufqvigmyhmlsgfaaqmmlblxbqxpluhaawqkdluwfirfngbhdkjjyfsxglsnakskcbsyafqpwmwmoxjwlhjduayqyzmpkmrjhbqyhongfdxmuwaqgjkcpatgbrqdllbzodnrifvhcfvgbixbwywanivsdjnbrgskyifgvksadvgzzzuogzcukskjxbohofdimkmyqypyuexypwnjlrfpbtkqyngvxjcwvngmilgwbpcsseoywetatfjijsbcekaixvqreelnlmdonknmxerjjhvmqiztsgjkijjtcyetuygqgsikxctvpxrqtuhxreidhwcklkkjayvqdzqqapgdqaapefzjfngdvjsiiivnkfimqkkucltgavwlakcfyhnpgmqxgfyjziliyqhugphhjtlllgtlcsibfdktzhcfuallqlonbsgyyvvyarvaxmchtyrtkgekkmhejwvsuumhcfcyncgeqtltfmhtlsfswaqpmwpjwgvksvazhwyrzwhyjjdbphhjcmurdcgtbvpkhbkpirhysrpcrntetacyfvgjivhaxgpqhbjahruuejdmaghoaquhiafjqaionbrjbjksxaezosxqmncejjptcksnoq"));
		System.out.println(lps.longestPalindromeUsingSubstrin(
				"esbtzjaaijqkgmtaajpsdfiqtvxsgfvijpxrvxgfumsuprzlyvhclgkhccmcnquukivlpnjlfteljvykbddtrpmxzcrdqinsnlsteonhcegtkoszzonkwjevlasgjlcquzuhdmmkhfniozhuphcfkeobturbuoefhmtgcvhlsezvkpgfebbdbhiuwdcftenihseorykdguoqotqyscwymtjejpdzqepjkadtftzwebxwyuqwyeegwxhroaaymusddwnjkvsvrwwsmolmidoybsotaqufhepinkkxicvzrgbgsarmizugbvtzfxghkhthzpuetufqvigmyhmlsgfaaqmmlblxbqxpluhaawqkdluwfirfngbhdkjjyfsxglsnakskcbsyafqpwmwmoxjwlhjduayqyzmpkmrjhbqyhongfdxmuwaqgjkcpatgbrqdllbzodnrifvhcfvgbixbwywanivsdjnbrgskyifgvksadvgzzzuogzcukskjxbohofdimkmyqypyuexypwnjlrfpbtkqyngvxjcwvngmilgwbpcsseoywetatfjijsbcekaixvqreelnlmdonknmxerjjhvmqiztsgjkijjtcyetuygqgsikxctvpxrqtuhxreidhwcklkkjayvqdzqqapgdqaapefzjfngdvjsiiivnkfimqkkucltgavwlakcfyhnpgmqxgfyjziliyqhugphhjtlllgtlcsibfdktzhcfuallqlonbsgyyvvyarvaxmchtyrtkgekkmhejwvsuumhcfcyncgeqtltfmhtlsfswaqpmwpjwgvksvazhwyrzwhyjjdbphhjcmurdcgtbvpkhbkpirhysrpcrntetacyfvgjivhaxgpqhbjahruuejdmaghoaquhiafjqaionbrjbjksxaezosxqmncejjptcksnoq"));
	}

	public String longestPalindrome(String s) {
		Set<String> ds = new HashSet<>();
		String result = "";
		int maxLen = Integer.MIN_VALUE;
		for (int i = 0; i <= s.length(); i++) {
			String temp = isPalindrome(s, i, ds);
			if (!temp.isEmpty() && maxLen < temp.length()) {
				result = temp;
				maxLen = temp.length();
			}
		}
		return result;
	}

	private String isPalindrome(String s, int index, Set<String> ds) {
		String result = "";
		for (int i = index + 1; i <= s.length(); i++) {
			String temp = s.substring(index, i);
			if (ds.contains(temp)) {

			} else {
				StringBuilder sb = new StringBuilder(temp);
				if (sb.toString().equals(sb.reverse().toString())) {
					result = sb.toString();
					ds.add(result);
				}
			}
		}

		return result;
	}

	public String longestPalindromeUsingSubstrin(String s) {
		Set<String> ds = new HashSet<>();
		String result = "";
		int maxLen = Integer.MIN_VALUE;
		StringBuilder sb = new StringBuilder(s);
		String sPrime = sb.reverse().toString();
		// Find common substring between s and s-reverse
		StringBuilder sbContainer = new StringBuilder();
		String subS = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == sPrime.charAt(i)) {
				sbContainer.append(s.charAt(i));
			} else {
				if (subS.length() < sbContainer.length()) {
					subS = sbContainer.toString();
				}
				sb = new StringBuilder();
			}
		}
		for (int i = 0; i <= subS.length(); i++) {
			String temp = isPalindrome(subS, i, ds);
			if (!temp.isEmpty() && maxLen < temp.length()) {
				result = temp;
				maxLen = temp.length();
			}
		}
		return result;
	}
}
