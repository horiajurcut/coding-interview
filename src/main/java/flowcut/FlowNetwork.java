package flowcut;

import graphs.Bag;

public class FlowNetwork {

  private final int v;
  private Bag<FlowEdge>[] adj;
  private int edges;

  public FlowNetwork(int v) {
    this.v = v;
    adj = (Bag<FlowEdge>[]) new Bag[v];
    for (int i = 0; i < this.v; i++) {
      adj[i] = new Bag<>();
    }
  }

  public void addEdge(FlowEdge e) {
    int v = e.from();
    int w = e.to();
    adj[v].add(e);
    adj[w].add(e);
    edges += 2;
  }

  public Iterable<FlowEdge> adjacent(int v) {
    return adj[v];
  }

  public int vertices() {
    return v;
  }

  public int edges() {
    return edges;
  }
}
