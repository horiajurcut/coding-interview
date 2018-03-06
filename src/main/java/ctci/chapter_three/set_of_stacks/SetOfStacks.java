package ctci.chapter_three.set_of_stacks;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class SetOfStacks {

  public int capacity;
  private List<Stack> stacks = new ArrayList<>();

  public SetOfStacks(int capacity) {
    this.capacity = capacity;
  }

  public void push(int value) {
    Stack last = getLastStack();

    if (last != null && !last.isFull()) {
      last.push(value);
    } else {
      Stack stack = new Stack(capacity);
      stack.push(value);
      stacks.add(stack);
    }
  }

  public int pop() {
    Stack last = getLastStack();
    if (last == null) {
      throw new EmptyStackException();
    }
    int value = last.pop();
    if (last.size == 0) {
      stacks.remove(stacks.size() - 1);
    }
    return value;
  }

  public Stack getLastStack() {
    if (stacks.size() == 0) {
      return null;
    }
    return stacks.get(stacks.size() - 1);
  }

  public boolean isEmpty() {
    Stack last = getLastStack();
    return last != null || last.isEmpty();
  }

  public int popAt(int index) {
    return leftShift(index, true);
  }

  public int leftShift(int index, boolean removeTop) {
    Stack stack = stacks.get(index);
    int removedItem;
    if (removeTop) {
      removedItem = stack.pop();
    } else {
      removedItem = stack.removeBottom();
    }
    if (stack.isEmpty()) {
      stacks.remove(index);
    } else if (stacks.size() > index + 1) {
      int v = leftShift(index + 1, false);
      stack.push(v);
    }
    return removedItem;
  }
}

