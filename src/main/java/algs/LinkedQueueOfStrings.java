package algs;

public class LinkedQueueOfStrings {

  private Node first = null;
  private Node last = null;

  private class Node {
    String item;
    Node next;
  }

  public boolean isEmpty() {
    return first == null;
  }

  public void enqueue(String item) {
    Node oldLast = last;
    last = new Node();
    last.item = item;
    last.next = null;

    if (isEmpty()) {
      // Last one is also the first
      first = last;
    } else {
      oldLast.next = last;
    }
  }

  public String dequeue() {
    // TODO: Throw exception if queue is empty

    String item = first.item;
    first = first.next;

    if (isEmpty()) {
      // Last should also reflect that the queue is empty
      last = null;
    }

    return item;
  }
}
