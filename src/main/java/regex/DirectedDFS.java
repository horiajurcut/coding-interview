package regex;

import graphs.Digraph;

public class DirectedDFS {

  private boolean[] marked;  // marked[v] = true if v is reachable from source (or sources)
  private int count;         // number of vertices reachable from s

  public DirectedDFS(Digraph g, int s) {
    marked = new boolean[g.vertices()];
    dfs(g, s);
  }

  public DirectedDFS(Digraph g, Iterable<Integer> sources) {
    marked = new boolean[g.vertices()];
    for (int v : sources) {
      if (!marked[v]) {
        dfs(g, v);
      }
    }
  }

  private void dfs(Digraph g, int v) {
    ++count;
    marked[v] = true;
    for (int w : g.adjacent(v)) {
      if (!marked[w]) {
        dfs(g, w);
      }
    }
  }

  public boolean marked(int v) {
    return marked[v];
  }

  public int count() {
    return count;
  }
}
