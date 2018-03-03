package ctci.utils;

public class LinkedListNode {
  public LinkedListNode next;
  public LinkedListNode previous;
  public LinkedListNode last;
  public int data;

  public LinkedListNode () {}

  public LinkedListNode(int data) {
    this.data = data;
  }

  public LinkedListNode(int data, LinkedListNode n, LinkedListNode p) {
    this.data = data;
    setNext(n);
    setPrevious(p);
  }

  public void setNext(LinkedListNode n) {
    next = n;
    if (this == last) {
      last = n;
    }
    if (n != null && n.previous != this) {
      n.setPrevious(this);
    }
  }

  public void setPrevious(LinkedListNode p) {
    previous = p;
    if (p != null && p.next != this) {
      p.setNext(this);
    }
  }

  public String printForward() {
    if (next != null) {
      return data + "->" + next.printForward();
    } else {
      return ((Integer) data).toString();
    }
  }
}

