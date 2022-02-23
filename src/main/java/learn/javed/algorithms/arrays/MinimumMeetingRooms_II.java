/**
* author: Javed Attar
*/
package learn.javed.algorithms.arrays;

import java.util.Arrays;

/**
 * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi],
 * return the minimum number of conference rooms required.
 * <p>
 * Input: intervals = [[0,30],[5,10],[15,20]]
 * Output: 2
 * Input: intervals = [[7,10],[2,4]]
 * Output: 1
 */

public class MinimumMeetingRooms_II {

	public static void main(String[] args) {
		int[][] intervals = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
		System.out.println(minMeetingRooms(intervals));
		intervals = new int[][] { { 7, 10 }, { 2, 4 } };
		System.out.println(minMeetingRooms(intervals));
		intervals = new int[][] { { 1, 10 }, { 2, 7 }, { 3, 19 }, { 8, 12 }, { 10, 20 }, { 11, 30 } };
		System.out.println(minMeetingRooms(intervals));
	}

	public static int minMeetingRooms(int[][] intervals) {

		int[] starts = new int[intervals.length];
		int[] ends = new int[intervals.length];
		for (int i = 0; i < intervals.length; i++) {
			starts[i] = intervals[i][0];
			ends[i] = intervals[i][1];
		}

		Arrays.sort(starts);
		Arrays.sort(ends);
		int rooms = 0;
		int endIndex = 0;
		for (int i = 0; i < starts.length; i++) {
			// when starts of the meeting is after end then there is NO conflict, so we can reuse the room
			if (starts[i] >= ends[endIndex]) {
				endIndex++;
			} else {
				rooms++;
			}
		}
		return rooms;
	}

}
