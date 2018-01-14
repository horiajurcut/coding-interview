package applications;

import java.util.Stack;

public class DijkstraTwoStack {

  /**
   * This is a very basic solution, where the expression format is strict
   */
  public static double evaluate(final String expression) {
    Stack<String> operators = new Stack<String>();
    Stack<Double> values = new Stack<Double>();

    for (int i = 0; i < expression.length(); i++) {
      char c = expression.charAt(i);

      if (c == '(') {
        // Ignore
      } else if (c == '+') {
        operators.push(String.valueOf(c));
      } else if (c == '*') {
        operators.push(String.valueOf(c));
      } else if (c == ')') {
        String operator = operators.pop();

        if (operator.equals("+")) {
          values.push(values.pop() + values.pop());
        } else if (operator.equals("*")) {
          values.push(values.pop() * values.pop());
        }
      } else {
        values.push(Double.parseDouble(String.valueOf(c)));
      }
    }

    return values.pop();
  }

}
