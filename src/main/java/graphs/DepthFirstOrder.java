package graphs;

public class DepthFirstOrder {

  private boolean[] marked;
  private Stack<Integer> reversePost;

  public DepthFirstOrder(Digraph g) {
    reversePost = new Stack<>();
    marked = new boolean[g.vertices()];
    for (int v = 0; v < g.vertices(); v++) {
      if (!marked[v]) {
        dfs(g, v);
      }
    }
  }

  private void dfs(Digraph g, int v) {
    marked[v] = true;
    for (int w : g.adjacent(v)) {
      if (!marked[w]) {
        dfs(g, w);
      }
    }
    reversePost.push(v);
  }

  public Iterable<Integer> reversePost() {
    return reversePost;
  }
}
