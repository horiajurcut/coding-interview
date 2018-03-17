package ctci.chpater_five.insertion;

import ctci.utils.AssortedMethods;

public class Question {

  public static int updateBits(int n, int m, int i, int j) {
    int allOnes = ~0;  // 1111111...
    int leftMask = allOnes << (j + 1);  // 11100000…
    int rightMask = ((1 << i) - 1);  // 00001000 - 00000001 = 00000111

    int mask = leftMask | rightMask;
    int nCleared = n & mask;
    int mShifted = m << i;  // 0110 << 3 = 0110000

    return nCleared | mShifted;
  }

  public static void main(String[] args) {
    int a = 103217;
    System.out.println(AssortedMethods.toFullBinaryString(a));
    int b = 13;
    System.out.println(AssortedMethods.toFullBinaryString(b));
    int c = updateBits(a, b, 4, 12);
    System.out.println(AssortedMethods.toFullBinaryString(c));
  }
}

