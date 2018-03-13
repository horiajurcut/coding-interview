package ctci.chapter_four.build_order;

import ctci.chapter_four.Graph;
import ctci.utils.Stack;

public class QuestionDFS {

  private static int[] marked;
  private static Stack<Integer> stack;

  public static Graph testCase() {
    Graph g = new Graph(6);

    g.add(0, 3);
    g.add(5, 1);
    g.add(1, 3);
    g.add(5, 0);
    g.add(3, 2);

    return g;
  }

  public static boolean dfs(Graph g, int v) {
    if (marked[v] == 1) {
      return false;
    }

    if (marked[v] == 0) {
      marked[v] = 1; // partial
      for (int w : g.adjacent(v)) {
        if (!dfs(g, w)) {
          return false;
        }
      }
      marked[v] = 2;
      stack.push(v);
    }
    return true;
  }

  public static boolean order(Graph g) {
    for (int v = 0; v < g.vertices(); v++) {
      if (marked[v] == 0) {
        if (!dfs(g, v)) {
          return false;
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Graph g = testCase();
    stack = new Stack<>();
    marked = new int[g.vertices()];
    if (order(g)) {
      System.out.println("Solution found");
    }
  }
}

