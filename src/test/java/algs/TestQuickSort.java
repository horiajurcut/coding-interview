package algs;

import org.junit.Assert;
import org.junit.Test;

public class TestQuickSort {

  @Test
  public void testQuickSort() {
    Integer[] a = { 4, 8, 13, 0, 7, 22, 54, 33 };
    Quicksort.sort(a);

    Assert.assertEquals(Integer.valueOf(0), a[0]);
    Assert.assertEquals(Integer.valueOf(54), a[7]);
  }

  @Test
  public void testThreeWaySort() {
    Integer[] a = { 4, 8, 13, 0, 7, 22, 54, 33 };
    Quicksort.threeWaySort(a);

    Assert.assertEquals(Integer.valueOf(0), a[0]);
    Assert.assertEquals(Integer.valueOf(54), a[7]);
  }

  @Test
  public void testQuickSelect() {
    Integer[] a = { 4, 8, 13, 0, 7, 22, 54, 33 };
    Comparable kth = Quicksort.select(a, 3);

    Assert.assertEquals(Integer.valueOf(8), kth);
  }
}
