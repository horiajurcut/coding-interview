package algs;

import java.util.Arrays;
import java.util.Collections;

public class Quicksort {

  private static int CUTOFF = 10;

  public static Comparable select(Comparable[] a, int k) {
    Collections.shuffle(Arrays.asList(a));

    int low = 0;
    int high = a.length - 1;

    while (high > low) {
      int j = partition(a, low, high);
      if (j < k) {
        low = j + 1;
      } else if (j > k) {
        high = j - 1;
      } else {
        return a[k];
      }
    }

    return a[k];
  }

  public static void sort(Comparable[] a) {
    Collections.shuffle(Arrays.asList(a));
    sort(a, 0, a.length - 1);
  }

  public static void threeWaySort(Comparable[] a) {
    Collections.shuffle(Arrays.asList(a));
    threeWaySort(a, 0, a.length - 1);
  }

  private static void sort(Comparable[] a, int low, int high) {
    if (high <= low + CUTOFF - 1) {
      InsertionSort.sort(a, low, high);
      return;
    }
    int j = partition(a, low, high); // j is already in place after partitioning
    sort(a, low, j - 1);
    sort(a, j + 1, high);
  }

  private static void threeWaySort(Comparable[] a, int low, int high) {
    if (high < low) {
      return;
    }

    int lt = low;
    int gt = high;
    int i = low;
    Comparable v = a[low];

    while (i <= gt) {
      int cmp = a[i].compareTo(v);
      if (cmp < 0) {
        exchange(a, lt++, i++);
      } else if (cmp > 0) {
        exchange(a, i, gt--);
      } else {
        i++;
      }
    }

    threeWaySort(a, low, lt - 1);
    threeWaySort(a, gt + 1, high);
  }

  private static int partition(Comparable[] a, int low, int high) {
    int i = low;
    int j = high + 1;

    while (true) {
      while (less(a[++i], a[low])) {
        if (i == high) {
          break;
        }
      }
      while (less(a[low], a[--j])) {
        if (j == low) {
          break;
        }
      }
      if (i >= j) {
        break;
      }
      exchange(a, i, j);
    }

    exchange(a, low, j);
    return j;
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
