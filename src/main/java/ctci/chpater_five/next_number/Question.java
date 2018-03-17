package ctci.chpater_five.next_number;

public class Question {

  public static int getNext(int n) {
    int c = n;
    int c0 = 0;
    int c1 = 0;

    while (((c & 1) == 0) && (c != 0)) {
      c0++;
      c >>= 1;  // number of 0s to the right of p
    }

    while ((c & 1) == 1) {
      c1++;
      c >>= 1;  // number of 1s to the right of p
    }

    if (c0 + c1 == 31 || c0 + c1 == 0) {
      return -1;
    }
    int p = c0 + c1;  // position of the rightmost non-trailing 0

    n |= (1 << p);  // flip rightmost non-trailing zero
    n &= ~((1 << p) - 1);  // clear all bits to the right of p
    n |= (1 << (c1 - 1)) - 1;  // insert (c1 -1) ones on the right

    return n;
  }

  public static int getPrev(int n) {
    int temp = n;
    int c0 = 0;  // c0 is the size of the block of zeros to the left of the trailing 1s
    int c1 = 0;  // c1 is the number of trailing 1s

    while ((temp & 1) == 1) {
      c1++;
      temp >>= 1;
    }

    if (temp == 0) {
      return -1;
    }

    while ((temp & 1) == 0 && (temp != 0)) {
      c0++;
      temp >>= 1;
    }

    int p = c0 + c1;
    n &= ((~0) << (p + 1));  // clear from bit p onwards
    int mask = (1 << (c1 + 1)) - 1;
    n |= mask << (c0 - 1);

    return n;
  }
}
