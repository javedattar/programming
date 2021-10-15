package learn.javed.algorithms.strings;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

	public static void main(String[] args) {
		System.out.println(remove("JavedAAttar"));
	}

	private static String remove(String s1) {
		Set<Character> chars = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i< s1.length(); i++) {
			if(chars.add(s1.charAt(i))) {
				sb.append(s1.charAt(i));
			}
		}
 		return sb.toString();
	}

}
