package algs;

import algs.ThreeSum.Triplet;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class TestThreeSum {

  @Test
  public void testThreeSum() {
    int[] a = { 30, -40, -20, -10, 40, 0, 10, 5 };
    ThreeSum threeSum = new ThreeSum(a);
    List<Triplet> actualTriplets = threeSum.triplets(0);

    Assert.assertEquals(4, actualTriplets.size());
  }
}
