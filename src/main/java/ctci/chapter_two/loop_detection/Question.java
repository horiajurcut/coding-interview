package ctci.chapter_two.loop_detection;

import ctci.utils.LinkedListNode;

public class Question {

  public static LinkedListNode findBeginningOfLoop(LinkedListNode head) {
    LinkedListNode slow = head;
    LinkedListNode fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;  // moving at twice the speed
      if (slow == fast) {
        // Collision
        break;
      }
    }
    if (fast == null || fast.next == null) {
      // no meeting point - therefore no loop (reached the end)
      return null;
    }

    // move slow to head - keep fast at meeting point
    slow = head;
    // each are k steps from the loop start
    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }

    return fast;
  }

  public static void main(String[] args) {
    int list_length = 100;
    int k = 10;

    // Create linked list
    LinkedListNode[] nodes = new LinkedListNode[list_length];
    for (int i = 0; i < list_length; i++) {
      nodes[i] = new LinkedListNode(i, null, i > 0 ? nodes[i - 1] : null);
    }

    // Create loop;
    nodes[list_length - 1].next = nodes[list_length - k];

    LinkedListNode loop = findBeginningOfLoop(nodes[0]);
    if (loop == null) {
      System.out.println("No Cycle.");
    } else {
      System.out.println(loop.data);
    }
  }
}

