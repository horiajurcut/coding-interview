package algs;

import org.junit.Assert;
import org.junit.Test;

public class TestQuickUnionWeights {

  @Test
  public void testQuickUnionWeights() {
    QuickUnionWeights quickUnionWeights = new QuickUnionWeights(10);

    quickUnionWeights.union(1, 2);
    quickUnionWeights.union(3, 4);
    quickUnionWeights.union(5, 6);
    quickUnionWeights.union(7, 8);
    quickUnionWeights.union(1, 9);
    quickUnionWeights.union(5, 0);
    quickUnionWeights.union(8, 2);
    quickUnionWeights.union(9, 7);

    Assert.assertEquals(false, quickUnionWeights.isConnected(9, 4));
    Assert.assertEquals(true, quickUnionWeights.isConnected(2, 9));
    Assert.assertEquals(true, quickUnionWeights.isConnected(0, 6));
  }
}
