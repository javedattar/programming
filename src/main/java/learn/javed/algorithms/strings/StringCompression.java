package learn.javed.algorithms.strings;

import java.util.Arrays;

public class StringCompression {

	public static void main(String[] args) {
		char[] chars = { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
		System.out.println("Length =" + compress(chars) + " resulting array" + Arrays.toString(chars));
		char[] chars3 = { 'a', 'a', 'a', 'b', 'b', 'a', 'a' };
		System.out.println("Length =" + compressWithConstantSpace(chars3) + " resulting array" + Arrays.toString(chars3));
		char[] chars2 = { 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b','c','d' };
		System.out.println("Length =" + compressWithConstantSpace(chars2) + " resulting array" + Arrays.toString(chars2));
		char[] chars4 = new char[4];
		System.out.println(" resulting array" + Arrays.toString(chars4));

	}

	/**
	 * Input: chars = ['a','a','b','b','c','c','c'] Output: Return 6, and the first
	 * 6 characters of the input array should be: ['a',"2",'b',"2",'c',"3"]
	 * Explanation: The groups are "aa", "bb", and "ccc". This compresses to
	 * "a2b2c3".
	 * <p>
	 * Input: chars = ['a','b','b','b','b','b','b','b','b','b','b','b','b'] Output:
	 * Return 4, and the first 4 characters of the input array should be:
	 * ['a','b',"1","2"]. Explanation: The groups are 'a' and "bbbbbbbbbbbb". This
	 * compresses to "ab12".
	 * 
	 * Input: chars = ['a','a','a','b','b','a','a'] Output: Return 6, and the first
	 * 6 characters of the input array should be: ['a',"3",'b',"2",'a',"2"].
	 * Explanation: The groups are "aaa", "bb", and "aa". This compresses to
	 * "a3b2a2". Note that each group is independent even if two groups have the
	 * same character.
	 */

	private static int compress(char[] chars) {
		StringBuilder result = new StringBuilder();
		if (chars.length == 0) {
			return chars.length;
		}
		char curr = chars[0];
		int groupCounter = 1;
		for (int i = 1; i < chars.length; i++) {
			if (curr == chars[i]) {
				groupCounter++;

			} else {
				result.append(curr);
				if (groupCounter > 1)
					result.append(groupCounter);

				curr = chars[i];
				groupCounter = 1;
			}
		}
		// for last char
		result.append(curr);
		if (groupCounter > 1)
			result.append(groupCounter);
		
		for (int i = 0; i < result.length(); i++) {
			chars[i] = result.charAt(i);
		}
		for (int i = result.length(); i < chars.length; i++) {
			chars[i] = ' ';
		}
		System.out.println(result);
		return result.length();
	}
	
	private static int compressWithConstantSpace(char[] chars) {
		if (chars.length == 0) {
			return chars.length;
		}
		int groupCounter = 1, index = 1;
		for (int i = 0; i < chars.length-1; i++) {
			if(chars[i] == chars[i+1]) {
				groupCounter++;
			}
			else {
				if(groupCounter > 1 && groupCounter < 10) {
				chars[index++] = (char)(groupCounter + '0');
				
			} else if (groupCounter > 10) {
				// find out number 10s, 100s or 1000s
				int places = 1;
				int count = groupCounter;
				while(count >= 10) {
					places *= 10;
					count  = count / 10;
				}
				while(places != 0) {
					int digit = groupCounter / places;
					chars[index++] = (char)(digit + '0');
					places = places / 10;
					groupCounter = groupCounter % 10;
				}
			}
				groupCounter = 1;
				chars[index++] = chars[i+1];
			}
				
				
			
		}
		if(groupCounter > 1 && groupCounter < 10) {
			chars[index++] = (char)(groupCounter + '0');
			
		} else if (groupCounter > 10) {
			// find out number 10s, 100s or 1000s
			int places = 1;
			int count = groupCounter;
			while(count >= 10) {
				places *= 10;
				count  = count / 10;
			}
			while(places != 0) {
				int digit = groupCounter / places;
				chars[index++] = (char)(digit + '0');
				places = places / 10;
				groupCounter = groupCounter % 10;
			}
		}
		return index;
	}
}
