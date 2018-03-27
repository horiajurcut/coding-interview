package ctci.chapter_eight.parens;

import java.util.ArrayList;

public class Question {

  static void parens(ArrayList<String> list, int left, int right, char[] str, int index) {
    if (left < 0 || right < left) {
      return;
    }

    if (left == 0 && right == 0) {
      list.add(String.copyValueOf(str));
    } else {
      str[index] = '(';
      parens(list, left - 1, right, str, index + 1);

      str[index] = ')';
      parens(list, left, right - 1, str, index + 1);
    }
  }

  static ArrayList<String> generateParens(int count) {
    char[] str = new char[count * 2];
    ArrayList<String> list = new ArrayList<>();
    parens(list, count, count, str, 0);
    return list;
  }

}
