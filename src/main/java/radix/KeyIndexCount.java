package radix;

public class KeyIndexCount {

  private int[] aux;
  private int[] count; // count frequencies for all values of a[]
  private int n;
  private int r;       // possible values of a[] are between 0 and (r - 1)

  public KeyIndexCount(int[] a, int r) {
    this.n = a.length;
    this.aux = new int[this.n];
    this.r = r;
    this.count = new int[r + 1]; // offset by 1

    for (int i = 0; i < this.n; i++) {
      count[a[i] + 1]++;
    }

    for (int rx = 0; rx < r; r++) {
      count[rx + 1] += count[rx]; // compute the cumulates
    }

    for (int i = 0; i < this.n; i++) {
      aux[count[a[i]]++] = a[i];
    }
  }

}
