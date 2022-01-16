/**
* author: Javed Attar
*/
package learn.javed.algorithms.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 * 
 * Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or
 * vertically neighboring. The same letter cell may not be used more than once in a word.
 * 
 * @author jattar
 *
 */
public class WordSearch2 {

	public static void main(String[] args) {
		WordSearch2 ws = new WordSearch2();
		char[][] board = new char[][] { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
				{ 'i', 'f', 'l', 'v' } };
		String[] words = new String[] { "oath", "pea", "eat", "rain" };

		System.out.println("Expected oath, eat: Actual:> " + ws.findWords(board, words));

	}

	public List<String> findWords(char[][] board, String[] words) {
		List<String> result = new ArrayList<>();

		for (int k = 0; k < words.length; k++) {
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					if ((!result.contains(words[k])) && board[i][j] == words[k].charAt(0)) {
						if (_find(board, i, j, words[k], 0)) {
							result.add(words[k]);
						}
					}
				}
			}
		}
		return result;

	}

	private boolean _find(char[][] board, int row, int col, String word, int charIndex) {
		if (charIndex == word.length()) {
			return true;
		}
		if (row < 0 || col < 0 || row >= board.length || col >= board[0].length
				|| word.charAt(charIndex) != board[row][col]) {
			return false;
		}
		char temp = board[row][col];
		board[row][col] = ' ';
		boolean result = _find(board, row, col + 1, word, charIndex + 1)
				|| _find(board, row, col - 1, word, charIndex + 1) || _find(board, row + 1, col, word, charIndex + 1)
				|| _find(board, row - 1, col, word, charIndex + 1);
		board[row][col] = temp;
		return result;
	}
}
