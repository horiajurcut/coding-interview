package complexity;

public class SpaceComplexity {

  /**
   * This code takes O(n) time and O(n) space
   */
  private static int sum(int n) {
    if (n <= 0) {
      return 0;
    }
    return n + sum(n - 1);
  }

  /**
   * This code takes O(n) time and O(1) space.
   * Even though there are n calls to pairSum, they do no exist simultaneously on the call stack.
   */
  private static int pairSumSequence(int n) {
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += pairSum(i, i + 1);
    }
    return sum;
  }

  private static int pairSum(int a, int b) {
    return a + b;
  }

  public static void main(String[] args) {
    System.out.println(
        String.format("Sum of all consecutive numbers from 0 to 10 is: %d", sum(10)));
    System.out.println(
        String.format("Pair sum of all numbers from 0 to 10 is: %d", pairSumSequence(10)));
  }
}
