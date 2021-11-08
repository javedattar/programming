/**
* author: Javed Attar
*/
package learn.javed.algorithms.arrays;

import java.util.HashMap;
import java.util.Map;

public class ContainsNearbyDuplicate {

	public static void main(String[] args) {
		ContainsNearbyDuplicate cd = new ContainsNearbyDuplicate();

		System.out.println(cd.containsNearbyDuplicate(new int[] { 99, 99 }, 2));
		System.out.println(cd.containsNearbyDuplicate(new int[] { 1, 0, 1, 1 }, 1));
		System.out.println(cd.containsNearbyDuplicate(new int[] { 1, 2, 3, 1 }, 3));
		System.out.println(cd.containsNearbyDuplicate(new int[] { 1, 2, 3, 1, 2, 3 }, 2));
		System.out.println();
		System.out.println(cd.containsNearbyDuplicateWithMemorization(new int[] { 99, 99 }, 2));
		System.out.println(cd.containsNearbyDuplicateWithMemorization(new int[] { 1, 0, 1, 1 }, 1));
		System.out.println(cd.containsNearbyDuplicateWithMemorization(new int[] { 1, 2, 3, 1 }, 3));
		System.out.println(cd.containsNearbyDuplicateWithMemorization(new int[] { 1, 2, 3, 1, 2, 3 }, 2));

	}

	// O(n)
	// O(n)
	// Leetcode: 18ms
	public boolean containsNearbyDuplicateWithMemorization(int[] nums, int k) {

		Map<Integer, Integer> duplicates = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (!duplicates.containsKey(nums[i])) {
				duplicates.put(nums[i], i);
			} else {
				if (Math.abs(i - duplicates.get(nums[i])) <= k) {
					return true;
				} else {
					duplicates.put(nums[i], i);
				}
			}
		}
		return false;
	}

	// O(n*k)
	// Constant space
	// Leetcode: 1285ms
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			j = i + 1;
			while (j < nums.length && j <= k + i) {
				if (nums[i] == nums[j]) {
					return true;
				}
				j++;
			}
		}
		return false;
	}

}
