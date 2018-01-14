package algs;

public class MergeSort {

  private static final int CUTOFF = 7;

  public static void merge(Comparable[] a, Comparable[] aux, int low, int mid, int high) {
    assert isSorted(a, low, mid);
    assert isSorted(a, mid + 1, high);

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
      } else if (less(aux[j], aux[i])) {
        a[k] = aux[j++];
      } else {
        a[k] = aux[i++];
      }
    }

    assert isSorted(a, low, high);
  }

  public static void sort(Comparable[] a, Comparable[] aux, int low, int high) {
    if (high <= low + CUTOFF - 1) {
      InsertionSort.sort(a, low, high);
      return;
    }
    int mid = low + (high - low) / 2;
    sort(a, aux, low, mid);
    sort(a, aux, mid + 1, high);
    // for partially sorted arrays; skip merge
    // if biggest item in first half <= smallest item in second half
    if (!less(a[mid + 1], a[mid])) {
      return;
    }
    merge(a, aux, low, mid, high);
  }

  public static void iSort(Comparable[] a) {
    int n = a.length;
    Comparable[] aux = new Comparable[n];

    for (int size = 1; size < n; size *= 2) {
      for (int lo = 0; lo < n - size; lo += 2 * size) {
        merge(a, aux, lo, lo + size - 1, Math.min(lo + 2 * size - 1, n - 1));
      }
    }
  }

  public static void sort(Comparable[] a) {
    Comparable[] aux = new Comparable[a.length];
    sort(a, aux, 0, a.length - 1);
  }

  private static boolean isSorted(Comparable[] a, int i, int j) {
    int k;
    for (k = i; k < j && less(a[k], a[k+1]); k++);
    return k == (j - 1);
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
