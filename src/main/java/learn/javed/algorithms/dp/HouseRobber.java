/**
* author: Javed Attar
*/
package learn.javed.algorithms.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * You are professional robber planning to rob house along the street.
 * Each house has certain amount of money stored. the only constraint stopping
 * you from robbing each house is that
 * adjacent ones have security systems connected.
 * 
 * Given an integer array representing the amount of money each house return max
 * amount of money
 * you can rob tonight without alerting the police
 * 
 * 
 * Example: [1,2,3] => 4 is total loot (1,3)
 * Example: [2,1,1,2] => 4 is total loot (2,2)
 * 
 * @author jattar
 *
 */
public class HouseRobber {
	private static Map<Integer, Integer> stashMap = new HashMap<>();

	public static void main(String[] args) {
		int[] houseStash = { 1, 2, 3 };
		System.out.println("Maximum loot {1, 2, 3} => " + findLoot(houseStash));
		System.out.println("Maximum loot with memo {1, 2, 3} => " + findLoot2(houseStash));
		houseStash = new int[] { 2, 1, 1, 2 };
		System.out.println("Maximum loot { 2, 1, 1, 2 } => " + findLoot(houseStash));
		houseStash = new int[] { 1, 2, 3, 4, 5 };
		System.out.println("Maximum loot {1, 2, 3, 4, 5} => " + findLoot(houseStash));
		System.out.println("Maximum loot with memo {1, 2, 3, 4, 5} => " + findLoot2(houseStash));
		houseStash = new int[] { 1, 2, 3, 4, 5, 6 };
		System.out.println("Maximum loot {1, 2, 3, 4, 5, 6} => " + findLoot(houseStash));
		houseStash = new int[] { 1, 2, 3, 1, 9, 1, 11 };
		System.out.println("Maximum loot {1, 2, 3, 1, 9, 1, 11} => " + findLoot(houseStash));
		houseStash = new int[] { 1, 2, 3, 1, 9, 1, 11, 5 };
		System.out.println("Maximum loot {1, 2, 3, 1, 9, 1, 11, 5} => " + findLoot(houseStash));
		System.out.println("Maximum loot with memo {1, 2, 3, 1, 9, 1, 11, 5} => " + findLoot2(houseStash));

	}

	/**
	 * At any point robber cannot rob two houses consecutive to each other.
	 * Given houses 1 - 10
	 * so if robber starts at house 1 then can go to either house in 3 - 10, house 2
	 * should be skipped for security reasons
	 * that means possible combinations are going to be
	 * Option A => 1,3,5,7,9 or Option B => 1,4,6,8,10 or Option C => 1,3,7,10 and
	 * many other possibilities hence the deciding factor will be the collective
	 * loot amount
	 * Option A amount adds up to $200K
	 * Option B amount adds up to $190K
	 * Option C amount adds up to $290K
	 * Then winner among options A, B and C will be C
	 */

	/**
	 * Lets try to find out recurrence relation or formula that can help us decide
	 * which houses to rob to maximize loot
	 * Given n houses selecting ith house shall be depending on summation of
	 * (stash(i) + (stash(i+2) OR stash(i+3)))
	 * But we cannot ignore possibilities with i+1
	 * so it's loot = loot + max(stash(i) + stash(i+2), stash(i+1))
	 */

	private static int findLoot(int[] houseStash) {

		return maximizeStash(houseStash, houseStash.length - 1);
	}

	// Recursion + memorization
	private static int findLoot2(int[] houseStash) {
		stashMap.clear();
		return maximizeStash2(houseStash, houseStash.length - 1);
	}

	// Recursion
	// Time: O(n-1)+O(n-2)+1
	private static int maximizeStash(int[] houseStash, int houseIndex) {
		if (houseIndex < 0) {
			return 0;
		}
		int loot = Math.max(houseStash[houseIndex] + maximizeStash(houseStash, houseIndex - 2),
				maximizeStash(houseStash, houseIndex - 1));
		System.out.println("intermediate index and loot => " + houseIndex + " and " + loot);
		return loot;
	}

	// Recursion + memorization
	// Time:
	private static int maximizeStash2(int[] houseStash, int houseIndex) {
		if (houseIndex < 0) {
			return 0;
		}
		if (stashMap.containsKey(houseIndex)) {
			System.out.println("Reading from map =>" + stashMap.get(houseIndex));
			return stashMap.get(houseIndex);
		}

		int loot = Math.max(houseStash[houseIndex] + maximizeStash2(houseStash, houseIndex - 2),
				maximizeStash2(houseStash, houseIndex - 1));

		stashMap.put(houseIndex, loot);
		System.out.println(stashMap.toString());
		return loot;
	}
}
