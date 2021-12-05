/**
* author: Javed Attar
*/
package learn.javed.algorithms.arrays;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		ProductOfArrayExceptSelf o = new ProductOfArrayExceptSelf();
		int[] arr = new int[] { 1, 2, 3, 4 };
		int[] answer = o.multiply(arr);
		System.out.println("For given array >> " + Arrays.toString(arr) + " product is >> " + Arrays.toString(answer));
		answer = o.multiply2(arr);
		System.out.println(
				"For given array while >> " + Arrays.toString(arr) + " product is >> " + Arrays.toString(answer));
		arr = new int[] { 1, 2, 0, 3, 4 };
		answer = o.multiply(arr);
		System.out.println("For given array >> " + Arrays.toString(arr) + " product is >> " + Arrays.toString(answer));
		answer = o.multiply2(arr);
		System.out.println(
				"For given array while >> " + Arrays.toString(arr) + " product is >> " + Arrays.toString(answer));
		arr = new int[] { -1, 1, 0, -3, 3 };
		answer = o.multiply(arr);
		System.out.println("For given array >> " + Arrays.toString(arr) + " product is >> " + Arrays.toString(answer));
		answer = o.multiply2(arr);
		System.out.println(
				"For given array while >> " + Arrays.toString(arr) + " product is >> " + Arrays.toString(answer));
	}

	public int[] multiply(int[] nums) {
		int[] answer = new int[nums.length];
		if (nums.length < 2 || nums.length > 100000) {
			return answer;
		}
		int arrProduct = 1, skippedZeros = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				arrProduct *= nums[i];
			} else {
				skippedZeros++;
			}
		}
		if (skippedZeros > 1) {
			return answer;
		}
		for (int i = 0; i < nums.length; i++) {
			answer[i] = skippedZeros == 1 && nums[i] != 0 ? 0 : nums[i] == 0 ? arrProduct : arrProduct / nums[i];
		}
		return answer;
	}

	public int[] multiply2(int[] nums) {
		int[] answer = new int[nums.length];
		if (nums.length < 2 || nums.length > 100000) {
			return answer;
		}
		int arrProduct = 1, skippedZeros = 0, i = 0, j = nums.length - 1;
		while (i <= j) {
			if (nums[i] != 0) {
				arrProduct *= nums[i];
			} else {
				skippedZeros++;
			}
			if (i != j)
				if (nums[j] != 0) {
					arrProduct *= nums[j];
				} else {
					skippedZeros++;
				}
			i++;
			j--;
		}
		if (skippedZeros > 1) {
			return answer;
		}
		i = 0;
		j = nums.length - 1;
		while (i <= j) {
			answer[i] = skippedZeros == 1 && nums[i] != 0 ? 0 : nums[i] == 0 ? arrProduct : arrProduct / nums[i];
			answer[j] = skippedZeros == 1 && nums[j] != 0 ? 0 : nums[j] == 0 ? arrProduct : arrProduct / nums[j];
			i++;
			j--;
		}
		return answer;
	}

	/**
	 * Without division
	 * 
	 * @param nums
	 * @return
	 */
	public int[] multiply3(int[] nums) {
		int[] answer = new int[nums.length];
		int[] right = new int[nums.length];
		if (nums.length < 2 || nums.length > 100000) {
			return answer;
		}
		for (int i = 0; i < nums.length; i++) {

		}
		return answer;
	}

}
