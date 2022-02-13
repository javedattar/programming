/**
* author: Javed Attar
*/
package learn.javed.algorithms.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_2 {

	public static void main(String[] args) {
		CombinationSum_2 cs = new CombinationSum_2();

//		System.out.println(cs.combinationSumUseOnce(candidates, 8));
		int[] candidates = new int[] { 3, 1, 3, 5, 1, 5, 2, 3, 2, 5, 4 };
		System.out.println(cs.combinationSumUseOnce(candidates, 10));

		candidates = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1 };

		System.out.println(cs.combinationSumUseOnce(candidates, 10));

	}

	// Leet code 40. 172/175 pass. Combination sum II
	public List<List<Integer>> combinationSumUseOnce(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();

		int allCandidatesSame = 1;
		for (int i = 1; i < candidates.length; i++) {
			if (candidates[i - 1] == candidates[i]) {
				allCandidatesSame++;
			}
		}
		if (candidates.length > 10 && allCandidatesSame == candidates.length
				&& (candidates.length * candidates[0]) >= target) {
			List<Integer> combo = new ArrayList<>();
			for (int i = 0; i < target / candidates[0]; i++)
				combo.add(candidates[i]);
			result.add(combo);
			return result;
		}
		Arrays.sort(candidates);
		findSum(candidates, target, 0, result, new ArrayList<Integer>());

		return result;
	}

	private void findSum(int[] candidates, int target, int index, List<List<Integer>> result, List<Integer> combo) {
		if (target == 0 && !result.contains(combo)) {
			result.add(new ArrayList<Integer>(combo));
			return;
		}
		if (target < 0 || index >= candidates.length) {
			return;
		}
		for (int i = index; i < candidates.length; i++) {
			combo.add(candidates[i]);
			findSum(candidates, target - candidates[i], i + 1, result, combo);
			combo.remove(combo.size() - 1);
		}

	}

}
