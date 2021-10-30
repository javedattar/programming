/**
* author: Javed Attar
*/
package learn.javed.algorithms.arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given an m x n grid where each cell can have one of three values:
 * 
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 * 
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return
 * -1.
 * 
 * 
 * @author jattar
 *
 */
public class RottingOranges {

	public static void main(String[] args) {
		int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		RottingOranges rottingOranges = new RottingOranges();
		System.out.println("Rotting Oranges grid >> " + Arrays.deepToString(grid) + " rots in ==> "
				+ rottingOranges.orangesRotting(grid));
		grid = new int[][] { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } };
		System.out.println("Rotting Oranges grid >> " + Arrays.deepToString(grid) + " rots in ==> "
				+ rottingOranges.orangesRotting(grid));
		grid = new int[][] { { 0, 2 }, { 0, 0 }, { 0, 1 } };
		System.out.println("Rotting Oranges grid >> " + Arrays.deepToString(grid) + " rots in ==> "
				+ rottingOranges.orangesRotting(grid));
		grid = new int[][] { { 2, 1, 1 }, { 1, 1, 1 }, { 0, 1, 2 } };
		System.out.println("Rotting Oranges grid >> " + Arrays.deepToString(grid) + " rots in ==> "
				+ rottingOranges.orangesRotting(grid));

	}

	public int orangesRotting(int[][] grid) {
		/**
		 * An orange will be rotten only when adjacent one rotten. In other words oranges on 4 side of rotten orange
		 * will rotten in first minute,
		 * Second minute all fresh oranges adjacent previous 4 will rotten hence this falls under level by level check
		 */
		int minutes = 0;
		int freshCount = 0;
		Queue<Node> rottingQueue = new LinkedList<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				switch (grid[i][j]) {
				case 1:
					freshCount++;
					break;
				case 2:
					rottingQueue.add(new Node(i, j));
					break;
				}
				if (grid[i][j] == 1) {

				}
			}
		}
		if (freshCount == 0)
			return 0;

		int x = grid.length, y = grid[0].length, rottenOrangesSize = rottingQueue.size();
		while (!rottingQueue.isEmpty() && rottenOrangesSize > 0) {
			Node ro = rottingQueue.poll();
			// find adjacent for x, y => [x,y-1], [x,y+1], [x-1, y], [x+1, y]
			// see if any of them are fresh oranges, reset them to rotten and add to queue

			// Left node
			if (ro.getY() - 1 >= 0 && grid[ro.getX()][ro.getY() - 1] == 1) {
				rottingQueue.add(new Node(ro.getX(), ro.getY() - 1));
				grid[ro.getX()][ro.getY() - 1] = 2;
				freshCount--;
			}
			// Right node
			if (ro.getY() + 1 < y && grid[ro.getX()][ro.getY() + 1] == 1) {
				rottingQueue.add(new Node(ro.getX(), ro.getY() + 1));
				grid[ro.getX()][ro.getY() + 1] = 2;
				freshCount--;
			}
			// Top Node
			if (ro.getX() - 1 >= 0 && grid[ro.getX() - 1][ro.getY()] == 1) {
				rottingQueue.add(new Node(ro.getX() - 1, ro.getY()));
				grid[ro.getX() - 1][ro.getY()] = 2;
				freshCount--;
			}
			// Bottom Node
			if (ro.getX() + 1 < x && grid[ro.getX() + 1][ro.getY()] == 1) {
				rottingQueue.add(new Node(ro.getX() + 1, ro.getY()));
				grid[ro.getX() + 1][ro.getY()] = 2;
				freshCount--;
			}
			rottenOrangesSize--;

			if (!rottingQueue.isEmpty() && rottenOrangesSize == 0) {
				rottenOrangesSize = rottingQueue.size();
				minutes++;
			}

		}

		return freshCount != 0 ? -1 : minutes;

	}

	public class Node {
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		private int x;
		private int y;

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

	}

}
