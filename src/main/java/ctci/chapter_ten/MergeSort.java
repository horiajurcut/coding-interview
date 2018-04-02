package ctci.chapter_ten;

import java.util.Arrays;

public class MergeSort {

  private static final int CUTOFF = 7;

  private static void merge(Comparable[] a, Comparable[] aux, int low, int mid, int high) {
    System.arraycopy(a, low, aux, low, high + 1 - low);

    int i = low;
    int j = mid + 1;

    for (int k = low; k <= high; k++) {
      if (i > mid) {
        a[k] = aux[j++];
      } else if (j > high) {
        a[k] = aux[i++];
      } else if (less(a[j], a[i])) {
        a[k] = a[j++];
      } else {
        a[k] = aux[i++];
      }
    }
  }

  private static void sort(Comparable[] a, Comparable[] aux, int low, int high) {
    if (high <= low + CUTOFF - 1) {
      Arrays.sort(a, low, high);
      return;
    }

    int mid = low + (high - low) / 2;

    sort(a, aux, low, mid);
    sort(a, aux, mid + 1, high);

    // Skip the merge operation for partially sorted arrays
    if (!less(a[mid + 1], a[mid])) {
      return;
    }

    merge(a, aux, low, mid, high);
  }

  private static boolean less(Comparable x, Comparable y) {
    return x.compareTo(y) < 0;
  }

  public static void sort(Comparable[] a) {
    Comparable[] aux = new Comparable[a.length];
    sort(a, aux, 0, a.length - 1);
  }
}
