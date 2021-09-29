package learn.javed.algorithms.strings;

/**
 * String palindrome check
 * 
 * author: Javed Attar
 */

public class Palindrome {

  /**
   * This implementation uses character array for recursion and processes that array.
   * 
   * @param word
   * @return true if palindrome, false otherwise
   */
  public static boolean isPalindrome(String word) {
    if (word == null || word.isEmpty()) {
      return false;
    }
    word = word.toLowerCase();
    char[] charArray = word.toCharArray();
    return _match(0, charArray.length - 1, charArray);
  }

  /**
   * This implementation uses String for recursion with constantly shrinking string by eliminating first and last
   * matching chars
   * 
   * @param word
   * @return true if palindrome, false otherwise
   */
  public static boolean isPalindrome2(String word) {
    if (word == null) {
      return false;
    }
    if (word.length() == 0 || word.length() == 1) {
      return true;
    }
    if (word.charAt(0) == word.charAt(word.length() - 1)) {
      word = word.substring(1, word.length() - 1);
      return isPalindrome2(word);
    }
    return false;
  }

  private static boolean _match(int i, int j, char[] charArray) {
    if (i >= j) {
      return true;
    }
    if (charArray[i] == charArray[j]) {
      return _match(++i, --j, charArray);
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(Palindrome.isPalindrome("abccbaabccba"));
    System.out.println(Palindrome.isPalindrome2("abccbaabccba"));
  }
}
