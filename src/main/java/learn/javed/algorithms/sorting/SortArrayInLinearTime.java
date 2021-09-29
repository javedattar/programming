package learn.javed.algorithms.sorting;

/**
 * Given Array of zeros, ones and negetive ones Sort this array in linear time author: Javed Attar
 */

public class SortArrayInLinearTime {
  static int inputArray[] = {
      0, 1, -1, 0, -1, 1, 1, -1, 0, 0, 1, 1, 1
  };

  public static int[] sort(int[] inputArray) {
    int[] resultArray = new int[inputArray.length];
    int countZeros = 0, countOnes = 0, countNegativeOnes = 0, counter = 0;;
    for (int i = 0; i < inputArray.length; i++) {
      if (inputArray[i] == 0)
        countZeros++;
      if (inputArray[i] == 1)
        countOnes++;
      if (inputArray[i] == -1)
        countNegativeOnes++;
    }
    while (countNegativeOnes > 0) {
      resultArray[counter++] = -1;
      countNegativeOnes--;
    }
    while (countZeros > 0) {
      resultArray[counter++] = 0;
      countZeros--;
    }
    while (countOnes > 0) {
      resultArray[counter++] = 1;
      countOnes--;
    }
    return resultArray;
  }

  public static void main(String[] args) {
    int[] resultantArray = SortArrayInLinearTime.sort(inputArray);
    for (int i : resultantArray) {
      System.out.print(i + ", ");
    }
  }
}
