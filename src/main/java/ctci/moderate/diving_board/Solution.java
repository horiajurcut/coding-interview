package ctci.moderate.diving_board;

import java.util.HashSet;

public class Solution {

  private static HashSet<Integer> allLengthsOptimized(int k, int shorter, int longer) {
    HashSet<Integer> lengths = new HashSet<>();

    for (int nShorter = 0; nShorter <= k; nShorter++) {
      int nLonger = k - nShorter;
      int length = nShorter * shorter + nLonger * longer;
      lengths.add(length);
    }

    return lengths;
  }

  private static HashSet<Integer> allLengths(int k, int shorter, int longer) {
    HashSet<Integer> lengths = new HashSet<>();
    HashSet<String> visited = new HashSet<>();

    getAllLengths(k, 0, shorter, longer, lengths, visited);
    return lengths;
  }

  private static void getAllLengths(int k, int total, int shorter, int longer,
      HashSet<Integer> lengths, HashSet<String> visited) {
    if (k == 0) {
      lengths.add(total);
      return;
    }

    String key = k + " " + total;

    if (visited.contains(key)) {
      return;
    }

    getAllLengths(k - 1, total + shorter, shorter, longer, lengths, visited);
    getAllLengths(k - 1, total + longer, shorter, longer, lengths, visited);

    visited.add(key);
  }

  public static void main(String[] args) {
    HashSet<Integer> lengths = allLengths(12, 1, 3);
    System.out.println(lengths.toString());
  }
}
