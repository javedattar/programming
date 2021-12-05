/**
* author: Javed Attar
*/
package learn.javed.algorithms.arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

	public static void main(String[] args) {
		FloodFill f = new FloodFill();
		System.out.println(Arrays.deepToString(f.floodFill(new int[][] { { 0, 0, 0 }, { 0, 1, 1 } }, 1, 1, 2)));
		System.out.println(Arrays.deepToString(f.floodFill(new int[][] { { 0, 0, 0 }, { 0, 1, 1 } }, 1, 1, 1)));
		System.out.println(Arrays.deepToString(f.floodFill(new int[][] { { 0, 0, 0 }, { 0, 0, 0 } }, 1, 1, 3)));

	}

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int oldColor = image[sr][sc];
		if (oldColor == newColor) {
			return image;
		}
		Queue<Integer> queue = new LinkedList<>();
		image[sr][sc] = newColor;
		queue.add(sr * (image[sr].length) + (sc));
		while (!queue.isEmpty()) {
			int cell = queue.poll();

			int y = (cell % image[0].length);
			int x = (cell - y) / image[0].length;
			y = y < 0 ? 0 : y;

//			System.out.println(cell + "  " + x + "  " + y);
			// Left
			if (y - 1 >= 0 && image[x][y - 1] == oldColor) {
				image[x][y - 1] = newColor;
				queue.add(cell - 1);
			}
			// Right
			if (y + 1 < image[0].length && image[x][y + 1] == oldColor) {
				image[x][y + 1] = newColor;
				queue.add(cell + 1);
			}
			// Top
			if (x - 1 >= 0 && image[x - 1][y] == oldColor) {
				image[x - 1][y] = newColor;
				queue.add(cell - image[0].length);
			}
			if (x + 1 < image.length && image[x + 1][y] == oldColor) {
				image[x + 1][y] = newColor;
				queue.add(cell + image[0].length);
			}

		}
		return image;
	}

}
