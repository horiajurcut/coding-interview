package ctci.chapter_four;

import graphs.Bag;

public class Graph {

  private int v;
  private int e;
  private Bag<Integer>[] adj;
  private int[] incoming;

  public Graph(int v) {
    this.v = v;
    this.e = 0;
    adj = (Bag<Integer>[]) new Bag[this.v];
    incoming = new int[this.v];
    for (int i = 0; i < this.v; i++) {
      adj[i] = new Bag<>();
      incoming[i] = 0;
    }
  }

  public void add(int v, int w) {
    adj[v].add(w);
    ++incoming[w];
    ++e;
  }

  public void removeOutgoing(int v) {
    for (int w : adj[v]) {
      --incoming[w];
    }
    incoming[v] = -1;
  }

  public Iterable<Integer> adjacent(int v) {
    return adj[v];
  }

  public int incoming(int v) {
    return incoming[v];
  }

  public int vertices() {
    return v;
  }

  public int edges() {
    return e;
  }
}
