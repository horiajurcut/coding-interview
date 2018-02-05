package mst;

import graphs.Queue;

public class LazyPrimMST {

  private boolean[] marked;  // MST vertices
  private Queue<Edge> mst;   // MST edges
  private MinPQ<Edge> pq;    // PQ of edges

  public LazyPrimMST(EdgeWeightedGraph g) {
    pq = new MinPQ<>();
    mst = new Queue<>();
    marked = new boolean[g.vertices()];
    visit(g, 0);

    while (!pq.isEmpty()) {
      Edge e = pq.delMin();

      int v = e.either();
      int w = e.other(v);

      if (marked[v] && marked[w]) {
        continue;
      }

      mst.enqueue(e);

      if (!marked[v]) {
        visit(g, v);
      }

      if (!marked[w]) {
        visit(g, w);
      }
    }
  }

  private void visit(EdgeWeightedGraph g, int vertex) {
    marked[vertex] = true;
    for (Edge e : g.adjacent(vertex)) {
      if (!marked[e.other(vertex)]) {
        pq.insert(e);
      }
    }
  }

  public Iterable<Edge> mst() {
    return mst;
  }
}
