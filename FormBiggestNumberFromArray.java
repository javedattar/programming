import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given an array of numbers, arrange them in a way that yields the largest value. For example, if the given
 * numbers are {54, 546, 548, 60}, the arrangement 6054854654 gives the largest value. And if the given numbers are
 * {1, 34, 3, 98, 9, 76, 45, 4}, then the arrangement 998764543431 gives the largest value.
 * 
 * author: Javed Attar
 */

public class FormBiggestNumberFromArray {
  public static void main(String[] args) {
    int[] inputArray = {
        1,
        34,
        3,
        98,
        9,
        76,
        45,
        4
    };
    printLargestNumber(inputArray);
    inputArray = new int[] {
        45,
        36,
        7,
        75,
        12
    };
    printLargestNumber(inputArray);
  }

  private static void printLargestNumber(int[] inputArray) {
    List<String> lstInput = new ArrayList<>();
    for (int num : inputArray) {
      lstInput.add("" + num);
    }
    Collections.sort(lstInput, new Comparator<String>() {

      @Override
      public int compare(String x, String y) {
        String xy = x + y;
        String yx = y + x;
        return xy.compareTo(yx) * -1;
      }

    });
    System.out.println(String.format("Largest number for input array %s is %s \n", Arrays.toString(inputArray),
        String.join("", lstInput)));
  }
}
