package learn.javed.algorithms.sorting;

/**
 * author: Javed Attar
 */


public class SortColors {

  /**
   * Sort colors in liner time 0=red, 1=blue, 2=green
   */
  static int[] colors = {
      2, 0, 1, 0, 0, 1, 1, 1, 2, 2, 0, 1, 2, 1, 0
  };

  public static void sortColors(int[] colors) {
    int blueIndex = -1, redIndex = -1, greenIndex = -1;
    for (int i = 0; i < colors.length; i++) {
      if (colors[i] == 0) {
        colors[++greenIndex] = 2;
        colors[++blueIndex] = 1;
        colors[++redIndex] = 0;
      } else if (colors[i] == 1) {
        colors[++greenIndex] = 2;
        colors[++blueIndex] = 1;
      } else if (colors[i] == 2) {
        colors[++greenIndex] = 2;
      }
    }
  }

  public static void main(String[] args) {
    SortColors.sortColors(colors);
    for (int num : colors) {
      System.out.print(num + ", ");
    }
  }
}
