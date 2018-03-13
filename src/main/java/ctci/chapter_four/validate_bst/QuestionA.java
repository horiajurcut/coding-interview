package ctci.chapter_four.validate_bst;

import ctci.chapter_four.TreeNode;

public class QuestionA {

  private static Integer last = null;

  public static boolean checkBST(TreeNode node) {
    return checkBST(node, true);
  }

  public static boolean checkBST(TreeNode node, boolean isLeft) {
    if (node == null) {
      return true;
    }

    if (!checkBST(node.left, true)) {
      return false;
    }

    // Check current
    if (last != null) {
      if (isLeft) {
        // left child "is allowed" be equal to parent.
        if (node.data < last) {
          return false;
        }
      } else {
        // Right child "is not allowed" be equal to parent.
        if (node.data <= last) {
          return false;
        }
      }
    }
    last = node.data;

    if (!checkBST(node.right, false)) {
      return false;
    }

    return true;
  }

  public static void main(String[] args) {
    int[] array = {Integer.MIN_VALUE, Integer.MAX_VALUE - 2, Integer.MAX_VALUE - 1,
        Integer.MAX_VALUE};
    TreeNode node = TreeNode.createMinimalBST(array);
    // node.left.data = 5;
    // node.left.right.data = 3;
    System.out.println(checkBST(node));

    test();
  }

  public static void test() {
    TreeNode node;
    boolean condition;
    System.out.println("test cases for equals condition.");

		// Expect true: for left child: node.data <= last_printed.
    int[] array2 = {1, 2, 3, 4};
    node = TreeNode.createMinimalBST(array2);
    node.left.data = 2;
    last = null;
    condition = checkBST(node);
    System.out.println("should be true: " + condition);

		// Expect false: for right child: node.data <= last_printed
    int[] array3 = {1, 2, 3, 4};
    node = TreeNode.createMinimalBST(array3);
    node.right.data = 2;
    last = null;
    condition = checkBST(node);
    System.out.println("should be false: " + condition);
  }
}

