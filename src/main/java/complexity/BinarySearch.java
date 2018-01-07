package complexity;

import java.util.Arrays;

public class BinarySearch {

  private static int search(int x, int s, int e, int[] v) {
    System.out.println(String.format("x = %d, s = %d, e = %d", x, s, e));

    if (s > e) {
      return -1;
    }

    if (x == v[s + ((e - s) / 2)]) {
      return (s + ((e - s) / 2));
    } else if (x < v[s + ((e - s) / 2)]) {
      return search(x, s, e / 2 - 1, v);
    } else if (x > v[s + ((e - s) / 2)]) {
      return search(x, s + ((e - s) / 2) + 1, e, v);
    }

    // Can't find element
    return -1;
  }

  public static void main(String args[]) {
    int[] test1 = { -4, -3, 1, 2, 4, 6, 8, 9, 11, 12 };
    int needle = 43;
    System.out.println(String.format("Element %d is at position %d in array %s",
        needle, search(needle, 0, test1.length - 1, test1), Arrays.toString(test1)));
  }
}
