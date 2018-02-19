package substr;

import java.math.BigInteger;
import java.util.Random;

public class RabinKarp {

  private static final int R = 256;
  private static long Q = 997;

  private int m;
  private long rm;
  private long patternHash;

  public RabinKarp(String pattern) {
    m = pattern.length();
    Q = longRandomPrime();

    rm = 1;
    for (int i = 1; i <= m - 1; i++) {
      rm = (R * rm) % Q;
    }
    patternHash = hash(pattern, m);
  }

  private long hash(String key, int m) {
    long h = 0;
    for (int j = 0; j < m; j++) {
      h = (R * h + key.charAt(j)) % Q;
    }
    return h;
  }

  // A random 31-bit prime
  private static long longRandomPrime() {
    BigInteger prime = BigInteger.probablePrime(31, new Random());
    return prime.longValue();
  }

  public int search(String text) {
    int n = text.length();
    long textHash = hash(text, m);
    if (patternHash == textHash) {
      return 0;
    }

    for (int i = m; i < n; i++) {
      textHash = (textHash + Q - rm * text.charAt(i - m) % Q) % Q;
      textHash = (textHash * R + text.charAt(i)) % Q;
      if (patternHash == textHash) {
        return i - m + 1;
      }
    }

    return n;
  }
}
