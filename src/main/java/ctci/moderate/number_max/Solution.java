package ctci.moderate.number_max;

public class Solution {

  private static int flip(int bit) {
    // bit is either 0 or 1
    return 1 ^ bit;
  }

  private static int sign(int a) {
    // the left most bit (the sign) gets copied in every position (1 or 0)
    // 1 for negative and 0 for positive
    // flip returns 1 for positive and 0 for negative
    return flip((a >> 31) & 0x1);
  }

  private static int getMaxNaive(int a, int b) {
    int k = sign(a - b);
    int q = flip(k);

    return a * k + b * q;
  }

  private static int getMax(int a, int b) {
    int c = a - b;

    int sa = sign(a);
    int sb = sign(b);
    int sc = sign(c);

    int use_sign_of_a = sa ^ sb;
    int use_sign_of_c = flip(sa ^ sb);

    int k = use_sign_of_a * sa + use_sign_of_c * sc;
    int q = flip(k);

    return a * k + b * q;
  }

  public static void main(String[] args) {
    int a = 26;
    int b = -15;

    System.out.println("max_naive(" + a + ", " + b + ") = " + getMaxNaive(a, b));
    System.out.println("max(" + a + ", " + b + ") = " + getMax(a, b));

    a = -15;
    b = 2147483647;

    System.out.println("max_naive(" + a + ", " + b + ") = " + getMaxNaive(a, b));
    System.out.println("max(" + a + ", " + b + ") = " + getMax(a, b));
  }
}
