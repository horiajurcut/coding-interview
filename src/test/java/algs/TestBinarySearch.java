package algs;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

public class TestBinarySearch {

  @Test
  public void testBinarySearchIterative() {
    int[] a = { 4, 8, 13, 0, 7, 22, 54, 33 };
    Arrays.sort(a);

    Assert.assertEquals(7, BinarySearch.binarySearch(a, 54));
    Assert.assertEquals(-1, BinarySearch.binarySearch(a, 154));
    Assert.assertEquals(2, BinarySearch.binarySearch(a, 7));
    Assert.assertEquals(0, BinarySearch.binarySearch(a, 0));
    Assert.assertEquals(7, BinarySearch.binarySearch(a, 54));
  }
}
