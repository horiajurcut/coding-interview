package complexity;

import java.util.Arrays;

public class Exercises {

  /**
   * Runtime will be O(N + N) = O(2*N) = O(N)
   */
  static void e1(int[] a) {
    int sum = 0;
    int product = 1;
    for (int i : a) {
      sum += i;
    }
    for (int j : a) {
      product *= j;
    }
    System.out.println(String.format("Sum = %d, Product = %d", sum, product));
  }

  /**
   * Runtime will be O(N * N) = O(N^2)
   *
   * Combination, k = 2
   * 2 * n! / (k!(n-k)!) + n = 2 * (n-1)n / 2 + n = n ^ 2
   *
   * Permutation, k = 2
   * n! / (n-k)! + n = (n-1)n + n = n ^ 2
   */
  static void e2(int[] a) {
    for (int i : a) {
      for (int j : a) {
        System.out.println(String.format("i = %d, j = %d", i, j));
      }
    }
  }

  /**
   * For j:
   * 1st time -> N - 1
   * 2nd time -> N - 2
   * 3rd time -> N - 3
   *
   * Total = (N-1) + (N-2) + ... + 2 + 1 = (N-1)N/2 -> O(N(N-1)/2) -> drop constants and
   * non-dominant term -> O(N^2)
   *
   * Solution looks like half of a NxN matrix
   *
   * Second loop has a work average of N/2 (roughly) and it runs N times -> N*N/2 = N^2/2
   */
  static void e3(int[] a) {
    for (int i = 0; i < a.length; i++) {
      for (int j = i + 1; j < a.length; j++) {
        System.out.println(String.format("i = %d, j = %d", a[i], a[j]));
      }
    }
  }

  /**
   * Runtime is O(a * b) and not O(N^2) - the size of the arrays is different
   *
   * if statement is O(1)
   */
  static void e4(int[] a, int[] b) {
    for (int i : a) {
      for (int j : b) {
        if (i < j) {
          System.out.println(String.format("i = %d, j = %d", i, j));
        }
      }
    }
  }

  /**
   * 100000 units of work is still constant -> O(1)
   * Runtime will be O(a * b)
   */
  static void e5(int[] a, int[] b) {
    for (int i : a) {
      for (int j : b) {
        for (int k = 0; k < 100000; k++) {
          System.out.println(String.format("i = %d, j = %d", i, j));
        }
      }
    }
  }

  /**
   * Runtime will be O(N/2) -> drop constants -> O(N)
   */
  static void e6(int[] a) {
    for (int i = 0; i < a.length / 2; i++) {
      int other = a.length - i - 1;
      int temp = a[i];
      a[i] = a[other];
      a[other] = temp;
    }
    System.out.println(String.format("Reversed array is %s", Arrays.toString(a)));
  }

  /**
   * O(N + P), where P is < N/2 -> drop non-dominant -> O(N)
   * O(2N) -> drop constants -> O(N)
   * O(N + log N) -> drop non-dominant -> O(N)
   * O(N + M) -> O(N + M)
   */
  static void e7() {
    System.out.println("Pick the ones that are equivalent with O(N)");
  }

  /**
   * Sorting each string takes O(N * log N), we have N strings to sort -> O(N^2 * log N).
   * There is an additional O(N * log N) to sort all strings
   * Incorrect because we have used N to represent multiple things (size of array, length of strings)
   *
   * s = length of longest string
   * a = length of array
   *
   * Sorting each string is O(s * log s)
   * We have to do this for every string O(a * s * log s)
   * Now we have to sort all the strings -> you would be inclined to say O(a * log a)
   * But each string comparison takes O(s)
   * There are O(a * log a) comparisons -> O(s * a * log a)
   *
   * -> Runtime will be O(a * s * (log a + log s))
   */
  static void e8() {
    System.out.println("Array of strings, sort each string, then sort the full array");
  }

  /**
   * Balanced binary tree -> N nodes -> log N depth (half every time)
   * Runtime will be O (branches ^ depth)
   * depth = log N
   * branches = 2 (binary tree)
   *
   * Runtime is O(2 ^ log N)
   *
   * 2 ^ log2 N -> if log2 N = P -> 2^P = N -> 2 ^ log2 N = 2 ^ P = N
   *
   * Runtime is O(N)
   */
  static int e9(Node node) {
    if (node == null) {
      return 0;
    }

    System.out.println(String.format("Node = (left = %s, right = %s, value = %d)",
        (node.left != null) ? node.left.toString() : "null",
        (node.right != null) ? node.right.toString() : "null",
        node.value));

    return e9(node.left) + node.value + e9(node.right);
  }

  static class Node {
    public Node left;
    public Node right;
    public int value;

    public Node(Node left, Node right, int value) {
      this.left = left;
      this.right = right;
      this.value = value;
    }
  }

