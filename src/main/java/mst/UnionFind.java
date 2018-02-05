package mst;

public class UnionFind {

  private int id[];
  private int sz[];

  public UnionFind(int capacity) {
    this.id = new int[capacity];
    this.sz = new int[capacity];

    for (int i = 0; i < capacity; i++) {
      id[i] = i;
      sz[i] = 1;
    }
  }

  private int root (int i) {
    while (id[i] != i) {
      id[i] = id[id[i]];
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

    if (pRoot == qRoot) return; // Already connected

    if (sz[pRoot] >= sz[qRoot]) {
      id[qRoot] = pRoot;
      sz[pRoot] += sz[qRoot];
    } else {
      id[pRoot] = qRoot;
      sz[qRoot] += sz[pRoot];
    }
  }
}
