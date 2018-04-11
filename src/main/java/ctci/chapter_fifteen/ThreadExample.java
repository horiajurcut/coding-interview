package ctci.chapter_fifteen;

public class ThreadExample {

  public static void main(String[] args) {
    MyThread instance = new MyThread();
    instance.start();

    while (instance.count != 5) {
      try {
        System.out.println(instance.count);
        Thread.sleep(250);
      } catch (InterruptedException exc) {
        exc.printStackTrace();
      }
    }
  }
}
