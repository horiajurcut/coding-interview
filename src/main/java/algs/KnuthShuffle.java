package algs;

public class KnuthShuffle {

  public static void shuffle(Object[] a) {
    int n = a.length;

    for (int i = 0; i < n; i++) {
      int r = (int)(Math.random() * i); // Replace with uniform random
      exchange(a, i, r);
    }
  }

  private static void exchange(Object[] a, int i, int j) {
    Object swap = a[i];
    a[i] = a[j];
    a[j] = swap;
  }
}
