package mst;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IndexMinPQ<Key extends Comparable<Key>> implements Iterable<Integer> {

  private int maxN;    // Maximum number of elements in PQ
  private int n;       // Number of elements in PQ
  private int[] pq;    // Binary heap using 1-based indexing -> keys[pq[i]] = key at position i
  private int[] qp;    // Inverse of pq -> qp[pq[i]] = pq[qp[i]] = i
  private Key[] keys;  // keys[i] = priority of i (value in the node)

  public IndexMinPQ(int maximumCapacity) {
    if (maximumCapacity < 0) {
      throw new IllegalArgumentException();
    }
    this.maxN = maximumCapacity;
    this.n = 0;
    keys = (Key[]) new Comparable[maximumCapacity + 1];
    pq = new int[maximumCapacity + 1];
    qp = new int[maximumCapacity + 1];

    for (int i = 0; i <= maximumCapacity; i++) {
      qp[i] = -1;
    }
  }

  public boolean isEmpty() {
    return n == 0;
  }

  public boolean contains(int i) {
    if (i < 0 || i >= maxN) {
      throw new IllegalArgumentException();
    }
    return qp[i] != -1;
  }

  public int size() {
    return n;
  }

  public void insert(int i, Key key) {
    if (i < 0 || i >= maxN) {
      throw new IllegalArgumentException();
    }
    if (contains(i)) {
      throw new IllegalArgumentException("Index is already in the priority queue");
    }
    n++;
    qp[i] = n;
    pq[n] = i;
    keys[i] = key;
    swim(n);
  }

  public int minIndex() {
    if (n == 0) {
      throw new NoSuchElementException("Priority queue underflow");
    }
    return pq[1];
  }

  public Key minKey() {
    if (n == 0) {
      throw new NoSuchElementException("Priority queue underflow");
    }
    return keys[pq[1]];
  }

  public int deleteMin() {
    if (n == 0) {
      throw new NoSuchElementException("Priority queue underflow");
    }
    int min = pq[1];
    exchange(1, n--); // move to last position in queue
    sink(1); // make sure the priority queue is a MinPQ

    assert min == pq[n + 1];

    qp[min] = -1;
    keys[min] = null;
    pq[n + 1] = -1;

    return min; // returns the index associated with the minimum key
  }

  public Key keyOf(int i) {
    if (i < 0 || i >= maxN) {
      throw new IllegalArgumentException();
    }
    if (!contains(i)) {
      throw new NoSuchElementException("Index is not in the priority queue");
    } else {
      return keys[i];
    }
  }

  public void changeKey(int i, Key key) {
    if (i < 0 || i >= maxN) {
      throw new IllegalArgumentException();
    }
    if (!contains(i)) {
      throw new NoSuchElementException("Index is not in the priority queue");
    }
    keys[i] = key;
    swim(qp[i]);
    sink(qp[i]);
  }

  public void decreaseKey(int i, Key key) {
    if (i < 0 || i >= maxN) {
      throw new IllegalArgumentException();
    }
    if (!contains(i)) {
      throw new NoSuchElementException("Index is not in the priority queue");
    }
    if (keys[i].compareTo(key) <= 0) {
      throw new IllegalArgumentException("New key will not decrease the existing one");
    }
    keys[i] = key;
    swim(qp[i]);
  }

  public void increaseKey(int i, Key key) {
    if (i < 0 || i >= maxN) {
      throw new IllegalArgumentException();
    }
    if (!contains(i)) {
      throw new NoSuchElementException("Index is not in the priority queue");
    }
    if (keys[i].compareTo(key) >= 0) {
      throw new IllegalArgumentException("New key will not increase the existing one");
    }
    keys[i] = key;
    sink(qp[i]);
  }

  public void delete(int i) {
    if (i < 0 || i >= maxN) {
      throw new IllegalArgumentException();
    }
    if (!contains(i)) {
      throw new NoSuchElementException("Index is not in the priority queue");
    }
    int index = qp[i];
    exchange(index, n--);
    swim(index);
    sink(index);
    keys[i] = null;
    qp[i] = -1;
  }

  @Override
  public Iterator<Integer> iterator() {
    return new HeapIterator();
  }

  private boolean greater(int i, int j) {
    return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
  }

  private void exchange(int i, int j) {
    int swap = pq[i];
    pq[i] = pq[j];
    pq[j] = swap;
    qp[pq[i]] = i;
    qp[pq[j]] = j;
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
      if (j < n && greater(j, j + 1)) {
        j++;
      }
      if (!greater(k, j)) {
        break;
      }
      exchange(k, j);
      k = j;
    }
  }

  private class HeapIterator implements Iterator<Integer> {

    private IndexMinPQ<Key> copy;

    public HeapIterator() {
      copy = new IndexMinPQ<>(pq.length - 1);
      for (int i = 1; i <= n; i++) {
        copy.insert(pq[i], keys[pq[i]]);
      }
    }

    public boolean hasNext() {
      return !copy.isEmpty();
    }

    public Integer next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      return copy.deleteMin();
    }
  }
}
