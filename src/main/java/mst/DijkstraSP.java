package mst;

import graphs.Stack;

public class DijkstraSP {

  private DirectedEdge[] edgeTo;
  private double[] distTo;
  private IndexMinPQ<Double> pq;

  public DijkstraSP(EdgeWeightedDigraph g, int s) {
    edgeTo = new DirectedEdge[g.vertices()];
    distTo = new double[g.vertices()];
    pq = new IndexMinPQ<>(g.vertices());

    for (int v = 0; v < g.vertices(); v++) {
      distTo[v] = Double.POSITIVE_INFINITY;
    }
    distTo[s] = 0.0;

    pq.insert(s, 0.0);
    while (!pq.isEmpty()) {
      int v = pq.deleteMin();
      for (DirectedEdge e: g.adjacent(v)) {
        relax(e);
      }
    }
  }

  private void relax(DirectedEdge e) {
    int v = e.from();
    int w = e.to();

    if (distTo[w] > distTo[v] + e.weight()) {
      distTo[w] = distTo[v] + e.weight();
      edgeTo[w] = e;
      if (pq.contains(w)) {
        pq.decreaseKey(w, distTo[w]);
      } else {
        pq.insert(w, distTo[w]);
      }
    }
  }

  public double distTo(int v) {
    return distTo[v];
  }

  public Iterable<DirectedEdge> pathTo(int v) {
    Stack<DirectedEdge> path = new Stack<>();
    for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
      path.push(e);
    }
    return path;
  }
}
