package algs;

import org.junit.Assert;
import org.junit.Test;

public class TestSelectionSort {

  @Test
  public void testSelectionSort() {
    Integer[] a = { 4, 8, 13, 0, 7, 22, 54, 33 };
    SelectionSort.sort(a);

    Assert.assertEquals(Integer.valueOf(0), a[0]);
    Assert.assertEquals(Integer.valueOf(54), a[7]);
  }
}
