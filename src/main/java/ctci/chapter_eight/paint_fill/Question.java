package ctci.chapter_eight.paint_fill;

public class Question {

  enum Color {
    BLACK,
    WHITE,
    RED,
    YELLOW,
    GREEN;
  }

  static boolean PaintFill(Color[][] screen, int r, int c, Color nColor) {
    if (screen[r][c] == nColor) {
      return false;
    }
    return PaintFill(screen, r, c, screen[r][c], nColor);
  }

  static boolean PaintFill(Color[][] screen, int r, int c, Color oColor, Color nColor) {
    if (r < 0 || r >= screen.length || c < 0 || c > screen[0].length) {
      return false;  // out of bounds
    }

    if (screen[r][c] == oColor) {
      screen[r][c] = nColor;
      PaintFill(screen, r - 1, c, oColor, nColor);  // UP
      PaintFill(screen, r + 1, c, oColor, nColor);  // DOWN
      PaintFill(screen, r, c - 1, oColor, nColor);  // LEFT
      PaintFill(screen, r, c + 1, oColor, nColor);  // RIGHT
    }
    return true;
  }

}
