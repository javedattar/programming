import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array find given target sum as addition of two elements
 * 
 * Example: { 1, 5, 4, 6, 7, 3, 7 } and target sum is 7 then should print [3,4] and [6,1]
 * 
 * Example: { 1, 5, 4, 6, 7, 3, 7 } and target sum is 9 then should print [3,6] and [4,5]
 * 
 * author: Javed Attar
 */

public class FindAllMatchingTargetAdditionFromArray {
  public static void main(String[] args) {
    int[] inputArray = {
        1,
        5,
        4,
        6,
        7,
        3,
        7
    };
    System.out.println("Input Array >> " + Arrays.toString(inputArray));
    findMatches(inputArray, 7);
    findMatches(inputArray, 9);
  }

  private static void findMatches(int[] inputArray, int target) {
    System.out.println("Target >> " + target);
    Map<Integer, Integer> mapPossibleTargets = new HashMap<>();
    Map<Integer, Integer> mapResultOutput = new HashMap<>();
    for (int i = 0; i < inputArray.length; i++) {
      if (mapPossibleTargets.containsKey(inputArray[i])) {
        mapResultOutput.put(inputArray[i], mapPossibleTargets.get(inputArray[i]));
      } else {
        mapPossibleTargets.put(target - inputArray[i], inputArray[i]);
      }
    }
    mapResultOutput.entrySet().stream().forEach(entrySet -> {
      System.out.println(String.format("[%d,%d]", entrySet.getKey(), entrySet.getValue()));
    });
  }
}
