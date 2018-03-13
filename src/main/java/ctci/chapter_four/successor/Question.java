package ctci.chapter_four.successor;

import ctci.chapter_four.TreeNode;

public class Question {

  public static TreeNode inOrderSuccessor(TreeNode node) {
    if (node == null) {
      return null;
    }

    if (node.right != null) {
      return leftMostChild(node.right);
    } else {
      TreeNode q = node;
      TreeNode p = q.parent;
      while (p != null && p.left != q) {
        q = p;
        p = p.parent;
      }
      return p;
    }
  }

  private static TreeNode leftMostChild(TreeNode node) {
    if (node == null) {
      return null;
    }
    while (node.left != null) {
      node = node.left;
    }
    return node;
  }
}

