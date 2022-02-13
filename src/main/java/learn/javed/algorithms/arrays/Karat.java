/**
* author: Javed Attar
*/
package learn.javed.algorithms.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Karat {

	/*
	 * While your players are waiting for a game, you've developed a solitaire game for the players to pass the time
	 * with.
	 * The player is given an NxM board of tiles from 0 to 9 like this:
	 * 4 4 4 4
	 * 5 5 5 4
	 * 2 5 7 5
	 * The player selects one of these tiles, and that tile will disappear, along with any tiles with the same number
	 * that are connected with that tile (up, down, left, or right), and any tiles with the same number connected with
	 * those, and so on. For example, if the 4 in the upper left corner is selected, these five tiles disappear
	 * >4< >4< >4< >4<
	 * 5 5 5 >4<
	 * 2 5 7 5
	 * If the 5 just below it is selected, these four tiles disappear. Note that tiles are not connected diagonally.
	 * 4 4 4 4
	 * >5< >5< >5< 4
	 * 2 >5< 7 5
	 * Write a function that, given a grid of tiles and a selected row and column of a tile, returns how many tiles will
	 * disappear.
	 * grid1 = [[4, 4, 4, 4],
	 * [5, 5, 5, 4],
	 * [2, 5, 7, 5]]
	 * disappear(grid1, 0, 0) => 5
	 * disappear(grid1, 1, 1) => 4
	 * disappear(grid1, 1, 0) => 4
	 * This is the grid from above.
	 * 
	 * Additional Inputs
	 * grid2 = [[0, 3, 3, 3, 3, 3, 3],
	 * [0, 1, 1, 1, 1, 1, 3],
	 * [0, 2, 2, 0, 2, 1, 4],
	 * [0, 1, 2, 2, 2, 1, 3],
	 * [0, 1, 1, 1, 1, 1, 3],
	 * [0, 0, 0, 0, 0, 0, 0]]
	 * 
	 * grid3 = [[0]]
	 * 
	 * grid4 = [[1, 1, 1],
	 * [1, 1, 1],
	 * [1, 1, 1]]
	 * 
	 * All Test Cases
	 * disappear(grid1, 0, 0) => 5
	 * disappear(grid1, 1, 1) => 4
	 * disappear(grid1, 1, 0) => 4
	 * disappear(grid2, 0, 0) => 12
	 * disappear(grid2, 3, 0) => 12
	 * disappear(grid2, 1, 1) => 13
	 * disappear(grid2, 2, 2) => 6
	 * disappear(grid2, 0, 3) => 7
	 * disappear(grid3, 0, 0) => 1
	 * disappear(grid4, 0, 0) => 9
	 * 
	 * N - Width of the grid
	 * M - Height of the grid
	 * 
	 * 
	 */

	public static void main(String[] argv) {
//     String tiles1 = "11133555";
		// triples or pair
		// complete hand => must contain 1 pair and zero or more triplets => true
		// char or 2 pairs => false
//     String tiles2 = "111333555";
//     String tiles3 = "00000111";
//     String tiles4 = "13233121";
//     String tiles5 = "11223344555";
//     String tiles6 = "99999999";
//     String tiles7 = "999999999";
//     String tiles8 = "9";
//     String tiles9 = "99";
//     String tiles10 = "000022";
//     String tiles11 = "888889";
//     String tiles12 = "889";
//     String tiles13 = "88888844";
//     String tiles14 = "77777777777777";
//     String tiles15 = "1111111";
//     String tiles16 = "1111122222";

//     System.out.println(tiles1 + " >> "+ complete(tiles1));
//     System.out.println(tiles2 + " >> "+ complete(tiles2));
//     System.out.println(tiles3 + " >> "+ complete(tiles3));
//     System.out.println(tiles4 + " >> "+ complete(tiles4));
//     System.out.println(tiles5 + " >> "+ complete(tiles5));
//     System.out.println(tiles6 + " >> "+ complete(tiles6));
//     System.out.println(tiles7 + " >> "+ complete(tiles7));
//     System.out.println(tiles8 + " >> "+ complete(tiles8));
//     System.out.println(tiles9 + " >> "+ complete(tiles9));
//     System.out.println(tiles10 + " >> "+ complete(tiles10));
//     System.out.println(tiles11 + " >> "+ complete(tiles11));
//     System.out.println(tiles12 + " >> "+ complete(tiles12));
//     System.out.println(tiles13 + " >> "+ complete(tiles13));
//     System.out.println(tiles14 + " >> "+ complete(tiles14));
//     System.out.println(tiles15 + " >> "+ complete(tiles15));
//     System.out.println(tiles16 + " >> "+ complete(tiles16));
		int[][] grid1 = { { 4, 4, 4, 4 }, { 5, 5, 5, 4 }, { 2, 5, 7, 5 } };
		int[][] grid2 = { { 0, 3, 3, 3, 3, 3, 3 }, { 0, 1, 1, 1, 1, 1, 3 }, { 0, 2, 2, 0, 2, 1, 4 },
				{ 0, 1, 2, 2, 2, 1, 3 }, { 0, 1, 1, 1, 1, 1, 3 }, { 0, 0, 0, 0, 0, 0, 0 } };
		int[][] grid3 = { { 0 } };
		int[][] grid4 = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };

		System.out.println("grid 1 >> " + disappear(grid1, 0, 0));
		System.out.println("" + disappear(grid1, 1, 1));
		System.out.println("" + disappear(grid1, 1, 0));
		System.out.println("" + disappear(grid2, 0, 0));
		System.out.println("" + disappear(grid2, 3, 0));
		System.out.println("" + disappear(grid2, 1, 1));
		System.out.println("" + disappear(grid2, 2, 2));
		System.out.println("" + disappear(grid2, 0, 3));
		System.out.println("" + disappear(grid3, 0, 0));
		System.out.println("grid 4 >> " + disappear(grid4, 0, 0));

	}

	public static boolean complete(String tile) {
		Map<Character, Integer> ds = new HashMap<>();
		for (int i = 0; i < tile.length(); i++) {
			ds.put(tile.charAt(i), ds.getOrDefault(tile.charAt(i), 0) + 1);
		}
		int numOfPairs = 0;
		for (Character c : ds.keySet()) {
			Integer numOcc = ds.get(c);
			if (numOcc > 3) {
				numOcc = numOcc % 3;
			}
			if (numOcc == 3) {
				continue;
			}
			if (numOcc == 2) {
				numOfPairs++;

				continue;
			} else if (numOcc == 1) {
				return false;
			}
		}
		return numOfPairs == 1;
	}

	private static int count = 0;
	private static Set<String> visited = new HashSet<>();

	public static int disappear(int[][] grid, int x, int y) {
		int tileValue = grid[x][y];
		count = 0;
		visited.clear();
		dfs(grid, x, y, tileValue);
		return count;
	}

	private static void dfs(int[][] grid, int x, int y, int tileValue) {
		if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || visited.contains(x + "" + y)
				|| grid[x][y] != tileValue) {
			return;
		}
//	     System.out.println
//	     System.out.println("grid >> " + Arrays.deepToString(grid));
//	     int temp = grid[x][y];
//	     grid[x][y] = -1;
		visited.add(x + "" + y);
		count++;
		dfs(grid, x, y + 1, tileValue);
		dfs(grid, x + 1, y, tileValue);
		dfs(grid, x, y - 1, tileValue);
		dfs(grid, x - 1, y, tileValue);
//	     grid[x][y] = temp;

	}
}
