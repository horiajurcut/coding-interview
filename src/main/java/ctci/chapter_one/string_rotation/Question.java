package ctci.chapter_one.string_rotation;

public class Question {

  public static boolean isRotation(String s1, String s2) {
    int len = s1.length();

    if (len == s2.length() && len > 0) {
      String s1s1 = s1 + s1;
      return s1s1.indexOf(s2) >= 0;
    }
    return false;
  }

  public static void main(String[] args) {
    String[][] pairs = {{"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"camera", "macera"}};
    for (String[] pair : pairs) {
      String word1 = pair[0];
      String word2 = pair[1];
      boolean is_rotation = isRotation(word1, word2);
      System.out.println(word1 + ", " + word2 + ": " + is_rotation);
    }
  }
}

