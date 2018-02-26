package ctci.chapter_one.check_permutation;

import java.util.Arrays;

public class QuestionA {

  public static String sort(String input) {
    char[] s = input.toCharArray();
    Arrays.sort(s);
    return new String(s);
  }

  public static boolean isPermutation(String a, String b) {
    if (a.length() != b.length()) {
      return false;
    }
    return sort(a).equals(sort(b));
  }

  public static void main(String[] args) {
    String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
    for (String[] pair : pairs) {
      String word1 = pair[0];
      String word2 = pair[1];
      boolean anagram = isPermutation(word1, word2);
      System.out.println(word1 + ", " + word2 + ": " + anagram);
    }
  }
}

