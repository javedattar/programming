/**
* author: Javed Attar
*/
package learn.javed.algorithms.arrays;

import java.util.Arrays;

public class TrappingRainWater {

	public static void main(String[] args) {
		int[] walls = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println("Given walls " + Arrays.toString(walls) + " trapped water => " + trapWater(walls));
		System.out
				.println("Given walls pointer approach " + Arrays.toString(walls) + " trapped water => " + trap(walls));
		walls = new int[] { 4, 2, 3 };
		System.out.println("Given walls " + Arrays.toString(walls) + " trapped water => " + trapWater(walls));
		System.out
				.println("Given walls pointer approach " + Arrays.toString(walls) + " trapped water => " + trap(walls));
		walls = new int[] { 5, 4, 1, 2 };
		System.out.println("Given walls " + Arrays.toString(walls) + " trapped water => " + trapWater(walls));
		System.out
				.println("Given walls pointer approach " + Arrays.toString(walls) + " trapped water => " + trap(walls));

	}

	private static int trapWater(int[] height) {
		// First and last wall cannot have any water on it
		// But in between walls can have water if walls before and after are taller
		int waterQuantity = 0;
		int prevMax = height[0], i = 1;
		int prevMaxIndex = 0;
		while (i < height.length) {
			if (prevMax < height[i]) {
				prevMax = height[i];
				prevMaxIndex = i;
				i++;
				continue;
			} else {
				while (i < height.length && prevMax >= height[i]) {

					i++;
				}

				// if reached end then it means we couldn't find anything in between
				// start from right side until
				if (i == height.length) {
//					int newHigh = prevMax;
//					prevMax = height[--i];
//					i--;
//					while (prevMaxIndex < i) {
//						if (prevMax < height[i]) {
//							prevMax = height[i];
//							i--;
//							continue;
//						}
//					}
				} else {
					int waterLevel = Math.min(prevMax, height[i]);

					while (prevMaxIndex < i) {
						waterQuantity += Math.max(0, waterLevel - height[prevMaxIndex]);
						prevMaxIndex++;
					}
					prevMax = height[i];
					i++;
				}
			}

		}

		return waterQuantity;
	}

	private static int trap(int[] height) {
		int waterQuantity = 0;
		int left = 0, right = height.length - 1, leftSideMax = height[left], rightSideMax = height[right];
		// base case to calculate water at index is min of (max on left and max on right) - height at index
		while (left < right) {
			if (leftSideMax < rightSideMax) {
				leftSideMax = Math.max(leftSideMax, height[++left]);
				waterQuantity += leftSideMax - height[left];
			} else {
				rightSideMax = Math.max(rightSideMax, height[--right]);
				waterQuantity += rightSideMax - height[right];
			}
		}

		return waterQuantity;
	}

}
