package ctci.chapter_one.is_unique;

public class QuestionB {
  public static boolean isUniqueChars(String input) {
    // reduce the amount of space needed by using a bit vector
    int checker = 0;
    for (int i = 0; i < input.length(); i++) {
      int val = input.charAt(i) - 'a';
      if ((checker & (1 << val)) > 0) {
        return false;
      }
      checker |= (1 << val);
    }
    return true;
  }
}
