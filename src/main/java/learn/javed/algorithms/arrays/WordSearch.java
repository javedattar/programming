/**
* author: Javed Attar
*/
package learn.javed.algorithms.arrays;

public class WordSearch {

	public static void main(String[] args) {
		WordSearch ws = new WordSearch();
		char[][] board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		String word = "ABCCED";

		System.out.println("Expected TRUE: Actual:> " + ws.exist(board, word));
		board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		word = "ABCB";
		System.out.println("Expected FALSE: Actual:> " + ws.exist(board, word));
		board = new char[][] { { 'a' } };
		word = "b";
		System.out.println("Expected FALSE: Actual:> " + ws.exist(board, word));

	}

	public boolean exist(char[][] board, String word) {
		if (word == null || word.length() == 0)
			return true;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == word.charAt(0))
					if (dfs(board, word, i, j, 0))
						return true;
			}
		}

		return false;
	}

	public boolean dfs(char[][] board, String word, int i, int j, int count) {
		if (count == word.length())
			return true;

		if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != word.charAt(count))
			return false;

		char temp = board[i][j];
		board[i][j] = ' '; // remove char for backtracking

		boolean found = dfs(board, word, i, j - 1, count + 1) || dfs(board, word, i, j + 1, count + 1)
				|| dfs(board, word, i - 1, j, count + 1) || dfs(board, word, i + 1, j, count + 1);

		board[i][j] = temp;

		return found;
	}
}
