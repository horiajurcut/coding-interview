package mst;

import graphs.Bag;

public class EdgeWeightedGraph {

  private final int v;
  private final Bag<Edge>[] adj;

  public EdgeWeightedGraph(int v) {
    this.v = v;
    this.adj = (Bag<Edge>[]) new Bag[v];
    for (int w = 0; w < this.v; w++) {
      adj[w] = new Bag<>();
    }
  }

  public void addEdge(Edge e) {
    int v = e.either();
    int w = e.other(v);
    adj[v].add(e);
    adj[w].add(e);
  }

  public Iterable<Edge> adjacent(int v) {
    return adj[v];
  }

  public Iterable<Edge> edges() {
    return adj[1]; // TODO: Check out implementation
  }

  public int vertices() {
    return v;
  }
}
