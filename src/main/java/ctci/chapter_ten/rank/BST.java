package ctci.chapter_ten.rank;

public class BST<Key extends Comparable<Key>, Value> {

  private Node root;

  private class Node {
    Key key;
    Value value;

    Node left;
    Node right;

    int count;

    public Node(Key key, Value value) {
      this.key = key;
      this.value = value;
    }
  }

  public void put(Key key, Value value) {
    root = put(root, key, value);
  }

  private Node put(Node search, Key key, Value value) {
    if (search == null) {
      return new Node(key, value);
    }

    int cmp = key.compareTo(search.key);

    if (cmp < 0) {
      search.left = put(search.left, key, value);
    } else if (cmp > 0) {
      search.right = put(search.right, key, value);
    } else {
      search.value = value;
    }

    search.count = 1 + size(search.left) + size(search.right);

    return search;
  }

  public int size() {
    return size(root);
  }

  private int size(Node search) {
    if (search == null) {
      return 0;
    }

    return search.count;
  }

  public int rank(Key key) {
    return rank(root, key);
  }

  private int rank(Node search, Key key) {
    if (search == null) {
      return 0;
    }
    int cmp = key.compareTo(search.key);

    if (cmp < 0) {
      return rank(search.left, key);
    } else if (cmp > 0) {
      return 1 + size(search.left) + rank(search.right, key);
    } else {
      return size(search.left);
    }
  }
}
