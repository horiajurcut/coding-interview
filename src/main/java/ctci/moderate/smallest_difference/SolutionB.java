package ctci.moderate.smallest_difference;

import java.util.Arrays;

public class SolutionB {

  private static int smallestDifference(int[] a, int[] b) {
    Arrays.sort(a);
    Arrays.sort(b);

    int i = 0;
    int j = 0;

    int diff = Integer.MAX_VALUE;

    while (i < a.length && j < b.length) {
      if (Math.abs(a[i] - b[j]) < diff) {
        diff = Math.abs(a[i] - b[j]);
      }

      if (a[i] < b[j]) {
        i++;
      } else {
        j++;
      }
    }

    return diff;
  }

  public static void main(String[] args) {
    int[] array1 = {1, 3, 15, 11, 2};
    int[] array2 = {23, 127, 234, 19, 8};
    int difference = smallestDifference(array1, array2);

    System.out.println(difference);
  }
}
