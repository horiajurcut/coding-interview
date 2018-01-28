package graphs;

public class DepthFirstPaths implements Paths {

  private boolean[] marked;
  private int[] edgeTo;
  private int s;

  public DepthFirstPaths(Graph g, int s) {
    this.marked = new boolean[g.vertices()];
    this.edgeTo = new int[g.vertices()];
    this.s = s;

    dfs(g, this.s);
  }

  private void dfs(Graph g, int v) {
    marked[v] = true;
    for (int w : g.adjacent(v)) {
      if (!marked[w]) {
        dfs(g, w);
        edgeTo[w] = v;
      }
    }
  }

  @Override
  public boolean hasPathTo(int v) {
    return marked[v];
  }

  @Override
  public Iterable<Integer> pathTo(int v) {
    if (!hasPathTo(v)) {
      return null;
    }
    Stack<Integer> path = new Stack<>(); // Using a stack since we keep the path in reverse order
    for (int x = v; x != s; x = edgeTo[x]) {
      path.push(x);
    }
    return path;
  }
}
