package algs;

import org.junit.Assert;
import org.junit.Test;

public class TestQuickUnionPathCompression {

  @Test
  public void testQuickUnionPathCompression() {
    QuickUnionPathCompression quickUnionPathCompression = new QuickUnionPathCompression(10);

    quickUnionPathCompression.union(1, 2);
    quickUnionPathCompression.union(3, 4);
    quickUnionPathCompression.union(5, 6);
    quickUnionPathCompression.union(7, 8);
    quickUnionPathCompression.union(1, 9);
    quickUnionPathCompression.union(5, 0);
    quickUnionPathCompression.union(8, 2);
    quickUnionPathCompression.union(9, 7);

    Assert.assertEquals(false, quickUnionPathCompression.isConnected(9, 4));
    Assert.assertEquals(true, quickUnionPathCompression.isConnected(2, 9));
    Assert.assertEquals(true, quickUnionPathCompression.isConnected(0, 6));
  }
}
