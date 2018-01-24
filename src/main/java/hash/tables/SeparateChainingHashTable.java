package hash.tables;

public class SeparateChainingHashTable<Key, Value> {

  private int m = 97; // number of chains
  private Node[] st = new Node[m]; // initialized with null?

  private static class Node {
    private Object key;
    private Object value;
    private Node next;

    Node(Object key, Object value, Node next) {
      this.key = key;
      this.value = value;
      this.next = next;
    }
  }

  private int hash(Key key) {
    return (key.hashCode() & Integer.MAX_VALUE) % m;
  }

  public Value get(Key key) {
    int i = hash(key);
    for (Node search = st[i]; search != null; search = search.next) {
      if (key.equals(search.key)) {
        return (Value) search.value;
      }
    }
    return null;
  }

  public void put(Key key, Value value) {
    int i = hash(key);
    for (Node search = st[i]; search != null; search = search.next) {
      if (key.equals(search.key)) {
        search.value = value;
        return;
      }
    }
    st[i] = new Node(key, value, st[i]);
  }
}
