package complexity;

public class RecursiveRuntime {

  /**
   * For a recursive function with multiple calls the runtime will often look like
   * O(branches ^ depth)
   */
  static int f(int n) {
    System.out.println(String.format("call %d", n));

    if (n <= 1) {
      return 1;
    }
    return f(n - 1) + f(n - 1);
  }

  public static void main(String[] args) {
    int needle = 4;
    System.out.println(String.format("f(%d) = %d", needle, f(needle)));
  }
}
