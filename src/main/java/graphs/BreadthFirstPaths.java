package graphs;

public class BreadthFirstPaths implements Paths {

  private static final int INFINITY = Integer.MAX_VALUE;
  private boolean[] marked;
  private int[] edgeTo;
  private int[] distTo;
  private int s;

  public BreadthFirstPaths(Graph g, int s) {
    this.marked = new boolean[g.vertices()];
    this.edgeTo = new int[g.vertices()];
    this.distTo = new int[g.vertices()];
    this.s = s;

    bfs(g, this.s);
  }

  private void bfs(Graph g, int s) {
    Queue<Integer> q = new Queue<>();

    for (int v = 0; v < g.vertices(); v++) {
      distTo[v] = INFINITY;
    }

    distTo[s] = 0;
    marked[s] = true;
    q.enqueue(s);

    while (!q.isEmpty()) {
      int v = q.dequeue();
      for (int w : g.adjacent(v)) {
        if (!marked[w]) {
          marked[w] = true;
          distTo[w] = distTo[v] + 1;
          edgeTo[w] = v;
          q.enqueue(w);
        }
      }
    }
  }

  @Override
  public boolean hasPathTo(int v) {
    return marked[v];
  }

  public int distTo(int v) {
    return distTo[v];
  }

  @Override
  public Iterable<Integer> pathTo(int v) {
    if (!hasPathTo(v)) {
      return null;
    }
    Stack<Integer> path = new Stack<>();
    int x;
    for (x = v; distTo[x] != 0; x = edgeTo[x]) {
      path.push(x);
    }
    path.push(x);
    return path;
  }
}
