package examples;

import java.util.Stack;

public class BalancedBrackets {

  private static final String BALANCED_1 = "([])[a]()";
  private static final String BALANCED_2 = "(a(a(a[(x[yo])]))())";

  private static final String UNBALANCED_1 = "(a[]a]()";
  private static final String UNBALANCED_2 = "]s[s";

  public static void main(String[] args) {
    System.out.println(String.format("Is %s a string of balanced brackets? Answer = %s",
        BALANCED_1, isBalanced(BALANCED_1)));
    System.out.println(String.format("Is %s a string of balanced brackets? Answer = %s",
        BALANCED_2, isBalanced(BALANCED_2)));
    System.out.println(String.format("Is %s a string of balanced brackets? Answer = %s",
        UNBALANCED_1, isBalanced(UNBALANCED_1)));
    System.out.println(String.format("Is %s a string of balanced brackets? Answer = %s",
        UNBALANCED_2, isBalanced(UNBALANCED_2)));
  }

  private static boolean isBalanced(final String brackets) {
    Stack<Character> validator = new Stack<Character>();

    for (int i = 0; i < brackets.length(); i++) {
      char c = brackets.charAt(i);

      if (c == '(' || c == '[') {
        validator.push(c);
      } else if (c == ')' || c == ']') {
        if (validator.empty()) {
          return false;
        }

        char top = validator.pop();
        if ((top == '(' && c != ')') || (top == '[' && c != ']')) {
          return false;
        }
      }
    }

    return validator.empty();
  }
}
