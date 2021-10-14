/**
* author: Javed Attar
*/
package learn.javed.algorithms.strings;

import java.util.Arrays;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		System.out.println("Longest common subsequence for abc, def is none, length 0 and actual length is => "
				+ commonSubSequence("abc", "def"));
		System.out.println("Longest common subsequence for abcde, ace is ace, length 3 and actual length is => "
				+ commonSubSequence("abcde", "ace"));
		System.out.println("Longest common subsequence for abcde, wwwwawwcwew is ace, length 3 and actual length is => "
				+ commonSubSequence("wwwwawwcwew", "abcde"));

	}

	/**
	 * Given two strings text1 and text2, return the length of their longest common
	 * subsequence. If there is no common subsequence, return 0.
	 * 
	 * A subsequence of a string is a new string generated from the original string
	 * with some characters (can be none) deleted without changing the relative
	 * order of the remaining characters.
	 * 
	 * For example, "ace" is a subsequence of "abcde".
	 * A common subsequence of two strings is a subsequence that is common to both
	 * strings.
	 * 
	 * @constraints:
	 *               Length of strings is less than 1000
	 *               List contains only lower case English letters
	 * @return
	 */
	private static int commonSubSequence(String s1, String s2) {

		if (s1 == null || s1.isEmpty() || s2 == null || s2.isEmpty()) {
			return 0;
		}
		int m = s1.length();
		int n = s2.length();
		int[][] matrix = new int[m + 1][n + 1];
//        for(int i=0;i<m+1;i++){
//            for(int j=0;j<n+1;j++){
//                if(i==0||j==0)
//                    matrix[i][j]=0;
//            }
//        }
		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					matrix[i][j] = 1 + matrix[i - 1][j - 1];
				} else {
					matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);

				}
			}
			System.out.println(Arrays.deepToString(matrix));
		}
		return matrix[m][n];
	}

}
