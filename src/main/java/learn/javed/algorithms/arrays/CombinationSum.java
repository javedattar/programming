/**
* author: Javed Attar
*/
package learn.javed.algorithms.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {
		CombinationSum cs = new CombinationSum();
		int[] candidates = new int[] { 2, 3, 5 };
		System.out.println(cs.combinationSum(candidates, 8));
		System.out.println(cs.combinationSum(candidates, 6));
		candidates = new int[] { 2, 3, 6, 7 };
		System.out.println(cs.combinationSum(candidates, 7));
		candidates = new int[] { 1, 2 };
		System.out.println(cs.combinationSum(candidates, 4));
//		candidates = new int[] { 10, 1, 2, 7, 6, 1, 5 };
//		System.out.println(cs.combinationSumUseOnce(candidates, 8));
		candidates = new int[] { 3, 1, 3, 5, 1, 5, 2, 3, 2, 5, 4 };
		System.out.println(cs.combinationSumUseOnce(candidates, 1));

		candidates = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1 };

		System.out.println(cs.combinationSumUseOnce(candidates, 10));

	}

	// Leet Code 39
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> combo = new ArrayList<>();
		findCombo(result, candidates, target, candidates.length - 1, combo);
		return result;
	}

	private void findCombo(List<List<Integer>> result, int[] candidates, int target, int index, List<Integer> combo) {
		if (target == 0) {
			result.add(new ArrayList<>(combo));
			return;
		}
		if (target < 0 || index < 0) {
			return;
		} else {
			if (target > 0) {
				int newTarget = target - candidates[index];
				combo.add(candidates[index]);
				findCombo(result, candidates, newTarget, index, combo);
				combo.remove(combo.size() - 1);
			}
			if (index > 0) {
				findCombo(result, candidates, target, index - 1, combo);
			}
		}
	}

	// Leet code 40. 172/175 pass
	public List<List<Integer>> combinationSumUseOnce(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> combo = new ArrayList<>();
		Arrays.sort(candidates);
		findComboOnce(result, candidates, target, candidates.length - 1, combo);
		return result;
	}

	private void findComboOnce(List<List<Integer>> result, int[] candidates, int target, int index,
			List<Integer> combo) {
		if (target == 0) {
			if (!result.contains(combo)) {
				result.add(new ArrayList<>(combo));
			}
			return;
		}
		if (target < 0 || index < 0) {
			return;
		} else {
			if (target > 0) {
				int newTarget = target - candidates[index];
				combo.add(candidates[index]);
				findComboOnce(result, candidates, newTarget, index - 1, combo);
				combo.remove(combo.size() - 1);
			}
			if (index > 0) {
				if (target == candidates[index] && candidates[index] == candidates[index - 1]) {
					return;
				}
				findComboOnce(result, candidates, target, index - 1, combo);
			}
		}
	}

}
