package ctci.chapter_four.common_ancestor;

import ctci.chapter_four.TreeNode;

public class QuestionC {

  public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (!covers(root, p) || !covers(root, q)) {
      return null;
    }
    return ancestorHelper(root, p, q);
  }
  private static TreeNode ancestorHelper(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) {
      return root;
    }

    boolean pIsOnLeft = covers(root.left, p);
    boolean qIsOnLeft = covers(root.left, q);

    if (pIsOnLeft != qIsOnLeft) {
      return root;  // nodes are on different sides
    }

    TreeNode childSide = pIsOnLeft ? root.left : root.right;
    return ancestorHelper(childSide, p, q);
  }

  private static boolean covers(TreeNode root, TreeNode p) {
    if (root == null) {
      return false;
    }
    if (root == p) {
      return true;
    }
    return covers(root.left, p) || covers(root.right, p);
  }
}

