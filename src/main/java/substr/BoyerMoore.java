package substr;

public class BoyerMoore {

  private static final int R = 256;
  private int[] right;
  private int m;
  private int n;
  private String pattern;

  public BoyerMoore(String pattern) {
    this.pattern = pattern;
    this.m = pattern.length();
    this.right = new int[R];
    for (int c = 0; c < R; c++) {
      right[c] = -1; // not in pattern
    }
    for (int j = 0; j < m; j++) {
      right[pattern.charAt(j)] = j;
    }
  }

  public int search(String text) {
    n = text.length();
    int skip;
    for (int i = 0; i <= n - m; i += skip) {
      skip = 0;
      for (int j = m - 1; j >= 0; j--) { // reading characters in pattern from right to left
        if (pattern.charAt(j) != text.charAt(i + j)) {
          skip = Math.max(1, j - right[text.charAt(i + j)]);
          break;
        }
      }
      if (skip == 0) {
        return i;
      }
    }
    return n;
  }
}
