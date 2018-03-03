package ctci.chapter_two.remove_dups;

import ctci.utils.LinkedList;
import java.util.HashSet;
import java.util.ListIterator;

public class QuestionA {

  public static void removeDuplicates(LinkedList<Integer> list) {
    HashSet<Integer> marked = new HashSet<>();
    ListIterator<Integer> iterator = list.iterator();

    while (iterator.hasNext()) {
      Integer next = iterator.next();
      if (marked.contains(next)) {
        iterator.remove();
      } else {
        marked.add(next);
      }
    }
  }

  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<>();
    list.add(7);
    list.add(8);
    list.add(9);
    list.add(7);
    list.add(9);

    for (Integer aList : list) {
      System.out.println(aList);
    }

    System.out.println("----------------------->");

    removeDuplicates(list);

    for (Integer aList : list) {
      System.out.println(aList);
    }
  }
}

