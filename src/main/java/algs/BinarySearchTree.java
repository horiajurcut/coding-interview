package algs;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {

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

  public Value get(Key key) {
    Node search = root;

    while (search != null) {
      int cmp = key.compareTo(search.key);
      if (cmp < 0) {
        search = search.left;
      } else if (cmp > 0) {
        search = search.right;
      } else {
        return search.value;
      }
    }

    return null;
  }

  public Key min() {
    Node search = root;
    while (search.left != null) {
      search = search.left;
    }
    return search.key;
  }

  public Node min(Node start) {
    while (start.left != null) {
      start= start.left;
    }
    return start;
  }

  public Key max() {
    Node search = root;
    while (search.right != null) {
      search = search.right;
    }
    return search.key;
  }

  public Key floor(Key key) {
    Node search = floor(root, key);
    if (search == null) {
      return null;
    }
    return search.key;
  }

  private Node floor(Node search, Key key) {
    if (search == null) {
      return null;
    }
    int cmp = key.compareTo(search.key);

    if (cmp == 0) {
      return search;
    }

    if (cmp < 0) {
      return floor(search.left, key);
    }

    Node t = floor(search.right, key);
    if (t != null) {
      return t;
    } else {
      return search;
    }
  }

  public Iterable<Key> keys() {
    Queue<Key> q = new LinkedList<>();
    inOrder(root, q);
    return q;
  }

  private void inOrder(Node search, Queue<Key> q) {
    if (search == null) {
      return;
    }
    inOrder(search.left, q);
    q.add(search.key);
    inOrder(search.right, q);
  }

  public void deleteMin() {
    root = deleteMin(root);
  }

  private Node deleteMin(Node search) {
    if (search.left == null) {
      return search.right;
    }
    search.left = deleteMin(search.left);
    search.count = 1 + size(search.left) + size(search.right);
    return search;
  }

  public void delete(Key key) {
    root = delete(root, key);
  }

  private Node delete(Node search, Key key) {
    if (search == null) {
      return null;
    }

    int cmp = key.compareTo(search.key);

    if (cmp < 0) {
      search.left = delete(search.left, key);
    } else if (cmp > 0) {
      search.right = delete(search.right, key);
    } else {
      if (search.right == null) {
        return search.left;
      }
      if (search.left == null) {
        return search.right;
      }

      Node t = search;
      search = min(t.right);
      search.right = deleteMin(t.right);
      search.left = t.left;
    }

    search.count = size(search.left) + size(search.right) + 1;
    return search;
  }
}
