package compression;

import mst.MinPQ;

public class Huffman {

  private static final int R = 256;

  private static class Node implements Comparable<Node> {

    private char ch;
    private int freq;
    private final Node left;
    private final Node right;

    public Node(char ch, int freq, Node left, Node right) {
      this.ch = ch;
      this.freq = freq;
      this.left = left;
      this.right = right;
    }

    public boolean isLeaf() {
      return left == null && right == null;
    }

    @Override
    public int compareTo(Node that) {
      return this.freq - that.freq;
    }
  }

  public void expand() {
    Node root = readTrie();
    int n = BinaryStdIn.readInt();

    for (int i = 0; i < n; i++) {
      Node x = root;
      while (!x.isLeaf()) {
        if (!BinaryStdIn.readBoolean()) {
          x = x.left;
        } else {
          x = x.right;
        }
      }
      BinaryStdOut.write(x.ch, 8);
    }

    BinaryStdOut.close();
  }

  private static void writeTrie(Node x) {
    if (x.isLeaf()) {
      BinaryStdOut.write(true);
      BinaryStdOut.write(x.ch, 8);
      return;
    }

    BinaryStdOut.write(false);
    writeTrie(x.left);
    writeTrie(x.right);
  }

  private static Node readTrie() {
    if (BinaryStdIn.readBoolean()) {
      char c = BinaryStdIn.readChar(8);
      return new Node(c, 0, null, null);
    }

    Node left = readTrie();
    Node right = readTrie();

    return new Node('\0', 0, left, right);
  }

  private static Node buildTrie(int[] freq) {
    MinPQ<Node> pq = new MinPQ<>();
    for (char i = 0; i < R; i++) {
      if (freq[i] > 0) {
        pq.insert(new Node(i, freq[i], null, null));
      }
    }

    while (pq.size() > 1) {
      Node left = pq.delMin();
      Node right = pq.delMin();
      Node parent = new Node('\0', left.freq + right.freq, left, right);
      pq.insert(parent);
    }

    return pq.delMin();
  }
}
