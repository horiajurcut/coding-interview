package ctci.chapter_four.paths_with_sum;

import ctci.chapter_four.TreeNode;

public class QuestionA {

  private static int countPathsWithSumFromNode(TreeNode node, int targetSum, int currentSum) {
    if (node == null) {
      return 0;
    }

    currentSum += node.data;

    int totalPaths = 0;
    if (currentSum == targetSum) {
      ++totalPaths;
    }
    totalPaths += countPathsWithSumFromNode(node.left, targetSum, currentSum);
    totalPaths += countPathsWithSumFromNode(node.right, targetSum, currentSum);

    return totalPaths;
  }

  static int countPathsWithSum(TreeNode root, int targetSum) {
    if (root == null) {
      return 0;
    }

    int pathsFromRoot = countPathsWithSumFromNode(root, targetSum, 0);
    int pathsOnLeft = countPathsWithSum(root.left, targetSum);
    int pathsOnRight = countPathsWithSum(root.right, targetSum);

    return pathsFromRoot + pathsOnLeft + pathsOnRight;
  }
}

