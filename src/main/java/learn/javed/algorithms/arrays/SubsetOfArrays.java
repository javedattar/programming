package learn.javed.algorithms.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 78 Given an integer array nums of unique elements, return all possible
 * subsets (the power set). The solution set must not contain duplicate subsets.
 * Return the solution in any order.
 *
 */
public class SubsetOfArrays {

	public static void main(String[] args) {
		System.out.println(subsets(new int[] { 1, 2, 3 }));
		System.out.println(subsetsWithDup(new int[] { 1, 2, 2 }));

	}
	/**
	 * Example: given nums = {1,2,3}
	 * output: [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		_generate(nums, result, new ArrayList<Integer>(), 0);
		return result;
	}

	private static void _generate(int[] nums, List<List<Integer>> result, List<Integer> subset, int index) {
		result.add(new ArrayList<Integer>(subset));
		for (int i = index; i < nums.length; i++) {

			subset.add(nums[i]);
			System.out.println("after adding element >> " + subset);
			_generate(nums, result, subset, i + 1);
			System.out.println("Backtracking subset >> " + subset);
			subset.remove(subset.size() - 1);
			System.out.println("After element removal >> " + subset);
		}
	}

//    private static void _generate(int[] nums, List<List<Integer>> result, Deque<List<Integer>> stack, int index) {
////        result.add(new ArrayList<Integer>(subset));
//        while(!stack.isEmpty()) {
//        for(int i=index; i<nums.length; i++) {
//        	
//            subset.add(nums[i]);
//            System.out.println("after adding element >> "+subset);
//            _generate(nums, result, subset, i+1);
//            System.out.println("Backtracking subset >> "+subset);
//            subset.remove(subset.size()-1);
//            System.out.println("After element removal >> " + subset);
//        }
//    }

	/**
	 * 90 Subsets II
	 * Example: given nums = {1,2,2}
	 * output: [[], [1], [1, 2], [1, 2, 2], [2], [2, 2]]
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		_generate2(nums, result, new ArrayList<Integer>(), 0);
		return result;
	}

	private static void _generate2(int[] nums, List<List<Integer>> result, List<Integer> subset, int index) {

		if (!result.contains(subset))
			result.add(new ArrayList<Integer>(subset));
		for (int i = index; i < nums.length; i++) {
			subset.add(nums[i]);
			_generate2(nums, result, subset, i + 1);
			subset.remove(subset.size() - 1);
		}
	}

}
