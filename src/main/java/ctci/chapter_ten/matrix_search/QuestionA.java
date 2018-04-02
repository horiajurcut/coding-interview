package ctci.chapter_ten.matrix_search;

public class QuestionA {

  static boolean findElement(int[][] matrix, int element) {
    int row = 0;
    int col = matrix[0].length - 1;

    while (row < matrix.length && col >= 0) {
      if (matrix[row][col] == element) {
        return true;
      } else if (matrix[row][col] > element) {
        col --;
      } else {
        row++;
      }
    }
    return false;
  }
}
