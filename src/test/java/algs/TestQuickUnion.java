package algs;

import org.junit.Assert;
import org.junit.Test;

public class TestQuickUnion {

  @Test
  public void testQuickUnion() {
    QuickUnion quickUnion = new QuickUnion(10);

    quickUnion.union(1, 2);
    quickUnion.union(3, 4);
    quickUnion.union(5, 6);
    quickUnion.union(7, 8);
    quickUnion.union(1, 9);
    quickUnion.union(5, 0);
    quickUnion.union(8, 2);
    quickUnion.union(9, 7);

    Assert.assertEquals(false, quickUnion.isConnected(9, 4));
    Assert.assertEquals(true, quickUnion.isConnected(2, 9));
    Assert.assertEquals(true, quickUnion.isConnected(0, 6));
  }
}
