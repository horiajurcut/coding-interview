package ctci.chapter_four.paths_with_sum;

import ctci.chapter_four.TreeNode;
import java.util.HashMap;

public class QuestionB {

  public static int countPathsWithSum(TreeNode root, int targetSum) {
    return countPathsWithSum(root, targetSum, 0, new HashMap<>());
  }

  public static int countPathsWithSum(TreeNode node, int targetSum, int runningSum, HashMap<Integer, Integer> pathCount) {
    if (node == null) return 0; // Base case

    runningSum += node.data;

    /* Count paths with sum ending at the current node. */
    int sum = runningSum - targetSum;
    int totalPaths = pathCount.getOrDefault(sum, 0);

    /* If runningSum equals targetSum, then one additional path starts at root. Add in this path.*/
    if (runningSum == targetSum) {
      totalPaths++;
    }

    /* Add runningSum to pathCounts. */
    incrementHashTable(pathCount, runningSum, 1);

    /* Count paths with sum on the left and right. */
    totalPaths += countPathsWithSum(node.left, targetSum, runningSum, pathCount);
    totalPaths += countPathsWithSum(node.right, targetSum, runningSum, pathCount);

    incrementHashTable(pathCount, runningSum, -1); // Remove runningSum
    return totalPaths;
  }

  public static void incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int delta) {
    int newCount = hashTable.getOrDefault(key, 0) + delta;
    if (newCount == 0) { // Remove when zero to reduce space usage
      hashTable.remove(key);
    } else {
      hashTable.put(key, newCount);
    }
  }
}
