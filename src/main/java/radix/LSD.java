package radix;

public class LSD {

  public static void sort(String[] a, int w) { // fixed length w strings
    int r = 256;
    int n = a.length;
    String[] aux = new String[n];

    for (int d = w - 1; d >= 0; d--) { // from right to left
      int[] count = new int[r + 1];

      for (int i = 0; i < n; i++) {
        count[a[i].charAt(d) + 1]++;
      }
      for (int rx = 0; rx < r; rx++) {
        count[rx + 1] += count[rx];
      }
      for (int i = 0; i < n; i++) {
        aux[count[a[i].charAt(d)]++] = a[i];
      }
      for (int i = 0; i < n; i++) {
        a[i] = aux[i];
      }
    }
  }

  // https://algs4.cs.princeton.edu/51radix/LSD.java.html
}
