package ctci.chapter_one.palindrom_permutation;

public class Common {

  public static int getCharNumber(Character c) {
    int a = Character.getNumericValue('a');
    int z = Character.getNumericValue('z');
    int val = Character.getNumericValue(c);
    if (a <= val && val <= z) {
      return val - a;
    }
    return -1;
  }

  public static int[] buildCharFrequencyTable(String input) {
    int[] table = new int['z' - 'a' + 1];
    for (char c : input.toCharArray()) {
      int x = getCharNumber(c);
      if (x != -1) {
        table[x]++;
      }
    }
    return table;
  }
}


