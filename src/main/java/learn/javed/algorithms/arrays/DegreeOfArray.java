/**
* author: Javed Attar
*/
package learn.javed.algorithms.arrays;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DegreeOfArray {
	public static void main(String[] args) {
		DegreeOfArray da = new DegreeOfArray();
		System.out.println(da.findShortestSubArray(new int[] { 1, 2, 2, 3, 1 }));
		System.out.println(da.findShortestSubArray(new int[] { 1, 2, 2, 1, 2, 1, 1, 1, 1, 2, 2, 2 }));
	}

	public int findShortestSubArray(int[] nums) {
		int maxFreq = 0, i = 0, j = nums.length - 1, minLen = nums.length;
		Map<Integer, Integer> ds = new HashMap<>();
		for (int num : nums) {
			ds.put(num, ds.getOrDefault(num, 0) + 1);
//			maxFreq = Math.max(maxFreq, ds.get(num));
		}
		maxFreq = Collections.max(ds.values());
		for (Integer key : ds.keySet()) {
			if (ds.get(key) == maxFreq) {
				i = 0;
				j = nums.length - 1;
				while (i <= j && nums[i] != key) {
					i++;
				}
				while (j >= 0 && nums[j] != nums[i]) {
					j--;
				}
				minLen = Math.min(minLen, j - i + 1);
			}
		}

		return minLen;

	}

}
