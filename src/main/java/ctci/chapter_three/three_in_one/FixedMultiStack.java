package ctci.chapter_three.three_in_one;

import ctci.utils.AssortedMethods;
import java.util.EmptyStackException;

public class FixedMultiStack {

  private int numberOfStacks = 3;
  private int stackCapacity;
  private int[] values;
  private int[] sizes;

  public FixedMultiStack(int stackSize) {
    stackCapacity = stackSize;
    values = new int[stackSize * numberOfStacks];
    sizes = new int[numberOfStacks];
  }

  public static class FullStackException extends Exception {
    private static final long serialVersionUID = 1L;

    public FullStackException(){
      super();
    }

    public FullStackException(String message){
      super(message);
    }
  }

  public void push(int stackNum, int value) throws FullStackException {
    if (isFull(stackNum)) {
      throw new FullStackException();
    }
    sizes[stackNum]++;
    values[indexOfTop(stackNum)] = value;
  }

  public int pop(int stackNum) {
    if (isEmpty(stackNum)) {
      throw new EmptyStackException();
    }
    int topIndex = indexOfTop(stackNum);
    int value = values[topIndex];
    values[topIndex] = 0;  // clear
    sizes[stackNum]--;
    return value;
  }

  public int peek(int stackNum) {
    if (isEmpty(stackNum)) {
      throw new EmptyStackException();
    }
    return values[indexOfTop(stackNum)];
  }

  public boolean isEmpty(int stackNum) {
    return sizes[stackNum] == 0;
  }

  public boolean isFull(int stackNum) {
    return sizes[stackNum] == stackCapacity;
  }

  public int indexOfTop(int stackNum) {
    int offset = stackNum * stackCapacity;
    return offset + sizes[stackNum] - 1;
  }

  public int[] getValues() {
    return values;
  }

  public int[] getStackValues(int stackNum) {
    int[] items = new int[sizes[stackNum]];
    for (int i = 0; i < items.length; i++) {
      items[i] = values[stackNum * stackCapacity + i];
    }
    return items;
  }

  public String stackToString(int stackNum) {
    int[] items = getStackValues(stackNum);
    return stackNum + ": " + AssortedMethods.arrayToString(items);
  }
}

