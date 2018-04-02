package ctci.chapter_ten.anagrams;

import ctci.utils.HashMapList;
import java.util.ArrayList;
import java.util.Arrays;

public class Question {

  public static void sort(String[] array) {
    HashMapList<String, String> mapList = new HashMapList<>();

    /* Group words by anagram */
    for (String s : array) {
      String key = sortChars(s);
      mapList.put(key, s);
    }

    /* Convert hash table to array */
    int index = 0;
    for (String key : mapList.keySet()) {
      ArrayList<String> list = mapList.get(key);
      for (String t : list) {
        array[index] = t;
        index++;
      }
    }
  }

  private static String sortChars(String s) {
    char[] content = s.toCharArray();
    Arrays.sort(content);
    return new String(content);
  }

}
