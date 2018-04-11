package ctci.chapter_fifteen;

public class RunnableExample {

  public static void main(String[] args) {
    MyRunnable instance = new MyRunnable();
    Thread thread = new Thread(instance);
    thread.start();

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
