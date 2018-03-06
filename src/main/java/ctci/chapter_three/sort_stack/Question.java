package ctci.chapter_three.sort_stack;

import ctci.utils.AssortedMethods;
import ctci.utils.Stack;

public class Question {

  public static void sort(Stack<Integer> s) {
    Stack<Integer> r = new Stack<>();
    while (!s.isEmpty()) {
      int tmp = s.pop();
      while (!r.isEmpty() && r.peek() > tmp) {
        s.push(r.pop());
      }
      r.push(tmp);
    }

    while (!r.isEmpty()) {
      s.push(r.pop());
    }
  }

  public static void main(String [] args) {
    Stack<Integer> s = new Stack<>();
    for (int i = 0; i < 10; i++) {
      int r = AssortedMethods.randomIntInRange(0,  1000);
      s.push(r);
    }

    sort(s);

    while(!s.isEmpty()) {
      System.out.println(s.pop());
    }
  }
}

