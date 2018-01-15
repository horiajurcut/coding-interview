package algs;

import java.util.Arrays;
import java.util.Comparator;

public class MergeSortComparator {

  private static final int CUTOFF = 7;

  public static void merge(Object[] a, Object[] aux, int low, int mid, int high, Comparator c) {
    assert isSorted(a, low, mid, c);
    assert isSorted(a, mid + 1, high, c);

    // Copy unsorted array (with two sorted halves) to aux
    for (int k = low; k <= high; k++) {
      aux[k] = a[k];
    }

    int i = low;
    int j = mid + 1;
    for (int k = low; k <= high; k++) {
      if (i > mid) {
        a[k] = aux[j++];
      } else if (j > high) {
        a[k] = aux[i++];
      } else if (less(c, aux[j], aux[i])) {
        a[k] = aux[j++];
      } else {
        a[k] = aux[i++];
      }
    }

    assert isSorted(a, low, high, c);
  }

  public static void sort(Object[] a, Object[] aux, int low, int high, Comparator c) {
    if (high <= low + CUTOFF - 1) {
      Arrays.sort(a, low, high); // This should be insert sort with a comparator
      return;
    }
    int mid = low + (high - low) / 2;
    sort(a, aux, low, mid, c);
    sort(a, aux, mid + 1, high, c);
    // for partially sorted arrays; skip merge
    // if biggest item in first half <= smallest item in second half
    if (!less(c, a[mid + 1], a[mid])) {
      return;
    }
    merge(a, aux, low, mid, high, c);
  }

  public static void sort(Object[] a, Comparator c) {
    Object[] aux = new Object[a.length];
    sort(a, aux, 0, a.length - 1, c);
  }

  private static boolean isSorted(Object[] a, int i, int j, Comparator c) {
    int k;
    for (k = i; k < j && less(c, a[k], a[k+1]); k++);
    return k == (j - 1);
  }

  private static boolean less(Comparator c, Object x, Object y) {
    return c.compare(x, y) < 0;
  }

  private static void exchange(Comparable[] a, int i, int j) {
    Comparable swap = a[i];
    a[i] = a[j];
    a[j] = swap;
  }
}
