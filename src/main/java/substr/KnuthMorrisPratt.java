package substr;

public class KnuthMorrisPratt {

  private static final int R = 256;
  private final int m;
  private String pattern;
  private int[][] dfa;

  public KnuthMorrisPratt(String pattern) {
    this.pattern = pattern;
    this.m = pattern.length();

    dfa = new int[R][m];
    dfa[pattern.charAt(0)][0] = 1;
    for (int x = 0, j = 1; j < this.m; j++) {
      for (int c = 0; c < R; c++) {
        dfa[c][j] = dfa[c][x];
      }
      dfa[pattern.charAt(j)][j] = j + 1;
      x = dfa[pattern.charAt(j)][x];
    }
  }

  public int search(String text) {
    int i;
    int j;
    int n = text.length();
    for (i = 0, j = 0; i < n && j < m; i++) {
      j = dfa[text.charAt(i)][j];
    }
    if (j == this.m) {
      return i - m;
    } else {
      return n;
    }
  }
}
