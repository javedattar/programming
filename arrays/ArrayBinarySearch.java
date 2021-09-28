public class ArrayBinarySearch {
  private static int intArray[] = {
      10,
      12,
      99,
      100,
      111,
      123,
      234,
      256,
      298,
      301,
      324,
      456,
      999,
      1010,
      1012,
      1099,
      10100,
      10111,
      10123,
      10234,
      10256,
      10298,
      10301,
      10324,
      10456,
      10999
  };
  private static int counter = 1;
  
  /**
   * This algorithm assumes array is sorted which makes it efficient search algorithm
   * 
   * Time: O(log n)
   * Space: O(n)
   * 
   * @param searchTarget target element to search
   * @param lo lower index of an array
   * @param hi higher index of an array
   * @return
   */

  private static int search(int searchTarget, int lo, int hi) {

    if (lo < hi) {

      int mid = (hi - lo) / 2 + lo;
      if (intArray[mid] == searchTarget) {
        System.out.println(counter++);
        return mid;
      }
      if (intArray[mid] > searchTarget) {
        System.out.println(counter++);
        return search(searchTarget, lo, mid - 1);
      }
      System.out.println(counter++);
      return search(searchTarget, mid + 1, hi);
    }
    return -1;
  }

  public static void main(String[] args) {
    int result = search(10456, 0, intArray.length - 1);
    printResult(result, 10456);
    counter = 1;
    result = search(99, 0, intArray.length - 1);
    printResult(result, 99);
    counter = 1;
    result = search(10, 0, intArray.length - 1);
    printResult(result, 10);
    counter = 1;
    result = search(199, 0, intArray.length - 1);
    printResult(result, 199);
  }

  private static void printResult(int result, int targetNum) {
    if (result == -1) {
      System.out.println(String.format("Element %d is NOT present in array >> ", targetNum));
    } else {
      System.out.println(String.format("Element %d is present in array at index [%d] >>", targetNum, result));
    }
  }
}
