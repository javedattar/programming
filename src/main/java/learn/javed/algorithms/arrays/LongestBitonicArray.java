/**
* author: Javed Attar
*/
package learn.javed.algorithms.arrays;

import java.util.Arrays;

public class LongestBitonicArray {

	public static void main(String[] args) {
		System.out.println("LongestBitonicArray.main() expected 5 <> actual "
				+ findLongestBiTonic(new int[] { 2, 1, 4, 7, 3, 2, 5 }));
		System.out.println("LongestBitonicArray.main() expected 5 <> actual "
				+ findLongestBiTonic(new int[] { 2, 1, 4, 7, 3, 2, 5, 1, 2, 1 }));
		System.out.println(
				"LongestBitonicArray.main() expected 5 <> actual " + findLongestBiTonic(new int[] { 4, 3, 2, 1 }));
	}

	public static int findLongestBiTonic(int[] arr) {
		int max = -1;
		int i = 0;
		int j = arr.length - 1;
		int[] increasing = new int[arr.length];
		int[] decreasing = new int[arr.length];
		increasing[i] = 1;
		decreasing[j] = 1;
		while (i < arr.length - 1) {
			if (arr[i] < arr[i + 1]) {
				increasing[i + 1] = increasing[i] + 1;
			} else {
				increasing[i + 1] = 1;
			}
			i++;
			if (arr[j] < arr[j - 1]) {
				decreasing[j - 1] = decreasing[j] + 1;
			} else {
				decreasing[j - 1] = 1;
			}
			j--;
		}
		System.out.println(Arrays.toString(increasing));
		System.out.println(Arrays.toString(decreasing));
		for (int k = 0; k < increasing.length; k++) {
			max = Math.max(max, increasing[k] + decreasing[k] - 1);
		}
		return max;
	}

}
