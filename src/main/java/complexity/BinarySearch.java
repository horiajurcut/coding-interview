package complexity;

import java.util.Arrays;

public class BinarySearch {

  public static int search(int[] array, int x) {
    return search0(array, x, 0, array.length - 1);
  }

  private static int search0(int[] array, int x, int low, int high) {
    if (high < low) {
      return -1;
    }

    // int mid = (low + high) / 2; -> int overflow
    int mid = low + (high - low) / 2;

    if (x == array[mid]) {
      return mid;
    } else if (x < array[mid]) {
      return search0(array, x, low, mid - 1);
    } else {
      return search0(array, x, mid + 1, high);
    }
  }

  public static void main(String args[]) {
    int[] b = { 33, 2, 0, 5, -9, 7, 333, 8 };
    int[] a = { 4, 8, 13, 0, 7, 22, 54, 33 };

    Arrays.sort(b);

    for (int x : a) {
      System.out.println(String.format("Element %d is at position %d", x, search(b, x)));
    }
  }
}
