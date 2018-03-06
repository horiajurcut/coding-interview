package ctci.chapter_three.stack_min;

import ctci.utils.Stack;

public class StackWithMin extends Stack<NodeWithMin> {
  public void push(int value) {
    int newMin = Math.min(value, min());
    super.push(new NodeWithMin(value, newMin));
  }

  public int min() {
    if (this.isEmpty()) {
      return Integer.MAX_VALUE;
    }
    return peek().min;
  }
}

