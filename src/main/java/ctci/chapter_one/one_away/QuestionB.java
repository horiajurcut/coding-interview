package ctci.chapter_one.one_away;

public class QuestionB {

  public static boolean isOneEditAway(String a, String b) {
    // Check if the difference between strings > 1
    if (Math.abs(a.length() - b.length()) > 1) {
      return false;
    }

    String s1 = a.length() < b.length() ? a : b;
    String s2 = a.length() < b.length() ? b : a;

    int firstIndex = 0;
    int secondIndex = 0;
    boolean foundDifference = false;

    while (firstIndex < s1.length() && secondIndex < s2.length()) {
      if (s1.charAt(firstIndex) != s2.charAt(secondIndex)) {
        if (foundDifference) {
          return false;
        }
        foundDifference = true;
        if (s1.length() == s2.length()) {
          ++firstIndex;
        }
      } else {
        ++firstIndex;  // if characters are matching
      }
      ++secondIndex;  // always move pointer to larger string
    }

    return true;
  }

  public static void main(String[] args) {
    String a = "palee";
    String b = "pale";
    boolean isOneEdit1 = isOneEditAway(a, b);
    System.out.println(a + ", " + b + ": " + isOneEdit1);

    String c = "pale";
    String d = "pkle";
    boolean isOneEdit2 = isOneEditAway(c, d);
    System.out.println(c + ", " + d + ": " + isOneEdit2);
  }
}

