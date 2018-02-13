package radix;

public class MSD {

  private static final int R = 256;      // extended ASCII alphabet size
  private static final int CUTOFF = 15;  // cutoff to insertion sort

  public static void sort(String[] a) {
    String[] aux = new String[a.length];
    sort(a, aux, 0, a.length - 1, 0);
  }

  public static void sort(String[] a, String[] aux, int low, int high, int d) {
    if (high <= low) {
      return;
    }
    int[] count = new int[R + 2];

    for (int i = low; i <= high; i++) {
      count[charAt(a[i], d) + 2]++;
    }
    for (int r = 0; r < R + 1; r++) {
      count[r + 1] += count[r];
    }
    for (int i = low; i <= high; i++) {
      aux[count[charAt(a[i], d) + 1]++] = a[i];
    }
    for (int i = low; i <= high; i++) {
      a[i] = aux[i - low];
    }

    for (int r = 0; r < R; r++) {
      sort(a, aux, low + count[r], low + count[r + 1] - 1, d + 1);
    }
  }

  public static void sort(String[] a, int low, int high, int d) {
    for (int i = low; i <= high; i++) {
      for (int j = i; j > low && less(a[j], a[j - 1], d); j--) {
        exchange(a, j, j - 1);
      }
    }
  }

  private static int charAt(String s, int d) {
    if (d < s.length()) {
      return s.charAt(d);
    } else {
      return -1;
    }
  }

  private static boolean less(String v, String w, int d) {
    return v.substring(d).compareTo(w.substring(d)) < 0;
  }

  // exchange a[i] and a[j]
  private static void exchange(String[] a, int i, int j) {
    String temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
}
