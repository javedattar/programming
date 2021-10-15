package learn.javed.algorithms.arrays;

import java.util.Arrays;
import java.util.Stack;

public class RemoveElementToMakeArraySorted {

	public static void main(String[] args) {
		int[] nums = {1,2,10,5,7};
		int[] nums2 = {1,10,3,11,7};
		int[] nums3 = {10,2,3,5,7};
		int[] nums4 = {1,2,3,5,0};
		int[] nums5 = {1,2,3};
		int[] nums6 = {1,1,1};
		int[] nums7 = {1,2,3, 5, 2, 3};
 		System.out.println(Arrays.toString(nums) + " = " + canSort(nums));
 		System.out.println(Arrays.toString(nums2) + " = " + canSort(nums2));
 		System.out.println(Arrays.toString(nums3) + " = " + canSort(nums3));
 		System.out.println(Arrays.toString(nums4) + " = " + canSort(nums4));
 		System.out.println(Arrays.toString(nums5) + " = " + canSort(nums5));
 		System.out.println(Arrays.toString(nums6) + " = " + canSort(nums6));
 		System.out.println(Arrays.toString(nums7) + " canBeIncreasing = " + canBeIncreasing(nums7));
 		System.out.println(Arrays.toString(nums6) + " = " + canSortWithStack(nums6));
 		System.out.println(Arrays.toString(nums5) + " = " + canSortWithStack(nums5));
 		System.out.println(Arrays.toString(nums4) + " = " + canSortWithStack(nums4));
 		System.out.println(Arrays.toString(nums3) + " = " + canSortWithStack(nums3));
 		System.out.println(Arrays.toString(nums2) + " = " + canSortWithStack(nums2));

	}

	private static boolean canSort(int[] nums) {
		if(nums.length == 1) return true;
		int prev = nums[0];
		int countElimination = 0;
		for (int i=1; i<nums.length; i++) {
			int curr = nums[i];
			if(prev >= curr) {
				countElimination++;
				
			}
			prev = curr;

		}

		
		return countElimination <= 1 ? true : false;
	}
	
	private static boolean canSortWithStack(int[] nums) {
		if(nums.length == 1) return true;
		int countElimination = 0;
		Stack<Integer> result = new Stack<>();
		result.push(nums[0]);
		
		for (int i=1; i<nums.length; i++) {
			int curr = nums[i];
			if(result.peek() >= curr) {
				countElimination++;
				result.pop();
				if(!result.isEmpty() && result.peek() >= curr) {
					countElimination++;
					result.pop();
				}
					
				
			}
			result.push(curr);
			
		}
		
		
		return countElimination <= 1 ? true : false;
	}
	
	private static boolean canBeIncreasing(int[] nums) {
        if(nums.length == 2)
            return true;
        
        int indexToRemove = 0;
        int count = 0;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] >= nums[i+1]){
                indexToRemove = i;
                count++;
            }
        }
        
        if(count > 1)   
            return false;
        
        if(indexToRemove == 0) 
            return true;
        
        if(nums[indexToRemove-1] >= nums[indexToRemove+1])
            indexToRemove += 1;
        
        if(indexToRemove == nums.length-1)
            return true;
        
       for(int i=0; i<indexToRemove-1; i++)
           if(nums[i] >= nums[i+1])
               return false;
        
        for(int i=indexToRemove+1; i<nums.length-1; i++)
            if(nums[i] >= nums[i+1])
                return false;
        
        if(nums[indexToRemove-1] >= nums[indexToRemove+1])
            return false;
        
        return true;
    }

}
