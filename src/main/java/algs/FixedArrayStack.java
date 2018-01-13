package algs;

import java.util.Iterator;

public class FixedArrayStack<Item> implements Iterable<Item> {

  private Item[] s;
  private int n = 0;

  public FixedArrayStack(int capacity) {
    s = (Item[]) new Object[capacity];
  }

  public boolean isEmpty() {
    return n == 0;
  }

  public void push(Item item) {
    s[n++] = item;
  }

  public Item popLoitering() {
    return s[--n];
  }

  public Item pop() {
    Item item = s[--n];
    s[n] = null; // release reference to unused object
    return item;
  }

  public Iterator<Item> iterator() {
    return null;
  }

  private class StackIterator implements Iterator<Item> {

    private int i = n;

    public boolean hasNext() {
      return i > 0; // LIFO
    }

    public Item next() {
      return s[--i];
    }

    public void remove() {

    }
  }
}
