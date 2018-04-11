package ctci.chapter_fifteen;

public class MyThread extends Thread {
  int count = 0;

  @Override
  public void run() {
    System.out.println("Thread starting");
    try {
      while (count < 5) {
        Thread.sleep(500);
        System.out.println("In Thread, count is " + count);
        count++;
      }
    } catch (InterruptedException exc) {
      System.out.println("Thread interrupted");
    }
    System.out.println("Thread terminating");
  }
}
