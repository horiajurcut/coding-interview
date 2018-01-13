package algs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

  private int[] a;

  static class Triplet {
    int x;
    int y;
    int z;

    Triplet(int x, int y, int z) {
      this.x = x;
      this.y = y;
      this.z = z;
    }
  }

  ThreeSum(int[] a) {
    this.a = a;
    Arrays.sort(this.a);
  }

  public List<Triplet> triplets(int sum) {
    List<Triplet> triplets = new ArrayList<Triplet>();

    for (int i = 0; i < this.a.length; i++) {
      for (int j = i + 1; j < this.a.length; j++) {
        int indexElement = BinarySearch.binarySearch(this.a, -(this.a[i] + this.a[j]));
        if (indexElement != -1 && a[indexElement] > a[i] && a[indexElement] > a[j]) {
          triplets.add(new Triplet(a[i], a[j], a[indexElement]));
        }
      }
    }

    return triplets;
  }
}
