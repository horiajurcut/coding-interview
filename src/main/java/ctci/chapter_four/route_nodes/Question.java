package ctci.chapter_four.route_nodes;

import ctci.chapter_four.Graph;
import ctci.utils.Queue;

public class Question {

  public static boolean isRouteBetween(Graph g, int a, int b) {
    if (a == b) {
      return true;
    }

    Queue<Integer> q = new Queue<>();
    boolean[] marked = new boolean[g.vertices()];

    q.add(a);
    marked[a] = true;

    while (!q.isEmpty()) {
      int v = q.remove();
      for (Integer w : g.adjacent(v)) {
        if (!marked[w]) {
          if (w == b) {
            return true;
          } else {
            marked[w] = true;
            q.add(w);
          }
        }
      }
      marked[v] = true;
    }
    return false;
  }

  public static void main(String[] args) {
    Graph g = new Graph(6);

    g.add(0, 1);
    g.add(0, 2);
    g.add(0, 3);
    g.add(3, 4);
    g.add(4, 5);

    System.out.println(isRouteBetween(g, 3, 5));
  }
}

