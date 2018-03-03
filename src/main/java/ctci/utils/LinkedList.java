package ctci.utils;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class LinkedList<Item extends Comparable<Item>> implements Iterable<Item> {

  private int n;
  private Node pre;    // sentinel node before first item
  private Node post;  // sentinel node after last item

  public LinkedList() {
    pre = new Node();
    post = new Node();
    pre.next = post;
    post.previous = pre;
  }

  public boolean isEmpty() {
    return n == 0;
  }

  public int size() {
    return n;
  }

  public void add(Item item) {
    Node last = post.previous;
    Node x = new Node();
    x.item = item;
    x.previous = last;
    x.next = post;
    post.previous = x;
    last.next = x;
    n++;
  }

  public Item kthToLast(int k) {
    return kthToLast(pre.next, k + 1, new Index()).item;
  }

  private Node kthToLast(Node x, int k, Index index) {
    if (x == null) {
      return null;
    }
    Node node = kthToLast(x.next, k, index);
    index.value = index.value + 1;
    if (index.value == k) {
      return x;
    }
    return node;
  }

  public Node head() {
    return pre.next;
  }

  public boolean delete(Node x) {
    if (x == null || x.next == null) {
      return false;
    }
    Node next = x.next;
    x.item = next.item;
    x.next = next.next;
    n--;

    return true;
  }

  public void partition(Item item) {
    Node head = pre.next;
    Node tail = pre.next;
    Node current = pre.next;

    while (current.next != null) {
      Node next = current.next;
      if (current.item.compareTo(item) < 0) {
        // Insert node at head
        current.next = head;
        head.previous = current;
        head = current;
      } else {
        // Insert node at tail
        tail.next = current;
        current.previous = tail;
        tail = current;
      }
      current = next;
    }
    pre.next = head;
    head.previous = pre;

    post.previous = tail;
    tail.next = post;
  }

  public ListIterator<Item> iterator() {
    return new LinkedListIterator();
  }

  private class LinkedListIterator implements ListIterator<Item> {
    private Node current = pre.next;
    private Node lastAccessed = null;
    private int index = 0;

    public boolean hasNext() {
      return index < n;
    }

    public boolean hasPrevious() {
      return index > 0;
    }

    public int nextIndex() {
      return index;
    }

    public int previousIndex() {
      return index - 1;
    }

    public Item next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      lastAccessed = current;
      Item item = current.item;
      current = current.next;
      ++index;
      return item;
    }

    public Item previous() {
      if (!hasPrevious()) {
        throw new NoSuchElementException();
      }
      current = current.previous;
      index--;
      lastAccessed = current;
      return current.item;
    }

    public void set(Item item) {
      // replace item for last accessed node
      if (lastAccessed == null) {
        throw new IllegalStateException();
      }
      lastAccessed.item = item;
    }

    public void remove() {
      // remove last element that was accessed by next() or previous()
      Node prev = lastAccessed.previous;
      Node next = lastAccessed.next;
      prev.next = next;
      next.previous = prev;
      n--;
      if (current == lastAccessed) {
        current = next;
      } else {
        index--;
      }
      lastAccessed = null;
    }

    public void add(Item item) {
      Node x = current.previous;
      Node y = new Node();
      Node z = current;

      y.item = item;
      x.next = y;
      y.next = z;
      z.previous = y;
      y.previous = x;
      n++;
      index++;
      lastAccessed = null;
    }
  }

  public class Node {
    public Item item;
    public Node next;
    public Node previous;
  }

  private class Index {
    private int value = 0;
  }
}


