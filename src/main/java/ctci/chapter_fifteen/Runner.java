package ctci.chapter_fifteen;

public class Runner {

  public static void main(String[] args) {
    MyObject myObject1 = new MyObject();
    MyObject myObject2 = new MyObject();

    MyClass thread1 = new MyClass(myObject1, "1");
    MyClass thread2 = new MyClass(myObject2, "2");

    thread1.start();
    thread2.start();
  }
}
