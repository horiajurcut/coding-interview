package ctci.chapter_fifteen.dining;

public class Philosopher extends Thread {

  private int bites = 10;
  private Chopstick left;
  private Chopstick right;

  public Philosopher(Chopstick left, Chopstick right) {
    this.left = left;
    this.right = right;
  }

//  public void eat() {
//    pickUp();
//    chew();
//    putDown();
//  }

  public void eat() {
    if (pickUp()) {
      chew();
      putDown();
    }
  }

  public void chew() {
    System.out.println(Thread.currentThread().getName() + " chewing");
  }

//  public void pickUp() {
//    left.pickUp();
//    right.pickUp();
//  }

  public boolean pickUp() {
    if (!left.pickUp()) {
      return false;
    }
    if (!right.pickUp()) {
      left.putDown();
      return false;
    }
    return true;
  }

  public void putDown() {
    right.putDown();
    left.putDown();
  }

  @Override
  public void run() {
    for (int i = 0; i < bites; i++) {
      eat();
    }
  }
}
