package ctci.chapter_one.one_away;

public class QuestionA {

  public static boolean isOneEditAway(String a, String b) {
    if (a.length() == b.length()) {
      return isOneReplace(a, b);
    } else if (a.length() + 1 == b.length()) {
      return isOneEdit(a, b);
    } else if (a.length() == b.length() + 1) {
      return isOneEdit(b, a);
    }

    return false;
  }

  public static boolean isOneReplace(String a, String b) {
    // Strings are the same length, once character is different
    boolean foundDifference = false;
    for (int i = 0; i < a.length(); i++) {
      if (a.charAt(i) != b.charAt(i)) {
        if (foundDifference) {
          return false;
        }
        foundDifference = true;
      }
    }
    return true;
  }

  public static boolean isOneEdit(String a, String b) {
    int indexA = 0;
    int indexB = 0;

    while (indexA < a.length() && indexB < b.length()) {
      if (a.charAt(indexA) != b.charAt(indexB)) {
        if (indexA != indexB) {
          // there should only be one difference
          return false;
        }
        ++indexB;
      } else {
        ++indexA;
        ++indexB;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    String a = "pale";
    String b = "ale";
    boolean isOneEdit = isOneEditAway(a, b);
    System.out.println(a + ", " + b + ": " + isOneEdit);
  }
}

