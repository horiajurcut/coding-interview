package ctci.chapter_two.partition;

import ctci.utils.LinkedList;

public class Question {

  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<>();
    list.add(3);
    list.add(5);
    list.add(8);
    list.add(5);
    list.add(10);
    list.add(2);
    list.add(1);

    for (Integer aList : list) {
      System.out.println(aList);
    }

    System.out.println("----------------------->");

    list.partition(8);

    for (Integer aList : list) {
      System.out.println(aList);
    }
  }
}
