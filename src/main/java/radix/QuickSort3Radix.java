package radix;

public class QuickSort3Radix {

  public static void sort(String[] a) {
    sort(a, 0, a.length - 1, 0);
  }

  private static void sort(String[] a, int low, int high, int d) {
    if (high <= low) {
      return;
    }

    int lt = low;
    int gt = high;
    int v = charAt(a[low], d);
    int i = low + 1;

    while (i <= gt) {
      int t = charAt(a[i], d);
      if (t < v) {
        exchange(a, lt++, i++);
      } else if (t > v) {
        exchange(a, i, gt--);
      } else {
        i++;
      }
    }

    sort(a, low, lt - 1, d);
    if (v >= 0) {
      sort(a, lt, gt, d + 1);
    }
    sort(a, gt + 1, high, d);
  }

  private static int charAt(String s, int d) {
    assert d >= 0 && d <= s.length();
    if (d == s.length()) return -1;
    return s.charAt(d);
  }

  private static void exchange(String[] a, int i, int j) {
    String temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
}
