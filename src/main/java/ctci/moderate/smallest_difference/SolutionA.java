package ctci.moderate.smallest_difference;

public class SolutionA {

  private static int smallestDifference(int[] a, int[] b) {
    if (a.length == 0 || b.length == 0) {
      return -1;
    }

    int min = Integer.MAX_VALUE;
    for (int i : a) {
      for (int j : b) {
        if (Math.abs(i - j) < min) {
          min = Math.abs(i - j);
        }
      }
    }

    return min;
  }

  public static void main(String[] args) {
    int[] array1 = {1, 3, 15, 11, 2};
    int[] array2 = {23, 127, 234, 19, 8};
    int difference = smallestDifference(array1, array2);

    System.out.println(difference);
  }
}
