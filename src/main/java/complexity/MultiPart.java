package complexity;

public class MultiPart {

  /**
   * In this method we do A chunks of work then B chunks of work.
   * Time complexity is O(A + B)
   */
  private static void addRuntime(int[] x, int[] y) {
    for (int i : x) {
      System.out.println(i);
    }

    for (int j : y) {
      System.out.println(j);
    }
  }

  /**
   * In this method we do B chunks of work for every element in A.
   * Time Complexity is O(A * B)
   */
  private static void multiplyRuntime(int[] x, int[] y) {
    for (int i : x) {
      for (int j : y) {
        System.out.println(i + ", " + j);
      }
    }
  }

  public static void main(String[] args) {
    int[] a = { 1, 2, 3 };
    int[] b = { 4, 5, 6 };

    addRuntime(a, b);
    System.out.println("---------------");
    multiplyRuntime(a, b);
  }
}
