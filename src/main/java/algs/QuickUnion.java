package algs;

public class QuickUnion {
  private int[] id;

  public QuickUnion(int n) {
    id = new int[n];
    for (int i = 0; i < id.length; i++) {
      id[i] = i;
    }
  }

  private int root(int i) {
    while (id[i] != i) {
      i = id[i];
    }
    return i;
  }

  public boolean isConnected(int p, int q) {
    return root(p) == root(q);
  }

  public void union(int p, int q) {
    int pRoot = root(p);
    int qRoot = root(q);
    id[pRoot] = qRoot;
  }
}
