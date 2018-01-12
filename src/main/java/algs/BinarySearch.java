package algs;

public final class BinarySearch {

  public static int binarySearch(int[] a, int key) {
    int low = 0;
    int high = a.length - 1;

    while (low <= high) {
      int mid  = low + (high - low) / 2; // no int overflow
      if (key < a[mid]) {
        high = mid - 1;
      } else if (key > a[mid]) {
        low = mid + 1;
      } else {
        return mid;
      }
    }

    return -1;
  }
}
