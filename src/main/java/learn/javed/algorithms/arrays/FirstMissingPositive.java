package learn.javed.algorithms.arrays;

import java.util.Arrays;

public class FirstMissingPositive {

	/**
	 * Given an unsorted integer array nums, find the smallest missing positive integer.
	 * You must implement an algorithm that runs in O(n) time and uses constant extra space.
	 * <p>
	 * Input: nums = [1,2,0], Output: 3
	 * Input: nums = [3,4,-1,1], Output: 2
	 */
	public static void main(String[] args) {
		int[] nums = { 7, 8, 9, 10, 11, 12, 1 };
		System.out.println(new FirstMissingPositive().find(nums));
		nums = new int[] { 1, 2, 0 - 1000, 1000 };
		System.out.println(new FirstMissingPositive().find(nums));
		nums = new int[] { -1200, 1, 2, 3, 4, 6, 10 };
		System.out.println(new FirstMissingPositive().find(nums));
	}

	/**
	 * Time: O[n]
	 * Space: O[1]
	 */
	public int find(int[] nums) {
		if (nums.length == 1 && nums[0] > 1)
			return 1;

		int n = nums.length;

		// check if one exists, if not, we can return immediately
		boolean one = false;
		for (int num : nums) {
			if (num == 1) {
				one = true;
				break;
			}
		}
		if (!one)
			return 1;

		// if length is 4 then expected range is 1,2,3,4
		// convert number to 1 if its not in this range
		for (int i = 0; i < n; i++) {
			if (nums[i] <= 0 || nums[i] > n)
				nums[i] = 1;
		}
		System.out.println("Setting 1" + Arrays.toString(nums));
		// for the number go to its index position and convert to negative
		for (int i = 0; i < n; i++) {
			int x = Math.abs(nums[i]);

			if (nums[x - 1] > 0)
				nums[x - 1] *= -1;
		}
		System.out.println("multiplied by -	1" + Arrays.toString(nums));

		// first positive number is the missing number
		for (int i = 0; i < n; i++)
			if (nums[i] > 0)
				return i + 1;

		return n + 1;
	}
}
