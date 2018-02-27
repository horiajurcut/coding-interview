package ctci.chapter_one.string_compression;

public class Question {

  public static String compress(String input) {
    if (input.length() <= 1) {
      return input;
    }
    StringBuilder result = new StringBuilder();
    char c = input.charAt(1);
    int counter = 1;

    for (int i = 1; i < input.length(); i++) {
      if (c == input.charAt(i)) {
        ++counter;
      } else {
        result.append(c);
        result.append(Integer.toString(counter));
        c = input.charAt(i);
        counter = 1;
      }
    }

    result.append(c);
    result.append(Integer.toString(counter));

    return result.length() >= input.length() ? input : result.toString();
  }

  public static int countCompress(String input) {
    if (input.length() <= 1) {
      return input.length();
    }

    char c = input.charAt(1);
    int counter = 1;
    int finalLength = 0;

    for (int i = 1; i < input.length(); i++) {
      if (c == input.charAt(i)) {
        ++counter;
      } else {
        finalLength += 1 + String.valueOf(counter).length();
        c = input.charAt(i);
        counter = 1;
      }
    }
    finalLength += 1 + String.valueOf(counter).length();
    return finalLength;
  }


  public static void main(String[] args) {
    String str = "aaaaabbbbaaaabbddc";
    System.out.println(str);
    System.out.println(compress(str));
    System.out.println(countCompress(str));

    str = "aa";
    System.out.println(str);
    System.out.println(compress(str));
    System.out.println(countCompress(str));

    str = "aaaaaaaaaaaaaaaaaaaaab";
    System.out.println(str);
    System.out.println(compress(str));
    System.out.println(countCompress(str));
  }
}

