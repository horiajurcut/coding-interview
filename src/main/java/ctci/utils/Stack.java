package ctci.utils;

import java.util.EmptyStackException;

public class Stack<Item> {

  private static class Node<Item> {
    private Item item;
    private Node<Item> next;

    public Node(Item item) {
      this.item = item;
    }
  }

  private Node<Item> top;
  private int size = 0;

  public Item pop() {
    if (top == null) {
      throw new EmptyStackException();
    }
    Item item = top.item;
    top = top.next;
    --size;
    return item;
  }

  public void push(Item item) {
    Node<Item> node = new Node<>(item);
    node.next = top;
    top = node;
    ++size;
  }

  public Item peek() {
    if (top == null) {
      throw new EmptyStackException();
    }
    return top.item;
  }

  public boolean isEmpty() {
    return top == null;
  }

  public int size() {
    return size;
  }
}
