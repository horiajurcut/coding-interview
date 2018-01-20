package algs;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

public class TestHeapSort {

  @Test
  public void testHeapSort() {
    Integer[] a = { 4, 8, 13, 0, 7, 22, 54, 33, 1, -10 };
    HeapSort.sort(a);
    System.out.println(Arrays.toString(a));

    Assert.assertEquals(Integer.valueOf(-10), a[0]);
    Assert.assertEquals(Integer.valueOf(54), a[a.length - 1]);
  }
}