  /**
   * The work inside the for loop is constant -> O(1)
   * Number of iterations is sqrt(n) -> O(sqrt(n))
   */
  static boolean e10(int n) {
    for (int x = 2; x * x <= n; x++) {
      if (n % x == 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * Factorial is a straight recursion from n to 1 -> O(n) time
   */
  static int e11(int n) {
    if (n < 0) {
      return -1;
    } else if (n == 0) {
      return 1;
    } else {
      return n * e11(n - 1);
    }
  }

  static void permutation(String str) {
    permutation(str, "");
  }

  /**
   * There are n! permutations for every string that begins with a letter from the initial string
   * There are N letters in the initial string -> call stack has n * n! nodes
   *
   * Let's compute the amount of work each node does:
   * Printing the string takes O(n) -> each letter needs to be printed
   * Inside the for loop the work takes O(n) due to string concatenation and charAt
   *
   * Runtime is O(N * N * N!) = O(N^2 * N!)
   */
  static void permutation(String str, String prefix) {
    if (str.length() == 0) {
      System.out.println(prefix);
    } else {
      for (int i = 0; i < str.length(); i++) {
        String rem = str.substring(0, i) + str.substring(i + 1);
        System.out.println(String.format("Str = %s, prefix = %s, rem = %s",
            str, prefix, rem));
        permutation(rem, prefix + str.charAt(i));
      }
    }
  }

  /**
   * The tree is not balanced but it does have a depth of N
   * We can approximate using the formula O(branches^depth)
   * Runtime is O(2^N)
   */
  static int fib(int n) {
    // System.out.println(String.format("Fib(%d)", n));

    if (n <= 0) return 0;
    else if (n == 1) return 1;
    return fib(n - 1) + fib(n - 2);
  }

  /**
   * fib(n) -> O(2^N)
   *
   * fib(1) -> 2^1 steps
   * fib(2) -> 2^2 steps
   * fib(3) -> 2^3 steps
   *
   * ...
   *
   * O() = 2^1 + 2^2 + 2^3 + ... + 2^N = 2^(N+1) - 1
   *
   * Runtime is O(2^(N+1) - 1) -> drop constants -> O(2^N)
   */
  static void allFib(int n) {
    for (int i = 0; i < n; i++) {
      System.out.println(String.format("fib(%d) = %d", i, fib(i)));
    }
  }

  static int fibMemo(int n, int[] memo) {
    if (n <= 0) {
      return 0;
    } else if (n == 1) {
      return 1;
    } else if (memo[n] > 0) {
      return memo[n];
    }

    memo[n] = fibMemo(n - 1, memo) + fibMemo(n - 2, memo);
    return memo[n];
  }

  /**
   * At each call to fib(i) starting with i = 0, we have computed the stored values for fib(i-1)
   * and fib(i-2). Looking up those values, storing them and returning them takes a constant amount
   * of time.
   *
   * Constant work N times. Runtime is O(N)
   *
   * The technique is called memoization
   */
  static void allFibMemo(int n) {
    int[] memo = new int[n + 1];
    for (int i = 0; i < n; i++) {
      System.out.println(String.format("fib(%d) = %d", i, fibMemo(i, memo)));
    }
  }

  /**
   * Runtime is the number of times we can divide N by 2 until we get down to the base case (1)
   * Runtime is O(log N)
   */
  static int powersOf2(int n) {
    if (n < 1) {
      return 0;
    } else if (n == 1) {
      System.out.println(1);
      return 1;
    } else {
      int prev = powersOf2(n / 2);
      int curr = prev * 2;
      System.out.println(curr);
      return curr;
    }
  }

  /**
   * Runtime is O(b)
   */
  static int product(int a, int b) {
    int sum = 0;
    for (int i = 0; i < b; i++) {
      sum += a;
    }
    return sum;
  }

  /**
   * Computes a^b
   *
   * Runtime is O(b). Add b calls to the stack
   */
  static int power(int a, int b) {
    if (b < 0) {
      return 0; // error
    } else if (b == 0) {
      return 1;
    } else {
      return a * power(a, b - 1);
    }
  }

  /**
   * Computes a % b
   *
   * Runtime is O(1)
   */
  static int mod(int a, int b) {
    if (b < 0) {
      return -1;
    }

    int div = a / b;
    return a - div * b;
  }

  /**
   * Runtime is O(a/b)
   */
  static int div(int a, int b) {
    int count = 0;
    int sum = 0;
    while (sum < a) {
      sum += b;
      count++;
    }
    return count;
  }

  static int sqrtHelper(int n, int min, int max) {
    if (max < min) return -1; // no square root
  }

  public static void main(String[] args) {
    int[] values1 = { 1, 2, 3, 4 };
    int[] values2 = { 5, 6, 7, 8, 9, 10, 11};
    int prime = 121;
    int factorial = 11;

    Node l13 = new Node(null, null, 3);
    Node l23 = new Node(null, null, 3);
    Node l33 = new Node(null, null, 3);
    Node l43 = new Node(null, null, 3);
    Node l21 = new Node(l13, l23, 2);
    Node l22 = new Node(l33, l43, 2);
    Node root = new Node(l21, l22, 1);

    // e1(values1);
    // e2(values1);
    // e3(values1);
    // e4(values1, values2);
    // e5(values1, values2);
    // e6(values2);
    // e7();
    // e8();
    // System.out.println(String.format("Sum of all nodes is %d", e9(root)));
    // System.out.println(String.format("The number n = %d, isPrime = %s", prime, e10(prime)));
    // System.out.println(String.format("n = %d, n! = %d", factorial, e11(factorial)));
    // permutation("irs");
    // fib(4);
    // allFib(8);
    // allFibMemo(8);
    // powersOf2(4);
    System.out.println(String.format("%d div %d = %d", 6, 3, div(6, 3)));
  }
}
