package ctci.chapter_four.random_node;

import java.util.Random;

public class TreeNode {
  private int data;
  public TreeNode left;
  public TreeNode right;
  private int size;

  public TreeNode(int data) {
    this.data = data;
    size = 1;
  }

  public int size() {
    return size;
  }

  public int data() {
    return data;
  }

  public void insertInOrder(int data) {
    if (data <= this.data) {
      if (left == null) {
        left = new TreeNode(data);
      } else {
        left.insertInOrder(data);
      }
    } else {
      if (right == null) {
        right = new TreeNode(data);
      } else {
        right.insertInOrder(data);
      }
    }
    ++size;
  }

  public TreeNode find(int data) {
    if (data == this.data) {
      return this;
    } else if (data <= this.data) {
      return left != null ? left.find(data) : null;
    } else if (data > data) {
      return right != null ? right.find(data) : null;
    }
    return null;
  }

  public TreeNode getRandomNode() {
    int leftSize = left == null ? 0 : left.size();
    Random random = new Random();
    int index = random.nextInt(size);
    if (index < leftSize) {
      return left.getRandomNode();
    } else if (index == leftSize) {
      return this;
    } else {
      return right.getRandomNode();
    }
  }
}

