package graphs;

public class Graph {

  private int v;
  private int e;
  private Bag<Integer>[] adj;

  public Graph(int v) {
    this.v = v;
    this.e = 0;
    adj = (Bag<Integer>[]) new Bag[v];
    for (int i = 0; i < this.v; i++) {
      adj[i] = new Bag<>();
    }
  }

  public void addEdge(int v, int w) {
    adj[v].add(w);
    adj[w].add(v);
    this.e += 2;
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

  @Override
  public String toString() {
    return super.toString();
  }

  public static int degree(Graph g, int v) {
    int degree = 0;
    for (int w : g.adjacent(v)) {
      ++degree;
    }
    return degree;
  }

  public static int maxDegree(Graph g) {
    int max = 0;
    for (int v = 0; v < g.vertices(); v++) {
      if (degree(g, v) > max) {
        max = degree(g, v);
      }
    }
    return max;
  }

  public static double averageDegree(Graph g) {
    return 2.0 * g.edges() / g.vertices();
  }

  public static int numberOfSelfLoops(Graph g) {
    int count = 0;
    for (int v = 0; v < g.vertices(); v++) {
      for (int w : g.adjacent(v)) {
        if (v == w) {
          count++;
        }
      }
    }
    return count / 2; // every edge is counted twice
  }
}
