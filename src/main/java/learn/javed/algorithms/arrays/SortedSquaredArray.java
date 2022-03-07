package learn.javed.algorithms.arrays;

import java.util.Arrays;

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
