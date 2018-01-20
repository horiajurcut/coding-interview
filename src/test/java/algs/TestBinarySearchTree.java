package algs;

import org.junit.Assert;
import org.junit.Test;

public class TestBinarySearchTree {

  @Test
  public void testBinarySearchTree() {
    BinarySearchTree<String, Integer> bst = new BinarySearchTree<>();

    bst.put("X", 1);
    bst.put("D", 2);
    bst.put("G", 3);
    bst.put("A", 1);
    bst.put("P", 2);
    bst.put("A", 1);
    bst.put("Z", 3);

    Assert.assertEquals("A", bst.min());
    Assert.assertEquals("Z", bst.max());
  }
}
