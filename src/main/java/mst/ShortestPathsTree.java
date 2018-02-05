package mst;

import graphs.Stack;

public class ShortestPathsTree {

  private DirectedEdge[] edgeTo;
  private double[] distTo;

  public ShortestPathsTree(EdgeWeightedDigraph g) {
    edgeTo = new DirectedEdge[g.vertices()];
    distTo = new double[g.vertices()];
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

  private void relax(DirectedEdge e) {
    int v = e.from();
    int w = e.to();

    if (distTo[w] > distTo[v] + e.weight()) {
      distTo[w] = distTo[v] + e.weight();
      edgeTo[w] = e;
    }
  }
}
