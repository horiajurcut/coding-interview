package algs;

import org.junit.Assert;
import org.junit.Test;

public class TestQuickFind {

  @Test
  public void testQuickFind() {
    QuickFind quickFind = new QuickFind(10);

    quickFind.union(1, 2);
    quickFind.union(3, 4);
    quickFind.union(5, 6);
    quickFind.union(7, 8);
    quickFind.union(1, 9);
    quickFind.union(5, 0);
    quickFind.union(8, 2);
    quickFind.union(9, 7);

    Assert.assertEquals(false, quickFind.isConnected(9, 4));
    Assert.assertEquals(true, quickFind.isConnected(2, 9));
    Assert.assertEquals(true, quickFind.isConnected(0, 6));
  }
}
