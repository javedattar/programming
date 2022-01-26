package learn.javed.algorithms.tree;

/**
 * Given binary tree represented as an array {3,6,2,9,-1,10}
 * Find which size is bigger left or right. Return "Left" if left side is bigger and 
 * return "Right" if right is bigger
 * Return empty string if sides are equal or array is empty
 * @author javedattar
 *
 */
public class BiggerTreeBranch {

	public static void main(String[] args) {
		
		solution(new int[] {3,6,2,9,-1,10});
	}
	
	private static String solution(int[] nums) {
		if(nums.length == 0) {
			return "";
		}
		
		return null;
	}
	
	

}
