package ctci.chapter_eight.power_set;

import java.util.ArrayList;

public class QuestionA {

  ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
    ArrayList<ArrayList<Integer>> allSubsets;

    if (set.size() == index) {
      allSubsets = new ArrayList<>();
      allSubsets.add(new ArrayList<>());
    } else {
      allSubsets = getSubsets(set, index + 1);

      int item = set.get(index);

      ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<>();

      for (ArrayList<Integer> subset : allSubsets) {
        ArrayList<Integer> newSubset = new ArrayList<>(subset);
        newSubset.add(item);
        moreSubsets.add(newSubset);
      }

      allSubsets.addAll(moreSubsets);
    }

    return allSubsets;
  }
}
