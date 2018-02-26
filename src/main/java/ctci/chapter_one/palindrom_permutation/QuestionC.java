package ctci.chapter_one.palindrom_permutation;

public class QuestionC {

  static boolean isPermutationOfPalindrome(String input) {
    int bitVector = createBitVector(input);
    return bitVector == 0 || checkExactlyOneBitSet(bitVector);
  }

  static int createBitVector(String input) {
    // for each letter with value i, toggle the ith bit
    int bitVector = 0;
    for (char c : input.toCharArray()) {
      int x = Common.getCharNumber(c);
      bitVector = toggle(bitVector, x);
    }
    return bitVector;
  }

  static int toggle(int bitVector, int index) {
    if (index < 0) {
      return bitVector;
    }
    int mask = 1 << index;
    if ((bitVector & mask) == 0) {
      bitVector |= mask;
    } else {
      bitVector &= ~mask;
    }
    return bitVector;
  }

  static boolean checkExactlyOneBitSet(int bitVector) {
    return (bitVector & (bitVector - 1)) == 0;
  }

  public static void main(String[] args) {
    String pali = "Rats live on no evil star";
    System.out.println(isPermutationOfPalindrome(pali));
  }
}
