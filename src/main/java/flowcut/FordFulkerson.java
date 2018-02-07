package flowcut;

import graphs.Queue;

public class FordFulkerson {

  private boolean[] marked;   // true if s->v path in residual network
  private FlowEdge[] edgeTo;  // last edge on s->v path
  private double value;       // value of the flow

  public FordFulkerson(FlowNetwork g, int s, int t) {
    value = 0.0;
    while (hasAugmentingPath(g, s, t)) {
      double bottleneck = Double.POSITIVE_INFINITY;
      for (int v = t; v != s; v = edgeTo[v].other(v)) {
        bottleneck = Math.min(bottleneck, edgeTo[v].residualCapacityTo(v));
      }
      for (int v = t; v != s; v = edgeTo[v].other(v)) {
        edgeTo[v].addResidualFlowTo(v, bottleneck);
      }
      value += bottleneck;
    }
  }

  private boolean hasAugmentingPath(FlowNetwork g, int s, int t) {
    edgeTo = new FlowEdge[g.vertices()];
    marked = new boolean[g.vertices()];

    Queue<Integer> q = new Queue<>();
    q.enqueue(s);
    marked[s] = true;

    while (!q.isEmpty()) {
      int v = q.dequeue();

      for (FlowEdge e : g.adjacent(v)) {
        int w = e.other(v);
        if (e.residualCapacityTo(w) > 0 && !marked[w]) {
          edgeTo[w] = e;
          marked[w] = true;
          q.enqueue(w);
        }
      }
    }

    return marked[t];
  }

  public double value() {
    return value;
  }

  public boolean inCut(int v) {
    return marked[v]; // is v reachable from s in residual network
  }
}
