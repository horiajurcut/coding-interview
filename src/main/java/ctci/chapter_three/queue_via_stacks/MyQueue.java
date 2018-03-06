package ctci.chapter_three.queue_via_stacks;

import ctci.utils.Stack;

public class MyQueue<Item> {

  Stack<Item> stackNewest, stackOldest;

  public MyQueue() {
    stackNewest = new Stack<>();
    stackOldest = new Stack<>();
  }

  public int size() {
    return stackNewest.size() + stackOldest.size();
  }

  public void add(Item item) {
    // Always has the newest elements on top
    stackNewest.push(item);
  }

  public void shiftStacks() {
    if (stackOldest.isEmpty()) {
      while (!stackNewest.isEmpty()) {
        stackOldest.push(stackNewest.pop());
      }
    }
  }

  public Item peek() {
    shiftStacks();
    return stackOldest.peek();
  }

  public Item remove() {
    shiftStacks();
    return stackOldest.pop();
  }
}

