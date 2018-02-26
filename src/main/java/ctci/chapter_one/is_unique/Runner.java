package ctci.chapter_one.is_unique;

public class Runner {

  /**
   * If you can't use additional data structures we might consider sorting the string.
   * We could compare every character of the string to every other character --> O(n^2)
   */
  public static void main(String[] args) {
    String[] words = {"apple", "paddle", "kite"};
    for (int i = 0; i < words.length; i++) {
      System.out.println(QuestionA.isUniqueChars(words[i]));
      System.out.println(QuestionB.isUniqueChars(words[i]));
    }
  }
}

