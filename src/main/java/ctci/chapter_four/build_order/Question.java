package ctci.chapter_four.build_order;

import ctci.chapter_four.Graph;
import graphs.Queue;

public class Question {

  public static Graph testCase() {
    Graph g = new Graph(6);

    g.add(0, 3);
    g.add(5, 1);
    g.add(1, 3);
    g.add(5, 0);
    g.add(3, 2);

    return g;
  }

  public static void compile() {
    Graph g = testCase();
    Queue<Integer> q = new Queue<>();
    boolean isProcessing = true;
    while (isProcessing) {
      int count = 0;
      for (int v = 0; v < g.vertices(); v++) {
        if (g.incoming(v) == 0) {
          q.enqueue(v);
          g.removeOutgoing(v);
          ++count;
        }
      }
      if (count == 0) {
        isProcessing = false;
      }
    }
    if (q.size() == g.vertices()) {
      System.out.println("Solution found");
    }

    for (Integer aQ : q) {
      System.out.println(aQ);
    }
  }

  public static void main(String[] args) {
    compile();
  }
}

