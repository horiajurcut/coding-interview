package algs;

public class RedBlackTree<Key extends Comparable<Key>, Value> {

  // https://www.cs.princeton.edu/~rs/talks/LLRB/RedBlack.pdf
  // https://algs4.cs.princeton.edu/33balanced/RedBlackBST.java.html

  private static final boolean RED = true;
  private static final boolean BLACK = false;

  private Node root;

  private class Node {
    Key key;
    Value value;
    Node left;
    Node right;
    boolean color; // color of parent link
    int count;

    public Node(Key key, Value value, boolean color) {
      this.key = key;
      this.value = value;
      this.color = color;
    }
  }

  private boolean isRed(Node node) {
    return node != null && node.color == RED;
  }

  private Node rotateLeft(Node node) {
    assert isRed(node.right);

    Node red = node.right;
    node.right = red.left;
    red.left = node;
    red.color = node.color;
    node.color = RED;

    return red;
  }

  private Node rotateRight(Node node) {
    assert isRed(node.left);
    Node red = node.left;
    red.left = node.right;
    node.right = red;
    red.color = node.color;
    node.color = RED;

    return red;
  }

  private void flipColors(Node node) {
    assert !isRed(node);
    assert isRed(node.left);
    assert isRed(node.right);

    node.left.color = BLACK;
    node.right.color = BLACK;
    node.color = RED;
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

  public void put(Key key, Value value) {
    root = put(root, key, value);
  }

  private Node put(Node search, Key key, Value value) {
    if (search == null) {
      return new Node(key, value, RED);
    }

    int cmp = key.compareTo(search.key);
    if (cmp < 0) {
      search.left = put(search.left, key, value);
    } else if (cmp > 0) {
      search.right = put(search.right, key, value);
    } else {
      search.value = value;
    }

    if (isRed(search.right) && !isRed(search.left)) {
      rotateLeft(search);
    }
    if (isRed(search.left) && isRed(search.left.left)) {
      rotateRight(search);
    }
    if (isRed(search.left) && isRed(search.right)) {
      flipColors(search);
    }

    return search;
  }
}
