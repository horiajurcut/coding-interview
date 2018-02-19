package substr;

public class BruteForceSubstringSearch {

  public static int search(String pattern, String text) {
    int m = pattern.length();
    int n = text.length();

    for (int i = 0; i <= n - m; i++) {
      int j;
      for (j = 0; j < m; j++) {
        if (text.charAt(i + j) != pattern.charAt(j)) {
          break;
        }
      }
      if (j == m) {
        return i;
      }
    }
    return n; // not found
  }

  public static int search2(String pattern, String text) {
    int m = pattern.length();
    int n = text.length();
    int i;
    int j;

    for (i = 0, j = 0; i < n && j < m; i++) {
      if (text.charAt(i) == pattern.charAt(j)) {
        j++;
      } else {
        i -= j;
        j = 0;
      }
    }

    if (j == m) {
      return i - m;
    } else {
      return n;
    }
  }
}
