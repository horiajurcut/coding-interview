package algs;

public class BinaryHeap<Key extends Comparable<Key>> {

  private Key[] heap;
  private int size;

  public BinaryHeap(int capacity) {
    heap = (Key[]) new Comparable[capacity + 1]; // 1-indexed array
  }

  public void insert(Key key) {
    heap[++size] = key;
    swim(size);
  }

  public Key delMax() {
    Key max = heap[1];
    exchange(1, size--);
    sink(1);
    heap[size + 1] = null; // free up space
    return max;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  private void swim(int k) {
    while (k > 1 && less(k / 2, k)) {
      exchange(k, k / 2);
      k = k / 2;
    }
  }

  private void sink(int k) {
    while (2 * k <= size) {
      int j = 2 * k;

      if (j < size && less(j, j + 1)) {
        j++;
      }
      if (!less(k, j)) { // Order has been restored
        break;
      }
      exchange(k, j);
      k = j;
    }
  }

  private boolean less(int i, int j) {
    return heap[i].compareTo(heap[j]) < 0;
  }

  private void exchange(int i, int j) {
    Key swap = heap[i];
    heap[i] = heap[j];
    heap[j] = swap;
  }
}
