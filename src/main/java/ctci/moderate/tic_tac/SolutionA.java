package ctci.moderate.tic_tac;

public class SolutionA {

  private static int convertBoardToInt(Piece[][] board) {
    int sum = 0;
    for (Piece[] row : board) {
      for (Piece column : row) {
        int value = column.ordinal();
        sum = sum * 3 + value;
      }
    }
    return sum;
  }

  public static void main(String[] args) {
    Piece[][] board = {
        {Piece.Empty, Piece.Empty, Piece.Empty},
        {Piece.Empty, Piece.Empty, Piece.Empty},
        {Piece.Blue, Piece.Blue, Piece.Blue}};

    int v = convertBoardToInt(board);
    System.out.println(v);
  }
}
