package learn.javed.algorithms.arrays;

public class SearchInRotatedArray {
	private static int counter = 0;

	public static void main(String[] args) {

		System.out.println(search(new int[] { 3, 4, 5, 6, 1, 2 }, 2));
		System.out.println(search(new int[] { 4, 5, 6, 7, 8, 0, 1, 2 }, 8));
		System.out.println("Number of recurssive calls >> " + counter);
		System.out.println(search(new int[] { 2, 1 }, 1));
		System.out.println(search(new int[] { 5, 1, 3 }, 5));

	}

	public static int search(int[] nums, int target) {
		return _search(nums, target, 0, nums.length - 1);
	}

	private static int _search(int[] nums, int target, int lo, int hi) {
		if (lo <= hi) {

			int mid = (hi - lo) / 2 + lo;

			if (target == nums[mid]) {
				return mid;
			} else if (nums[lo] <= nums[mid]) {
				if (target >= nums[lo] && target < nums[mid]) {
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}
			} else {

				if (target <= nums[hi] && target > nums[mid]) {
					lo = mid + 1;
				} else {
					hi = mid - 1;
				}
			}

			return _search(nums, target, lo, hi);

		}
		return -1;
	}

}
