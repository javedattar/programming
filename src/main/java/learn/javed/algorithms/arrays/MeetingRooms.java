/**
* author: Javed Attar
*/
package learn.javed.algorithms.arrays;

import java.util.Arrays;

/**
 * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi],
 * return true if all meetings can be attended otherwise return false;
 * <p>
 * Input: intervals = [[0,30],[5,10],[15,20]]
 * Output: false
 * Input: intervals = [[7,10],[2,4]]
 * Output: true
 */

public class MeetingRooms {

	public static void main(String[] args) {
		int[][] intervals = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
		System.out.println(minMeetingRooms(intervals));
		intervals = new int[][] { { 7, 10 }, { 2, 4 } };
		System.out.println(minMeetingRooms(intervals));

	}

	public static boolean minMeetingRooms(int[][] intervals) {

		int[] starts = new int[intervals.length];
		int[] ends = new int[intervals.length];
		for (int i = 0; i < intervals.length; i++) {
			starts[i] = intervals[i][0];
			ends[i] = intervals[i][1];
		}

		Arrays.sort(starts);
		Arrays.sort(ends);

		for (int i = 0; i < starts.length - 1; i++) {
			// Find out if there is conflict. If the next meeting starts before first meeting end then there is conflict
			if (starts[i + 1] < ends[i]) {
				return false;
			}
		}
		return true;
	}

}
