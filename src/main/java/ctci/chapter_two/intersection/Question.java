package ctci.chapter_two.intersection;

import ctci.utils.AssortedMethods;
import ctci.utils.LinkedListNode;

public class Question {

  static class Result {

    public LinkedListNode tail;
    public int size;

    public Result(LinkedListNode tail, int size) {
      this.tail = tail;
      this.size = size;
    }
  }

  public static LinkedListNode findIntersection(LinkedListNode a, LinkedListNode b) {
    if (a == null || b == null) {
      return null;
    }

    // get tail and sizes
    Result resultA = getTailAndSize(a);
    Result resultB = getTailAndSize(b);

    // if different tail nodes we have no intersection
    if (resultA.tail != resultB.tail) {
      return null;
    }

    // set pointers to the start of each linked list
    LinkedListNode shorter = resultA.size < resultB.size ? a : b;
    LinkedListNode longer = resultA.size < resultB.size ? b : a;

    // Advance pointer for longer list by k positions
    longer = getKthNode(longer, Math.abs(resultA.size - resultB.size));

    while (shorter != longer) {
      shorter = shorter.next;
      longer = longer.next;
    }

    return longer;
  }

  private static Result getTailAndSize(LinkedListNode list) {
    if (list == null) {
      return null;
    }

    int size = 1;
    LinkedListNode current = list;
    while (current.next != null) {
      size++;
      current = current.next;
    }

    return new Result(current, size);
  }

  private static LinkedListNode getKthNode(LinkedListNode head, int k) {
    LinkedListNode current = head;

    while (k > 0 && current != null) {
      current = current.next;
      k--;
    }
    return current;
  }

  public static void main(String[] args) {
    /* Create linked list */
    int[] vals = {-1, -2, 0, 1, 2, 3, 4, 5, 6, 7, 8};
    LinkedListNode list1 = AssortedMethods.createLinkedListFromArray(vals);

    int[] vals2 = {12, 14, 15};
    LinkedListNode list2 = AssortedMethods.createLinkedListFromArray(vals2);

    list2.next.next = list1.next.next.next.next;

    System.out.println(list1.printForward());
    System.out.println(list2.printForward());


    LinkedListNode intersection = findIntersection(list1, list2);

    System.out.println(intersection.printForward());
  }

}

