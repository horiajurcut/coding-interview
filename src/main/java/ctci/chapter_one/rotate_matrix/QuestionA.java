package ctci.chapter_one.rotate_matrix;

public class QuestionA {

  public static boolean rotate(int[][] matrix) {
    if (matrix.length == 0 || (matrix.length != matrix[0].length)) {
      return false;
    }

    int n = matrix.length;
    for (int layer = 0; layer < n / 2; layer++) {
      int first = layer;
      int last = n - 1 - layer;

      for (int i = first; i < last; i++) {
        int offset = i - first;
        int top = matrix[first][i]; // save top

        // left -> top
        matrix[first][i] = matrix[last - offset][first];
        printMove(last - offset, first, first, i);

        // bottom -> left
        matrix[last - offset][first] = matrix[last][last - offset];
        printMove(last, last - offset, last - offset, first);

        // right -> bottom
        matrix[last][last - offset] = matrix[i][last];
        printMove(i, last, last, last - offset);

        // top -> right
        matrix[i][last] = top; // right <- saved top
        printMove(first, i, i, last);
      }
    }
    return true;
  }

  static void printMove(int r1, int c1, int r2, int c2) {
    System.out.println(
        "[" + (r1 + 1) + "][" + (c1 + 1) + "] moves to [" + (r2 + 1) + "][" + (c2 + 1) + "]");
  }

  static void printMatrix(int[][] m, int n) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(m[i][j] + " ");
      }
      System.out.println("");
    }
  }

  static void createMatrix(int[][] m, int n) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        m[i][j] = 10 * (i + 1) + j + 1;
      }
    }
  }

  public static void main(String[] args) {
    int n = 6;
    int[][] m = new int[n][n];
    createMatrix(m, n);
    printMatrix(m, n);
    rotate(m);
    System.out.println("");
    printMatrix(m, n);
  }
}

