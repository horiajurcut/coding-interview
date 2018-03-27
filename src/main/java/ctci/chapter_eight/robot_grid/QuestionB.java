package ctci.chapter_eight.robot_grid;

import ctci.utils.AssortedMethods;
import java.util.ArrayList;
import java.util.HashSet;

public class QuestionB {
  public static ArrayList<Point> getPath(boolean[][] maze) {
    if (maze == null || maze.length == 0) return null;
    ArrayList<Point> path = new ArrayList<>();
    HashSet<Point> failedPoints = new HashSet<>();
    if (getPath(maze, maze.length - 1, maze[0].length - 1, path, failedPoints)) {
      return path;
    }
    return null;
  }

  public static boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path,
      HashSet<Point> failedPoints) {
    // If out of bounds or not available, return.
    if (col < 0 || row < 0 || !maze[row][col]) {
      return false;
    }

    Point p = new Point(row, col);

    if (failedPoints.contains(p)) {
      return false;
    }

    boolean isAtOrigin = (row == 0) && (col == 0);

    // If there's a path from the start to my current location, add my location.
    if (isAtOrigin ||
        getPath(maze, row, col - 1, path, failedPoints) ||
        getPath(maze, row - 1, col, path, failedPoints)) {
      path.add(p);
      return true;
    }

    failedPoints.add(p);
    return false;
  }

  public static void main(String[] args) {
    int size = 5;
    boolean[][] maze = AssortedMethods.randomBooleanMatrix(size, size, 70);

    AssortedMethods.printMatrix(maze);

    ArrayList<Point> path = getPath(maze);
    if (path != null) {
      System.out.println(path.toString());
    } else {
      System.out.println("No path found.");
    }
  }
}
