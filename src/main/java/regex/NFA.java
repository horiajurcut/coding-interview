package regex;

import graphs.Bag;
import graphs.Digraph;
import graphs.Stack;

public class NFA {

  private char[] re;
  private Digraph g;
  private int m;

  public NFA(String regexp) {
    m = regexp.length();
    re = regexp.toCharArray();
    g = buildEpsilonTransitionDigraph();
  }

  public boolean recognizes(String text) {
    Bag<Integer> pc = new Bag<>(); // all possible states the NFA could be in
    DirectedDFS dfs = new DirectedDFS(g, 0);

    for (int v = 0; v < g.vertices(); v++) {
      if (dfs.marked(v)) {
        pc.add(v);
      }
    }

    for (int i = 0; i < text.length(); i++) {
      Bag<Integer> match = new Bag<>();
      for (int v : pc) {
        if (v == m) {  // test to see if we reached accept state
          continue;
        }
        if ((re[v] == text.charAt(i)) || re[v] == '.') {  // wildcard also works
          match.add(v + 1);
        }
      }

      dfs = new DirectedDFS(g, match);
      pc = new Bag<>();
      for (int v = 0; v < g.vertices(); v++) {
        if (dfs.marked(v)) {
          pc.add(v);
        }
      }
    }

    for (int v : pc) {
      if (v == m) {
        return true;  // we made it to the accept state
      }
    }

    return false;
  }

  private Digraph buildEpsilonTransitionDigraph() {
    Digraph g = new Digraph(m + 1);
    Stack<Integer> ops = new Stack<>();

    for (int i = 0; i < m; i++) {
      int lp = i;

      if (re[i] == '(' || re[i] == '|') {
        ops.push(i);
      } else if (re[i] == ')') {
        int or = ops.pop();

        if (re[or] == '|') {  // what happens if we have multiple | on the stack?
          lp = ops.pop();
          g.addEdge(lp, or + 1);
          g.addEdge(or, i);
        } else {
          lp = or;
        }
      }

      if (i < m - 1 && re[i + 1] == '*') {
        g.addEdge(lp, i + 1);
        g.addEdge(i + 1, lp);
      }

      if (re[i] == '(' || re[i] == '*' || re[i] == ')') {
        g.addEdge(i, i + 1);
      }
    }

    return g;
  }
}
