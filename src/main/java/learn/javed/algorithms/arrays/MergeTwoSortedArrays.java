package learn.javed.algorithms.arrays;

import java.util.Arrays;

/**
 * author: Javed Attar
 */

public class MergeTwoSortedArrays {
	static int arr1[] = { 1, 3, 5, 7, 9, 11, 12, 13, 14, 15 };
	static int arr2[] = { 2, 4, 6 };
	static int arr3[] = { 1, 3, 5, 7, 9, 0, 0, 0 };

	public static int[] mergeArrays(int arr1[], int arr2[]) {
		int i = 0, j = 0, k = 0;
		int totalLength = arr1.length + arr2.length;
		int resultArray[] = new int[totalLength];
		while (k < totalLength) {
			if (j == arr2.length || arr1[i] < arr2[j]) {
				resultArray[k] = arr1[i];
				i++;
			} else if (i == arr1.length || arr1[i] > arr2[j]) {
				resultArray[k] = arr2[j];
				j++;
			}
			k++;
		}

		return resultArray;
	}

	public static void main(String[] args) {
		int[] mergeArrays = mergeArrays(arr1, arr2);
		System.out.println("Array 1 >> " + Arrays.toString(arr1));
		System.out.println("Array 2 >> " + Arrays.toString(arr2));
		System.out.println("\nMerged array >> " + Arrays.toString(mergeArrays));
		mergeArrays(arr3, 5, arr2, 3);
		System.out.println("\nMerged array >> " + Arrays.toString(arr3));
	}

	/**
	 * Leetcode: 88 Merge sorted arrays
	 * 
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */

	public static void mergeArrays(int nums1[], int m, int nums2[], int n) {
		int i = m - 1, j = n - 1, k = nums1.length - 1;
		while (i >= 0 && j >= 0) {
			if (nums1[i] > nums2[j]) {
				nums1[k] = nums1[i--];

			} else {
				nums1[k] = nums2[j--];
			}
			k--;
		}
//		while (i >= 0) {
//			nums1[k--] = nums1[i--];
//		}
		while (j >= 0) {
			nums1[k--] = nums2[j--];
		}
	}
}
