package ctci.chapter_four.bst_sequences;

import ctci.chapter_four.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;

public class QuestionB {

  public ArrayList<LinkedList<TreeNode>> allSequences;

  public QuestionB(TreeNode root) {
    allSequences = new ArrayList<>();
    LinkedList<TreeNode> pre = new LinkedList<>();
    LinkedList<TreeNode> post = new LinkedList<>();

    buildSequences(pre, post, root);
  }

  private void buildSequences(LinkedList<TreeNode> pre, LinkedList<TreeNode> post, TreeNode root) {
    pre.add(root);

    if (root.left != null) {
      post.add(root.left);
    }

    if (root.right != null) {
      post.add(root.right);
    }

    if (post.isEmpty()) {
      allSequences.add(pre);
      return;
    }

    for (TreeNode node : post) {
      LinkedList<TreeNode> preTemp = (LinkedList<TreeNode>) pre.clone();
      LinkedList<TreeNode> postTemp = (LinkedList<TreeNode>) post.clone();

      postTemp.remove(node);
      buildSequences(preTemp, postTemp, node);
    }
  }

  public static void main(String[] args) {
    TreeNode node = new TreeNode(100);
    int[] array = {100, 50, 20, 75, 150, 120, 170};
    for (int a : array) {
      node.insertInOrder(a);
    }

    QuestionB q = new QuestionB(node);
    for (LinkedList<TreeNode> list : q.allSequences) {
      System.out.println(list);
    }
    System.out.println(q.allSequences.size());
  }

}
