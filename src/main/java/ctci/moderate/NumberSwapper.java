package ctci.moderate;

public class NumberSwapper {

  private static int[] swap(int a, int b) {
    a = a - b;
    b = a + b;
    a = b - a;

    return new int[]{a, b};
  }

  private static int[] swapBits(int a, int b) {
    a = a ^ b;
    b = a ^ b;
    a = a ^ b;

    return new int[]{a, b};
  }

  public static void main(String[] args) {
    int a = 4;
    int b = 9;
    System.out.println("a = " + a + ", b = " + b);

    int[] result = swap(a, b);
    a = result[0];
    b = result[1];
    System.out.println("a = " + a + ", b = " + b);

    int[] resultBits = swapBits(a, b);
    a = resultBits[0];
    b = resultBits[1];
    System.out.println("a = " + a + ", b = " + b);
  }
}
