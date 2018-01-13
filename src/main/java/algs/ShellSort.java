package algs;

public class ShellSort {

  public static void sort(Comparable[] a) {
    int n = a.length;

    // pick starting h based on 3x+1 sequence
    int h = 1;
    while (h < n / 3) {
      h = 3 * h + 1;
    }

    while (h >= 1) {
      // h-sort the array
      for (int i = h; i < n; i++) {
        for (int j = i; j >= h; j = j - h) {
          if (less(a[j], a[j - h])) {
            exchange(a, j, j - h);
          }
        }
      }
      h = h / 3;
    }
  }

  private static boolean less(Comparable x, Comparable y) {
    return x.compareTo(y) < 0;
  }

  private static void exchange(Comparable[] a, int i, int j) {
    Comparable swap = a[i];
    a[i] = a[j];
    a[j] = swap;
  }
}
