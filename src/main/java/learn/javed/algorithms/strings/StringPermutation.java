package learn.javed.algorithms.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a string find out all possible combination of letters in string.
 * 
 * Example: for input string ABC possible combinations are ABC, ACB, CAB, BAC, BCA, CBA Possible pemutations in
 * this case are n factorial (n!) where n is length of string.
 * 
 * author: Javed Attar
 */

public class StringPermutation {

  static Set<String> permutationSet = new HashSet<>();
  static int counter = 0;

  private static void permuteString(String input, String selected) {
    if (input.isEmpty()) {
      counter++;
      System.out.println(String.format("Combo %d >> %s ", counter, selected));
      permutationSet.add(selected);
    } else {
      for (int i = 0; i < input.length(); i++) {
        System.out.println(String.format("input %s & output %s", input, selected));
        String input2 = input.substring(0, i) + input.substring(i + 1, input.length());
        permuteString(input2, selected + input.charAt(i));
      }
    }

  }

  public static void main(String[] args) {
    counter = 0;
    permuteString("abc", "");
    System.out.println("Total no of permutations:>> " + counter);
    List<String> lst = new ArrayList<>();
    lst.add("45");
    lst.add("79");
    lst.add("75");
    lst.add("12");
    lst.add("36");
    Collections.sort(lst);
    System.out.println(Arrays.deepToString(lst.toArray()));
    System.out.println(String.join(",", lst));
  }
}
