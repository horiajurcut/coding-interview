package mst;

import graphs.Bag;

public class EdgeWeightedDigraph {

  private final int v;
  private final Bag<DirectedEdge>[] adj;

  public EdgeWeightedDigraph(int v) {
    this.v = v;
    this.adj = (Bag<DirectedEdge>[]) new Bag[v];
    for (int w = 0; w < this.v; w++) {
      adj[w] = new Bag<>();
    }
  }

  public void addEdge(DirectedEdge e) {
    int v = e.from();
    adj[v].add(e);
  }

  public Iterable<DirectedEdge> adjacent(int v) {
    return adj[v];
  }

  public int vertices() {
    return v;
  }
}
