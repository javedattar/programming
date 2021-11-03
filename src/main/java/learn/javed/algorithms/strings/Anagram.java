/**
* author: Javed Attar
*/
package learn.javed.algorithms.strings;

public class Anagram {

	public static void main(String[] args) {
		Anagram a = new Anagram();
		System.out.println("Are 'Anagram' & 'Nagaram' anagrams >> " + a.isAnagram("Anagram", "nagAram"));
		System.out.println("Are 'i am lord voldemort' & 'tom marvolo riddle' anagrams >> "
				+ a.isAnagram("i am lordvoldemort", "tom marvolo riddle"));
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
