package ctci.chpater_five.conversion;

public class Question {

  public static int bitSwapRequired(int a, int b) {
    int count = 0;
    for (int c = a ^ b; c != 0; c = c >> 1) {
      count += c & 1;
    }
    return count;
  }

  // Optimized code
  public static int bitSwap(int a, int b) {
    int count = 0;
    for (int c = a ^ b; c != 0; c = c & (c - 1)) {
      count++;
    }
    return count;
  }
}

