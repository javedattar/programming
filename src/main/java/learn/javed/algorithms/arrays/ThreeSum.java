/**
* author: Javed Attar
*/
package learn.javed.algorithms.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Problem statement copied from leetcode
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j !=
 * k, and nums[i] + nums[j] + nums[k] == 0.
 * 
 * @author jattar
 *
 */
public class ThreeSum {

	public static void main(String[] args) {
		int[] nums = new int[] { -1, 0, 1, 2, -1, -4, -2 };
		System.out.println("Target 0 >> " + threeSum(nums, 0));
		System.out.println("threeSumWithMemo Target 0 >> " + threeSumWithMemo(nums, 0));
		System.out.println("Target 1 >> " + threeSum(nums, 1));
		System.out.println("threeSumWithMemo Target 1 >> " + threeSumWithMemo(nums, 1));

	}

	private static List<List<Integer>> threeSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);

		for (int i = 0; i < nums.length; i++) {
			int low = i + 1;
			int high = nums.length - 1;
			int delta = target - nums[i];
			// Eliminate duplicate combinations for first element
			if (i == 0 || nums[i] != nums[i - 1]) {
				while (low < high) {

					if (delta < nums[low] + nums[high]) {
						high--;
					} else if (delta > nums[low] + nums[high]) {
						low++;
					} else {

						result.add(Arrays.asList(nums[i], nums[low], nums[high]));

						// Eliminate duplicate combinations from 2nd and 3rd element
						while (low < high && nums[high] == nums[high - 1]) {
							high--;
						}
						while (low < high && nums[low] == nums[low + 1]) {
							low++;
						}
						low++;
						high--;
					}
				}

			}
		}
		return result;
	}

	private static List<List<Integer>> threeSumWithMemo(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();

		for (int i = 0; i < nums.length - 2; i++) {
			Set<Integer> twoSumMemory = new HashSet<>();
			int twoSumTarget = target - nums[i];
			int j = i + 2;

			while (j < nums.length) {
				twoSumMemory.add(nums[j - 1]);
				if (twoSumMemory.contains(twoSumTarget - nums[j])) {
					result.add(Arrays.asList(nums[i], nums[j - 1], nums[j]));
				}
				j++;
			}
		}
		return result;
	}

}
