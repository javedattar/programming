/**
* author: Javed Attar
*/
package learn.javed.algorithms.arrays;

public class MinRotatedSortedArray {

	public static void main(String[] args) {
		MinRotatedSortedArray ma = new MinRotatedSortedArray();
		System.out.println(ma.findMin(new int[] { 4, 5, 6, 7, 0, 1, 2 }));
		System.out.println(ma.findMin2(new int[] { 11, 13, 15, 17 }));
	}

	public int findMin(int[] nums) {
		int min = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < min) {

				min = nums[i];
				break;
			}
		}
		return min;
	}

	// Like binary search
	public int findMin2(int[] nums) {
		int midIndex = nums.length / 2;
		int leftLoop = midIndex;
		while (leftLoop > 0) {
			if (nums[leftLoop--] < nums[leftLoop])
				break;
		}
		if (leftLoop != 0) {
			return nums[leftLoop];
		}
		while (midIndex < nums.length - 1) {
			if (nums[midIndex++] > nums[midIndex])
				break;
		}
		if (midIndex != nums.length - 1) {
			return nums[midIndex];
		}
		return nums[0];
	}
}
