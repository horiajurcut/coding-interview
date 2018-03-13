package ctci.chapter_four.validate_bst;

import ctci.chapter_four.TreeNode;

public class QuestionB {

  public static boolean isBST(TreeNode node) {
    return isBST(node, null, null);
  }

  private static boolean isBST(TreeNode node, Integer min, Integer max) {
    if (node == null) {
      return true;
    }

    if ((min != null && node.data <= min) || (max != null && node.data > max)) {
      return false;
    }

    if (!isBST(node.left, min, node.data) || !isBST(node.right, node.data, max)) {
      return false;
    }

    return true;
  }
}

