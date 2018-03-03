package ctci.chapter_two.return_kth;

import ctci.utils.LinkedList;

public class QuestionA {

  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<>();
    list.add(1);
    list.add(8);
    list.add(4);
    list.add(7);
    list.add(9);
    list.add(11);

    for (Integer aList : list) {
      System.out.println(aList);
    }

    System.out.println("k-th to last element is: " + list.kthToLast(2));
  }
}
