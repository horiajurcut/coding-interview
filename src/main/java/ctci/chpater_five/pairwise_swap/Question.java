package ctci.chpater_five.pairwise_swap;

public class Question {

  public static int swapOddEvenBits(int x) {
    return (((x & 0xaaaaaaaa) >>> 1) | (x & 0x55555555) << 1);
  }
}

