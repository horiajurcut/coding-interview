package algs;

public class QuickFind {
  private final int[] id;

  public QuickFind(int n) {
    id = new int[n];
    for (int i = 0; i < id.length; i++) {
      id[i] = i;
    }
  }

  /**
   * Runtime complexity is O(1)
   */
  public boolean isConnected(int p, int q) {
    return id[p] == id[q];
  }

  /**
   * N union commands on a N size array -> O(n^2) (quadratic runtime complexity)
   */
  public void union(int p, int q) {
    int pid = id[p];
    int qid = id[q];

    for (int i = 0; i < id.length; i++) {
      if (id[i] == pid) {
        id[i] = qid;
      }
    }
  }
}
