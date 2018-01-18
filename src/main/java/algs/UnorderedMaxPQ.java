package algs;

public class UnorderedMaxPQ<Key extends Comparable<Key>> {
  private Key[] pq;
  private int size;

  public UnorderedMaxPQ(int capacity) {
    pq = (Key[]) new Comparable[capacity];
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void insert(Key k) {
    pq[size++] = k;
  }

  public Key deleteMax() {
    int max = 0;
    for (int i = 1; i < size; i++) {
      if (less(max, i)) {
        max = i;
      }
    }
    exchange(pq, max, size - 1);
    return pq[--size]; // we don't remove the last element
  }

  private boolean less(int x, int y) {
    return pq[x].compareTo(pq[y]) < 0;
  }

  private static void exchange(Comparable[] a, int i, int j) {
    Comparable swap = a[i];
    a[i] = a[j];
    a[j] = swap;
  }
}
