package ctci.chapter_two.sum_lists;

import ctci.utils.LinkedListNode;

public class QuestionA {

  public static LinkedListNode addLists(LinkedListNode a, LinkedListNode b, int carry) {
    if (a == null && b == null && carry == 0) {
      return null;
    }
    System.out.println(a == null ? "null" : a.data);
    System.out.println(b == null ? "null" : b.data);
    System.out.println(carry);

    LinkedListNode result = new LinkedListNode();
    int value = carry;

    if (a != null) {
      value += a.data;
    }

    if (b != null) {
      value += b.data;
    }

    result.data = value % 10;
    System.out.println("data = " + result.data);

    if (a != null || b != null) {
      LinkedListNode next = addLists(
          a == null ? null : a.next,
          b == null ? null : b.next,
          value / 10
      );
      result.setNext(next);
    }

    return result;
  }

  public static void main(String[] args) {
    LinkedListNode lA1 = new LinkedListNode(9, null, null);
    LinkedListNode lA2 = new LinkedListNode(9, null, lA1);
    LinkedListNode lA3 = new LinkedListNode(9, null, lA2);

    LinkedListNode lB1 = new LinkedListNode(1, null, null);
    LinkedListNode lB2 = new LinkedListNode(0, null, lB1);
    LinkedListNode lB3 = new LinkedListNode(0, null, lB2);

    LinkedListNode list3 = addLists(lA1, lB1, 0);

    System.out.println("  " + lA1.printForward());
    System.out.println("+ " + lB1.printForward());
    System.out.println("= " + list3.printForward());
  }
}
