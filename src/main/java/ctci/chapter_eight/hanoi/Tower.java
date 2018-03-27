package ctci.chapter_eight.hanoi;

import java.util.Stack;

public class Tower {
  private Stack<Integer> disks;
  private int index;

  public Tower(int index) {
    this.disks = new Stack<>();
    this.index = index;
  }

  public int index() {
    return index;
  }

  public boolean add(int disk) {
    if (!disks.isEmpty() && disks.peek() <= disk) {
      return false;
    }
    disks.push(disk);
    return true;
  }

  public void moveTopTo(Tower tower) {
    int top = disks.pop();
    tower.add(top);
  }

  public void moveDisks(int n, Tower destination, Tower buffer) {
    if (n <= 0) {
      return;
    }
    moveDisks(n - 1, buffer, destination);
    moveTopTo(destination);
    buffer.moveDisks(n - 1, destination, this);
  }
}

