package ctci.chapter_ten.duplicates;

public class BitSet {
  int[] bitset;

  public BitSet(int size) {
    bitset = new int[(size >> 5) + 1];
  }

  boolean get(int pos) {
    int wordNumber = (pos >> 5);  // divide by 32
    int bitNumber = (pos & 0x1F);  // x mod y = x & (y - 1) if y is a power of 2
    return (bitset[wordNumber] & (1 << bitNumber)) != 0;
  }

  void set(int pos) {
    int wordNumber = (pos >> 5);  // divide by 32
    int bitNumber = (pos & 0x1F);  // x mod y = x & (y - 1) if y is a power of 2
    bitset[wordNumber] |= 1 << bitNumber;
  }
}
