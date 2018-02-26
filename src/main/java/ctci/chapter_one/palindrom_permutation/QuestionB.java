package ctci.chapter_one.palindrom_permutation;

public class QuestionB {
  public static boolean isPermutationOfPalindrome(String input) {
    int countOdd = 0;
    int[] table = new int['z' - 'a' + 1];
    for (char c : input.toCharArray()) {
      int x = Common.getCharNumber(c);
      if (x != -1) {
        table[x]++;
        if (table[x] % 2 == 1) {
          countOdd++;
        } else {
          countOdd--;
        }
      }
    }
    return countOdd <= 1;
  }

  public static void main(String[] args) {
    String pali = "Ratzs live on no evil starz";
    System.out.println(isPermutationOfPalindrome(pali));
    String pali2 = "Zeus was deified, saw Suez";
    System.out.println(isPermutationOfPalindrome(pali2));
  }
}

