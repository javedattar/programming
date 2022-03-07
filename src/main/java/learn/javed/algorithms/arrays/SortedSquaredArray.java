package learn.javed.algorithms.arrays;

import java.util.Arrays;
/**
 *977: Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

 

Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.
 * @author javedattar
 *
 */
public class SortedSquaredArray {

	public static void main(String[] args) {
		int arr[] = {-6, -4, 1, 2, 3, 5};
		int[] output = new SortedSquaredArray().sortedSquares(arr);
		System.out.println(Arrays.toString(output));

	}
	public int[] sortedSquares(int[] nums) {
        
        int[] result = new int[nums.length];  
        int negativeEndIndex = 0;
        while(negativeEndIndex < nums.length && nums[negativeEndIndex] < 0)
            negativeEndIndex++;

        int negativeIndex = negativeEndIndex-1;
        int positiveIndex = negativeEndIndex;
        int k = 0;
        while(positiveIndex < nums.length && negativeIndex >= 0) {
            if(square(nums[negativeIndex]) < square(nums[positiveIndex]))
                result[k++] = square(nums[negativeIndex--]);
            else
                result[k++] = square(nums[positiveIndex++]);
        }
        while(positiveIndex < nums.length) {
            result[k++] = square(nums[positiveIndex++]);
        }
        while(negativeIndex >= 0)
            result[k++] = square(nums[negativeIndex--]);
        return result;
    }
    
    private int square(int num) {

        return num * num;
    }
	
}
