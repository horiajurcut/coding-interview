package ctci.chapter_four.common_ancestor;

import ctci.chapter_four.TreeNode;

public class QuestionA {

  public static TreeNode commonAncestor(TreeNode p, TreeNode q) {
    int delta = depth(p) - depth(q);
    TreeNode first = delta > 0 ? q : p; // shallower node
    TreeNode second = delta > 0 ? p : q; // deeper node
    second = goUpBy(second, Math.abs(delta));

    while (first != second && first != null && second != null) {
      first = first.parent;
      second = second.parent;
    }
    return first == null || second == null ? null : first;
  }

  private static TreeNode goUpBy(TreeNode node, int delta) {
    while (delta > 0 && node != null) {
      node = node.parent;
      --delta;
    }
    return node;
  }

  private static int depth(TreeNode node) {
    int depth = 0;
    while (node != null) {
      node = node.parent;
      depth++;
    }
    return depth;
  }
}

