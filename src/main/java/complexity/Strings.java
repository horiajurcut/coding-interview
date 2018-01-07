package complexity;

public class Strings {

  static int numChars = 26;

  static void printSortedStrings(int remaining) {
    printSortedStrings(remaining, "");
  }

  /**
   * Generating the string takes O(c^k)
   * We can compute it with the formula O(branches^depth)
   * depth = k, branches = c (number of characters in the alphabet)
   */
  static void printSortedStrings(int remaining, String prefix) {
    System.out.println(String.format("r = %d, prefix = %s", remaining, prefix));

    if (remaining == 0) {
      if (isInOrder(prefix)) {
        System.out.println(prefix);
      }
    } else {
      for (int i = 0; i < numChars; i++) {
        char c = ithLetter(i);
        printSortedStrings(remaining - 1, prefix + c);
      }
    }
  }

  /**
   * Checking if the string is ordered takes O(k) time
   */
  static boolean isInOrder(String s) {
    for (int i = 1; i < s.length(); i++) {
      int prev = ithLetter(s.charAt(i - 1));
      int curr = ithLetter(s.charAt(i));
      if (prev > curr) {
        return false;
      }
    }
    return true;
  }

  static char ithLetter(int i) {
    return (char) ((int)'a' + i);
  }

  /**
   * Runtime is O(k * c^k)
   */
  public static void main(String[] args) {
    printSortedStrings(2);
  }
}
