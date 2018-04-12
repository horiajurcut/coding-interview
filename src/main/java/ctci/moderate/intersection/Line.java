package ctci.moderate.intersection;

public class Line {
  public double slope;
  public double yIntercept;

  public Line(Point start, Point end) {
    double deltaY = end.y - start.y;
    double deltaX = end.x - start.x;
    slope = deltaY / deltaX; // Will be Infinity (not exception) when deltaX = 0
    yIntercept = end.y - slope * end.x;  // y = mx + b, where m is the slope and b = yIntercept
  }

  public void print() {
    System.out.print("y = " + slope + "x + " + yIntercept);
  }
}
