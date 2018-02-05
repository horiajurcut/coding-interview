package mst;

public class AcyclicSP {

  private DirectedEdge[] edgeTo;
  private double[] distTo;

  public AcyclicSP(EdgeWeightedDigraph g, int s) {
    edgeTo = new DirectedEdge[g.vertices()];
    distTo = new double[g.vertices()];

    for (int i = 0; i < g.vertices(); i++) {
      distTo[i] = Double.POSITIVE_INFINITY;
    }
    distTo[s] = 0.0;

    Topological topological = new Topological(g);
    for (int v : topological.reversePost()) {
      for (DirectedEdge e : g.adjacent(v)) {
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
    }
  }
}
