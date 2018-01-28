package graphs;

public class ConnectedComponents {

  private boolean[] marked;
  private int[] id;
  private int count;

  public ConnectedComponents(Graph g) {
    marked = new boolean[g.vertices()];
    id = new int[g.vertices()];
    for (int v = 0; v < g.vertices(); v++) {
      if (!marked[v]) {
        dfs(g, v);
        count++;
      }
    }
  }

  public int count() {
    return count;
  }

  public int id(int v) {
    return id[v];
  }

  private void dfs(Graph g, int v) {
    marked[v] = true;
    id[v] = count;
    for (int w : g.adjacent(v)) {
      if (!marked[w]) {
        dfs(g, w);
      }
    }
  }
}
