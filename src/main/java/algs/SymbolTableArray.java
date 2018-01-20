package algs;

public class SymbolTableArray<Key extends Comparable<Key>, Value> {

  private Key[] keys;
  private Value[] values;
  private int size = 0;

  public SymbolTableArray(int capacity) {
    keys = (Key[]) new Comparable[capacity];
    values = (Value[]) new Object[capacity];
  }

  public void put(Key key, Value value) {
    int i = rank(key);
    for (int j = size - 1; j >= i; j--) {
      keys[j + 1] = keys[j];
      values[j + 1] = values[j];
    }

    keys[i] = key;
    values[i] = value;

    ++size;
  }

  public Value get(Key key) {
    if (isEmpty()) {
      return null;
    }

    int i = rank(key);
    if (i < size && keys[i].compareTo(key) == 0) {
      return values[i];
    } else {
      return null;
    }
  }

  public void delete(Key key) {
    if (isEmpty()) {
      return;
    }

    int i = rank(key);
    if (i >= size || keys[i].compareTo(key) != 0) {
      return;
    }

    for (int j = i; j < size - 1; j++) {
      keys[j] = keys[j + 1];
      values[j] = values[j + 1];
    }

    keys[size - 1] = null;
    values[size - 1] = null;

    --size;
  }

  public boolean contains(Key key) {
    return get(key) != null;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  public Iterable<Key> keys() {
    return null;
  }

  private int rank(Key key) {
    int low = 0;
    int high = size - 1;

    while (low <= high) {
      int middle = low + (high - low) / 2;
      int cmp = key.compareTo(keys[middle]);

      if (cmp < 0) {
        high = middle - 1;
      } else if (cmp > 0) {
        low = middle + 1;
      } else {
        return middle;
      }
    }

    return low;
  }
}
