package mst;

import graphs.Queue;

public class KruskalMST implements MinimumSpanningTree {

  private Queue<Edge> mst = new Queue<>();

  public KruskalMST(EdgeWeightedGraph g) {
    MinPQ<Edge> pq = new MinPQ<>();
    for (Edge e: g.edges()) {
      pq.insert(e);
    }

    UnionFind unionFind = new UnionFind(g.vertices());
    while (!pq.isEmpty() && mst.size() < g.vertices() - 1) {
      Edge e = pq.delMin();
      int v = e.either();
      int w = e.other(v);

      if (!unionFind.isConnected(v, w)) {
        unionFind.union(v, w);
        mst.enqueue(e);
      }
    }
  }

  public Iterable<Edge> edges() {
    return mst;
  }

  @Override
  public double weight() {
    return 0;
  }
}
