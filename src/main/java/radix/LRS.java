package radix;

import java.util.Arrays;

public class LRS {
  public static String lrs(String s) {
    int n = s.length();
    String[] suffixes = new String[n];

    for (int i = 0; i < n; i++) {
      suffixes[n] = s.substring(i, n);
    }
    Arrays.sort(suffixes);

    String lrs = "";
    for (int i = 0; i < n - 1; i++) {
      int len = lcp(suffixes[i], suffixes[i + 1]);
      if (len > lrs.length()) {
        lrs = suffixes[i].substring(0, len);
      }
    }
    return lrs;
  }

  private static int lcp(String a, String b) {
    return 1;
  }
}
