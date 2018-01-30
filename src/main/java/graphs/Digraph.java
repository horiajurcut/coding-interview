package graphs;

public class Digraph {
  private int v;
  private int e;
  private Bag<Integer>[] adj;

  public Digraph(int v) {
    this.v = v;
    this.e = 0;
    adj = (Bag<Integer>[]) new Bag[v];
    for (int i = 0; i < this.v; i++) {
      adj[i] = new Bag<>();
    }
  }

  public void addEdge(int v, int w) {
    adj[v].add(w);
    this.e += 1;
  }

  public Iterable<Integer> adjacent(int v) {
    return adj[v]; // Bag implements Iterable
  }

  public int vertices() {
    return v;
  }

  public int edges() {
    return e;
  }
}
