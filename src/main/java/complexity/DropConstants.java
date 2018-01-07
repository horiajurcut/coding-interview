package complexity;

public class DropConstants {

  private static void minMax1(int[] a) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;

    for (int x : a) {
      if (x < min) {
        min = x;
      }
      if (x > max) {
        max = x;
      }
    }

    System.out.println(
        String.format("MinMax1: min = %d, max = %d", min, max));
  }

  private static void minMax2(int[] a) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;

    for (int x : a) {
      if (x < min) {
        min = x;
      }
    }

    for (int x : a) {
      if (x > max) {
        max = x;
      }
    }

    System.out.println(
        String.format("MinMax1: min = %d, max = %d", min, max));
  }

  public static void main(String[] args) {
    int[] values = {1, 56, 2, -1, 89, 7};
    long start;
    long end;

    start = System.currentTimeMillis();
    minMax1(values);
    end = System.currentTimeMillis();
    System.out.println(String.format("Time to execute MinMax1 = %d ms", end - start));

    start = System.currentTimeMillis();
    minMax2(values);
    end = System.currentTimeMillis();
    System.out.println(String.format("Time to execute MinMax2 = %d ms", end - start));
  }
}
