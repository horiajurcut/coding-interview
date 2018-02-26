package ctci.chapter_one.is_unique;

public class QuestionA {

  private static final int R = 256;

  public static boolean isUniqueChars(String input) {
    // Complexity O(N) --> O(c) where c = size of alphabet
    if (input.length() > R) {
      return false;  // input size is bigger than alphabet
    }

    boolean[] marked = new boolean[R];
    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      if (marked[c]) {
        return false;
      }
      marked[c] = true;
    }
    return true;
  }
}



