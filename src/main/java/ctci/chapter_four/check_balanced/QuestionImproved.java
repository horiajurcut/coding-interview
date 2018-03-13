package ctci.chapter_four.check_balanced;

import ctci.chapter_four.TreeNode;

public class QuestionImproved {

  public static int getHeight(TreeNode root) {
    if (root == null) {
      return -1;
    }

    int leftHeight = getHeight(root.left);
    if (leftHeight == Integer.MIN_VALUE) {
      return Integer.MIN_VALUE;
    }

    int rightHeight = getHeight(root.right);
    if (rightHeight == Integer.MIN_VALUE) {
      return Integer.MIN_VALUE;
    }

    int deltaHeight = leftHeight - rightHeight;
    if (Math.abs(deltaHeight) > 1) {
      return Integer.MIN_VALUE;
    } else {
      return Math.max(leftHeight, rightHeight) + 1;
    }
  }

  public static boolean isBalanced(TreeNode root) {
    return getHeight(root) != Integer.MIN_VALUE;
  }

  public static void main(String[] args) {
    // Create balanced tree
    int[] array = {0, 1, 2, 3, 5, 6, 7, 8, 9, 10};
    TreeNode root = TreeNode.createMinimalBST(array);


    System.out.println("Is balanced? " + isBalanced(root));

    root.insertInOrder(4); // Add 4 to make it unbalanced

    System.out.println("Is balanced? " + isBalanced(root));
  }
}

