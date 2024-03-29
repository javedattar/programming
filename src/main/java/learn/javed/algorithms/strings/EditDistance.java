/**
* author: Javed Attar
*/
package learn.javed.algorithms.strings;

public class EditDistance {

	public static void main(String[] args) {
		System.out.println(new EditDistance().minDistance("horse", "ros"));
		System.out.println(new EditDistance().minDistance("horse", "mouthless"));
	}

	public int minDistance(String word1, String word2) {
		if ((word1 == null && word2 == null) || (word1.length() == 0 && word2.length() == 0))
			return 0;

		int[][] dp = new int[word1.length() + 1][word2.length() + 1];

		// as string 2 char is empty at first extra added column.. we need to delete chars from first column...
		// 1,2,3,4, ....
		for (int i = 0; i < dp.length; i++)
			dp[i][0] = i;

		// as string 1 char is empty at first extra added row.. we need to add chars at first row...
		// 1,2,3,4, ....
		for (int j = 0; j < dp[0].length; j++)
			dp[0][j] = j;

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1];
				else
					dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
			}
		}

		return dp[word1.length()][word2.length()];
	}

}
