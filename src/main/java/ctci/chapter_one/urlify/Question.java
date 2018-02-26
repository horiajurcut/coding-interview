package ctci.chapter_one.urlify;

import java.util.Arrays;

public class Question {

  public static void urlEncode(char[] str, int trueLength) {
    int spaceCount = 0;

    for (int i = 0; i < trueLength; i++) {
      if (str[i] == ' ') {
        spaceCount++;
      }
    }

    int index = trueLength + 2 * spaceCount;
    // if (trueLength < str.length) str[trueLength] = '\0';

    for (int i = trueLength - 1; i >= 0; i--) {
      if (str[i] == ' ') {
        str[index - 1] = '0';
        str[index - 2] = '2';
        str[index - 3] = '%';
        index -= 3;
      } else {
        str[index - 1] = str[i];
        index--;
      }
    }
  }

  public static int findLastCharacter(char[] str) {
    for (int i = str.length - 1; i >= 0; i--) {
      if (str[i] != ' ') {
        return i;
      }
    }
    return -1;
  }

  public static String urlEncode(String str) {
    String input = str.trim();
    StringBuilder encodedString = new StringBuilder();
    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      if (c == ' ') {
        encodedString.append("%20");
      } else {
        encodedString.append(c);
      }
    }
    return encodedString.toString();
  }

  public static void replaceSpaces(char[] str, int trueLength) {
    int spaceCount = 0, index, i = 0;
    for (i = 0; i < trueLength; i++) {
      if (str[i] == ' ') {
        spaceCount++;
      }
    }
    index = trueLength + spaceCount * 2;
    if (trueLength < str.length) str[trueLength] = '\0';
    for (i = trueLength - 1; i >= 0; i--) {
      if (str[i] == ' ') {
        str[index - 1] = '0';
        str[index - 2] = '2';
        str[index - 3] = '%';
        index = index - 3;
      } else {
        str[index - 1] = str[i];
        index--;
      }
    }
  }

  public static void main(String[] args) {
    String str = "Mr John Smith    ";
    char[] arr = Arrays.copyOf(str.toCharArray(), 256);
    int trueLength = findLastCharacter(str.toCharArray()) + 1;
    urlEncode(arr, trueLength);
    System.out.println(new String(arr));
    System.out.println(urlEncode(str));
  }
}
