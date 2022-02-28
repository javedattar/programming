
package learn.javed.algorithms.graphs;

import java.util.HashSet;

public class NumberOfIslands {

	public static void main(String[] args) {
		char[][] grid = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '0', '0', '0' } };
		System.out.println(numIslands(grid));
		System.out.println(numIslands2(grid));
		grid = new char[][] { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '1', '1' } };
		System.out.println(numIslands(grid));
		System.out.println(numIslands2(grid));
		grid = new char[][] {
				{ '1', '0', '0', '1', '1', '1', '0', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0' },
				{ '1', '0', '0', '1', '1', '0', '0', '1', '0', '0', '0', '1', '0', '1', '0', '1', '0', '0', '1', '0' },
				{ '0', '0', '0', '1', '1', '1', '1', '0', '1', '0', '1', '1', '0', '0', '0', '0', '1', '0', '1', '0' },
				{ '0', '0', '0', '1', '1', '0', '0', '1', '0', '0', '0', '1', '1', '1', '0', '0', '1', '0', '0', '1' },
				{ '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0' },
				{ '1', '0', '0', '0', '0', '1', '0', '1', '0', '1', '1', '0', '0', '0', '0', '0', '0', '1', '0', '1' },
				{ '0', '0', '0', '1', '0', '0', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1' },
				{ '0', '0', '0', '1', '0', '1', '0', '0', '1', '1', '0', '1', '0', '1', '1', '0', '1', '1', '1', '0' },
				{ '0', '0', '0', '0', '1', '0', '0', '1', '1', '0', '0', '0', '0', '1', '0', '0', '0', '1', '0', '1' },
				{ '0', '0', '1', '0', '0', '1', '0', '0', '0', '0', '0', '1', '0', '0', '1', '0', '0', '0', '1', '0' },
				{ '1', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '1', '0', '1', '0', '1', '0' },
				{ '0', '1', '0', '0', '0', '1', '0', '1', '0', '1', '1', '0', '1', '1', '1', '0', '1', '1', '0', '0' },
				{ '1', '1', '0', '1', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '1' },
				{ '0', '1', '0', '0', '1', '1', '1', '0', '0', '0', '1', '1', '1', '1', '1', '0', '1', '0', '0', '0' },
				{ '0', '0', '1', '1', '1', '0', '0', '0', '1', '1', '0', '0', '0', '1', '0', '1', '0', '0', '0', '0' },
				{ '1', '0', '0', '1', '0', '1', '0', '0', '0', '0', '1', '0', '0', '0', '1', '0', '1', '0', '1', '1' },
				{ '1', '0', '1', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '1', '0', '1', '0', '0', '0', '0' },
				{ '0', '1', '1', '0', '0', '0', '1', '1', '1', '0', '1', '0', '1', '0', '1', '1', '1', '1', '0', '0' },
				{ '0', '1', '0', '0', '0', '0', '1', '1', '0', '0', '1', '0', '1', '0', '0', '1', '0', '0', '1', '1' },
				{ '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '0', '1', '0', '0', '0', '1', '1', '0', '0',
						'0' } };
		System.out.println(numIslands(grid));
		System.out.println(numIslands2(grid));
	}

	static HashSet<Integer> visited = new HashSet<>();

	public static int numIslands(char[][] grid) {
		visited.clear();
		int islandCount = 0;
		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid[0].length; j++)
				if (grid[i][j] == '1' && !visited.contains(i * (grid[i].length) + (j + 1))) {
					islandCount += countIslands(grid, i, j);
				}

		return islandCount;
	}

	private static int countIslands(char[][] grid, int x, int y) {

		visited.add(x * (grid[0].length) + (y + 1));

		int[] neighbors = { x, y + 1, x + 1, y, x, y - 1, x - 1, y };
		for (int i = 0; i < neighbors.length; i += 2) {
			if (neighbors[i] >= 0 && neighbors[i] < grid.length && neighbors[i + 1] >= 0
					&& neighbors[i + 1] < grid[0].length) {

				int nodePosition = neighbors[i] * (grid[0].length) + (neighbors[i + 1] + 1);
				// if not visited and value is 1
				if (grid[neighbors[i]][neighbors[i + 1]] == '1' && !visited.contains(nodePosition))
					countIslands(grid, neighbors[i], neighbors[i + 1]);
			}
		}
		return 1;

	}

	public static int numIslands2(char[][] grid) {
		int islandCount = 0;
		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid[0].length; j++)
				if (grid[i][j] == '1') {
					islandCount += 1;
					countIslands2(grid, i, j);
				}

		return islandCount;
	}

	private static void countIslands2(char[][] grid, int x, int y) {
		if (x < 0 || x == grid.length || y < 0 || y == grid[0].length || grid[x][y] == '0')
			return;
		grid[x][y] = '0';
		countIslands2(grid, x, y + 1);
		countIslands2(grid, x + 1, y);
		countIslands2(grid, x, y - 1);
		countIslands2(grid, x - 1, y);

	}

}
