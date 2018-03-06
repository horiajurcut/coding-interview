package ctci.utils;

import java.util.NoSuchElementException;

public class Queue<Item> {

  private static class Node<Item> {
    private Item item;
    private Node<Item> next;

    public Node(Item item) {
      this.item = item;
    }
  }

  private Node<Item> first;
  private Node<Item> last;

  public void add(Item item) {
    Node<Item> node = new Node<>(item);
    if (last != null) {
      last.next = node;
    }
    last = node;
    if (first == null) {
      first = last;
    }
  }

  public Item remove() {
    if (first == null) {
      throw new NoSuchElementException();
    }
    Item item = first.item;
    first = first.next;
    if (first == null) {
      last = null;
    }
    return item;
  }

  public Item peek() {
    if (first == null) {
      throw new NoSuchElementException();
    }
    return first.item;
  }

  public boolean isEmpty() {
    return first == null;
  }
}
