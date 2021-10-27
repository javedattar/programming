/**
* author: Javed Attar
*/
package learn.javed.algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = { 1, 5, 8, 9, 6, 0, 3, 2, 7, 4 };
		System.out.println(Arrays.toString(arr) + " sorted => " + Arrays.toString(sort(arr)));

	}

	private static int[] sort(int[] arr) {
		// Base Condition
		if (arr.length < 2) {
			return arr;
		}
		// Recursion Condition

		// Selecting random pivot is important to achieve O(n * log(n))
		int pivot = arr[0];
		// Since no. of items less than pivot can not be pre-determined, hence initializing array is not possible so
		// using List
		List<Integer> leftList = new ArrayList<>();
		List<Integer> rightList = new ArrayList<>();
		for (int i = 1; i < arr.length; i++) {

			if (arr[i] < pivot) {
				leftList.add(arr[i]);
			} else {
				rightList.add(arr[i]);
			}
		}

		int[] less = sort(leftList.stream().mapToInt(i -> i).toArray());
		int[] more = sort(rightList.stream().mapToInt(i -> i).toArray());
		int outArr[] = new int[less.length + more.length + 1];

		int counter = 0, r = 0;
		while (counter < less.length) {
			outArr[counter] = less[counter];
			counter++;
		}

		outArr[counter++] = pivot;

		while (r < more.length)
			outArr[counter++] = more[r++];

		return outArr;
	}

	private static int[] sort2(int[] arr) {
		return arr;
	}

}
