package algs;

public class HeapSort {

  public static void sort(Comparable[] pq) {
    int size = pq.length;

    for (int k = size / 2; k >= 1; k--) {
      sink(pq, k, size);
    }

    while (size > 1) {
      exchange(pq, 1, size);
      sink(pq, 1, --size);
    }
  }

  private static void sink(Comparable[] pq, int k, int size) {
    while (2 * k <= size) {
      int j = 2 * k;

      if (j < size && less(pq, j, j+1)) {
        j++;
      }

      if (!less(pq, k, j)) {
        break; // Heap Order
      }

      exchange(pq, k, j);
      k = j;
    }
  }

  private static boolean less(Comparable[] pq, int i, int j) { // 0-indexed array
    return pq[i - 1].compareTo(pq[j - 1]) < 0;
  }

  private static void exchange(Comparable[] pq, int i, int j) { // 0-indexed array
    Comparable swap = pq[i - 1];
    pq[i - 1] = pq[j - 1];
    pq[j - 1] = swap;
  }
}
