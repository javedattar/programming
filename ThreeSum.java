import java.util.ArrayList;
import java.util.List;

class ThreeSum {
  public List<List<Integer>> threeSum(int[] nums) {
    int result = 0;
    List<List<Integer>> resultList = new ArrayList<List<Integer>>();
    for (int i = 0; i < nums.length - 1; i++) {
      List<Integer> subList = new ArrayList<Integer>();
      // For every element try to find combination
      int temp = result - nums[i];
      subList.add(nums[i]);
      for (int j = 0; j < nums.length; j++) {
        if (j == i)
          continue;
        temp = temp - nums[j];
        subList.add(nums[j]);
        if (temp == 0 && subList.size() == 3) {
          resultList.add(subList);
          subList = new ArrayList<Integer>();
          temp = result - nums[i];
          subList.add(nums[i]);
        }


      }
    }
    return resultList;
  }

}
