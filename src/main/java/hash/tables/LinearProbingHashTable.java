package hash.tables;

public class LinearProbingHashTable<Key, Value> {

  private int m = 30001;
  private Value[] values = (Value[]) new Object[m];
  private Key[] keys = (Key[]) new Object[m];

  private int hash(Key key) {
    return (key.hashCode() & Integer.MAX_VALUE) % m;
  }

  public void put(Key key, Value value) {
    int i;
    for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
      if (key.equals(keys[i])) {
        break;
      }
    }

    keys[i] = key;
    values[i] = value;
  }

  public Value get(Key key) {
    for (int i = hash(key); keys[i] != null; i = (i + 1) % m) {
      if (key.equals(keys[i])) {
        return values[i];
      }
    }
    return null;
  }
}
