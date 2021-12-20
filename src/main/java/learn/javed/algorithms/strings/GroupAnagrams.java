/**
* author: Javed Attar
*/
package learn.javed.algorithms.strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupAnagrams {
	public static void main(String[] args) {
		GroupAnagrams ga = new GroupAnagrams();
		String[] input = new String[] { "cat", "act", "top", "pot", "mouse", "house" };
		System.out.println(ga.groupAnagrams(input));
		input = new String[] { "eat", "tea", "tan", "ate", "nat", "bat" };
		System.out.println(ga.groupAnagrams(input));
		input = new String[] { "", "", "" };
		System.out.println(ga.groupAnagrams(input));
		input = new String[] { "", "b", "ab" };
		System.out.println(ga.groupAnagrams(input));

	}

	public List<List<String>> groupAnagrams(String[] strs) {

		List<List<String>> result = new ArrayList<List<String>>();
//		if (validateEmpty(strs) || validate(strs)) {
//			List<String> group = Arrays.asList(strs);
//			result.add(group);
//			return result;
//		}
		Set<String> visited = new HashSet<>();
		List<String> emptyGroup = new ArrayList<>();
		List<String> singleChar = new ArrayList<>();
		for (int i = 0; i < strs.length; i++) {
			if (strs[i].isEmpty()) {
				emptyGroup.add(strs[i]);
				continue;
			}
//			if (strs[i].length() == 1) {
//				singleChar.add(strs[i]);
//				continue;
//			}
			if (visited.contains(strs[i])) {
				continue;
			}
			List<String> group = new ArrayList<>();
			group.add(strs[i]);
			for (int j = i + 1; j < strs.length; j++) {

				if (!visited.contains(strs[j])) {
					if (isAnagram(strs[i], strs[j])) {
						group.add(strs[j]);
						visited.add(strs[j]);
					}
				}
			}
			visited.add(strs[i]);
			result.add(group);
		}
		if (!emptyGroup.isEmpty()) {
			result.add(emptyGroup);
		}
//		if (singleChar.isEmpty()) {
//			result.add(singleChar);
//		}
		return result;
	}

	private boolean validate(String[] strs) {
		int count = 0;
		for (int i = 0; i < strs.length; i++) {
			if (strs[i].length() == 1) {
				count++;
			}

		}

		return strs.length == count;
	}

	private boolean validateEmpty(String[] strs) {
		int count = 0;
		for (int i = 0; i < strs.length; i++) {
			if (strs[i].isEmpty()) {
				count++;
			}

		}

		return strs.length == count;
	}

	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] ds = new int[256];
		char[] sa = s.toCharArray();
		char[] ta = t.toCharArray();
		for (int i = 0; i < sa.length; i++) {
			ds[sa[i]] += 1;
		}
		for (int i = 0; i < ta.length; i++) {
			ds[ta[i]] -= 1;
		}
		for (int val : ds) {
			if (val != 0) {
				return false;
			}
		}
		return true;
	}
}
