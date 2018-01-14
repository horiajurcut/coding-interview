package applications;

import java.util.Stack;

public class BalancedBrackets {

  public static boolean isBalanced(final String brackets) {
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
