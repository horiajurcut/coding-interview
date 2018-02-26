package ctci.chapter_one.palindrom_permutation;

public class QuestionA {
  public static boolean isPermutationOfPalindrome(String input) {
    int[] table = Common.buildCharFrequencyTable(input);
    return checkMaxOneOdd(table);
  }

  static boolean checkMaxOneOdd(int[] table) {
    boolean foundOdd = false;
    for (int count : table) {
      if (count % 2 == 1) {
        if (foundOdd) {
          return false;
        }
        foundOdd = true;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    String pali = "Rats live on no evil star";
    System.out.println(isPermutationOfPalindrome(pali));
  }
}

