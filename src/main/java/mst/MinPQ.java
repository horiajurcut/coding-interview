package mst;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MinPQ<Key> implements Iterable<Key> {

  private Key[] pq;
  private int n;
  private Comparator<Key> comparator;

  public MinPQ(int initCapacity) {
    pq = (Key[]) new Object[initCapacity + 1];
    n = 0;
  }

  public MinPQ() {
    this(1);
  }

  public MinPQ(int initCapacity, Comparator<Key> comparator) {
    this.comparator = comparator;
    pq = (Key[]) new Object[initCapacity + 1];
    n = 0;
  }

  public MinPQ(Comparator<Key> comparator) {
    this(1, comparator);
  }

  public MinPQ(Key[] keys) {
    n = keys.length;
    pq = (Key[]) new Object[keys.length + 1];
    for (int i = 0; i < n; i++) {
      pq[i + 1] = keys[i];
    }
    for (int k = n / 2; k >= 1; k--) {
      sink(k);
    }

    assert isMinHeap();
  }

  public boolean isEmpty() {
    return n == 0;
  }

  public int size() {
    return n;
  }

  /**
   * Returns the smallest key on the priority queue.
   *
   * @return Key smallest key
   * @throws NoSuchElementException priority queue must have at least one element
   */
  public Key min() {
    if (isEmpty()) {
      throw new NoSuchElementException("Priority queue underflow");
    }
    return pq[1];
  }

  /**
   * Add a new key to the priority queue.
   *
   * @param key to be inserted
   */
  public void insert(Key key) {
    if (n == pq.length - 1) {
      resize(2 * pq.length);
    }

    pq[++n] = key;
    swim(n);

    assert isMinHeap();
  }

  public Key delMin() {
    if (isEmpty()) {
      throw new NoSuchElementException("Priority queue underflow");
    }
    Key min = pq[1];
    exchange(1, n--);
    sink(1);
    pq[n + 1] = null;

    if ((n > 0) && (n == (pq.length - 1) / 4)) {
      resize(pq.length / 2);
    }

    return min;
  }

  @Override
  public Iterator<Key> iterator() {
    return null;
  }

  private void resize(int capacity) {
    assert capacity > n;
    Key[] temp = (Key[]) new Object[capacity];
    for (int i = 1; i <= n; i++) {
      temp[i] = pq[i];
    }
    pq = temp;
  }

  private boolean greater(int i, int j) {
    if (comparator == null) {
      return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
    } else {
      return comparator.compare(pq[i], pq[j]) > 0;
    }
  }

  /**
   * Swap keys at positions i and j in the priority queue.
   *
   * @param i index in pq
   * @param j index in pq
   */
  private void exchange(int i, int j) {
    Key swap = pq[i];
    pq[i] = pq[j];
    pq[j] = swap;
  }

  /**
   * Returns true if pq[1..N] a min heap, false otherwise.
   *
   * @return boolean is pq a min heap?
   */
  private boolean isMinHeap() {
    return isMinHeap(1);
  }

  private boolean isMinHeap(int k) {
    if (k > n) {
      return true;
    }

    int left = 2 * k;
    int right = 2 * k + 1;

    if (left <= n && greater(k, left)) {
      return false;
    }
    if (right <= n && greater(k, right)) {
      return false;
    }

    return isMinHeap(left) && isMinHeap(right);
  }

  private void swim(int k) {
    while (k > 1 && greater(k / 2, k)) {
      exchange(k, k / 2);
      k = k / 2;
    }
  }

  private void sink(int k) {
    while (2 * k <= n) {
      int j = 2 * k;
      if (j < n && greater(j, j++)) {
        j++;
      }
      exchange(k, j);
      k = j;
    }
  }
}
