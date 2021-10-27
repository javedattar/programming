/**
* author: Javed Attar
*/
package learn.javed.algorithms.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

	public static void main(String[] args) {
		int[][] intervals = { { 2, 6 }, { 1, 3 }, { 5, 7 }, { 8, 9 }, { 12, 16 } };
		System.out.println("intervals >> " + Arrays.deepToString(intervals));
		System.out.println(Arrays.deepToString(insert(intervals)));
		intervals = new int[][] { { 1, 3 }, { 2, 6 }, { 5, 7 }, { 8, 9 }, { 12, 16 } };
		System.out.println("intervals >> " + Arrays.deepToString(intervals));
		System.out.println(Arrays.deepToString(insert(intervals)));
		intervals = new int[][] { { 1, 4 }, { 0, 2 }, { 3, 5 } };
		System.out.println("intervals >> " + Arrays.deepToString(intervals));
		System.out.println(Arrays.deepToString(insert(intervals)));
		intervals = new int[][] { { 1, 4 }, { 0, 0 } };
		System.out.println("intervals >> " + Arrays.deepToString(intervals));
		System.out.println(Arrays.deepToString(insert(intervals)));
		intervals = new int[][] { { 2, 3 }, { 2, 2 }, { 3, 3 }, { 1, 3 }, { 5, 7 }, { 2, 2 }, { 4, 6 } };
		System.out.println("intervals >> " + Arrays.deepToString(intervals));
		System.out.println(Arrays.deepToString(insert(intervals)));
		intervals = new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		System.out.println("intervals >> " + Arrays.deepToString(intervals));
		System.out.println(Arrays.deepToString(insert(intervals)));

	}

	public static int[][] insert(int[][] intervals) {
		Arrays.sort(intervals, (x, y) -> x[0] - y[0]);
		List<int[]> result = new ArrayList<>();
		int i = 1;
		int[] temp = new int[] { intervals[i - 1][0], intervals[i - 1][1] };
		while (i < intervals.length) {

			if (temp[1] >= intervals[i][0]) {
				temp[1] = Math.max(intervals[i][1], temp[1]);
				i++;
			} else {
				result.add(temp);
				temp = intervals[i];
				i++;
			}
		}
		result.add(temp);
		return result.toArray(new int[result.size()][]);

	}

}
