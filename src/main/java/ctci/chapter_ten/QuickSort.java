package ctci.chapter_ten;

import java.util.Arrays;
import java.util.Collections;

public class QuickSort {

  public static void sort(Comparable[] a) {
    Collections.shuffle(Arrays.asList(a));
    sort(a, 0, a.length - 1);
  }

  private static void sort(Comparable[] a, int low, int high) {
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

    sort(a, low, lt - 1);
    sort(a, gt + 1, high);
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
