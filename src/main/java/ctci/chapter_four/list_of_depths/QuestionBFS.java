package ctci.chapter_four.list_of_depths;

import ctci.chapter_four.TreeNode;
import ctci.utils.AssortedMethods;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class QuestionBFS {

  public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
    ArrayList<LinkedList<TreeNode>> lists = new ArrayList<>();
    LinkedList<TreeNode> current = new LinkedList<>();
    if (root != null) {
      current.add(root);
    }
    while (current.size() > 0) {
      lists.add(current);
      LinkedList<TreeNode> parents = current;
      current = new LinkedList<>();
      for (TreeNode parent : parents) {
        if (parent.left != null) {
          current.add(parent.left);
        }
        if (parent.right != null) {
          current.add(parent.right);
        }
      }
    }
    return lists;
  }

  public static void printResult(ArrayList<LinkedList<TreeNode>> result){
    int depth = 0;
    for(LinkedList<TreeNode> entry : result) {
      Iterator<TreeNode> i = entry.listIterator();
      System.out.print("Link list at depth " + depth + ":");
      while(i.hasNext()){
        System.out.print(" " + i.next().data);
      }
      System.out.println();
      depth++;
    }
  }

  public static void main(String[] args) {
    int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    TreeNode root = AssortedMethods.createTreeFromArray(nodes_flattened);
    ArrayList<LinkedList<TreeNode>> list = createLevelLinkedList(root);
    printResult(list);
  }
}

