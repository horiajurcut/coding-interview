package mst;

import graphs.Stack;

public class Topological {

  private boolean[] marked;
  private Stack<Integer> reversePost;

  public Topological(EdgeWeightedDigraph g) {
    reversePost = new Stack<>();
    marked = new boolean[g.vertices()];
    for (int v = 0; v < g.vertices(); v++) {
      if (!marked[v]) {
        dfs(g, v);
      }
    }
  }

  private void dfs(EdgeWeightedDigraph g, int v) {
    marked[v] = true;
    for (DirectedEdge e : g.adjacent(v)) {
      if (!marked[e.to()]) {
        dfs(g, e.to());
      }
    }
    reversePost.push(v);
  }

  public Iterable<Integer> reversePost() {
    return reversePost;
  }

}
