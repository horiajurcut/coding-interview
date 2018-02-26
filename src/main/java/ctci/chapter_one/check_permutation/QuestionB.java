package ctci.chapter_one.check_permutation;

public class QuestionB {

  private static final int R = 256;

  public static boolean isPermutation(String a, String b) {
    if (a.length() != b.length()) {
      return false;
    }
    int letters[] = new int[R];
    for (int i = 0; i < a.length(); i++) {
      letters[a.charAt(i)]++;
    }
    for (int i = 0; i < b.length(); i++) {
      letters[b.charAt(i)]--;
      if (letters[b.charAt(i)] < 0) {
        return false;
      }
    }
    return true;
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

