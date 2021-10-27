/**
* author: Javed Attar
*/
package learn.javed.algorithms.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertIntervals {

	public static void main(String[] args) {
		int[][] intervals = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 9 }, { 12, 16 } };
		System.out.println("Existing intervals >> " + Arrays.deepToString(intervals));
		int[] newInterval = { 4, 8 };
		System.out.println("input interval >> " + Arrays.toString(newInterval));
		System.out.println(Arrays.deepToString(insert(intervals, newInterval)));
		newInterval = new int[] { 17, 18 };
		System.out.println("input interval >> " + Arrays.toString(newInterval));
		System.out.println(Arrays.deepToString(insert(intervals, newInterval)));
		newInterval = new int[] { 10, 11 };
		System.out.println("input interval >> " + Arrays.toString(newInterval));
		System.out.println(Arrays.deepToString(insert(intervals, newInterval)));

	}

	public static int[][] insert(int[][] intervals, int[] newInterval) {
		List<int[]> result = new ArrayList<>();
		int i = 0;
		while (i < intervals.length && intervals[i][1] < newInterval[0]) {
			result.add(intervals[i]);
			i++;
		}
		while (i < intervals.length) {

			if (newInterval[1] >= intervals[i][0]) {
				newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
				i++;
			} else {
				result.add(newInterval);
				newInterval = intervals[i];
				i++;
			}
		}

		result.add(newInterval);
		return result.toArray(new int[result.size()][]);

	}
}
